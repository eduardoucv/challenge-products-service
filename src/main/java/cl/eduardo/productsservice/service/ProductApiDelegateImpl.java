package cl.eduardo.productsservice.service;

import cl.eduardo.api.ProductApiDelegate;
import cl.eduardo.model.ProductDetail;
import cl.eduardo.productsservice.client.MocksClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductApiDelegateImpl implements ProductApiDelegate {

    @Autowired
    private MocksClient mocksClient;
    @Override
    public ResponseEntity<List<ProductDetail>> getProductSimilar(String productId) {
        List<ProductDetail> productDetails =
                mocksClient.getSimilarIds(productId)
                .stream().map(similarProductId -> mocksClient.getProductDetails(similarProductId))
                .collect(Collectors.toList());
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }
}