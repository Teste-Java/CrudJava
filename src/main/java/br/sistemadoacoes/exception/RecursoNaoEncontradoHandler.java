package br.sistemadoacoes.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RecursoNaoEncontradoHandler implements ExceptionMapper<RecursoNaoEncontradoException> {
    @Override
    public Response toResponse(RecursoNaoEncontradoException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }
}
