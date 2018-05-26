import java.util.ArrayList;
import java.util.LinkedList;

public class PlayList {
    private LinkedList<Song> playList;

    public PlayList() {
        this.playList = new LinkedList<>();
    }

    public boolean addSongToPlayList(Album album, String songTitle){
        Song song = album.findSong(songTitle);
        if(song != null){
            playList.add(song);
            return true;
        }
        return false;
    }

    public void removeCurrentSong(Song song){
        playList.remove(song);
    }

    public LinkedList<Song> getPlayList() {
        return playList;
    }
}
