package com.room.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.entity.Owner;
import com.room.repository.OwnerRepository;

@Service
public class ReminderService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private WhatsAppService whatsAppService;

    public void sendMaintenanceReminders() {

        List<Owner> owners = ownerRepository.findByPendingAmountGreaterThan(0);

        for (Owner o : owners) {

            String msg =
                "🏢 *Housing Society Maintenance Reminder*\n\n" +
                "Dear " + o.getName() + ",\n" +
                "Your maintenance amount of ₹" + o.getPendingAmount() +
                " for Flat " + o.getFlatNo() + " is pending.\n\n" +
                "Please make the payment at the earliest.\n\n" +
                "– Society Management Date: " + LocalDate.now();
            

            whatsAppService.sendMessage( o.getWhatsappNumber(), msg );
        }
    }
}
