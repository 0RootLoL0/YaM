package com.rootlol.yam.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;

import com.rootlol.yam.R;

public class DialogScreenTool {

    public static final int IDD_ABOUT = 1;
    public static final int IDD_SETTINGS = 2;
    public static AlertDialog dialog;

    public static AlertDialog getDialog(Activity activity, int ID) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        switch(ID) {
            case IDD_ABOUT: // Диалоговое About
                builder.setTitle("lol");
                builder.setMessage("heh");
                builder.setCancelable(true);
                dialog = builder.create();
                return dialog;
            case IDD_SETTINGS: // Диалог настроек
                View view = activity.getLayoutInflater().inflate(R.layout.dialog_playlist_settings, null); // Получаем layout по его ID
                builder.setView(view);
                builder.setTitle(R.string.dialog_playlist_settings_title);
                builder.setCancelable(true);
                return builder.create();
            default:
                return null;
        }
    }
}
