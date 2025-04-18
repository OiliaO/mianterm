package music;

import java.util.ArrayList;

public class Music {
    private final String title;
    private final User singer;
    private int numberOfStreams = 0;
    private static final ArrayList<Music> allMusic = new ArrayList<>();

    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusic.add(this);
    }

    public String getTitle() { return title; }
    public User getSinger() { return singer; }
    public int getNumberOfStreams() { return numberOfStreams; }
    public static ArrayList<Music> getAllMusic() { return allMusic; }

    public void play() {
        System.out.println("در حال پخش موزیک '" + title + "' از " + singer.getUsername());
        numberOfStreams++;
    }

    public static ArrayList<Music> search(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : allMusic) {
            if (music.getTitle().equalsIgnoreCase(title.trim())) {
                result.add(music);
            }
        }

        if (result.isEmpty()) {
            System.out.println(" هیچ موزیکی با عنوان " + title + " یافت نشد");
        } else {
            System.out.printf(" %d نتیجه برای جستجوی '%s' یافت شد:\n", result.size(), title);
            for (Music m : result) {
                System.out.printf("- %s (خواننده: %s)%n", m.getTitle(), m.getSinger().getUsername());
            }
        }

        return result;
    }

    public static Music search(String title, User artist) {
        for (Music music : allMusic) {
            if (music.getTitle().equals(title) && music.getSinger().equals(artist)) {
                System.out.println("موزیک یافت شد: '" + title + "' از " + artist.getUsername());
                return music;
            }
        }

        System.out.println("هیچ موزیکی با عنوان '" + title + "' از هنرمند " + artist.getUsername() + " یافت نشد");
        return null;
    }
}