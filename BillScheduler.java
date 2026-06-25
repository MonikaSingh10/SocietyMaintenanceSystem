package com.room.scheduler;

import com.room.service.BillService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BillScheduler {

    private final BillService billService;
    public BillScheduler(BillService billService) {
        this.billService = billService;
    }

    // Runs on the 1st of every month at 12:05 AM
    @Scheduled(cron = "0 5 0 1 * ?")
  //  @Scheduled(cron = "0 */5 * * * ?")
    public void generateMonthlyBills() {
        billService.generateMonthlyBills();
        System.out.println("Monthly bills generated automatically.");
    }
}
