package be.pxl.services.proxy.graphql;

import be.pxl.services.proxy.contracts.Customer;
import be.pxl.services.proxy.contracts.CustomerCreateRequest;
import be.pxl.services.proxy.contracts.CustomerUpdateRequest;
import com.netflix.graphql.dgs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@DgsComponent
public class CustomerGraphQLController {

    private static final Logger log = LoggerFactory.getLogger(CustomerGraphQLController.class);
    private final RestTemplate restTemplate;

    @Value("${CUSTOMERS_URL}")
    private String baseUrl;

    public CustomerGraphQLController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @DgsQuery
    public Customer getCustomer(@InputArgument Long id) {
        log.info("Fetching customer with id: {}", id);
        return restTemplate.getForObject(baseUrl + "/" + id, Customer.class);
    }

    @DgsQuery
    public List<Customer> listCustomers() {
        log.info("Fetching all customers");
        Customer[] customers = restTemplate.getForObject(baseUrl, Customer[].class);
        return Arrays.asList(customers);
    }

    @DgsMutation
    public Customer createCustomer(@InputArgument String firstName,
                                      @InputArgument String lastName,
                                      @InputArgument String email,
                                      @InputArgument String phone,
                                      @InputArgument String address,
                                      @InputArgument String city,
                                      @InputArgument String zipCode) {
        log.info("Creating customer with firstName: {} and lastName: {}", firstName, lastName);
        CustomerCreateRequest request = new CustomerCreateRequest(firstName, lastName, email, phone, address, city, zipCode);
        return restTemplate.postForObject(baseUrl, request, Customer.class);
    }

    @DgsMutation
    public Customer updateCustomer(@InputArgument Long id,
                                      @InputArgument String firstName,
                                      @InputArgument String lastName,
                                      @InputArgument String email,
                                      @InputArgument String phone,
                                      @InputArgument String address,
                                      @InputArgument String city,
                                      @InputArgument String zipCode) {
        log.info("Updating customer with id: {}", id);
        CustomerUpdateRequest request = new CustomerUpdateRequest(firstName, lastName, email, phone, address, city, zipCode);
        restTemplate.put(baseUrl + "/" + id, request);
        return restTemplate.getForObject(baseUrl + "/" + id, Customer.class);
    }

    @DgsMutation
    public Boolean deleteCustomer(@Argument Long id) {
        log.info("Deleting customer with id: {}", id);
        restTemplate.delete(baseUrl + "/" + id);
        return true;
    }

    @DgsEntityFetcher(name = "Customer")
    public Customer resolveCustomer(Map<String, Object> reference) {
        log.info("Fetching customer by reference: {}", reference);
        String customerId = reference.get("id").toString();
        return getCustomer(Long.valueOf(customerId));
    }
}