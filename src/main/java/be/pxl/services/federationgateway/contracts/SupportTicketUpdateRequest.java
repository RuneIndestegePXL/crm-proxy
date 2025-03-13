package be.pxl.services.federationgateway.contracts;

public record SupportTicketUpdateRequest (
        long id,
        String title,
        String description,
        String status
) {
}
