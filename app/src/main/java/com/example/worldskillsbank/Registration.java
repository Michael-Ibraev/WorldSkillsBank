package com.example.worldskillsbank;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void signUp(View view) {

        String email = ((TextView)findViewById(R.id.editTextTextEmailAddress)).getText().toString();       // строки содержащии соответствующую информацию
        String passwordFirst = ((TextView)findViewById(R.id.editTextTextPassword)).getText().toString();
        String fullName = ((TextView)findViewById(R.id.editTextTextPersonName)).getText().toString();
        String number = ((TextView)findViewById(R.id.editTextPhone)).getText().toString();

        if (email.isEmpty() || passwordFirst.isEmpty() || fullName.isEmpty() || number.isEmpty())       // проверка на заполненность всех полей
        {
            Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show();        // в случае, если одно из полей не заполненно, на экран будет выведен toast с сообщением
            return;
        }

        if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(.[A-Za-z]{2,})$"))  // проверка на соответствие формата e-mail
        {
            Toast.makeText(this, "Некорректный адрес электронной почты", Toast.LENGTH_LONG).show();  // в случае, если почта не соответсвует нужному формату,
                                                                                                                // на экран будет выведен toast с сообщением
            return;
        }


        String url = "https://food.madskill.ru/auth/register";  // строка, содержащая url для api запроса

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registration.this, response.toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Registration.this, Enter.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration.this, "Регистрация не удалась", Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", passwordFirst);
                params.put("login", fullName);


                return params;
            }
        };

        requestQueue.add(request);
    }

    public void onClickToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}