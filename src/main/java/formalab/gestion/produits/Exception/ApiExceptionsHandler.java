package formalab.gestion.produits.Exception;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

//heritina mel ResponseEntityExceptionHandler
//polymorphisme
//dnc najmou naamlou override yaani tourethha w tbadel fiha
@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrorsList = ex.getBindingResult().getFieldErrors();
        ValidatorError validationError = new ValidatorError();
        for(FieldError fieldError: fieldErrorsList) {
            String error = fieldError.getDefaultMessage();
            validationError.addError(error);
            //validationError.addError(fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
