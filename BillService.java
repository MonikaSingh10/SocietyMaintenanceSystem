package com.room.service;

import com.room.entity.*;
import com.room.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final FlatRepository flatRepository;

    public BillService(BillRepository billRepository, FlatRepository flatRepository) {
        this.billRepository = billRepository;
        this.flatRepository = flatRepository;
    }

    public void generateMonthlyBills() {
        List<Flat> flats = flatRepository.findAll();
        for (Flat flat : flats) {
            MaintenanceBill bill = new MaintenanceBill();
            bill.setFlat(flat);
            bill.setMonth(LocalDate.now().getMonth().name());
            bill.setAmount(2000.0);
            bill.setPaid(false);
            bill.setGeneratedDate(LocalDate.now());
            billRepository.save(bill);
        }
    }

    public List<MaintenanceBill> getBillsForOwner(Long flatId) {
        return billRepository.findAll().stream().filter(b -> b.getFlat().getId().equals(flatId)).toList();
    }
}
