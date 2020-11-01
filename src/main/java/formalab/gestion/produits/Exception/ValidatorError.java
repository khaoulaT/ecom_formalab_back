package formalab.gestion.produits.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidatorError {

    private List<String> errors;

    private String uri;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    public void addError(String error){
        errors.add(error);
    }

    public ValidatorError() { //constructor without param
        //initialisation
        this.timestamp= new Date();
        this.errors= new ArrayList<>();//hedhi bch baed ki naabi l objet m ikolish taabi f null
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
