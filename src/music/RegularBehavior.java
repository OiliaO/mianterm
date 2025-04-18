package music;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) throws InvalidOperationException {
        throw new InvalidOperationException("کاربران عادی نمی‌توانند پلی‌لیست ایجاد کنند");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if (playingLimit < 1) {
            throw new InvalidOperationException("محدودیت پلی کردن موزیک برای کاربر عادی به پایان رسیده است");
        }
        music.play();
        playingLimit--;
    }

    @Override
    public void buyPremium(User user) {
        System.out.println("اشتراک یک ماهه برای کاربر " + user.getUsername() + " فعال شد");
        user.setBehavior(new PremiumBehavior());
    }
}