package com.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.room.service.ReminderService;
import com.room.service.WhatsAppService;

@RestController
@RequestMapping("/admin")
public class AdminController1 {

    @Autowired
    private ReminderService reminderService;
    
    @Autowired
    private WhatsAppService WhatsAppService;

    @GetMapping("/send-reminders")
    public String sendNow() {
        reminderService.sendMaintenanceReminders();
        return "WhatsApp maintenance reminders sent successfully!";
    }
    
    
    @GetMapping("/test-whatsapp")
    @ResponseBody
    public String test() {
    	WhatsAppService.sendMessage(
            "+919372486264",
            "Test Maintenance Reminder from Society App"
        );
        return "Sent";
    }

}
