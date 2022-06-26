package com.example.worldskillsbank;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Enter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void sendRequest(View view){
        String login = ((TextView) findViewById(R.id.editTextTextEmailAddress)).getText().toString();  // создается строка, которая содержит e-mail введенный пользователем
        String password = ((TextView) findViewById(R.id.editTextTextPassword)).getText().toString();   // создается строка, которая содержит пароль введенный пользователем

        JSONObject jsonObject = new JSONObject();   // создается объект типа json
         try {
             jsonObject.put("email", login);        // в ранее созданный объект типа json записываем email и пароль
             jsonObject.put("password", password);
         }catch (JSONException e){                          // обработка исключений
             e.printStackTrace();
         }

         String url = "https://food.madskill.ru/auth/login";   // строка, содержащая url для api запроса

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                response -> startActivity(new Intent(this, Account.class)),
                error -> Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
        );
        requestQueue.add(request);
    }

    public void onClickToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}