package com.yellowstonebooking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class TheatreViewAdapter extends SelectableAdapter<RecyclerView.ViewHolder> {

    private OnSeatSelected mOnSeatSelected;

    private static class SeatViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSeat;
        private final ImageView imgSeatSelected;


        public SeatViewHolder(View itemView) {
            super(itemView);
            imgSeat = itemView.findViewById(R.id.img_seat);
            imgSeatSelected = itemView.findViewById(R.id.img_seat_selected);

        }

    }


    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private List<String> mItems;

    public TheatreViewAdapter(Context context, List<String> items) {
        mOnSeatSelected = (OnSeatSelected) context;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

//    @Override
//    public String getItemViewType(int position) {
//        return mItems.get(position);
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.seat_row_item, parent, false);
        return new SeatViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int position) {
        final int pos = position;
        SeatViewHolder holder = (SeatViewHolder) viewHolder;
        holder.imgSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSelection(pos);
                mOnSeatSelected.onSeatSelected(getSelectedItemCount());
            }
        });

        holder.imgSeatSelected.setVisibility(isSelected(position) ? View.VISIBLE : View.INVISIBLE);
    }
}


