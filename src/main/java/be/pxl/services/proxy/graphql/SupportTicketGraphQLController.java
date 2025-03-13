package be.pxl.services.proxy.graphql;

import be.pxl.services.proxy.contracts.SupportTicketDto;
import be.pxl.services.proxy.contracts.SupportTicketCreateRequest;
import be.pxl.services.proxy.contracts.SupportTicketUpdateRequest;
import com.netflix.graphql.dgs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@DgsComponent
public class SupportTicketGraphQLController {

    private static final Logger log = LoggerFactory.getLogger(SupportTicketGraphQLController.class);
    private final RestTemplate restTemplate;
    @Value("${SUPPORTTICKETS_URL}")
    private String baseUrl;

    public SupportTicketGraphQLController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @DgsQuery
    public SupportTicketDto getSupportTicket(@InputArgument Long id) {
        log.info("Fetching support ticket with id: {}", id);
        return restTemplate.getForObject(baseUrl + "/" + id, SupportTicketDto.class);
    }

    @DgsQuery
    public List<SupportTicketDto> listSupportTickets() {
        log.info("Fetching all support tickets");
        SupportTicketDto[] tickets = restTemplate.getForObject(baseUrl, SupportTicketDto[].class);
        assert tickets != null;
        return Arrays.asList(tickets);
    }

    @DgsMutation
    public SupportTicketDto createSupportTicket(@InputArgument String title, @InputArgument String description, @InputArgument String customerId) {
        log.info("Creating support ticket with title: {} and description: {}", title, description);
        SupportTicketCreateRequest request = new SupportTicketCreateRequest(title, description, Long.parseLong(customerId));
        return restTemplate.postForObject(baseUrl, request, SupportTicketDto.class);
    }

    @DgsMutation
    public SupportTicketDto updateSupportTicket(@InputArgument Long id,
                                                @InputArgument String title,
                                                @InputArgument String description,
                                                @InputArgument String status) {
        log.info("Updating support ticket with id: {}", id);
        SupportTicketUpdateRequest request = new SupportTicketUpdateRequest(id, title, description, status);
        restTemplate.put(baseUrl + "/" + id, request);
        return restTemplate.getForObject(baseUrl + "/" + id, SupportTicketDto.class);
    }

    @DgsMutation
    public Boolean deleteSupportTicket(@InputArgument Long id) {
        log.info("Deleting support ticket with id: {}", id);
        restTemplate.delete(baseUrl + "/" + id);
        return true;
    }
    @DgsEntityFetcher(name = "SupportTicket")
    public SupportTicketDto supportTicketByReference(Map<String, Object> reference) {
        log.info("Fetching support ticket by reference: {}", reference);
        String id = (String) reference.get("id");
        return restTemplate.getForObject(baseUrl + "/" + id, SupportTicketDto.class);
    }
}
