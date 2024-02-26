package com.example.storage_service.ServiceImpl;

import com.example.storage_service.DTO.MonsterDTO;
import com.example.storage_service.DTO.StorageDTO;
import com.example.storage_service.Model.Monster;
import com.example.storage_service.Model.Storage;
import com.example.storage_service.Repository.MonsterRepository;
import com.example.storage_service.Repository.StorageRepository;
import com.example.storage_service.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private MonsterRepository monsterRepository;

    @Override
    public StorageDTO getStorage(Long playerId) {
        Storage storage = storageRepository.findByPlayerId(playerId);
        return mapToDTO(storage);
    }

    @Override
    public void addMonsterToStorage(Long playerId, MonsterDTO monsterDTO) {
        Storage storage = storageRepository.findByPlayerId(playerId);
        Monster monster = mapToEntity(monsterDTO);
        monsterRepository.save(monster);
    }

    @Override
    public void removeMonsterFromStorage(Long playerId, Long monsterId) {
        Storage storage = storageRepository.findByPlayerId(playerId);
        Optional<Monster> monster = monsterRepository.findById(monsterId);
        if (monster != null) {
            monsterRepository.delete(monster.get());
        }
    }

    @Override
    public List<MonsterDTO> getAllMonstersInStorage(Long playerId) {
        Storage storage = storageRepository.findByPlayerId(playerId);
        List<Monster> monsters = storage.getStoredMonsters();
        return monsters.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Other methods as needed...

    private StorageDTO mapToDTO(Storage storage) {
        StorageDTO storageDTO = new StorageDTO();
        storageDTO.setStorageId(storage.getStorageId());
        storageDTO.setCapacity(storage.getCapacity());
        // Map other attributes as needed...
        return storageDTO;
    }

    private Monster mapToEntity(MonsterDTO monsterDTO) {
        Monster monster = new Monster();
        monster.setName(monsterDTO.getName());
        monster.setType(monsterDTO.getType());
        monster.setLevel(monsterDTO.getLevel());
        monster.setExperience(monsterDTO.getExperience());
        // Map other attributes as needed...
        return monster;
    }

    private MonsterDTO mapToDTO(Monster monster) {
        MonsterDTO monsterDTO = new MonsterDTO();
        monsterDTO.setMonsterId(monster.getId());
        monsterDTO.setName(monster.getName());
        monsterDTO.setType(monster.getType());
        monsterDTO.setLevel(monster.getLevel());
        monsterDTO.setExperience(monster.getExperience());
        // Map other attributes as needed...
        return monsterDTO;
    }
}
