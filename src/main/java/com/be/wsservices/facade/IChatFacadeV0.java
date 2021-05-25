package com.be.wsservices.facade;

import com.be.wsservices.facade.dto.Message;

public interface IChatFacadeV0
{
    /**
     *
     * @param message
     * @return
     */
    Message handleMessage(final Message message);

    /**
     *
     * @param username
     * @return
     */
    String getWritingMessage(final String username);

    /**
     *
     * @param clientId
     */
    void getHistory(final String clientId);
}
