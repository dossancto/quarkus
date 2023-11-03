package org.doto.domain.exceptions;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ValidationFailException extends  RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public ValidationFailException(String message, Collection<br.com.fluentvalidator.context.Error> eros){
        super(message);
        this.errors = eros
        .stream()
        .map(e -> String.format("%s %s",e.getField(), e.getMessage()))
        .toList();
    }
    public ValidationFailException(String message, List<String> errros){
        super(message);

        this.errors = errros;
    }

    public List<String> getErrors(){
        return errors;
    }
}
