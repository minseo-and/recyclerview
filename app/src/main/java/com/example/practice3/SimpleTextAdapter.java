package com.example.practice3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {

    private List<String> mData;
//    private Context _context;

    SimpleTextAdapter(List<String> list) {
        mData = list;
//        _context = context;
    }

    @NonNull
    @Override
    public SimpleTextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false) ;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleTextAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.textView1.setText(text);
//        holder.WriteView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                _context.startActivity(new Intent(_context, WriteActivity.class));
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addData(String text) {
        this.mData.add(text);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        ConstraintLayout WriteView;

        ViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.text1);
            WriteView = itemView.findViewById(R.id.WriteView);

        }
    }
}
