package com.be.wsservices.facade.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Message implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String text;
    private Long date;
    private String username;
    private String type;
    private String color;
}