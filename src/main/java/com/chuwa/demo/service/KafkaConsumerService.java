package com.chuwa.demo.service;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {
    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;
    @Value("${kafka.topic.name}")
    private String topic;

    private final MessageService messageService;

    public KafkaConsumerService(MessageService messageService) {
        this.messageService = messageService;
    }

    // At least once, commit if the message is saved in database
//    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
//    public void listenGroupFoo(ConsumerRecord<String, String> record, Acknowledgment ack) {
//        try {
//            messageService.saveMessage(record.key(), record.value());
//            ack.acknowledge();
//        } catch(Exception e) {
//            System.out.println("Failed to process message" + e.getMessage());
//        }
//    }

    // At most once, commit before the process is completed
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenGroupFoo(ConsumerRecord<String, String> record, Acknowledgment ack) {
        ack.acknowledge();
        try {
            messageService.saveMessage(record.key(), record.value());
        } catch(Exception e) {
            System.out.println("Failed to process message" + e.getMessage());
        }
    }




    //How do kafka consumers "consume" messages from broker
    //Kafka consumer: poll
    //Read the topic-partition on assigned broker, by offset

    //What will Kafka consumer do when above operation failed
    //If above operation fails: indicate assigned broker is down
    //The consumer will read from the new leader

//    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
//    public void listenGroupFoo(String message) {
//        System.out.println("Received message: " + message + " from group: " + consumerGroupId + " with topic: " + topic);
//        // Process the received message, commit consumption immediately(at most once)
//        // business logics
//        // persist to database (commit consumption successfully only when persistence is successfully) at least once
//
//        // {"messageKey":1234 //idempotency key
//        // }
////        try {
////            // process and persist message
//        // Persist message to MySQL DB(add idempotency key to your MySQL schema)
////        } catch (Exception e) {
////            //send to dead letter queue(dead letter topic)
////        } finally {
//            // commit offset to broker and return
//        //
////      }
//    }
}
