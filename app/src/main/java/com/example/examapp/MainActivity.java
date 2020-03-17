package com.example.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView user, pass;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        b = findViewById(R.id.login);
    }

    public void termpage(View obj){
        String password = String.valueOf(pass.getText());
        if(password.equals("123456")) {
            Intent i = new Intent(MainActivity.this, TermPage.class);
            String name = String.valueOf(user.getText());
            i.putExtra("k", name);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
        }
    }
}
