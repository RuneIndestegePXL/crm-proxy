package be.pxl.services.proxy.contracts;

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
