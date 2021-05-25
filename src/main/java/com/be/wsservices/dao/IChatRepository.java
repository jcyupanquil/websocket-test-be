package com.be.wsservices.dao;


import com.be.wsservices.dao.entity.MessageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IChatRepository extends MongoRepository<MessageEntity, String>
{
    List<MessageEntity> findFirst10ByOrderByDateDesc();
}
