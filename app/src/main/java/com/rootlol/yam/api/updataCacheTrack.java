package com.rootlol.yam.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.rootlol.yam.db.TrackListCacheDB;
import com.rootlol.yam.pojo.downloadinfo.DownloadInfoPojo;
import com.rootlol.yam.pojo.likestracks.LikesTracksPojo;
import com.rootlol.yam.pojo.track.TrackPojo;
import com.rootlol.yam.pojo.usersplaylists.Track;
import com.rootlol.yam.pojo.usersplaylists.UsersPlaylistsPojo;
import com.rootlol.yam.tools.ImageTool;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    String TAG = "qazxcdew";
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
    public JSONArray getGetLikes(String token, String user_id){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/users/"+user_id+"/likes/tracks")
                .header("Authorization", "OAuth "+token)
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            JSONParser jsonParser = new JSONParser();
            Log.i(TAG, "getGetLikes: start");
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.body().string());
            Log.i(TAG, "getGetLikes: end");
            JSONArray lang = ((JSONArray)((JSONObject)((JSONObject)jsonObject.get("result")).get("library")).get("tracks"));
            Log.i(TAG, "getGetLikes: getarray");
            if (lang != null){
                return lang;
            }
            return null;
        } catch (IOException | ParseException e) {
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
                if (TP.getResult().get(0).getAvailable() && TP.getResult().get(0).getArtists().size()!=0)
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
                            Integer.parseInt(kind),
                            getDownloadInfoUrl(token, track_id));
                else if (TP.getResult().get(0).getAvailable())
                    return new TrackListCacheDB.TrackListCacheEntity(
                            TP.getResult().get(0).getTitle(),
                            TP.getResult().get(0).getId(),
                            TP.getResult().get(0).getVersion(),
                            0,
                            "podcast",
                            TP.getResult().get(0).getAlbums().get(0).getId().intValue(),
                            TP.getResult().get(0).getAlbums().get(0).getTitle(),
                            getBase64Image(TP.getResult().get(0).getCoverUri()),
                            TP.getResult().get(0).getDurationMs().intValue(),
                            Integer.parseInt(kind),
                            getDownloadInfoUrl(token, track_id));
                else return new TrackListCacheDB.TrackListCacheEntity(
                        TP.getResult().get(0).getTitle(),
                        TP.getResult().get(0).getId(),
                        "not availableFullWithoutPermission",
                        TP.getResult().get(0).getArtists().get(0).getId().intValue(),
                        TP.getResult().get(0).getArtists().get(0).getName(),
                        0,
                        "not availableFullWithoutPermission",
                        null,
                        0,
                        Integer.parseInt(kind),
                        "https://codeskulptor-demos.commondatastorage.googleapis.com/pang/paza-moduless.mp3");
            }
            return null;
        } catch (IOException | NullPointerException e) {
            return null;
        }
    }
    public String getDownloadInfoUrl(String token, String track_id){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/tracks/"+track_id+"/download-info")
                .header("Authorization", "OAuth "+token)
                .build();
        try {
            okhttp3.Response response = client.newCall(request).execute();
            DownloadInfoPojo DIP = gson.fromJson(response.body().string(), DownloadInfoPojo.class);
            if (DIP != null){
                return DIP.getResult().get(3).getDownloadInfoUrl();
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

        Log.i(TAG, "doInBackground: kind:" + lp[2]);
        if (!lp[2].equals("3")) {
            Log.i(TAG, "doInBackground: not 3");
            List<Track> mGetTrackList = getTrackList(lp[0], lp[1], lp[2]);
            if (mGetTrackList != null) {
                for (Track track : mGetTrackList) {

                    tempItem.add(getTrackInfo(lp[0], "" + track.getId(), lp[2]));
                }
            }
        }else {
            Log.i(TAG, "doInBackground: 3www");
            JSONArray lang = getGetLikes(lp[0], lp[1]);
            Log.i(TAG, "doInBackground: "+lang.size());
            if (lang != null) {
                for (int i=0; i<lang.size(); i++) {
                    Log.i(TAG, "doInBackground: "+((JSONObject) lang.get(i)).get("id"));
                    TrackListCacheDB.TrackListCacheEntity ww = getTrackInfo(lp[0], ""+((JSONObject) lang.get(i)).get("id"), lp[2]);
                    if(ww != null)
                    tempItem.add(getTrackInfo(lp[0], ""+((JSONObject) lang.get(i)).get("id"), lp[2]));
                }
            }
        }

        return tempItem;
    }
}