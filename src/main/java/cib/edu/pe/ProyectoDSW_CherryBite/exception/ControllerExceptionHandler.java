package cib.edu.pe.ProyectoDSW_CherryBite.exception;


import cib.edu.pe.ProyectoDSW_CherryBite.model.dto.MensajeErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public MensajeErrorDto resourceNotFoundException(
            ResourceNotFoundException ex,
            WebRequest request
    ) {
        return MensajeErrorDto.builder().mensaje(ex.getMessage())
                .codigoestado(HttpStatus.NOT_FOUND.value())
                .fechaerror(new Date())
                .descripcion(request.getDescription(true)).build();
    }
}