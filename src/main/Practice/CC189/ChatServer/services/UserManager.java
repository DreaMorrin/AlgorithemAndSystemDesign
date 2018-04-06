package main.Practice.CC189.ChatServer.services;

import main.Practice.CC189.ChatServer.models.Request;
import main.Practice.CC189.ChatServer.models.Status;
import main.Practice.CC189.ChatServer.models.Type;
import main.Practice.CC189.ChatServer.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static UserManager instance = null;
    private Map<Integer, User> userIdMap;
    private Map<String, User> userNameMap;
    private UserManager () {
        userIdMap = new HashMap<>();
        userNameMap = new HashMap<>();
    }
    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    public User getUserById(int id) {
        return userIdMap.getOrDefault(id, null);
    }

    public User getUserByName(String name) {
        return userNameMap.getOrDefault(name, null);
    }

    public boolean addUser(int id, User user) {
        if (userIdMap.containsKey(id)) {
            return false;
        }
        userIdMap.put(id, user);
        return true;
    }

    public boolean login(int userId, String password) {
        User user = userIdMap.getOrDefault(userId, null);
        if (user == null) {
            return false;
        }
        if (!user.getPassword().equals(password)) {
            return false;
        }
        if (!user.getStatus().equals(Status.ONLINE)) {
            return false;
        }
        return true;
    }

    public boolean logout(int userId) {
        User user = userIdMap.getOrDefault(userId, null);
        if (user == null) {
            return false;
        }
        if (user.getStatus().equals(Status.OFFLINE)) {
            return false;
        }
        user.setStatus(Status.OFFLINE);
        return true;
    }

    public void addUser(Request request) {
        User user = userNameMap.getOrDefault(request.getToAccountName(), null);
        if (user != null) {
            user.getPendingRequests().put(request.getFromAccountId(), request);
        }
    }

    public void approveRequest(Request request) {
        request.setStatus(Status.APPROVED);
        User fromUser = userIdMap.getOrDefault(request.getFromAccountId(), null);
        User toUser = userNameMap.getOrDefault(request.getToAccountName(), null);
        if (fromUser == null || toUser == null) {
            return;
        }
        fromUser.getFriends().put(toUser.getId(), toUser);
        toUser.getFriends().put(fromUser.getId(), fromUser);
    }
}
