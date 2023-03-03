package com.iut.app.android.tp1android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.iut.app.android.tp1android.Model.User;

import java.io.Serializable;
import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<User> contacts;
    public ListAdapter(Context context, ArrayList<User> contacts) {
        this.context = context;
        this.contacts = contacts;
    }
    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null)
        {
            layout = (ConstraintLayout) inflater.inflate(R.layout.adapter_item, parent, false);
        }
        else {
            layout = (ConstraintLayout) convertView;
        }
        TextView tv = (TextView) layout.findViewById(R.id.tv_name);
        TextView tv2 = (TextView) layout.findViewById(R.id.tv_firstname);

        tv.setText(contacts.get(position).getName());
        tv2.setText(contacts.get(position).getFirstName());

        return layout;
    }
}
