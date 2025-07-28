package com.chuwa.demo.service;

import dto.MessageDto;

public interface MessageService {
    MessageDto saveMessage(String key, String value);
}
