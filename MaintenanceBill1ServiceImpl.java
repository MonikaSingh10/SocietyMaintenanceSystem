package com.room.service;

import java.util.List;
import com.room.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.room.entity.MaintenanceBill1;
import com.room.repository.MaintenanceBill1Repository;

@Service
public class MaintenanceBill1ServiceImpl implements MaintenanceBill1Service {

    private final UserRepository userRepository;

    private final MaintenanceBill1Repository repository;

    public MaintenanceBill1ServiceImpl(MaintenanceBill1Repository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public List<MaintenanceBill1> getAllBills() {
    	
        return repository.findAll();
    }

    @Override
    public MaintenanceBill1 getBillById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MaintenanceBill1 saveBill(MaintenanceBill1 bill) {
        return repository.save(bill);
    }

    @Override
    public MaintenanceBill1 saveaintenanceBill1(MaintenanceBill1 bill) {
        return repository.save(bill);
    }
    
    
    
    @Override
    public void deleteBill(Long id) {
        repository.deleteById(id);
    }
    
    
    
    
    public List<MaintenanceBill1> getAllBills1() {
        return repository.findAllWithOwner();
    }
    
    
    
    
    
    
    
}

