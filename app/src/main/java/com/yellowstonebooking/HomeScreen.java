package com.yellowstonebooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class HomeScreen extends AppCompatActivity {
    private Toolbar mToolbar;
    private CardView mCardView1;
    private Button mMovieButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bindViews();

        setupViews();

        onClicks();
    }

    private void bindViews() {
        mToolbar = findViewById(R.id.toolbar);
        mCardView1 = findViewById(R.id.cardView1);
        mMovieButton1 = findViewById(R.id.movieButton1);
    }

    private void setupViews() {
        //Set up Toolbar
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

        mCardView1.setCardElevation(5.0f);
        mCardView1.setMaxCardElevation(5.0f);
        mCardView1.setRadius(1.0f);
        mCardView1.setCardBackgroundColor(getResources().getColor(R.color.black));
    }

    private void onClicks() {
        mMovieButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToShowTimings();
            }
        });
    }

    private void sendToShowTimings() {
        Intent intent = new Intent(this, ShowTimings.class);
        startActivity(intent);
    }

}
