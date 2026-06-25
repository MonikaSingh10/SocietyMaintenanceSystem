package com.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.room.entity.FlatOwner1;
import com.room.service.FlatOwnerService;

@Controller
@RequestMapping("/owners")
public class FlatOwnerController {

    private final FlatOwnerService service;

    public FlatOwnerController(FlatOwnerService service) {
        this.service = service;
    }

    // ✅ LIST + DASHBOARD LINK
    @GetMapping
    public String listOwners(Model model) {
        model.addAttribute("owners", service.getAllOwners());
        return "owner/list";
    }

    // ✅ ADD FORM
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("owner", new FlatOwner1());
        return "owner/form";
    }

    // ✅ SAVE / UPDATE
    @PostMapping("/save")
    public String saveOwner(@ModelAttribute("owner") FlatOwner1 owner) {
        service.saveOwner(owner);
        return "redirect:/owners";
    }

    // ✅ EDIT
    @GetMapping("/edit/{id}")
    public String editOwner(@PathVariable Long id, Model model) {
        model.addAttribute("owner", service.getOwnerById(id));
        return "owner/form";
    }

    // ✅ DELETE
    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {
        service.deleteOwner(id);
        return "redirect:/owners";
    }
}
