package com.example.storage_service.Repository;

import com.example.storage_service.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByPlayerId(Long playerId);
    boolean existsByPlayerId(Long playerId);
    // You can add custom query methods here if needed
}