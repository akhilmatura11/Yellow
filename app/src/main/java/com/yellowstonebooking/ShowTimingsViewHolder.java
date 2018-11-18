package com.yellowstonebooking;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ShowTimingsViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private TextView mShowTimings;

    public ShowTimingsViewHolder(View itemView, Context context) {
        super(itemView);
        mContext = context;
        mShowTimings = itemView.findViewById(R.id.showTimingsTextView);
    }


    public void setRowDetails(String s) {
        mShowTimings.setText(s);
        mShowTimings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, SeatSelection.class);
//                mContext.startActivity(intent);
            }
        });
    }
}
