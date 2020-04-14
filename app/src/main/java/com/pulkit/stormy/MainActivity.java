package com.pulkit.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String lat = "35";
        String lon = "139";
        String apiKey = "9a6b400fe12e6d24e53bf83522335e8c";
        String forcastUrl = "https://api.openweathermap.org/data/2.5/" +
                "weather?lat=" +
                 lat +
                "&lon=" +
                lon +
                "&appid=" +
                apiKey;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(forcastUrl)
                .build();

        Call call = client.newCall(request);


        try {
            Response response = call.execute();
            if(response.isSuccessful())
            {
                Log.v(TAG, response.body().string());
            }
        }

        catch (IOException e) {
            Log.v(TAG, "IO exception caught:",e);
        }


    }
}
