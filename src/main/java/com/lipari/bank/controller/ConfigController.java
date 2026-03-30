package com.lipari.bank.controller;

import com.lipari.bank.model.ConfigAuditEntry;
import com.lipari.bank.shared.config.LipariBankProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ConfigController {

    private final LipariBankProperties lipariBankProperties;
    private final ObjectProvider<ConfigAuditEntry> auditEntriesProvider;

    public ConfigController(LipariBankProperties lipariBankProperties, ObjectProvider<ConfigAuditEntry> auditEntriesProvider) {
        this.lipariBankProperties = lipariBankProperties;
        this.auditEntriesProvider = auditEntriesProvider;
    }


    @GetMapping("/config")
    public ResponseEntity<ConfigAuditEntry.ConfigResponse> getConfig() {

        ConfigAuditEntry auditEntry = auditEntriesProvider.getIfAvailable();

        return ResponseEntity.ok(new ConfigAuditEntry.ConfigResponse(lipariBankProperties, auditEntry));
    }
}
