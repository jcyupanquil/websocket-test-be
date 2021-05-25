package com.be.wsservices.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "message")
public class MessageEntity
{
    @Id
    private String id;

    private String text;
    private Long date;
    private String username;
    private String type;
    private String color;
}
