package com.yellowstonebooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SeatSelection extends AppCompatActivity implements OnSeatSelected {
    private Toolbar mToolbar;
    private RecyclerView mSeatRecyclerView;
    private Button mBookSeatsButton;
    private List<String> mSeatsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        bindViews();
        setupViews();
    }

    private void bindViews() {
        mToolbar = findViewById(R.id.toolbar);
        mSeatRecyclerView = findViewById(R.id.seatRecyclerView);
        mBookSeatsButton = findViewById(R.id.bookSeatsButton);
    }

    private void setupViews() {
        setSupportActionBar(mToolbar);
        mSeatsList = new ArrayList<>();
        //    mSeatsList.add("l");
        for (int i = 65; i < 70; i++) {
            for (int j = 1; j <= 7; j++)
                mSeatsList.add((char) i + String.valueOf(j));
        }

        GridLayoutManager manager = new GridLayoutManager(this, 7);
        mSeatRecyclerView.setLayoutManager(manager);

        TheatreViewAdapter adapter = new TheatreViewAdapter(this, mSeatsList);
        mSeatRecyclerView.setAdapter(adapter);

        mBookSeatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeatSelection.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
        if (adapter.getSelectedItemCount() == 0) {
            mBookSeatsButton.setEnabled(false);
            mBookSeatsButton.setAlpha(0.4f);
            mBookSeatsButton.setText("Book");
        } else {
            mBookSeatsButton.setEnabled(true);
            mBookSeatsButton.setAlpha(1.0f);
            String message = "Book " + adapter.getSelectedItemCount() + " seats";
            mBookSeatsButton.setText(message);
        }

    }

    @Override
    public void onSeatSelected(int count) {
        if (count==0) {
            mBookSeatsButton.setEnabled(false);
            mBookSeatsButton.setAlpha(0.4f);
            mBookSeatsButton.setText("Book");
        } else {
            mBookSeatsButton.setEnabled(true);
            mBookSeatsButton.setAlpha(1.0f);
            String message = "Book " + count + " seats";
            mBookSeatsButton.setText(message);
        }

    }

}
