package be.pxl.services.proxy.contracts;

public record CustomerUpdateRequest (
    String firstName,
    String lastName,
    String email,
    String phone,
    String address,
    String city,
    String zipCode){
}
