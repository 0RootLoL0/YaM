/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

/**
 * аааа полез сюда так вот ответ на вопрос почем @id это тип string ответ прост,
 * потому что api yandex пихает всё что не поподя: и строки, и числа, и писюны, вобщем всё
 */
package io.github.rootlol.yamapilib.pojo.feed;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Title {

    @SerializedName("id")
    private String mId;
    @SerializedName("text")
    private String mText;
    @SerializedName("type")
    private String mType;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
