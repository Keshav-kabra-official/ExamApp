package com.example.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    // disabling the back button of android phone
    @Override
    public void onBackPressed() { }

    TextView t, t_info;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t = findViewById(R.id.textView);
        t_info = findViewById(R.id.info);
        b = findViewById(R.id.back);

        Intent i2 = getIntent();
        String[] user = i2.getStringExtra("k").split(" ;;", 4);
        String name = user[0];
        String score = user[1];
        String correct = user[2];
        String incorrect = user[3];

        String ss = "<b>" + "Final Results : " + "</b>";
        t.setText(Html.fromHtml(ss));
        t.append("\n\n");

        if(Integer.parseInt(score) < 0)
            score = "0";

        t.append("Dear " + name + ", you obtained " + score + " marks out of 20.\n");
        double per = (Double.parseDouble(score)/20.0)*100;
        t.append("\nCorrect attempts : " + correct);
        t.append("\nIncorrect attempts : " + incorrect);
        t.append("\n\n           ---  Percentage : " + String.format(String.valueOf(per), "%.2f") + "%  ---");

        String xx = "Designed By :\n   Keshav Kabra\n   +91-7014722936\n";
        xx += "   (keshavkabra.official@gmail.com)";
        t_info.setText(xx);
    }

    public void back(View obj){
        Intent i = new Intent(Result.this, MainActivity.class);
        startActivity(i);
    }
}
