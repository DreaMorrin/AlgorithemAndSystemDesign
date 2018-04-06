package main.Practice.CC189.ChatServer.models;

import main.Practice.CC189.ChatServer.services.UserManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String username;
    private String password;
    private Status status;
    private Map<Integer, User> friends;
    private Map<String, Request> pendingRequests;
    private List<GroupChat> groupChats;
    private Map<Integer, PrivateChat> privateChats;
    private Map<String, Request> sentRequests;
    private Map<Integer, Message> messageMap;


    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = Status.OFFLINE;
        friends = new HashMap<>();
        pendingRequests = new HashMap<>();
        groupChats = new ArrayList<>();
        messageMap = new HashMap<>();
        privateChats = new HashMap<>();
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public void addConversation(GroupChat conversation) {
        conversation.addParticipant(this);
        //check if exists
        groupChats.add(conversation.getId(), conversation);
    }

    public void addConversation(PrivateChat conversation) {
        //check if exists
        privateChats.put(conversation.getId(), conversation);
    }

    public boolean sendMessageToUser(int toUserId, String content) {
        Message message = new Message(1324, content, getId(), toUserId);
        User toUser = UserManager.getInstance().getUserById(toUserId);
        PrivateChat npChat = new PrivateChat(13244, this, toUser);
        npChat.addMessage(message);
        toUser.addConversation(npChat);
        addConversation(npChat);
        return true;
    }

    public boolean sendMessageToGroupChat(int groupId, String content) {
        Message message = new Message(1324, content, getId(), groupId);
        return groupChats.get(groupId).addMessage(message);
    }


    /* getters and setters */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Request> getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(Map<String, Request> pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public List<GroupChat> getGroupChats() {
        return groupChats;
    }

    public void setGroupChats(List<GroupChat> groupChats) {
        this.groupChats = groupChats;
    }

    public Map<String, Request> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(Map<String, Request> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public Map<Integer, User> getFriends() {
        return friends;
    }

    public void setFriends(Map<Integer, User> friends) {
        this.friends = friends;
    }

    public Map<Integer, PrivateChat> getPrivateChats() {
        return privateChats;
    }

    public void setPrivateChats(Map<Integer, PrivateChat> privateChats) {
        this.privateChats = privateChats;
    }

    public Map<Integer, Message> getMessageMap() {
        return messageMap;
    }

    public void setMessageMap(Map<Integer, Message> messageMap) {
        this.messageMap = messageMap;
    }
}
