package be.pxl.services.federationgateway.contracts;

import be.pxl.services.federationgateway.contracts.TicketStatus;

import java.time.LocalDateTime;

public record SupportTicketDto(
        Long id,
        String title,
        String description,
        TicketStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
