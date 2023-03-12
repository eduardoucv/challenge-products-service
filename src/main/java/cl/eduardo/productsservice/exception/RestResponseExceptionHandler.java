package cl.eduardo.productsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ProductNotFountException.class})
    @ResponseBody
    public ErrorsResponse handle404ProductNotFountException(Exception e) {
        return new ErrorsResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public ErrorsResponse handle500InternalServerErrorException(Exception e) {
        return new ErrorsResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "A system error has occurred");
    }

}