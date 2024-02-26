package com.example.storage_service.Repository;

import com.example.storage_service.Model.Monster;
import com.example.storage_service.Model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
    //Monster findByIdAndStorage(Long id, Storage storage);
}
