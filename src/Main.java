import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Comatose1");
        album1.addSong("Monster1", 3.56);
        album1.addSong("Monster2", 4.56);
        album1.addSong("Monster3", 5.56);
        album1.addSong("Monster4", 6.56);

        Album album2 = new Album("Comatose2");
        album2.addSong("Whisper1", 3.56);
        album2.addSong("Whisper2", 4.56);
        album2.addSong("Whisper3", 5.56);
        album2.addSong("Whisper4", 6.56);

        PlayList playList = new PlayList();
        playList.addSongToPlayList(album1, "Monster4");
        playList.addSongToPlayList(album2, "Whisper1");
        playList.addSongToPlayList(album2, "Whisper3");
        playList.addSongToPlayList(album2, "Whisper2");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playList.getPlayList().listIterator();
        if (listIterator.hasNext())
            System.out.println(listIterator.next().getTitle() + " playing.");

        showMenu();
        while(running){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    running = false;
                    break;
                case 1:
                    if(!goingForward){
                        if (listIterator.hasNext())
                            listIterator.next();
                        goingForward = true;
                    }

                    if(listIterator.hasNext())
                        System.out.println(listIterator.next().getTitle() + " playing.");
                    else
                        System.out.println("Reached the end of the list.");
                    break;
                case 2:
                    if(goingForward){
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious())
                        System.out.println(listIterator.previous().getTitle() + " playing.");
                    else
                        System.out.println("We are at the start of the list.");

                    break;
                case 3:
                    if(listIterator.hasPrevious())
                    listIterator.previous();
                    System.out.println(listIterator.next().getTitle() + " replaying.");
                    break;
                case 4:
                    printListOfSongs(playList);
                    break;
                case 5:
                    if(listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous().getTitle() + " removed.");
                        listIterator.remove();
                    }
                    if(listIterator.hasNext())
                    listIterator.next();
                    else
                        System.out.println("List is empty.");
                    break;
                case 6:
                    showMenu();
                    break;
            }
        }
    }


    private static void printListOfSongs(PlayList playList){
        if (playList.getPlayList().isEmpty())
            System.out.println("List is empty.");
        int index=0;
        for(Song song : playList.getPlayList()){
            index++;
            System.out.println(index +". "+song.getTitle());
        }
    }

    private static void showMenu(){
        System.out.println("\n0. Quit.\n" +
                "1. Play next song.\n" +
                "2. Play previous song.\n" +
                "3. Replay current song.\n" +
                "4. Print playlist.\n" +
                "5. Remove current cong.\n" +
                "6. Show menu.");
    }

}
