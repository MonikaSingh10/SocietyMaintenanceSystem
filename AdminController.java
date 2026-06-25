package com.room.controller;

import com.room.repository.BillRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final BillRepository billRepository;
    
    public AdminController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("bills", billRepository.findAll());
        return "admin-dashboard";
    }
}
