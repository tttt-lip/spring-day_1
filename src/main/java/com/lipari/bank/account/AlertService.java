package com.lipari.bank.account;

import org.springframework.stereotype.Service;

@Service
public class AlertService {

    private final NotificationService notificationService;

    public AlertService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void raiseAlert(String accountId, String reason) {
        notificationService.notify(accountId, "ALERT: " + reason);
    }
}
