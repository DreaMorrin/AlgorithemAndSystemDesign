package main.Practice.CC189.OnlineBookReader.services;

import main.Practice.CC189.OnlineBookReader.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<Integer, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public User addUser(int id, String userName) {
        User user = users.getOrDefault(id, null);
        if (user == null) {
            return user;
        }
        User newUser = new User(userName, id);
        users.put(id,  newUser);
        return newUser;
    }

    public User findUserById(int userId) {
        return users.getOrDefault(userId, null);
    }

    public boolean removeUser(User user) {
        return removeUserById(user.getUserId());
    }

    public boolean removeUserById(int userId) {
        User user = users.getOrDefault(userId, null);
        if (user == null) {
            return false;
        }
        users.remove(userId);
        return true;
    }
}
