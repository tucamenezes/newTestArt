package com.flightsearch.application;

import com.flightsearch.controller.ExceptionHandlerController;
import com.flightsearch.model.exception.MessagePayload;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlerControllerTest {

    private final String CODE_ERROR_EXCEPTION ="9999";
    private final String CODE_ERROR_PARSE_EXCEPTION ="1000";

    @InjectMocks
    ExceptionHandlerController controller;

    @Test
    public void testgenerateErrorException() {

        Exception exception = new Exception("Test Exception");
        MessagePayload error = controller.generateErrorException(exception);

        Assert.assertEquals(error.getCode(), CODE_ERROR_EXCEPTION);

    }


    @Test
    public void testgenerateErrorParseException() {

        ParseException exception = new ParseException("Test Exception",1);
        MessagePayload error = controller.generateErrorParseException(exception);

        Assert.assertEquals(error.getCode(), CODE_ERROR_PARSE_EXCEPTION);

    }
}
