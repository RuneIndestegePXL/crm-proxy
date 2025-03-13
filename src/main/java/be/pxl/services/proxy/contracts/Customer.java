package be.pxl.services.proxy.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.netflix.graphql.dgs.DgsComponent;
import java.util.List;

@DgsComponent
public class Customer {
    private String __typename = "Customer";

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String zipCode;
    private String createdAt;
    private String updatedAt;
    @JsonProperty("supportTickets")
    private List<SupportTicketDto> supportTickets;
    @JsonProperty("closedSupportTickets")
    private List<SupportTicketDto> closedSupportTickets;

    public Customer() {}

    public Customer(String id, String firstName, String lastName, String email,
                       String phone, String address, String city, String zipCode,
                       String createdAt, String updatedAt,
                       List<SupportTicketDto> supporttickets,
                       List<SupportTicketDto> closedsupporttickets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.supportTickets = supporttickets;
        this.closedSupportTickets = closedsupporttickets;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getZipCode() { return zipCode; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }
    public List<SupportTicketDto> getSupporttickets() { return supportTickets; }
    public List<SupportTicketDto> getClosedsupporttickets() { return closedSupportTickets; }
    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }
    public void setId(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
    public void setSupporttickets(List<SupportTicketDto> supporttickets) { this.supportTickets = supporttickets; }
    public void setClosedsupporttickets(List<SupportTicketDto> closedsupporttickets) { this.closedSupportTickets = closedsupporttickets; }

}