package com.example.fotyonework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("addr")
    @Expose
    private String addr;
    @SerializedName("t")
    @Expose
    private String t;
    @SerializedName("strt")
    @Expose
    private String strt;
    @SerializedName("fin")
    @Expose
    private String fin;

    public String getAddr() {
        return addr;
    }

    public String getT() {
        return t;
    }

    public String getStrt() {
        return strt;
    }

    public String getFin() {
        return fin;
    }
}