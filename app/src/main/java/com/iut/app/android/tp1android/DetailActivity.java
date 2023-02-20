package com.iut.app.android.tp1android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        //String name = getIntent().getStringExtra(KEY_NAME);
        //String firstName = getIntent().getStringExtra(KEY_FIRST_NAME);

        TextView t = findViewById(R.id.tv_name);
        //t.setText(name);

        //findViewById(R.id.btn_ok).setOnClickListener(View.OnClickListener());

    }
}