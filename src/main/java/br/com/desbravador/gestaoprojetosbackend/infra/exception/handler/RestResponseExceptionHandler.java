package br.com.desbravador.gestaoprojetosbackend.infra.exception.handler;

import br.com.desbravador.gestaoprojetosbackend.infra.exception.ApiError;
import br.com.desbravador.gestaoprojetosbackend.infra.exception.ConverterErrorException;
import br.com.desbravador.gestaoprojetosbackend.infra.exception.NotEnumException;
import br.com.desbravador.gestaoprojetosbackend.infra.exception.ProjetoExclusionException;
import org.apache.logging.log4j.util.Strings;
import com.google.gson.JsonParseException;
import org.hibernate.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static br.com.desbravador.gestaoprojetosbackend.infra.util.Constants.LOGGER;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(LOGGER);

    public RestResponseExceptionHandler() {
        super();
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        ApiError apiError = ApiError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST)
                .build();
        logger.error("handleHttpMessageNotReadable: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        List<String> argumentErrors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(item -> argumentErrors.add(item.getField() + ": " + item.getDefaultMessage() +
                        (Objects.toString(item.getRejectedValue(), "").length() > 15 ? Strings.EMPTY :
                                " - (Rejected value: " + item.getRejectedValue() + ")")));

        ex.getBindingResult().getGlobalErrors()
                .forEach(item -> argumentErrors.add(item.getObjectName() + ": " + item.getDefaultMessage()));

        ApiError apiError = ApiError.builder()
                .message("Error detected on " + ex.getParameter().getExecutable().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST)
                .errors(argumentErrors)
                .build();

        logger.error("handleMethodArgumentNotValid: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JsonParseException.class, MappingException.class, NotEnumException.class})
    public ResponseEntity<Object> handleInternalServerError(final Exception ex) {

        ApiError apiError = ApiError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        logger.error("handleInternalServerError: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(final EntityNotFoundException ex) {

        ApiError apiError = ApiError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND)
                .build();

        logger.error("handleEntityNotFoundException: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<Object> handleInternalServerErrorDataBase(final Exception ex) {
        ApiError apiError = ApiError.builder()
                .message("Error at database: " + ex.toString())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        logger.error("handleInternalServerErrorDataBase: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(final Exception ex) {
        ApiError apiError = ApiError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        logger.error("handleException: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ConverterErrorException.class})
    public ResponseEntity<Object> converterErrorException(final ConverterErrorException ex) {

        ApiError apiError = ApiError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST)
                .build();

        logger.error("converterErrorException: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ProjetoExclusionException.class})
    public ResponseEntity<Object> projetoExclusionException(final ProjetoExclusionException ex) {

        ApiError apiError = ApiError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST)
                .build();

        logger.error("projetoExclusionException: {}", ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
