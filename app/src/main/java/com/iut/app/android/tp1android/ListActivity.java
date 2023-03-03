package com.iut.app.android.tp1android;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iut.app.android.tp1android.Model.User;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private FloatingActionButton fbAdd;
    private ListView listView;
    private ListAdapter adapter;
    private ArrayList<User> listContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        listContacts = new ArrayList<>();

        listView = findViewById(R.id.lv_contact);
        fbAdd = findViewById(R.id.fb_add);

        adapter = new ListAdapter(ListActivity.this, listContacts);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ListActivity.this, DisplayData.class);
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            listContacts.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK)
                {
                    assert result.getData() != null;
                    User resUser = (User) result.getData().getSerializableExtra("contact");
                    listContacts.add(resUser);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        fbAdd.setOnClickListener(view -> {
            Intent intent1 = new Intent(ListActivity.this, FormActivity.class);
            mStartForResult.launch(intent1);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 10 && resultCode == RESULT_OK)
        {
            User retour = (User) data.getSerializableExtra("contact");
            listContacts.add(retour);
        }
    }
}