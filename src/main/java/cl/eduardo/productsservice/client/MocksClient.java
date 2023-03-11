package cl.eduardo.productsservice.client;

import cl.eduardo.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class MocksClient {

    private RestTemplate restTemplate;

    @Autowired
    public MocksClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<Long> getSimilarIds(String productId) {
        Map<String, String> params = Collections.singletonMap("productId", productId);
        Long[] similarIdsDto = restTemplate.getForObject(
                "http://host.docker.internal:3001/product/{productId}/similarids",
                Long[].class, params);
        return Arrays.asList(similarIdsDto);
    }

    public ProductDetail getProductDetails(Long productId) {
        Map<String, Long> params = Collections.singletonMap("productId", productId);
        return restTemplate.getForObject(
                "http://host.docker.internal:3001/product/{productId}",
                ProductDetail.class, params);
    }
}