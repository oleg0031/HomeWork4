package com.olegsmirnov.homework4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataset1;
    private String[] mDataset2;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView country;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.textView1);
            country = (TextView) v.findViewById(R.id.textView2);
            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Man # " + (getAdapterPosition() + 1) + "\nName: "
                    + name.getText().toString() + "\nCountry: " + country.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public MyAdapter(String[] dataset1, String[] dataset2) {
        mDataset1 = dataset1;
        mDataset2 = dataset2;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(mDataset1[position]);
        holder.country.setText(mDataset2[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset1.length;
    }

}