package com.rootlol.yam.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.palette.graphics.Palette;

import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.MainActivity;
import com.rootlol.yam.tools.PlayerTool;

import org.videolan.libvlc.Media;

public class YaMPlayerService extends Service {

    private NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = App.getInstance().getNotificationManager();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String s = intent.getAction();

        if (s.equals("startServise")) startMedia();
        else if (s.equals("Iplay")) PlayPauseMedia();


        return super.onStartCommand(intent, flags, startId);
    }

    public void showNotification(String title, String message) {
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent PIacti = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Intent Iprevious = new Intent(this, YaMPlayerService.class);
        Iprevious.setAction("Iprevious");
        PendingIntent PIprevious = PendingIntent.getService(this, 0, Iprevious, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent Iplay = new Intent(this, YaMPlayerService.class);
        Iplay.setAction("Iplay");
        PendingIntent PIplay = PendingIntent.getService(this, 0, Iplay, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent Iskip = new Intent(this, YaMPlayerService.class);
        Iskip.setAction("Iskip");
        PendingIntent PIskip = PendingIntent.getService(this, 0, Iskip, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification;

        Bitmap artwork = BitmapFactory.decodeResource(getResources(), R.drawable.playlist_no_cover);//.ImageTool.convert(null, getResources());

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            androidx.media.app.NotificationCompat.MediaStyle style = new androidx.media.app.NotificationCompat.MediaStyle()
                    .setShowActionsInCompactView(0, 1, 2, 3);


            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "NotificationPlayer")
                    .setSmallIcon(R.drawable.ic_icon)
                    .setLargeIcon(artwork)
                    .setContentIntent(PIacti)
                    .setContentTitle(title)
                    .setContentText(message)
                    .addAction(R.drawable.ic_skip_previous_white_24dp,"", PIprevious)
                    .addAction(R.drawable.ic_play_white, "", PIplay)
                    .addAction(R.drawable.ic_skip_next_white_24dp, "", PIskip)
                    .setStyle(style);

                    builder.setColor(Color.parseColor("#403f4d"));
                    builder.setColorized(true);

            notification = builder.build();
            Log.d("qqqq", Palette.from(artwork).generate().getVibrantColor(Color.parseColor("#403f4d"))+"");

        } else {
            notification =
                    new Notification.Builder(this)
                            .setSmallIcon(R.drawable.ic_icon)
                            .setLargeIcon(artwork)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setContentIntent(PIacti)
                            .addAction(R.drawable.ic_skip_previous_white_24dp,"", PIprevious)
                            .addAction(R.drawable.ic_play_white, "", PIplay)
                            .addAction(R.drawable.ic_skip_next_white_24dp, "", PIskip)
                            .build();
        }

        notificationManager.notify(1, notification);
    }

    private void startMedia(){

        final Media media = new Media(PlayerTool.getInstance().mLibVLC, Uri.parse("https://ru.kachevo.org/get/music/20181130/musicbossorg_KIKO_Music_-_Marcher_au_sud_60637949.mp3"));
        PlayerTool.getInstance().mMediaPlayer.setMedia(media);
        media.release();
        showNotification("Marcher au sud ", "KIKO Music");
        PlayerTool.getInstance().mMediaPlayer.play();

    }
    private void PlayPauseMedia(){
        if (PlayerTool.getInstance().mMediaPlayer.isPlaying()) {
            PlayerTool.getInstance().mMediaPlayer.pause();
        } else {
            PlayerTool.getInstance().mMediaPlayer.play();
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("qqqq", "ffffffff");
        PlayerTool.getInstance().mMediaPlayer.release();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) notificationManager.cancel("NotificationPlayer",1);
        else notificationManager.cancel(1);
    }

}
