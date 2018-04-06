package main.Practice.CC189.ChatServer.models;

import main.Practice.CC189.ChatServer.models.base.Conversation;

import java.util.Arrays;
import java.util.List;

public class PrivateChat extends Conversation {
    public PrivateChat(int id, User user1, User user2) {
        super(id);
        this.participants.addAll(Arrays.asList(user1, user2));
    }

    public User getOtherParticipant(User user) {
        for (User participant : participants) {
            if (participant.getId() != user.getId()) {
                return participant;
            }
        }
        return null;
    }
}
