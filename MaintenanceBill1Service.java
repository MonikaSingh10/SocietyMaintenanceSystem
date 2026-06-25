package com.room.service;

import java.util.List;
import com.room.entity.MaintenanceBill1;

public interface MaintenanceBill1Service {

    List<MaintenanceBill1> getAllBills();

    MaintenanceBill1 getBillById(Long id);

    MaintenanceBill1 saveBill(MaintenanceBill1 bill);
    
    MaintenanceBill1 saveaintenanceBill1(MaintenanceBill1 bill);

    void deleteBill(Long id);
}
