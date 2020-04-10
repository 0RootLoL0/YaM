package com.rootlol.yam.tools;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class MusicRepository {

    private List<Track> data;

    private int maxIndex;
    private int currentItemIndex = 0;
    private static MusicRepository instance;

    public MusicRepository() {
        data = new ArrayList<>();
        instance = this;
    }
    public static MusicRepository getInstance() {
        return instance;
    }
    public void setData(Track data) {
        this.data.add(data);
        maxIndex = this.data.size();
    }

    public Track getNext() {
        if (currentItemIndex == maxIndex)
            currentItemIndex = 0;
        else
            currentItemIndex++;
        return getCurrent();
    }

    public Track getPrevious() {
        if (currentItemIndex == 0)
            currentItemIndex = maxIndex;
        else
            currentItemIndex--;
        return getCurrent();
    }

    public Track getCurrent() {
        return data.get(currentItemIndex);
    }

    public static class Track {

        private String title;
        private String artist;
        private Bitmap bitmapRes;
        private long duration; // in ms
        private Uri uri;

        public Track(String title, String artist, String bitmapResUri, long duration, int id) {
            /*this.title = title;
            this.artist = artist;
            this.duration = duration;
            MusicYandexApi.getInstance().getDownloadInfoUrl(id, "OAuth "+App.getInstance().getDatabase().userDao().getAll().get(0).token).enqueue(new Callback<DownloadInfoPojo>() {
                @Override
                public void onResponse(Call<DownloadInfoPojo> call, Response<DownloadInfoPojo> response) {

                    for (Result w :response.body().getResult()) {
                        if (w.getCodec().equals("mp3")) MusicYandexApi.getInstance().downloadUrl(w.getDownloadInfoUrl()).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                Matcher m1 = Pattern.compile("<host>.{1,}</host>").matcher(response.body());
                                m1.find();
                                Matcher m2 = Pattern.compile("<path>.{1,}</path>").matcher(response.body());
                                m2.find();
                                Matcher m3 = Pattern.compile("<ts>.{1,}</ts>").matcher(response.body());
                                m3.find();

                                uri = Uri.parse("https://"+m1.group().replace("<host>", "").replace("</host>", "")+"/get-mp3/d824bd57d0b34067ff9ec9a280f94fd9/"+m3.group().replace("<ts>", "").replace("</ts>", "")+m2.group().replace("<path>", "").replace("</path>", ""));
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                                ExceptionActivity.viewError("Error in MusicRepository.Track.Track.MusicYandexApi.getDownloadInfoUrl.onResponse.MusicYandexApi.downloadUrl");
                            }
                        });
                    }

                }

                @Override
                public void onFailure(Call<DownloadInfoPojo> call, Throwable t) {
                    ExceptionActivity.viewError("Error in MusicRepository.Track.Track.MusicYandexApi.getDownloadInfoUrl");
                }
            });
            Log.i("TAG", "Track: "+bitmapResUri);
            MusicYandexApi.getInstance().getCover(bitmapResUri).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        bitmapRes = BitmapFactory.decodeStream(response.body().byteStream());
                    }catch (NullPointerException e){
                        Intent intent= new Intent(App.getInstance(), ExceptionActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        App.getInstance().startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    ExceptionActivity.viewError("Error in MusicRepository.Track.Track.MusicYandexApi.getCover");
                }
            });
*/
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public Bitmap getBitmapResId() {
            return bitmapRes;
        }

        public Uri getUri() {
            return uri;
        }
        public long getDuration() {
            return duration;
        }
    }
}
