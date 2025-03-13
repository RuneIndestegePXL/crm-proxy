package be.pxl.services.proxy.contracts;

public record SupportTicketCreateRequest(
    String title,
    String description,
    Long customerId
) {
}
