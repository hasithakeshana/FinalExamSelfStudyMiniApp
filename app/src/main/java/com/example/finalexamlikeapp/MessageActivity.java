package com.example.finalexamlikeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.finalexamlikeapp.StudentActivity.SEND_MESSAGE;
import static com.example.finalexamlikeapp.StudentActivity.SEND_SUBJECT;

public class MessageActivity extends AppCompatActivity {

    TextView sub,mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        sub = (TextView)findViewById(R.id.sub);
        mes = (TextView)findViewById(R.id.mes);

        Intent intent = getIntent() ;

        String subject = intent.getStringExtra(SEND_SUBJECT);
        String message = intent.getStringExtra(SEND_MESSAGE);

        sub.setText(""+subject);
        mes.setText(""+message);






    }
}
