package com.chuwa.demo.service;

import com.chuwa.demo.Entity.MessageEntity;
import com.chuwa.demo.dao.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public dto.MessageDto saveMessage(String key, String value) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setKey(key);
        messageEntity.setValue(value);

        MessageEntity message = messageRepository.save(messageEntity);

        return modelMapper.map(message, dto.MessageDto.class);
    }
}
