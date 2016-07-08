package com.unishi.sina.premapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ScrollingTabContainerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Sina on 2016-06-07.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private ArrayList<Club> clubsArray;
    private Context context;

    public static View view;
    public static int position;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected CardView cv;
        protected ImageView photo;


        public ViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            photo = (ImageView)itemView.findViewById(R.id.image);
            view = itemView;
            position = getAdapterPosition();
        }
    }

    public RVAdapter(Context context, ArrayList<Club> clubsArray) {
        this.clubsArray = clubsArray;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // using gradle from: https://github.com/bumptech/glide
        Glide.with(context).load(clubsArray.get(position).photoID).into(holder.photo);

        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.getContext().startActivity(new Intent(view.getContext(), ScrollingActivity.class).putExtra("variable", position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return clubsArray.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
