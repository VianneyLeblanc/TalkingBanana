package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new CallAPI().execute("adynamic-scissors.000webhostapp.com/?page=getapi", "");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                startActivity(new Intent(MainActivity.this,Game.class));
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                startActivity(new Intent(MainActivity.this,CallAPI.class));
            }
        });
    }
}



