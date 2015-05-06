package net.perklim.perk_instagram_app;

/**
 * Created by PerkLun on 5/5/2015.
 */
public class InstagramPhoto {
    public String username;
    public String caption;
    public String photo_url;
    public int image_height;
    public int likes;
    public String user_photo_url;

    public InstagramPhoto(String new_username, String new_caption, String new_photo_url, int new_image_height, int new_likes_count, String new_user_photo_url ){
        username = new_username;
        caption = new_caption;
        photo_url = new_photo_url;
        image_height = new_image_height;
        likes = new_likes_count;
        user_photo_url = new_user_photo_url;
    }

    public String getCaption(){
        return caption + " Likes: " + likes;
    }
    public String getUsername(){
        return username;
    }
}
