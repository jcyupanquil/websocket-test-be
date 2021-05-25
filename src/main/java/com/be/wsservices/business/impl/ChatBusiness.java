package com.be.wsservices.business.impl;

import com.be.wsservices.business.IChatBusiness;
import com.be.wsservices.dao.IChatRepository;
import com.be.wsservices.dao.entity.MessageEntity;
import com.be.wsservices.dao.mapper.IChatDAOMapper;
import com.be.wsservices.facade.dto.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChatBusiness implements IChatBusiness
{

    @Resource
    private IChatRepository chatRepository;

    @Resource
    private IChatDAOMapper chatMapper;

    public List<Message> getMessages()
    {
        List<MessageEntity> messageEntities = chatRepository.findFirst10ByOrderByDateDesc();

        if (CollectionUtils.isEmpty(messageEntities))
            return null;

        return messageEntities.stream().map(chatMapper::mapOutMessage)
                .collect(Collectors.toList());
    }

    @Override
    public Message createMessage(Message message)
    {
        return chatMapper.mapOutMessage(chatRepository.save(chatMapper.mapInMessage(message)));
    }
}
