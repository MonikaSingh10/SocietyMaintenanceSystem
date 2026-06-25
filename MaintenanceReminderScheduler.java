package com.room.scheduler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.room.entity.Owner;
import com.room.repository.OwnerRepository;
import com.room.service.WhatsAppService;

@EnableScheduling
@Component
public class MaintenanceReminderScheduler {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private WhatsAppService whatsAppService;

	// Runs on 1st day of every month at 10 AM
   @Scheduled(cron = "0 0 10 1 * ?")
// @Scheduled(cron = "0 */5 * * * ?")
	public void sendMonthlyReminders() {

		List<Owner> owners = ownerRepository.findByPendingAmountGreaterThan(0);

		for (Owner owner : owners) {

			String msg = "🏢 *Housing Society Maintenance Reminder*\n\n"
					+ "Dear " + owner.getName() + ",\n"
					+ "Your maintenance payment of ₹" + owner.getPendingAmount()
					+ " for Flat " + owner.getFlatNo() + " is pending.\n\n"
					+ "Kindly make the payment at the earliest.\n\n"
					+ "– Society Management";

			whatsAppService.sendMessage( owner.getWhatsappNumber(), msg );
		}
	}
}
