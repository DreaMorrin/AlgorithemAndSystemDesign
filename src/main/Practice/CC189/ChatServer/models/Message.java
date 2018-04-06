package main.Practice.CC189.ChatServer.models;

import java.time.LocalTime;

public class Message {
    private int id;
    private String content;
    private int fromUserId;
    private int toUserId;
    private LocalTime timeStamp;

    public Message(int id, String content, int fromUserId, int toUserId) {
        this.id = id;
        this.content = content;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.timeStamp = LocalTime.now();
    }


}
