package com.example.storage_service.ServiceImpl;

import com.example.storage_service.DTO.InventoryDTO;
import com.example.storage_service.DTO.MonsterDTO;
import com.example.storage_service.Exception.InventoryFullException;
import com.example.storage_service.Exception.MonsterAlreadyInInventoryException;
import com.example.storage_service.Exception.NotFoundException;
import com.example.storage_service.Model.Inventory;
import com.example.storage_service.Model.Monster;
import com.example.storage_service.Repository.InventoryRepository;
import com.example.storage_service.Repository.MonsterRepository;
import com.example.storage_service.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
     private final InventoryRepository inventoryRepository;
     private final MonsterRepository monsterRepository;

     @Autowired
     public InventoryServiceImpl(InventoryRepository inventoryRepository, MonsterRepository monsterRepository) {
            this.inventoryRepository = inventoryRepository;
            this.monsterRepository = monsterRepository;
     }

     @Override
     public InventoryDTO getInventory(Long playerId) {
            Inventory inventory = inventoryRepository.findByPlayerId(playerId);
            // Convert Inventory entity to InventoryDTO and return
            InventoryDTO inventoryDTO = new InventoryDTO();
            inventoryDTO.setInventoryId(inventory.getInventoryId());
            inventoryDTO.setMonsters(convertMonstersToDTOs(inventory.getMonsters()));
            inventoryDTO.setCapacity(inventory.getCapacity());
            return inventoryDTO;
     }
     @Override
        public void addMonsterToInventory(Long playerId, Long monsterId) {
            Inventory inventory = inventoryRepository.findByPlayerId(playerId);
            Monster monster = monsterRepository.findById(monsterId).orElseThrow(() -> new NotFoundException("Monster not found"));

            if (inventory.getMonsters().size() >= inventory.getCapacity()) {
                throw new InventoryFullException("Inventory is full");
            }

            // Check if the monster already exists in the inventory
            if (inventory.getMonsters().contains(monster)) {
                throw new MonsterAlreadyInInventoryException("Monster already exists in the inventory");
            }

            // Add monster to the player's inventory
            inventory.getMonsters().add(monster);
            inventoryRepository.save(inventory);
        }
        @Override
        public void removeMonsterFromInventory(Long playerId, Long monsterId) {
            Inventory inventory = inventoryRepository.findByPlayerId(playerId);
            Monster monster = monsterRepository.findById(monsterId).orElseThrow(() -> new NotFoundException("Monster not found"));

            // Check if the monster exists in the player's inventory
            if (!inventory.getMonsters().contains(monster)) {
                throw new NotFoundException("Monster not found in the inventory");
            }

            // Remove monster from the player's inventory
            inventory.getMonsters().remove(monster);
            inventoryRepository.save(inventory);
        }

        // Other methods for inventory operations
        private List<MonsterDTO> convertMonstersToDTOs(List<Monster> monsters) {
            // Convert list of Monster entities to list of MonsterDTOs
            // Implement conversion logic here
            return null;
        }
    }










