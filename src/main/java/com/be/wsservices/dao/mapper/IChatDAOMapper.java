package com.be.wsservices.dao.mapper;

import com.be.wsservices.dao.entity.MessageEntity;
import com.be.wsservices.facade.dto.Message;

public interface IChatDAOMapper
{
    MessageEntity mapInMessage(Message message);

    Message mapOutMessage(MessageEntity messageEntity);
}
