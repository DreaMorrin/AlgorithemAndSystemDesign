package main.Practice.CC189.JukeBox.component;

import main.Practice.CC189.JukeBox.models.CD;
import main.Practice.CC189.JukeBox.models.Song;
import main.Practice.CC189.JukeBox.models.User;
import main.Practice.CC189.JukeBox.services.CDPlayer;

import java.util.Map;
import java.util.Set;

public class JukeBox {
    private CDPlayer cdPlayer;
    private User user;
    private Map<String, CD> cdCollection;
    private Set<CD> cdSet;
    private Map<String, Set<String>> userCdCollection;
    public JukeBox(CDPlayer cdPlayer, User user, Map<String, CD> cdCollection,
                   Map<String, Set<String>> userCdCollection, Set<CD> cdSet) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.userCdCollection = userCdCollection;
        this.cdSet = cdSet;
    }

    public void switchUser(String userId) {
        cdSet.clear();
        Set<String> cdIds = userCdCollection.getOrDefault(userId, null);
        for (String cdId : cdIds) {
            CD cd = cdCollection.getOrDefault(cdId, null);
            if (cd != null) {
                cdSet.add(cd);
            }
        }
    }

    public void switchCd(int cdId) {
        CD cd = cdCollection.getOrDefault(cdId, null);
        this.cdPlayer.playCd(cd);
    }

    public Song getCurrentSong() {
        return this.cdPlayer.getCurrentSong();
    }

    /* Getters and setters */
    public CDPlayer getCdPlayer() {
        return cdPlayer;
    }

    public void setCdPlayer(CDPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, CD> getCdCollection() {
        return cdCollection;
    }

    public void setCdCollection(Map<String, CD> cdCollection) {
        this.cdCollection = cdCollection;
    }

    public Set<CD> getCdSet() {
        return cdSet;
    }

    public void setCdSet(Set<CD> cdSet) {
        this.cdSet = cdSet;
    }
}
