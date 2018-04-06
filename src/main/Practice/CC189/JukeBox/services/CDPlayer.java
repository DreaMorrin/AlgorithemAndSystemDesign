package main.Practice.CC189.JukeBox.services;

import main.Practice.CC189.JukeBox.models.CD;
import main.Practice.CC189.JukeBox.models.Song;

public class CDPlayer {
    private CD cdUnderPlay;
    private SongSelector songSelector;

    public CDPlayer (CD cd, SongSelector songSelector) {
        this.cdUnderPlay = cd;
        this.songSelector = songSelector;
    }

    public Song getCurrentSong() {
        return songSelector.getCurrentSong();
    }

    public void playCd(CD cd) {
        this.songSelector.reset(cd);
        this.cdUnderPlay = cd;
    }

    public void playNext() {
        songSelector.playNext();
    }

    public void playPrevious() {
        songSelector.playPrevious();
    }

    public void pause() {
        songSelector.stop();
    }


    /* getters and setters */
    public CD getCdUnderPlay() {
        return cdUnderPlay;
    }

    public void setCdUnderPlay(CD cdUnderPlay) {
        this.cdUnderPlay = cdUnderPlay;
    }

    public SongSelector getSongSelector() {
        return songSelector;
    }

    public void setSongSelector(SongSelector songSelector) {
        this.songSelector = songSelector;
    }
}
