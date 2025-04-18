package music;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) throws InvalidOperationException {
        boolean usernameExists = false;
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                usernameExists = true;
                break;
            }
        }

        if (username == null || username.isEmpty() || usernameExists) {
            throw new InvalidOperationException("نام کاربری تکراری یا نامعتبر است");
        }

        if (password == null || password.length() < 8) {
            throw new InvalidOperationException("رمز عبور باید حداقل 8 کاراکتر داشته باشد");
        }

        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public ArrayList<User> getFollowerList() { return followerList; }
    public ArrayList<User> getFollowingList() { return followingList; }
    public UserBehavior getBehavior() { return behavior; }
    public void setBehavior(UserBehavior behavior) { this.behavior = behavior; }
    public ArrayList<Playlist> getPlaylists() { return playlists; }
    public static ArrayList<User> getAllUsers() { return allUsers; }

    public void follow(User user) {
        if (!followingList.contains(user)) {
            followingList.add(user);
            user.getFollowerList().add(this);
        }
    }

    public void unfollow(User user) {
        followingList.remove(user);
        user.getFollowerList().remove(this);
    }

    public void printFollowers() {
        if (followerList.isEmpty()) {
            System.out.println("هنوز هیچ فالوری ندارید!");
            return;
        }

        System.out.println("لیست فالورهای شما (" + followerList.size() + " نفر):");
        for (User follower : followerList) {
            System.out.println("- " + follower.getUsername());
        }
    }

    public void printFollowing() {
        if (followingList.isEmpty()) {
            System.out.println("هنوز هیچ کسی را فالو نکرده‌اید!");
            return;
        }

        System.out.println("لیست افرادی که فالو کرده‌اید (" + followingList.size() + " نفر):");
        for (User following : followingList) {
            System.out.println("- " + following.getUsername());
        }
    }

    public void createPlaylist(String title) throws InvalidOperationException {
        behavior.createPlaylist(title, this);
    }

    public void playMusic(Music music) throws InvalidOperationException {
        behavior.playMusic(music);
    }

    public void buyPremium() throws InvalidOperationException {
        behavior.buyPremium(this);
    }
}