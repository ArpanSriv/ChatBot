package com.arpan.chatbot;

public class Message {

    private String senderName;
    private String messageContent;

    public Message(String senderName, String messageContent) {
        this.senderName = senderName;
        this.messageContent = messageContent;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
