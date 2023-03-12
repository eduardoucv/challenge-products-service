package cl.eduardo.productsservice.client;

import cl.eduardo.model.ProductDetail;
import cl.eduardo.productsservice.exception.ProductNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class MocksClient {

    private CircuitBreakerFactory circuitBreakerFactory;
    private RestTemplate restTemplate;

    @Autowired
    public MocksClient(RestTemplateBuilder restTemplateBuilder, CircuitBreakerFactory circuitBreakerFactory) {
        this.restTemplate = restTemplateBuilder.build();
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public List<Long> getSimilarIds(String productId) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker1");
        Map<String, String> params = Collections.singletonMap("productId", productId);
        Long[] similarIdsDto = circuitBreaker.run(() -> restTemplate.getForObject(
                "http://host.docker.internal:3001/product/{productId}/similarids", Long[].class, params),
                throwable -> getSimilarIdsFallback(throwable));
        return Arrays.asList(similarIdsDto);
    }

    public ProductDetail getProductDetails(Long productId) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker2");
        Map<String, Long> params = Collections.singletonMap("productId", productId);
        return circuitBreaker.run(() -> restTemplate.getForObject(
                "http://host.docker.internal:3001/product/{productId}", ProductDetail.class, params),
                throwable -> getProductDetailsFallback(throwable));
    }

    private Long[] getSimilarIdsFallback(Throwable throwable) {
        System.out.println();
        if(throwable instanceof HttpClientErrorException.NotFound) {
            throw new ProductNotFountException("product not found");
        }
        return new Long[]{};
    }
    private ProductDetail getProductDetailsFallback(Throwable throwable) {
        System.out.println();
        if(throwable instanceof HttpClientErrorException.NotFound) {
            throw new ProductNotFountException("product not found");
        }
        return new ProductDetail();
    }

}