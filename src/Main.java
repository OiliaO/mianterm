import music.InvalidOperationException;
import music.Music;

import music.Playlist;
import music.User;

public class Main {
    public static void main(String[] args) throws InvalidOperationException {
        User user1 = new User("ilia" ,"12345678");
        User user2 = new User("mehrdad" , "87654321");
        user1.follow(user1);
        user2.follow(user1);
        user1.printFollowers();
        user1.buyPremium();
        Music music1 = new Music("hi" , user1);
        Music music3 = new Music("hi" , user2);
        Music music2 = new Music("hello" , user1);
        Music.search("hi");
        user1.createPlaylist("shab");
        Playlist shab = new Playlist("shab" ,  user1);
        shab.addMusic(music1 , "12345678");
        shab.removeMusic(music1 , "12345678");
        shab.editTitle("rooz" , "12345678");
        shab.addMusic(music1 , "12345678");
        shab.addMusic(music2 , "12345678");
        shab.addMusic(music3 , "12345678");

        shab.searchInPlaylist("hi");
        shab.playPlaylist();
    }
}