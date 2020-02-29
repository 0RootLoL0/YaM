package com.rootlol.yam.tools;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.rootlol.yam.R;

import java.io.ByteArrayOutputStream;

public class ImageTool {

    public static Bitmap convert(String base64Str, Resources resurs) throws IllegalArgumentException {
        if (base64Str != null){
            byte[] decodedBytes = Base64.decode(
                    base64Str.substring(base64Str.indexOf(",") + 1),
                    Base64.DEFAULT
            );
            return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        }else return BitmapFactory.decodeResource(resurs, R.drawable.playlist_no_cover);
    }

    public static String convert(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
    }

}
