package com.rootlol.yam.api;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.rootlol.yam.pojo.playlistdelet.PlaylistDeletePojo;
import com.rootlol.yam.pojo.playlistrename.PlaylistRenamePojo;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class settingsPlaylist extends AsyncTask<String, Void, String> {

    public String postDeletePlaylist(String token, String user_id, String kind){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/users/"+user_id+"/playlists/"+kind+"/delete")
                .header("Authorization", "OAuth "+token)
                .post(new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("somParam", "someValue")
                        .build())
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            PlaylistDeletePojo PDP = gson.fromJson(response.body().string(), PlaylistDeletePojo.class);

            if (PDP != null){
                if (PDP.getResult() != null) return PDP.getResult();
                else return PDP.getError().getMessage();
            }
            return "parse error";
        } catch (IOException e) {
            return "network error";
        }
    }

    public String postRenamePlaylist(String token, String user_id, String kind, String name){
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("value", name)
                .build();

        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/users/"+user_id+"/playlists/"+kind+"/name")
                .header("Authorization", "OAuth "+token)
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            PlaylistRenamePojo PRP = gson.fromJson(response.body().string(), PlaylistRenamePojo.class);

            if (PRP != null){
                if (PRP.getResult() != null) return "rename ok";
                else return "name error";
            }
            return "parse error";
        } catch (IOException e) {
            return "network error";
        }
    }

    public String postVisibilityPlaylist(String token, String user_id, String kind, String visibility){
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("value", visibility)
                .build();

        Request request = new Request.Builder()
                .url("https://api.music.yandex.net/users/"+user_id+"/playlists/"+kind+"/visibility")
                .header("Authorization", "OAuth "+token)
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            PlaylistRenamePojo PRP = gson.fromJson(response.body().string(), PlaylistRenamePojo.class);

            if (PRP != null){
                if (PRP.getResult() != null) return visibility;
                else return "error";
            }
            return "parse error";
        } catch (IOException e) {
            return "network error";
        }
    }


    @Override
    protected String doInBackground(String... lp) {
        switch (lp[0]) {
            case "delete":
                return postDeletePlaylist(lp[1], lp[2], lp[3]);
            case "rename":
                return postRenamePlaylist(lp[1], lp[2], lp[3], lp[4]);
            case "visibility":
                return postVisibilityPlaylist(lp[1], lp[2], lp[3], lp[4]);
            default:
                return null;
        }
    }
}