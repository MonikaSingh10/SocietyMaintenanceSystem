package com.room.controller;

import com.room.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    private final BillService billService;
    
    public OwnerController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/owner/dashboard")
    public String ownerDashboard(Model model) {
        Long flatId = 1L; // for demo
        model.addAttribute("bills", billService.getBillsForOwner(flatId));
        return "owner-dashboard";
    }
}
