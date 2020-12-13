package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.lang.annotation.Aspect;

@Getter
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    //private String toCC;


}
