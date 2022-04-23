package com.course.rabbitmq.producer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //ignore other properties
public class RabbitmqQueue {

    private String name;
    private long messages;

    public RabbitmqQueue(String name, long messages) {
        this.name = name;
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "RabbitmqQueue{" +
                "name='" + name + '\'' +
                ", messages=" + messages +
                '}';
    }

    public RabbitmqQueue() {
    }

    public boolean isDirty(){
        return (this.messages > 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMessages() {
        return messages;
    }

    public void setMessages(long messages) {
        this.messages = messages;
    }
}
