package org.doto.application.errros.mappers;
import jakarta.ws.rs.ext.Provider;
import org.doto.domain.exceptions.ValidationFailException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

@Provider
public class ValidationFailMapper implements ExceptionMapper<ValidationFailException> {
    @Override
    public Response toResponse(ValidationFailException e) {
        var response = new ValidationFailResponse(e.getMessage(), e.getErrors());

        return Response
        .status(Response.Status.BAD_REQUEST)
        .entity(response)
        .build();
    }   
}

