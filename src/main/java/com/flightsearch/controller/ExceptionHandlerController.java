package com.flightsearch.controller;

import com.flightsearch.model.exception.MessagePayload;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;

@ControllerAdvice
public class ExceptionHandlerController {

    public ExceptionHandlerController() {
    }

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessagePayload generateErrorParseException (ParseException ex) {
        MessagePayload messagePayload = new MessagePayload();

        messagePayload.setCode("1000");
        messagePayload.setMessage("Le valeur de la date n'est pas valide.");

        return messagePayload;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public MessagePayload generateErrorException (Exception ex) {
        MessagePayload messagePayload = new MessagePayload();

        messagePayload.setCode("9999");
        messagePayload.setMessage(ex.getMessage());

        return messagePayload;
    }
}
