package com.example.storage_service.Service;

import com.example.storage_service.DTO.InventoryDTO;

public interface InventoryService {
    InventoryDTO getInventory(Long playerId);
    void addMonsterToInventory(Long playerId, Long monsterId);
    void removeMonsterFromInventory(Long playerId, Long monsterId);
}
