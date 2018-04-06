package main.Practice.CC189.ChatServer.models.base;

import main.Practice.CC189.ChatServer.models.Message;
import main.Practice.CC189.ChatServer.models.User;

import java.util.ArrayList;
import java.util.List;

public abstract class Conversation {
    protected List<User> participants;
    protected int id;
    protected List<Message> messages;

    public Conversation(int id) {
        this.participants = new ArrayList<>();
        this.id = id;
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public boolean addMessage(Message message) {
        return messages.add(message);
    }

    public boolean removeMessage(Message message) {
        return messages.remove(message);
    }

    public int getId() {
        return id;
    }
}
