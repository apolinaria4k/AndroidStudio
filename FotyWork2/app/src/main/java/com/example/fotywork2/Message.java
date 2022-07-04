package com.example.fotywork2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("time")
    @Expose
    private long time;
    @SerializedName("text")
    @Expose
    private String text;

    public long getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
}

