package be.pxl.services.federationgateway.contracts;

public record SupportTicketCreateRequest(
    String title,
    String description,
    Long customerId
) {
}
