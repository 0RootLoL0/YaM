package com.rootlol.yam.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.rootlol.yam.db.TrackListCacheDB;
import com.rootlol.yam.pojo.track.TrackPojo;
import com.rootlol.yam.pojo.usersplaylists.Track;
import com.rootlol.yam.pojo.usersplaylists.UsersPlaylistsPojo;
import com.rootlol.yam.tools.ImageTool;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class updataCacheTrack extends AsyncTask<String, Void, List<TrackListCacheDB.TrackListCacheEntity>> {

    Gson gson;

    public List<Track> getTrackList(String token, String user_id, String kind){
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("kinds", kind)
                .build();
        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/users/"+user_id+"/playlists/")
                .header("Authorization", "OAuth "+token)
                .post(formBody)
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            UsersPlaylistsPojo UPP = gson.fromJson(response.body().string(), UsersPlaylistsPojo.class);

            if (UPP != null){
                return UPP.getResult().get(0).getTracks();
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public TrackListCacheDB.TrackListCacheEntity getTrackInfo(String token, String track_id, String kind){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/tracks/"+track_id)
                .header("Authorization", "OAuth "+token)
                .build();
        try {
            okhttp3.Response response = client.newCall(request).execute();
            TrackPojo TP = gson.fromJson(response.body().string(), TrackPojo.class);

            if (TP != null){
                return new TrackListCacheDB.TrackListCacheEntity(
                        TP.getResult().get(0).getTitle(),
                        TP.getResult().get(0).getId(),
                        TP.getResult().get(0).getVersion(),
                        TP.getResult().get(0).getArtists().get(0).getId().intValue(),
                        TP.getResult().get(0).getArtists().get(0).getName(),
                        TP.getResult().get(0).getAlbums().get(0).getId().intValue(),
                        TP.getResult().get(0).getAlbums().get(0).getTitle(),
                        getBase64Image(TP.getResult().get(0).getCoverUri()),
                        TP.getResult().get(0).getDurationMs().intValue(),
                        Integer.parseInt(kind));
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public String getBase64Image(String src){
        try {
            URL url = new URL("https://"+src.replace("%%", "100x100"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            String test = ImageTool.convert(myBitmap);
            return test;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    protected List<TrackListCacheDB.TrackListCacheEntity> doInBackground(String... lp) {
        gson = new Gson();
        List<TrackListCacheDB.TrackListCacheEntity> tempItem = new ArrayList<>();

        List<Track> mGetTrackList = getTrackList(lp[0], lp[1], lp[2]);
        if (mGetTrackList != null){
            for (Track track : mGetTrackList){

                tempItem.add(getTrackInfo(lp[0], ""+track.getId(), lp[2]) );
            }
        }

        return tempItem;
    }
}