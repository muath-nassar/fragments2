package com.muath.fragments2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muath.fragments2.databinding.FragmentRecyclerBinding;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment implements NameRecyclerListener {
    FragmentRecyclerBinding binding;
    MainActivityListener listener;

    public void setListener(MainActivityListener listener) {
        this.listener = listener;
    }

    private NamesAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false);
        setupAdapter();
        return binding.getRoot();
    }
    private void setupAdapter() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Ahmad");
        data.add("Mohammed");
        data.add("ALi");
        data.add("Muath");
        adapter = new NamesAdapter(data);
        adapter.setListener(RecyclerFragment.this);
        binding.rvItems.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvItems.setAdapter(adapter);
    }

    @Override
    public void onClick(String name) {
        listener.switchName(name);
    }
}