package com.example.worldskillsbank;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Rates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);

        String date_const = new SimpleDateFormat("dd.MM.yyyy" , Locale.getDefault()).format(new Date());

        TextView date_tv = findViewById(R.id.textView_date);
        date_tv.setText(date_const);
    }

    public void onClickToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}