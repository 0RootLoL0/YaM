/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.activity.controller.homecontroller;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.activity.MainActivity;
import com.rootlol.yam.service.PlayerService;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.BIND_AUTO_CREATE;
// TODO: добовлять удалённые треки в отдельный плейлист
public class PlayerController extends Controller {

    ImageButton IBprevious;
    ImageButton IBnext;
    FloatingActionButton FABplaypausefloating;
    SeekBar song_progress;
    ImageView album_art;
    TextView song_title;
    TextView song_artist;

    private PlayerService.PlayerServiceBinder playerServiceBinder;
    private MediaControllerCompat mediaController;
    private MediaControllerCompat.Callback callback;
    private ServiceConnection serviceConnection;

    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_player, container, false);
        bind(view);
/*


        callback = new MediaControllerCompat.Callback() {
            @Override
            public void onPlaybackStateChanged(PlaybackStateCompat state) {
                if (state == null)
                    return;

                if (state.getState() == PlaybackStateCompat.STATE_PLAYING & state.getState() != PlaybackStateCompat.STATE_PAUSED) {
                    boolean playing = state.getState() == PlaybackStateCompat.STATE_PLAYING;
                    if (playing) FABplaypausefloating.setImageResource(R.drawable.ic_pause_white);
                    else FABplaypausefloating.setImageResource(R.drawable.ic_play_white);
                } else if (state.getState() == PlaybackStateCompat.STATE_SKIPPING_TO_NEXT || state.getState() == PlaybackStateCompat.STATE_SKIPPING_TO_PREVIOUS) {
                    album_art.setImageBitmap(mediaController.getMetadata().getBitmap(MediaMetadataCompat.METADATA_KEY_ART));
                    song_title.setText(mediaController.getMetadata().getText(MediaMetadataCompat.METADATA_KEY_TITLE));
                    song_artist.setText(mediaController.getMetadata().getText(MediaMetadataCompat.METADATA_KEY_ARTIST));
                }
            }

            @Override
            public void onSessionEvent(String event, Bundle extras) {
                super.onSessionEvent(event, extras);
            }
        };

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                playerServiceBinder = (PlayerService.PlayerServiceBinder) service;
                try {
                    mediaController = new MediaControllerCompat(getApplicationContext(), playerServiceBinder.getMediaSessionToken());
                    mediaController.registerCallback(callback);
                    callback.onPlaybackStateChanged(mediaController.getPlaybackState());
                    callback.onSessionEvent(mediaController.getPackageName(), mediaController.getExtras());

                }
                catch (RemoteException e) {
                    mediaController = null;
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                playerServiceBinder = null;
                if (mediaController != null) {
                    mediaController.unregisterCallback(callback);
                    mediaController = null;
                }
            }
        };

        getActivity().bindService(new Intent(getApplicationContext(), PlayerService.class), serviceConnection, BIND_AUTO_CREATE);

        FABplaypausefloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaController != null)
                    mediaController.getTransportControls().play();
            }
        });

        IBnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaController != null)
                    mediaController.getTransportControls().skipToNext();
            }
        });

        IBprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaController != null)
                    mediaController.getTransportControls().skipToPrevious();
            }
        });

        song_progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    float offset = (float) progress / seekBar.getMax();
                    PlayerService.getInstance().getExoPlayer().seekTo((long) (offset * PlayerService.getInstance().getExoPlayer().getDuration()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (PlayerService.getInstance().getExoPlayer() != null) {
                            Long progress = PlayerService.getInstance().getExoPlayer().getCurrentPosition();
                            Long max = PlayerService.getInstance().getExoPlayer().getDuration();
                            if (max > 0) {
                                song_progress.setMax(max.intValue());
                            }
                            song_progress.setProgress(progress.intValue());
                        }
                    }
                });
            }
        }, 0, 1000);*/
        return view;
    }




    private void bind(@NonNull View view) {
        IBprevious = view.findViewById(R.id.previous);
        IBnext = view.findViewById(R.id.next);
        FABplaypausefloating = view.findViewById(R.id.playpausefloating);
        song_progress = view.findViewById(R.id.song_progress);
        album_art = view.findViewById(R.id.album_art);
        song_title = view.findViewById(R.id.song_title);
        song_artist = view.findViewById(R.id.song_artist);
    }

    public void wwww() {
        playerServiceBinder = null;
        if (mediaController != null) {
            mediaController.unregisterCallback(callback);
            mediaController = null;
        }
        getActivity().unbindService(serviceConnection);
    }

    @NonNull
    @Override
    public Bundle getArgs() {
        wwww();
        return super.getArgs();
    }
}
