package com.example.demo.aspet;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAspect {

    @ExceptionHandler
    @ResponseBody
    public String handleException(Exception e)
    {
        return "exception happened";
    }
}
