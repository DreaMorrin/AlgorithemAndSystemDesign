package main.Practice.CC189.JukeBox.models;

public class Song {
    private String id;
    private long length;
    private String artist;

    private Song(String id, long length, String artist) {
        this.id = id;
        this.length = length;
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
