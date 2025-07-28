package com.chuwa.demo.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_key")
    private String key;

    @Column(name = "message_value")
    private String value;

    public void setId(Long id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public MessageEntity() {
    }

    public MessageEntity(Long id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" +
            "id=" + id +
            ", key='" + key + '\'' +
            ", value='" + value +
            '}';
    }

}

