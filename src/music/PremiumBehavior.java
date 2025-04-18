package music;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior() {
        this.month = 1;
    }

    @Override
    public void createPlaylist(String title, User owner) {
        Playlist playlist = new Playlist(title, owner);
        owner.getPlaylists().add(playlist);

        System.out.printf("پلی‌لیست جدید با عنوان " + "%s " , title + " با موفقیت افزوده شد \n");
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User user) {
        this.month++;
        System.out.println("کاربر " + user.getUsername() + " اشتراک خود را یک ماه تمدید کرد");
    }

    public int getMonth() {
        return month;
    }
}