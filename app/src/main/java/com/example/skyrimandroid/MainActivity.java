package com.example.skyrimandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView message;
    Button[] options = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);
        message.setText(R.string.intro);
        options[0] = findViewById(R.id.btn0);
        options[1] = findViewById(R.id.btn1);
        options[2] = findViewById(R.id.btn2);
        options[3] = findViewById(R.id.btn3);
        String[] races = getResources().getStringArray(R.array.races);
        for (int i = 0; i < 4; i++) {
            options[i].setText(races[i]);
            options[i].setOnClickListener(this);
        }

    }
    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String race = (String) b.getText();
        Intent i = new Intent(this, StoryActivity.class);
        i.putExtra("race", race);
        startActivity(i);
    }

}