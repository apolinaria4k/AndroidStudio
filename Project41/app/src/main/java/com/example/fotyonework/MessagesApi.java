package com.example.fotyonework;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessagesApi {
    @GET("bankomats")
    Call<List<Message>> messages();

}
