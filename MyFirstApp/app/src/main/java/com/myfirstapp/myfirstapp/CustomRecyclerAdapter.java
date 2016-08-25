package com.myfirstapp.myfirstapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    final OnClickListener callback;
    final List<CustomModel> data = new ArrayList<>();

    public CustomRecyclerAdapter(final OnClickListener callback) {
        this.callback = callback;
    }

    public void addData(final CustomModel model) {
        data.add(model);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        final CustomModel model = data.get(position);

        holder.setImage(model.getImageUrl());
        holder.setText(model.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                callback.onClick(model);
            }
        });
    }

    @Override
    public CustomViewHolder onCreateViewHolder(final ViewGroup parent,
                                               final int viewType) {
        return new CustomViewHolder(parent.getContext());
    }
}
