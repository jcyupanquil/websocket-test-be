package com.be.wsservices.facade.impl;


import com.be.wsservices.business.IChatBusiness;
import com.be.wsservices.facade.IChatFacadeV0;
import com.be.wsservices.facade.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@Controller
public class ChatFacadeV0 implements IChatFacadeV0
{
    private final String[] colors = {"red", "blue", "orange", "green", "purple", "magenta"};

    @Resource
    private IChatBusiness chatService;

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @Override
    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message handleMessage(final Message message)
    {
        message.setDate(new Date().getTime());
        message.setText(message.getText());

        if ("NEW_USER".equals(message.getType()))
        {
            message.setText(" joined the conversation!");
            message.setColor(colors[new Random().nextInt(colors.length)]);
        }
        else
        {
            chatService.createMessage(message);
        }

        return message;
    }

    @Override
    @MessageMapping("/writing")
    @SendTo("/chat/writing")
    public String getWritingMessage(final String username)
    {
        return username.concat("is writing...");
    }

    @Override
    @MessageMapping("/history")
    public void getHistory(final String clientId)
    {
        messagingTemplate.convertAndSend("/chat/history/" + clientId, chatService.getMessages());
    }
}
