package com.yellowstonebooking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ShowTimingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mShowTimings;

    public ShowTimingsAdapter(Context context, ArrayList<String> showTimings, RecyclerView recyclerView) {
        mContext = context;
        mShowTimings = showTimings;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = mContext;

        View view = LayoutInflater.from(context).inflate(R.layout.show_timings_item, parent, false);
        return new ShowTimingsViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ShowTimingsViewHolder holder = (ShowTimingsViewHolder) viewHolder;
        holder.setRowDetails(mShowTimings.get(position));
    }

    @Override
    public int getItemCount() {
        return mShowTimings == null ? 0 : mShowTimings.size();
    }
}
