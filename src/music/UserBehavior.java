package music;

public interface UserBehavior {
    void createPlaylist(String title, User owner) throws InvalidOperationException;
    void playMusic(Music music) throws InvalidOperationException;
    void buyPremium(User user) throws InvalidOperationException;
}