package main.Practice.CC189.JukeBox.services;

import main.Practice.CC189.JukeBox.models.CD;
import main.Practice.CC189.JukeBox.models.Song;

import java.util.*;

public class SongSelector {
    private String artist;
    private List<Song> songCollection;
    private int currentIndex;

    public Song getCurrentSong() {
        return songCollection.get(currentIndex);
    }

    public void reset(CD cd) {
        // if you change CD frequently
//        songCollection = new LinkedList<>(cd.getSongs());
//        currentIndex = 0;


        /* if you are not changing CD frequently */

        songCollection = new LinkedList<>(cd.getSongs());
        Collections.sort(songCollection, new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return s1.getId().compareTo(s2.getId());
            }
        });
        currentIndex = 0;

    }

    public void playNext() {
        currentIndex++;
    }

    public void playPrevious() {
        currentIndex--;
    }

    public void jumpToSong(Song song) {
        //binary search and check edge case
    }

    public void stop() {

    }


    /* getters and setters */
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongCollection() {
        return songCollection;
    }

    public void setSongCollection(List<Song> songCollection) {
        this.songCollection = songCollection;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
