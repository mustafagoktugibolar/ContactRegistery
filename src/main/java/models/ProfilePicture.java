package models;

import java.io.FileInputStream;

public class ProfilePicture {
    private int photo_id;
    private String username;
    private byte[] profile_photo;


    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(byte[] profile_photo) {
        this.profile_photo = profile_photo;
    }
}
