package android.example.musicalstructureapp.modals;

import androidx.annotation.NonNull;

public class SongItemModal {
    String songName,singerName,duration;

    public String getDuration() {
        return duration;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public SongItemModal(String songName,String singerName,String duration){
        this.songName=songName;
        this.singerName=singerName;
        this.duration=duration;
    }
}
