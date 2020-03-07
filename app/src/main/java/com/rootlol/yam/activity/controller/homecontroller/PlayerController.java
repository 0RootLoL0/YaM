package com.rootlol.yam.activity.controller.homecontroller;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rootlol.yam.R;
import com.rootlol.yam.service.YaMPlayerService;
import com.rootlol.yam.tools.PlayerTool;

import org.videolan.libvlc.MediaPlayer;

public class PlayerController extends Controller {

    public PlayerController() {
    }
    ImageButton IBprevious;
    ImageButton IBnext;
    FloatingActionButton FABplaypausefloating;
    SeekBar song_progress;


    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_player, container, false);
        bind(view);
        FABplaypausefloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (PlayerTool.getInstance().mMediaPlayer.isPlaying()) FABplaypausefloating.setImageResource(R.drawable.ic_pause_white);
                else FABplaypausefloating.setImageResource(R.drawable.ic_play_white);

                Intent intent = new Intent(getActivity(), YaMPlayerService.class);
                intent.setAction("Iplay");
                getActivity().startService(intent);
            }
        });
        PlayerTool.getInstance().mMediaPlayer.setEventListener(new MediaPlayer.EventListener() {
            @Override
            public void onEvent(MediaPlayer.Event event) {
                int posit = (int) (PlayerTool.getInstance().mMediaPlayer.getPosition()*10000);
                song_progress.setProgress(posit);
            }
        });
        return view;
    }

    private void bind(@NonNull View view) {
        IBprevious = view.findViewById(R.id.previous);
        IBnext = view.findViewById(R.id.next);
        FABplaypausefloating = view.findViewById(R.id.playpausefloating);
        song_progress = view.findViewById(R.id.song_progress);
    }
}
