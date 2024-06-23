package org.doto.lib.validations;
import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationResult;
import org.doto.domain.exceptions.ValidationFailException;

public class ValidationUtils {
    public static <T> void Validate(AbstractValidator<T> validator, T model, String message)
    {
        final ValidationResult result = validator.validate(model);

        if(!result.isValid()){
            throw new ValidationFailException(message, result.getErrors());
        }
    }
}
