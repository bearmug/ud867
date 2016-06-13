package com.udacity.gradle.builditbigger.lib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class LibraryActivity extends AppCompatActivity {

    public static final String JOKE_HOLDER = "jokeHolder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Toast.makeText(this, getIntent().getExtras().getString(JOKE_HOLDER),
                Toast.LENGTH_LONG).show();
    }
}
