package com.muath.fragments2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muath.fragments2.databinding.NameItemBinding;

import java.util.ArrayList;


public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.MyViewHolder> {
    private NameRecyclerListener listener;

    public void setListener(NameRecyclerListener listener) {
        this.listener = listener;
    }

    private ArrayList<String> data;

    public NamesAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(NameItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.name.setText(data.get(position));
        holder.binding.name.setOnClickListener(v->{
            listener.onClick(data.get(position));
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final NameItemBinding binding;


        public MyViewHolder(NameItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
