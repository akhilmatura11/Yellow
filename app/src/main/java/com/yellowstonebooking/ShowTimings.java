package com.yellowstonebooking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Objects;

public class ShowTimings extends AppCompatActivity {
    private Toolbar mToolbar;
    private Spinner mDateSpinner;
    private AutoFitGridRecyclerView mShowRecyclerView;

    private ArrayList<String> mDatesList, mShowsList;

    private ShowTimingsAdapter mShowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_timings);

        bindViews();

        setupViews();
    }

    private void bindViews() {
        mToolbar = findViewById(R.id.toolbar);
        mDateSpinner = findViewById(R.id.dateSpinner);
        mShowRecyclerView = findViewById(R.id.showRecyclerView);
    }

    private void setupViews() {
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.thugs_of_hindustan);

        getDatesLists();
        setupSpinnerAdapter();

        mShowsList = new ArrayList<>();
        getShowLists(0);
        setupRecyclerView();
    }

    private void getDatesLists() {
        mDatesList = new ArrayList<>();
        mDatesList.add("19 Nov, Monday");
        mDatesList.add("20 Nov, Tuesday");
        mDatesList.add("21 Nov, Wednesday");
        mDatesList.add("22 Nov, Thursday");
    }

    private void setupSpinnerAdapter() {
        ArrayAdapter<String> datesAdapter = new ArrayAdapter<>(this, R.layout.custom_spinner_item, mDatesList);
        datesAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        mDateSpinner.setAdapter(datesAdapter);
        mDateSpinner.setSelection(0);

        mDateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                populateShowTimings(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getShowLists(int i) {
        mShowsList.clear();
        mShowsList.add("9:00 am");
        mShowsList.add("12:00 pm");
        mShowsList.add("1:00 pm");
        mShowsList.add("4:00 pm");
        mShowsList.add("7:20 pm");
        mShowsList.add("9:40 pm");
        mShowsList.add("11:10 pm");
    }

    private void setupRecyclerView() {
        mShowRecyclerView.setHasFixedSize(true);
        mShowAdapter = new ShowTimingsAdapter(mShowsList, mShowRecyclerView);
        mShowRecyclerView.setAdapter(mShowAdapter);
    }

    private void populateShowTimings(int position) {
        getShowLists(position);
        mShowAdapter.notifyDataSetChanged();
    }

}
