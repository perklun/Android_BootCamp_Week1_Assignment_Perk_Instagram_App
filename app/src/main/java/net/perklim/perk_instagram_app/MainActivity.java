package net.perklim.perk_instagram_app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.loopj.android.http.*;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    // Instagram params
    public static String client_id = "2e64cf453fa140b0a92459eab546ada9";
    public static String instagram_url = "https://api.instagram.com/v1/media/popular?client_id=";

    private static ArrayList<InstagramPhoto> photo_array;
    private InstagramArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up photo list
        photo_array = new ArrayList<InstagramPhoto>();
        ListView lvPics = (ListView) findViewById(R.id.lvPics);
        adapter = new InstagramArrayAdapter(this, photo_array);
        lvPics.setAdapter(adapter);
        fetchPopularPhotos();
    }

    /**
     * Makes Async request to retrieve Instagram popular photos
     * Parses JSON and creates photo objects
     *
     */
    public void fetchPopularPhotos(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(instagram_url+client_id, null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray photo_json = null;
                try{
                    photo_json = response.getJSONArray("data");
                    for(int i = 0; i < photo_json.length(); i++){
                        JSONObject obj = photo_json.getJSONObject(i);
                        // Creates photo object for each photo
                        InstagramPhoto photo = new InstagramPhoto(
                                obj.getJSONObject("user").getString("username"),
                                obj.getJSONObject("caption").getString("text"),
                                obj.getJSONObject("images").getJSONObject("standard_resolution").getString("url"),
                                obj.getJSONObject("images").getJSONObject("standard_resolution").getInt("height"),
                                obj.getJSONObject("likes").getInt("count"),
                                obj.getJSONObject("user").getString("profile_picture")
                        );
                        photo_array.add(photo);
                    }
                } catch (JSONException je){
                    Log.i("DEBUG JSON", je.toString());
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.i("DEBUG JSON", statusCode + " " + errorResponse.toString());
            }
        });
    }
}
