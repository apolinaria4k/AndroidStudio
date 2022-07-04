package com.example.fotytwowork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coef {
    @SerializedName("coef")
    @Expose
    private String coef;

    public String getCoef() {
        return coef;
    }
}
