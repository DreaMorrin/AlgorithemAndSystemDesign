package main.LeetCode;

import java.util.*;

public class Twitter {
    Map<Integer, User> userMap;
    private static int timeStamp = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        this.userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (userMap.containsKey(userId)) {
            User user = userMap.get(userId);
            Tweet nTweet = new Tweet(tweetId, timeStamp++);
            user.addTweet(nTweet);
        } else {
            User nUser = new User(userId);
            Tweet nTweet = new Tweet(tweetId, timeStamp++);
            nUser.addTweet(nTweet);
            userMap.put(userId, nUser);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetIds = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return tweetIds;
        }
        User currUser = userMap.get(userId);

        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(new Comparator<Tweet>(){
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t2.time - t1.time;
            }
        });
        Tweet currTweet = currUser.getNewPosts();
        if (currTweet != null) {
            pq.add(currTweet);
        }
        for (int id : currUser.followed) {
            if (userMap.containsKey(id) && id != userId) {
                User iterUser = userMap.get(id);
                if (iterUser.head != null) {
                    pq.add(iterUser.head);
                }
            }
        }
        List<Integer> tweets = new ArrayList<>();
        while (!pq.isEmpty()) {
            if (tweets.size() == 10) {
                break;
            }
            Tweet currLatest = pq.poll();
            tweets.add(currLatest.tweetId);
            if (currLatest.next != null) {
                pq.add(currLatest.next);
            }
        }
        return tweets;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User user = userMap.get(followerId);
            user.followed.add(followeeId);
        } else {
            User user = new User(followerId);
            user.followed.add(followeeId);
            userMap.put(followerId, user);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User user = userMap.get(followerId);
            user.followed.remove(followeeId);
        }
    }
}

class User {
    int userId;
    Set<Integer> followed;
    Tweet head;
    public User(int userId) {
        this.userId = userId;
        this.followed = new HashSet<>();
        this.head = null;
    }

    public void addTweet(Tweet nTweet) {
        nTweet.next = head;
        head = nTweet;
    }

    public Tweet getNewPosts() {
        return head;
    }
}

class Tweet {
    int tweetId;
    Tweet next;
    int time;
    public Tweet (int tweetId, int time) {
        this.tweetId = tweetId;
        this.next = null;
        this.time = time;
    }
}