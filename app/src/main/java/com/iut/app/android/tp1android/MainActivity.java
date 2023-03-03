package com.iut.app.android.tp1android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.iut.app.android.tp1android.Model.ListContacts;
import com.iut.app.android.tp1android.Model.UserData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String INPUT_GENDER = "input_gender";
    public static final String INPUT_NAME = "input_name";
    public static final String INPUT_FIRSTNAME = "input_firstname";
    public static final String INPUT_BIRTHDATE = "input_birthdate";
    public static final String INPUT_PHONE = "input_phone";
    public static final String INPUT_MAIL = "input_mail";
    public static final String INPUT_ZIPCODE = "input_zipcode";
    public static final String INPUT_ADDRESS = "input_address";

    private EditText nameEditText, firstNameEditText, birthdateEditText, phoneEditText, mailEditText, postalCodeEditText, cityEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    final Calendar myCalendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderRadioGroup = findViewById(R.id.rg_gender);
        maleRadioButton = findViewById(R.id.rb_male);
        femaleRadioButton = findViewById(R.id.rb_woman);
        nameEditText = findViewById(R.id.tiet_name);
        firstNameEditText = findViewById(R.id.tiet_firstname);
        phoneEditText = findViewById(R.id.tiet_phone);
        mailEditText = findViewById(R.id.tiet_mail);
        postalCodeEditText = findViewById(R.id.tiet_zipcode);
        cityEditText = findViewById(R.id.tiet_address);

        birthdateEditText= findViewById(R.id.et_birthday);
        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            updateLabel();
        };
        birthdateEditText.setOnClickListener(view -> new DatePickerDialog(MainActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show());
    }

    private void updateLabel(){
        String myFormat="dd/MM/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.FRANCE);
        birthdateEditText.setText(dateFormat.format(myCalendar.getTime()));
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
        Intent intent = new Intent(this, ListActivity.class);

        String gender = "";
        String name = nameEditText.getText().toString().trim();
        String firstName = firstNameEditText.getText().toString().trim();
        String birthdate = birthdateEditText.getText().toString().trim();
        String phoneNumber = phoneEditText.getText().toString().trim();
        String mail = mailEditText.getText().toString().trim();
        String postalCode = postalCodeEditText.getText().toString().trim();
        String city = cityEditText.getText().toString().trim();

        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedGenderId == maleRadioButton.getId()) {
            gender = "Masculin";
        } else if (selectedGenderId == femaleRadioButton.getId()) {
            gender = "Féminin";
        }

        if (firstName.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Nom manquant !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (name.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Prénom manquant !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (phoneNumber.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Téléphone manquant !", Toast.LENGTH_SHORT).show();
            return;
        }

        intent.putExtra(INPUT_GENDER, gender);
        intent.putExtra(INPUT_NAME, name);
        intent.putExtra(INPUT_FIRSTNAME, firstName);
        intent.putExtra(INPUT_BIRTHDATE, birthdate);
        intent.putExtra(INPUT_PHONE, phoneNumber);
        intent.putExtra(INPUT_MAIL, mail);
        intent.putExtra(INPUT_ZIPCODE, postalCode);
        intent.putExtra(INPUT_ADDRESS, city);

        startActivity(intent);
    }
}