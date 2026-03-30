package com.lipari.bank.model;

import com.lipari.bank.shared.config.LipariBankProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Scope("prototype")
@Component
public class ConfigAuditEntry {

    private String id;
    private Timestamp timestamp;

    @PostConstruct
    public void setTimestamp() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = Timestamp.from(Instant.now());

    }

    public String getId() {
        return id;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }


    public record ConfigResponse(LipariBankProperties properties, ConfigAuditEntry auditEntry) {
    }

}
