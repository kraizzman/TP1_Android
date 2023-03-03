package com.iut.app.android.tp1android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iut.app.android.tp1android.Model.ListContacts;
import com.iut.app.android.tp1android.Model.UserData;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private FloatingActionButton fbAdd;
    private ListView listView;
    private ArrayList<String> items = new ArrayList<>();
    private final ListContacts contacts = new ListContacts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        Intent intent = getIntent();

        listView = findViewById(R.id.lv_contact);

        fbAdd = findViewById(R.id.fb_add);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        listView.setAdapter(itemsAdapter);

        UserData user = new UserData(intent.getStringExtra(MainActivity.INPUT_GENDER),
                                     intent.getStringExtra(MainActivity.INPUT_NAME),
                                     intent.getStringExtra(MainActivity.INPUT_FIRSTNAME),
                                     intent.getStringExtra(MainActivity.INPUT_BIRTHDATE),
                                     intent.getStringExtra(MainActivity.INPUT_PHONE),
                                     intent.getStringExtra(MainActivity.INPUT_MAIL),
                                     intent.getStringExtra(MainActivity.INPUT_ZIPCODE),
                                     intent.getStringExtra(MainActivity.INPUT_ADDRESS));

        contacts.addContact(user);
        items.add("Johan Gagean");
        items.add("Fabien Gouin");
        items.add("Albert Bélanger");
        items.add("Isaac Boudreaux");
        items.add("Léon Courbis");
        items.add("Quentin Dubos");
        items.add("Bastien Vandame");
        items.add(user.getFirstName() + " " + user.getName());

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Récupérer le contact sélectionné
            UserData contact = (UserData) parent.getItemAtPosition(position);

        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            // Récupérer le contact sélectionné
            UserData contact = (UserData) parent.getItemAtPosition(position);
            // Supprimer le contact
            items.remove(contact);
            return true;
        });
        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}