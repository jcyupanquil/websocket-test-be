package com.be.wsservices.business;

import com.be.wsservices.facade.dto.Message;

import java.util.List;

public interface IChatBusiness
{
    List<Message> getMessages();

    Message createMessage(Message message);
}
