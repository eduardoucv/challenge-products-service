package cl.eduardo.productsservice.exception;

public class ProductNotFountException extends RuntimeException {
    public ProductNotFountException(String message) {
        super(message);
    }
}
