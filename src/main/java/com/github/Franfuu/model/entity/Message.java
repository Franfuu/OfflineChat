package com.github.Franfuu.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Message {
    private User sender;
    private User recipient;
    private String content;
    private int messageID;
    private LocalDate date;   // Date attribute
    private LocalTime time;   // Time attribute

    // Full constructor
    public Message(User sender, User recipient, String content, int messageID, LocalDate date, LocalTime time) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.messageID = messageID;
        this.date = date;
        this.time = time;
    }

    // Empty constructor
    public Message() {
    }

    // GETTERS
    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public int getMessageID() {
        return messageID;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    // SETTERS
    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    // toString method
    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender.getName() + " " + sender.getSurname() +
                ", recipient=" + recipient.getName() + " " + recipient.getSurname() +
                ", content='" + content + '\'' +
                ", messageID=" + messageID +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
