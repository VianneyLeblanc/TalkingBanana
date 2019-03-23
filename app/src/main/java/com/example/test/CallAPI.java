package com.example.test;


import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CallAPI extends AsyncTask<String, String, Response> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Response doInBackground(String... params) {
        String urlString = params[0]; // URL to call
        String data = params[1]; //data to post

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("json", data).build();

        Request request = new Request.Builder().url(urlString).post(requestBody).build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("ERROR 36", "----------------->" + e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
        if (response == null) {
            Log.i("tag", "----------------------> La requete à rendu null !!");
        } else {
            String rep = null;
            try {
                rep = response.body().string();
                Log.i("INFO", rep);
            } catch (Exception e) {
                Log.i("ERROR 51", "-------------------->" + e.getMessage());
            }
        }
    }
}
