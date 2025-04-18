package music;

import java.util.ArrayList;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Music> getPlaylist() {
        return playlist;
    }

    public User getOwner() {
        return owner;
    }

    public void editTitle(String newTitle, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("خطا: رمز عبور برای ویرایش عنوان پلی‌لیست نادرست است");
        }
        System.out.printf("عنوان پلی‌لیست از '%s' به '%s' تغییر یافت%n", this.title, newTitle);
        this.title = newTitle;
    }


    public void addMusic(Music music, String password) throws InvalidOperationException {

        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("خطا: رمز عبور برای اضافه کردن موزیک به پلی‌لیست نادرست است");
        }

        if (playlist.contains(music)) {
            throw new InvalidOperationException("خطا : موزیک از قبل در پلی لیست بوده است.");
        }

        playlist.add(music);
        System.out.printf(" موزیک '%s' با موفقیت به پلی‌لیست '%s' اضافه شد%n", music.getTitle(), this.title);
    }


    public void removeMusic(Music music, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("خطا: رمز عبور برای حذف موزیک از پلی‌لیست نادرست است");
        }

        if (playlist.remove(music)) {
            System.out.printf("موزیک '%s' با موفقیت از پلی‌لیست '%s' حذف شد%n", music.getTitle(), this.title);
        } else {
            throw new InvalidOperationException("خطا: موزیک مورد نظر در پلی‌لیست وجود ندارد");
        }
    }


    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : playlist) {
            if (music.getTitle().equals(title)) {
                result.add(music);
            }
        }
        System.out.printf("%d مورد موزیک با نام '%s' در پلی لیست موجود است\n"
                , result.size() , title);
        return result;
    }

    public Music searchInPlaylist(String title, User artist) {
        for (Music music : playlist) {
            if (music.getTitle().equalsIgnoreCase(title.trim()) &&
                    music.getSinger().equals(artist)) {
                System.out.printf("\n موزیک یافت شد در پلی‌لیست '%s':%n", this.title);
                System.out.printf("   عنوان: %s%n   هنرمند: %s%n", music.getTitle(), artist.getUsername());
                return music;
            }
        }

        System.out.printf("\n موزیک '%s' از هنرمند '%s' در پلی‌لیست '%s' یافت نشد%n",  title, artist.getUsername(), this.title);
        return null;
    }

    public void playPlaylist() {
        int trackNumber = 1;
        for (Music music : playlist) {
            System.out.printf("%d. در حال پخش موزیک '%s' از %s\n",
                    trackNumber++,
                    music.getTitle(),
                    music.getSinger().getUsername());
        }
    }
}