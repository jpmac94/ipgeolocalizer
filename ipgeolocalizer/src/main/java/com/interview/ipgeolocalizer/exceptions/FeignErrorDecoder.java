package com.interview.ipgeolocalizer.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 400:
                return new IllegalArgumentException("Solicitud inválida al llamar a: " + s);
            case 404:
                return new RecursoNoEncontradoException("Recurso no encontrado");
            case 500:
                return new RuntimeException("Error interno del servidor remoto");
            default:
                return defaultDecoder.decode(s, response);
        }
    }
}
