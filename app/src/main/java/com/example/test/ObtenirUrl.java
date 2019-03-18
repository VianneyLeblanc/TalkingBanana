package com.example.test;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ObtenirUrl extends AsyncTask<Void, Void ,Response>
{

    @Override
    protected Response doInBackground(Void... voids)
    {

        OkHttpClient client = new OkHttpClient();
        String url = "https://rickandmortyapi.com/api/character";

        //Send the request to Openrouteservice
        Request request = new Request.Builder()
                .url(url)
                .build();

        //Get the response
        Response response = null;
        try
        {
            response = client.newCall(request).execute();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //return the response to onPostExecute
        return response;
    }

    @Override
    protected void onPostExecute(Response response)
    {
        if (response == null)
        {
            Log.i("tag", "reponse vide");
        }
        else {


            // Traitement de la réponse / Parse JSON etc
        }
    }
}
