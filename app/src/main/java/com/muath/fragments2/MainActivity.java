package com.muath.fragments2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;

import com.muath.fragments2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityListener {
    private ActivityMainBinding binding;
    private BlankFragment blankFragment;
    private RecyclerFragment recyclerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupFragments();

    }

    private void setupFragments() {
        blankFragment = new BlankFragment();
        recyclerFragment = new RecyclerFragment();
        recyclerFragment.setListener(MainActivity.this);
        getSupportFragmentManager().beginTransaction().add(binding.frameRecycle.getId(), recyclerFragment).commit();
        getSupportFragmentManager().beginTransaction().add(binding.frameText.getId(), blankFragment).commit();
    }


    @Override
    public void switchName(String name) {
        blankFragment.changeName(name);
    }
}