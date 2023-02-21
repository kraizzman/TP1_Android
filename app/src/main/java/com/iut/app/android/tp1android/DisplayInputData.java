package com.iut.app.android.tp1android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayInputData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_input_data);
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(MainActivity.INPUT_NAME);
        String message2 = intent.getStringExtra(MainActivity.INPUT_FIRSTNAME);
        String message3 = intent.getStringExtra(MainActivity.INPUT_BIRTHDATE);
        String message4 = intent.getStringExtra(MainActivity.INPUT_PHONE);
        String message5 = intent.getStringExtra(MainActivity.INPUT_MAIL);
        String message6 = intent.getStringExtra(MainActivity.INPUT_ZIPCODE);
        String message7 = intent.getStringExtra(MainActivity.INPUT_ADDRESS);

        TextView textView1 = findViewById(R.id.textViewName);
        textView1.setText(message1);

        TextView textView2 = findViewById(R.id.textViewFirstName);
        textView2.setText(message2);

        TextView textView3 = findViewById(R.id.textViewBirthDate);
        textView3.setText(message3);

        TextView textView4 = findViewById(R.id.textViewPhone);
        textView4.setText(message4);

        TextView textView5 = findViewById(R.id.textViewMail);
        textView5.setText(message5);

        TextView textView6 = findViewById(R.id.textViewZipCode);
        textView6.setText(message6);

        TextView textView7 = findViewById(R.id.textViewAddress);
        textView7.setText(message7);
    }
}