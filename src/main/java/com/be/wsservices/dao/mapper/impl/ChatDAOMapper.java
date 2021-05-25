package com.be.wsservices.dao.mapper.impl;

import com.be.wsservices.dao.entity.MessageEntity;
import com.be.wsservices.dao.mapper.IChatDAOMapper;
import com.be.wsservices.facade.dto.Message;
import org.springframework.stereotype.Component;

@Component
public class ChatDAOMapper implements IChatDAOMapper
{
    @Override
    public MessageEntity mapInMessage(final Message message)
    {
        if (message == null)
        {
            return null;
        }
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setText(message.getText());
        messageEntity.setDate(message.getDate());
        messageEntity.setColor(message.getColor());
        messageEntity.setType(message.getType());
        messageEntity.setUsername(message.getUsername());
        return messageEntity;
    }

    @Override
    public Message mapOutMessage(final MessageEntity messageEntity)
    {
        if (messageEntity == null)
        {
            return null;
        }
        Message message = new Message();
        message.setText(messageEntity.getText());
        message.setDate(messageEntity.getDate());
        message.setColor(messageEntity.getColor());
        message.setType(messageEntity.getType());
        message.setUsername(messageEntity.getUsername());
        return message;
    }
}
