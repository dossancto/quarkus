package org.doto.ui.errors.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.doto.domain.exceptions.NotFoundException;


record NotFoundResponse(String msg){ }

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException e) {
        var response = new NotFoundResponse(e.getMessage());

        return Response
        .status(Response.Status.NOT_FOUND)
        .entity(response)
        .build();
    }   
}

