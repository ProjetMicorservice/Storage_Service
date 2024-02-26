package com.example.storage_service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageId;

    private Long playerId; // Foreign key referencing Player

    @OneToMany
    @JoinColumn(name = "storage_id")
    private List<Monster> storedMonsters;

    private int capacity;
    // Other storage attributes, constructors, getters, setters...
}
