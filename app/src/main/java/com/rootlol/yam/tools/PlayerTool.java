package com.rootlol.yam.tools;

import com.rootlol.yam.App;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.MediaPlayer;

import java.util.ArrayList;

public class PlayerTool {

    private static PlayerTool instance;
    public LibVLC mLibVLC;
    public MediaPlayer mMediaPlayer;

    private PlayerTool() {
        final ArrayList<String> args = new ArrayList<>();
        args.add("-vvv");

        mLibVLC = new LibVLC(App.getInstance().getApplicationContext(), args);// и так сойдёт
        mMediaPlayer = new MediaPlayer(mLibVLC);
    }

    public static PlayerTool getInstance(){
        if(instance == null){
            instance = new PlayerTool();
        }
        return instance;
    }
}
