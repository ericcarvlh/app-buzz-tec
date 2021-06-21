package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SobreActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        this.setTitle("Sobre");
    }
}