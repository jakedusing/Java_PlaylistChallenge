import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create albums
        Album album1 = new Album("Thriller", "Michael Jackson");
        album1.addSong("Thriller", 5.57);
        album1.addSong("Billie Jean", 4.54);
        album1.addSong("Beat It", 4.18);

        Album album2 = new Album("1989", "Taylor Swift");
        album2.addSong("Blank Space", 3.51);
        album2.addSong("Style", 3.51);
        album2.addSong("Shake It Off", 3.39);

        // Create playlist and add songs from albums
        LinkedList<Song> playList = new LinkedList<>();
        album1.addToPlayList("Thriller", playList);
        album1.addToPlayList("Billie Jean", playList);
        album2.addToPlayList("Style", playList);
        album2.addToPlayList("Shake It Off", playList);

        // Test the playlist functionality
        play(playList);
    }

    private static void play (LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        // ListIterator allows us to traverse the LinkedList forwards and backwards
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.isEmpty()) {
            System.out.println("No songs in playList.");
            return;
        } else {
            // start by playing the first song in the playlist
            System.out.println("Now playing: " + listIterator.next().toString());
        }

        printMenu();
        while (!quit) {
            System.out.print("Choose an action (5 to print menu options):");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1: // play the next song
                    if (!goingForward) {
                        // if currently moving backward, adjust iterator to move forward
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        // play the next song if available
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        // end of the playlist
                        System.out.println("End of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2: // play the previous song
                    if (goingForward) {
                        // if currently moving forward, adjust iterator to move backward
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        // play the previous song if available
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        // start of the playlist
                        System.out.println("Start of the playlist.");
                        goingForward = true;
                    }
                    break;
                case 3:  // replay the current song
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            // replay the previous song and adjust direction
                            System.out.println("Replaying: " + listIterator.previous().toString());
                            goingForward = false;
                        } else {
                            System.out.println("Start of the playlist.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            // replay the next song and adjust direction
                            System.out.println("Replaying: " + listIterator.next().toString());
                            goingForward = true;
                        } else {
                            System.out.println("End of the playlist");
                        }
                    }
                    break;
                case 4:
                    printPlaylist(playList);
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\nPress");
        System.out.println("""
                0 - to quit
                1 - to play next song
                2 - to play previous song
                3 - to replay the current song
                4 - list songs in the playlist
                5 - print menu options
                """);
    }

    private static void printPlaylist(LinkedList<Song> playList) {
        System.out.println("Playlist:");
        for (Song song : playList) {
            System.out.println(song);
        }
    }
}