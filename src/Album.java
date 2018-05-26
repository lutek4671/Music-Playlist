import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Song> songs;

    public Album(String albumName) {
        this.albumName = albumName;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            System.out.println(title + " already is in the list.");
            return false;
        } else
            songs.add(new Song(title, duration));
        return true;
    }

    public boolean removeSong(String title) {
        if (findSong(title) == null) {
            System.out.println("Could not find " + title + ".");
            return false;
        } else
            songs.remove(findSong(title));
        return true;
    }

    public Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title))
                return song;
        }
        return null;
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
