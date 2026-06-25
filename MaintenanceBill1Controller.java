package com.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.room.entity.MaintenanceBill1;
import com.room.service.FlatOwnerService;
import com.room.service.MaintenanceBill1Service;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceBill1Controller {

	@Autowired
    private final MaintenanceBill1Service service;
    private final FlatOwnerService ownerService;
    

    public MaintenanceBill1Controller(MaintenanceBill1Service service, FlatOwnerService ownerService) {
        this.service = service;
        this.ownerService = ownerService;
    }

    // LIST
    @GetMapping
    public String listBills(Model model) {
        model.addAttribute("bills", service.getAllBills());
        return "maintenance/list";
    }

    // ADD FORM
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("bill", new MaintenanceBill1());
        model.addAttribute("owners", ownerService.getAllOwners()); // 👈 flat owners
        return "maintenance/form";
    }

   
    
    // SAVE
    @PostMapping("/save")
    public String saveBill(@ModelAttribute("bill") MaintenanceBill1 bill) {
        service.saveaintenanceBill1(bill);
        return "redirect:/maintenance";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editBill(@PathVariable Long id, Model model) {
        model.addAttribute("bill", service.getBillById(id));
        model.addAttribute("owners", ownerService.getAllOwners());
        return "maintenance/form";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteBill(@PathVariable Long id) {
        service.deleteBill(id);
        return "redirect:/maintenance";
    }
    
    
 

    @GetMapping("/maintenance/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("bill", service.getBillById(id));
        model.addAttribute("owners", ownerService.getAllOwners());
        return "maintenance/form";
    }

    
    
    
}
