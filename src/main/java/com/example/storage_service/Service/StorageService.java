package com.example.storage_service.Service;

import com.example.storage_service.DTO.MonsterDTO;
import com.example.storage_service.DTO.StorageDTO;

import java.util.List;

public interface StorageService {

    /**
     * Retrieves the storage for a given playerId.
     * @param playerId The ID of the player.
     * @return The storage DTO for the player.
     */
    StorageDTO getStorage(Long playerId);

    /**
     * Adds a monster to the storage of a player.
     * @param playerId The ID of the player.
     * @param monsterDTO The monster DTO to add.
     */
    void addMonsterToStorage(Long playerId, MonsterDTO monsterDTO);

    /**
     * Removes a monster from the storage of a player.
     * @param playerId The ID of the player.
     * @param monsterId The ID of the monster to remove.
     */
    void removeMonsterFromStorage(Long playerId, Long monsterId);

    /**
     * Retrieves all monsters stored in the storage of a player.
     * @param playerId The ID of the player.
     * @return List of monster DTOs stored in the player's storage.
     */
    List<MonsterDTO> getAllMonstersInStorage(Long playerId);

    // Other methods as needed...
}
