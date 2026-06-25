package com.room.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.room.entity.FlatOwner1;
import com.room.repository.FlatOwnerRepository;

@Service
public class FlatOwnerService {

    private final FlatOwnerRepository repository;

    public FlatOwnerService(FlatOwnerRepository repository) {
        this.repository = repository;
    }

    public List<FlatOwner1> getAllOwners() {
        return repository.findAll();
    }

    public FlatOwner1 getOwnerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FlatOwner1 saveOwner(FlatOwner1 owner) {
        return repository.save(owner);
    }

    public void deleteOwner(Long id) {
        repository.deleteById(id);
    }
}
