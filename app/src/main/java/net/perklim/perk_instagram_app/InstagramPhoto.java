package net.perklim.perk_instagram_app;

/**
 * Created by PerkLun on 5/5/2015.
 *
 * Class to present each popular photo
 */
public class InstagramPhoto {

    // Attributes of each photo
    public String username;
    public String caption;
    public String photo_url;
    public int image_height;
    public int no_of_likes;
    public String user_photo_url;

    /**
     * Creates a new photo object
     *
     * @param new_username photo username
     * @param new_caption photo caption
     * @param new_photo_url photo uro
     * @param new_image_height photo height
     * @param new_likes_count photo likes count
     * @param new_user_photo_url user photo url
     */
    public InstagramPhoto(String new_username, String new_caption, String new_photo_url, int new_image_height, int new_likes_count, String new_user_photo_url ) {
        username = new_username;
        caption = new_caption;
        photo_url = new_photo_url;
        image_height = new_image_height;
        no_of_likes = new_likes_count;
        user_photo_url = new_user_photo_url;
    }

    /**
     * Get photo caption
     *
     * @return caption
     */
    public String getCaption(){
        return caption;
    }

    /**
     * Get username for photo
     *
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /**
     * Get number of likes for photo
     *
     * @return no_of_likes with text "likes"
     */
    public String getLikes(){
        return no_of_likes + " likes";
    }
}
