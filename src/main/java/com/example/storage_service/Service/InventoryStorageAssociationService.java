package com.example.storage_service.Service;

public interface InventoryStorageAssociationService {

    /**
     * Associates an inventory with a player.
     *
     * @param playerId    The ID of the player.
     * @param inventoryId The ID of the inventory.
     */
    void associateInventoryWithPlayer(Long playerId, Long inventoryId);

    /**
     * Associates a storage with a player.
     *
     * @param playerId  The ID of the player.
     * @param storageId The ID of the storage.
     */
    void associateStorageWithPlayer(Long playerId, Long storageId);

    /**
     * Retrieves the inventory ID associated with the player.
     *
     * @param playerId The ID of the player.
     * @return The ID of the associated inventory.
     */
    Long getInventoryIdByPlayerId(Long playerId);

    /**
     * Retrieves the storage ID associated with the player.
     *
     * @param playerId The ID of the player.
     * @return The ID of the associated storage.
     */
    Long getStorageIdByPlayerId(Long playerId);

    /**
     * Checks if a player has an associated inventory.
     *
     * @param playerId The ID of the player.
     * @return True if the player has an associated inventory, false otherwise.
     */
    boolean hasAssociatedInventory(Long playerId);

    /**
     * Checks if a player has an associated storage.
     *
     * @param playerId The ID of the player.
     * @return True if the player has an associated storage, false otherwise.
     */
    boolean hasAssociatedStorage(Long playerId);
}

