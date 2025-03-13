package be.pxl.services.federationgateway.services;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.web.reactive.function.client.WebClient;

/*

@DgsComponent
public class ProductDataFetcher {
    private final WebClient webClient;

    public ProductDataFetcher(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://rest-service/api").build();
    }

    @DgsQuery
    public Product product(@InputArgument String id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block(); // Blocking for simplicity, use reactive for better performance
    }

}

 */