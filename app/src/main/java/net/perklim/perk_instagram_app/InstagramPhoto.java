package net.perklim.perk_instagram_app;

/**
 * Created by PerkLun on 5/5/2015.
 */
public class InstagramPhoto {
    public String username;
    public String caption;
    public String photo_url;
    public int image_height;
    public int likes_count;

    public InstagramPhoto(String new_username, String new_caption, String new_photo_url, int new_image_height, int new_likes_count ){
        username = new_username;
        caption = new_caption;
        photo_url = new_photo_url;
        image_height = new_image_height;
        likes_count = new_likes_count;
    }

    public String getCaption(){
        return "User: " + username + " Caption: " + caption + " Likes: " + likes_count;
    }
}
