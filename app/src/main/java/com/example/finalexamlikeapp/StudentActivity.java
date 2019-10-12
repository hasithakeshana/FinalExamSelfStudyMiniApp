package com.example.finalexamlikeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    final static String SEND_MESSAGE = "message";
    final static String SEND_SUBJECT = "subject";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final ListView listView = (ListView)findViewById(R.id.listView);

        myDB = new DatabaseHelper(this);

        final ArrayList<String> subjects = new ArrayList<>();

        final ArrayList<String> messages = new ArrayList<>();



        Cursor data = myDB.getListMessages();

        if(data.getCount() == 0 )
        {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (data.moveToNext())
            {
                subjects.add(data.getString(2));

                messages.add(data.getString(3));


                final ListAdapter listAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,subjects);

                listView.setAdapter(listAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String message = messages.get(i);   // get onclick values and pass them through an intent
                        String subject = subjects.get(i);

                        Intent intent = new Intent(StudentActivity.this,MessageActivity.class);

                        intent.putExtra(SEND_MESSAGE,message);
                        intent.putExtra(SEND_SUBJECT,subject);

                        startActivity(intent);


                        Toast.makeText(StudentActivity.this, ""+subjects.get(i), Toast.LENGTH_SHORT).show();

                        //listAdapter.getItem(messages.indexOf(i))
                    }
                });


            }


        }
    }
}
