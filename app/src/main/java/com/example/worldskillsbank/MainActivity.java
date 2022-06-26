package com.example.worldskillsbank;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickToTerminal(View view){
        Intent intent = new Intent(this, terminals.class);
        startActivity(intent);
    }

    public  void onClickToEnter(View view){
        Intent intent = new Intent(this, Enter.class);
        startActivity(intent);
    }

    public void onClickToRates(View view){
        Intent intent = new Intent(this, Rates.class);
        startActivity(intent);
    }

    public void onClickToRegister(View view){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}