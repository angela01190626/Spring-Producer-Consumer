package com.chuwa.demo.dao;

import com.chuwa.demo.Entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
