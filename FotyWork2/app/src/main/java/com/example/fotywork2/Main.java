package com.example.fotywork2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main extends AppCompatActivity{
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        context = this;
        parse();
    }

    public void parse(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessagesApi messagesApi = retrofit.create(MessagesApi.class);

        Call<List<Message>> messages = messagesApi.messages();

        messages.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                    List<Message> message = null;
                    message = response.body();
                    ListView listView = (ListView)findViewById(R.id.listView);
                    Adapter adapter = new Adapter(context, message);
                    listView.setAdapter(adapter);
                List<Message> finalMessage = message;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(context, Second.class);
                            intent.putExtra("text", finalMessage.get(position).getText());
                            startActivity(intent);
                        }
                    });
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Log.d("MYTAG",t.toString());
            }
        });
    }

}