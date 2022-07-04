package com.example.fotytwowork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessagesBankApi {
    @GET("bankomats")
    Call<List<Message>> messages();

}
