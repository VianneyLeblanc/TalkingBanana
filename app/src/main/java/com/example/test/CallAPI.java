package com.example.test;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CallAPI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        OkHttpClient client = new OkHttpClient();

        String url = "http://adynamic-scissors.000webhostapp.com/?page=getapi";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    CallAPI.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                FileOutputStream fileOutputStream = openFileOutput("DataTalkingBanana.json", MODE_PRIVATE);
                                fileOutputStream.write(Integer.parseInt(myResponse));
                                fileOutputStream.close();

                            }
                            catch (FileNotFoundException fnfe) {
                                fnfe.printStackTrace();
                            }
                            catch (IOException ioe) {
                                ioe.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }
}
