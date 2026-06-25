package com.room.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.room.service.ReminderService;

@EnableScheduling
@Component
public class MaintenanceScheduler {

    @Autowired
    private ReminderService reminderService;

    // Every 1st day of month at 10 AM
    @Scheduled(cron = "0 0 10 1 * ?")
   // @Scheduled(cron = "0 */5 * * * ?")
    public void runMonthlyReminder() {
        reminderService.sendMaintenanceReminders();
    }
}
