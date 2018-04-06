package main.Practice.CC189.ChatServer.models;

import main.Practice.CC189.ChatServer.models.base.Conversation;

import java.util.List;

public class GroupChat extends Conversation {
    public GroupChat(int id, User user) {
        super(id);
        this.participants.add(user);
    }

    public boolean addParticipant(User user) {
        if (this.participants.contains(user)) {
            return false;
        }
        return this.participants.add(user);
    }

    public boolean addParticipants(List<User> users) {
        return this.participants.addAll(users);
    }

    public boolean removeParticipants(List<User> users) {
        return this.participants.removeAll(users);
    }

    public boolean removeParticipant(User user) {
        return this.participants.remove(user);
    }
}
