package com.example.storage_service.Repository;

import com.example.storage_service.Model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    Storage findByPlayerId(Long playerId);
    boolean existsByPlayerId(Long playerId);
    // You can add custom query methods here if needed
}