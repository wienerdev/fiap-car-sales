package br.com.fiap.car.sales.infrastructure.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.webjars.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    private NotFoundException notFoundException;
    private Exception generalException;

    @BeforeEach
    void setUp() {
        notFoundException = new NotFoundException("Resource not found");
        generalException = new Exception("General error");
    }

    @Test
    void handlesNotFoundExceptionCorrectly() {
        ResponseEntity<String> response = globalExceptionHandler.handleNotFoundException(notFoundException);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isEqualTo("Resource not found");
    }

    @Test
    void handlesGeneralExceptionCorrectly() {
        ResponseEntity<String> response = globalExceptionHandler.handleException(generalException);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isEqualTo("General error");
    }
}