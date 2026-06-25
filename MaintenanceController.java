package com.room.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.room.entity.MaintenanceBill1;
import com.room.service.FlatOwnerService;
import com.room.service.MaintenanceBill1Service;
/*
@Controller
public class MaintenanceController {

    @Autowired
    private MaintenanceBill1Service billService;

    @Autowired
    private FlatOwnerService ownerService;

    /* ===============================
       LIST ALL MAINTENANCE BILLS
       =============================== */
	/*
    @GetMapping("/maintenance")
    public String listBills(Model model) {
        List<MaintenanceBill1> bills = billService.getAllBills();
        model.addAttribute("bills", bills);
        return "maintenance/list";
    }*/

    /* ===============================
       OPEN ADD BILL FORM
       =============================== */
	/*
	 * @GetMapping("/maintenance/new") public String newBill(Model model) {
	 * 
	 * MaintenanceBill1 bill = new MaintenanceBill1();
	 * 
	 * model.addAttribute("bill", bill); model.addAttribute("owners",
	 * ownerService.getAllOwners());
	 * 
	 * return "maintenance/form"; }
	 */

    /* ===============================
       OPEN EDIT BILL FORM
       =============================== */
	/*
	 * @GetMapping("/maintenance/edit/{id}") public String editBill(@PathVariable
	 * Long id, Model model) {
	 * 
	 * MaintenanceBill1 bill = billService.getBillById(id);
	 * 
	 * model.addAttribute("bill", bill); model.addAttribute("owners",
	 * ownerService.getAllOwners());
	 * 
	 * return "maintenance/form"; }
	 */

    /* ===============================
       SAVE / UPDATE BILL
       =============================== */
	/* @PostMapping("/maintenance/save")
    public String saveBill(MaintenanceBill1 bill) {
    			   */
        /*
         * ownerId is automatically mapped to owner
         * using setter in entity:
         * setOwnerId(Long ownerId)
         */
    	 /*      billService.saveBill(bill);

        return "redirect:/maintenance";
    } */

    /* ===============================
       DELETE BILL
       =============================== */  /*
    @GetMapping("/maintenance/delete/{id}")
    public String deleteBill(@PathVariable Long id) {

        billService.deleteBill(id);

        return "redirect:/maintenance";
    }   
}*/
