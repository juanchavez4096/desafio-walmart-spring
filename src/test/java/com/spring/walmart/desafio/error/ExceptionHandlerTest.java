package com.spring.walmart.desafio.error;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.context.request.WebRequest;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlerTest {
    @InjectMocks
    ExceptionHandler exceptionHandler;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleConflict() {

        RuntimeException ex = Mockito.mock(RuntimeException.class);

        WebRequest request = Mockito.mock(WebRequest.class);

        assertNotNull(exceptionHandler.handleConstraintError(ex, request));
    }
}