package com.example.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class TermPage extends AppCompatActivity {

    String fullName;
    TextView t, terms;
    CheckBox c;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_page);

        t = findViewById(R.id.username);
        terms = findViewById(R.id.terms);
        c = findViewById(R.id.checkBox);
        b = findViewById(R.id.start);

        /* Displaying Name of user with Welcome */
        Intent i2 = getIntent();
        fullName = i2.getStringExtra("k");
        String[] user = i2.getStringExtra("k").split(" ", 2);
        final String name = user[0].substring(0,1).toUpperCase() + user[0].substring(1).toLowerCase();
        t.setText("Welcome "+ name);

        String ss = "<b>" + "Terms for Examination : " + "</b>";
        terms.setText(Html.fromHtml(ss));
        terms.append("\n\n");

        terms.append("  (1) All questions have single correct answer.\n");
        terms.append("  (2) Each correct attempt will give you +4 marks.\n");
        terms.append("  (3) Each incorrect attempt will give you -1 mark.\n");
        terms.append("  (4) Use of Internet is permitted.\n");
        terms.append("  (5) There are total 5 question in the quiz.\n  ");
        String x = "<b>" + "(6) Once you click <i>'PREV'</i> button, previous question with your response(if any) will be shown. You need to <i>'SUBMIT'</i> or <i>'SKIP'</i> the question <i>AGAIN</i> as per your need." + "</b>";
        terms.append(Html.fromHtml(x));
        terms.append("\n  (7) Result will be shown once you complete the exam.\n");
        terms.append("    --- --- --- --- --- --- ---\n");
        terms.append("  All the best ...\n");
    }

    public void nextPage(View obj){
        if(c.isChecked()){
            Intent i = new Intent(TermPage.this, QuestionPage.class);
            i.putExtra("k", fullName);
            startActivity(i);
        }
        else {
            Toast.makeText(TermPage.this, "Accept the Terms", Toast.LENGTH_SHORT).show();
        }
    }
}
