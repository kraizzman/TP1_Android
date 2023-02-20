package com.iut.app.android.tp1android;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    final Calendar myCalendar= Calendar.getInstance();
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.til_birthday);
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.FRANCE);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy");
    }

}