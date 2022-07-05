package com.example.fotytwowork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface coefApi {
    @GET("valute")
    Call<List<Coef>> coefs();

}
