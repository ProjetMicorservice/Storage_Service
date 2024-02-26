package com.example.storage_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonsterDTO {
    private Long monsterId;
    private String name;
    private String type;
    private int level;
    private int experience;
}
