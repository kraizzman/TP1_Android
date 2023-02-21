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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String INPUT_NAME = "input_name";
    public static final String INPUT_FIRSTNAME = "input_firstname";
    public static final String INPUT_BIRTHDATE = "input_birthdate";
    public static final String INPUT_PHONE = "input_phone";
    public static final String INPUT_MAIL = "input_mail";
    public static final String INPUT_ZIPCODE = "input_zipcode";
    public static final String INPUT_ADDRESS = "input_address";
    final Calendar myCalendar= Calendar.getInstance();
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.et_birthday);
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
        String myFormat="dd/MM/yy";
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

    public void sendInputData(View view) {
        Intent intent = new Intent(this, DisplayInputData.class);
        EditText editTextName = (EditText) findViewById(R.id.tiet_name);
        EditText editTextFirstName = (EditText) findViewById(R.id.tiet_firstname);
        EditText editTextBirthDate = (EditText) findViewById(R.id.et_birthday);
        EditText editTextPhone = (EditText) findViewById(R.id.tiet_phone);
        EditText editTextMail = (EditText) findViewById(R.id.tiet_mail);
        EditText editTextZipCode = (EditText) findViewById(R.id.tiet_zipcode);
        EditText editTextAddress = (EditText) findViewById(R.id.tiet_address);
        String message1 = editTextName.getText().toString();
        String message2 = editTextFirstName.getText().toString();
        String message3 = editTextBirthDate.getText().toString();
        String message4 = editTextPhone.getText().toString();
        String message5 = editTextMail.getText().toString();
        String message6 = editTextZipCode.getText().toString();
        String message7 = editTextAddress.getText().toString();
        if ( ( message1.equals("")) )
        {
            Toast.makeText(getApplicationContext(), "Nom manquant !", Toast.LENGTH_SHORT).show();
            return;
        }
        if ( ( message2.equals("")) )
        {
            Toast.makeText(getApplicationContext(), "Prénom manquant !", Toast.LENGTH_SHORT).show();
            return;
        }
        if ( ( message4.equals("")) )
        {
            Toast.makeText(getApplicationContext(), "Téléphone manquant !", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra(EXTRA_MESSAGE, message1);
        intent.putExtra(EXTRA_MESSAGE, message2);
        intent.putExtra(EXTRA_MESSAGE, message3);
        intent.putExtra(EXTRA_MESSAGE, message4);
        intent.putExtra(EXTRA_MESSAGE, message5);
        intent.putExtra(EXTRA_MESSAGE, message6);
        intent.putExtra(EXTRA_MESSAGE, message7);
        startActivity(intent);
    }
}