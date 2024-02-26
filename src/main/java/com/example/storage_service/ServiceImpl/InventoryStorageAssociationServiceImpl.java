package com.example.storage_service.ServiceImpl;

import com.example.storage_service.Model.Inventory;
import com.example.storage_service.Model.Storage;
import com.example.storage_service.Repository.InventoryRepository;
import com.example.storage_service.Repository.StorageRepository;
import com.example.storage_service.Service.InventoryStorageAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryStorageAssociationServiceImpl implements InventoryStorageAssociationService {

    @Autowired
    private InventoryRepository inventoryRepository; // Assuming you have an InventoryRepository

    @Autowired
    private StorageRepository storageRepository; // Assuming you have a StorageRepository

    @Override
    public void associateInventoryWithPlayer(Long playerId, Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + inventoryId));

        inventory.setPlayerId(playerId);
        inventoryRepository.save(inventory);
    }

    @Override
    public void associateStorageWithPlayer(Long playerId, Long storageId) {
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new RuntimeException("Storage not found with id: " + storageId));

        storage.setPlayerId(playerId);
        storageRepository.save(storage);
    }

    @Override
    public Long getInventoryIdByPlayerId(Long playerId) {
        Inventory inventory = inventoryRepository.findByPlayerId(playerId);
        return (inventory != null) ? inventory.getInventoryId() : null;
    }

    @Override
    public Long getStorageIdByPlayerId(Long playerId) {
        Storage storage = storageRepository.findByPlayerId(playerId);
        return (storage != null) ? storage.getStorageId() : null;
    }

    @Override
    public boolean hasAssociatedInventory(Long playerId) {
        return inventoryRepository.existsByPlayerId(playerId);
    }

    @Override
    public boolean hasAssociatedStorage(Long playerId) {
        return storageRepository.existsByPlayerId(playerId);
    }
}

