package be.pxl.services.proxy.contracts;

public record SupportTicketUpdateRequest (
        long id,
        String title,
        String description,
        String status
) {
}
