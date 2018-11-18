package com.yellowstonebooking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SeatSelection extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        bindViews();
        setupViews();
    }

    private void bindViews() {
        mToolbar = findViewById(R.id.toolbar);
    }

    private void setupViews() {
        setSupportActionBar(mToolbar);
    }

}
