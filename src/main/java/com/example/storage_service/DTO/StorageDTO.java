package com.example.storage_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StorageDTO {
    private Long storageId;
    private List<MonsterDTO> storedMonsters;
    private int capacity;
}
