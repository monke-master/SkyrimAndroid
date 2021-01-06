package com.example.skyrimandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity implements View.OnClickListener {
    Player dovakin;
    Story story;
    TextView message;
    Button[] options = new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        String race = getIntent().getStringExtra("race");
        dovakin = new Player(race);
        story = new Story(this);
        message = findViewById(R.id.message);
        options[0] = findViewById(R.id.btn0);
        options[1] = findViewById(R.id.btn1);
        options[2] = findViewById(R.id.btn2);
        options[3] = findViewById(R.id.btn3);
        message.setText(story.current_situation.text);
        showStats();
        for (int i = 0; i < 4; i++) {
            options[i].setVisibility(View.INVISIBLE);
        }
        for (int i = 0; i < story.current_situation.direction.length; i++) {
            options[i].setVisibility(View.VISIBLE);
            options[i].setText(String.valueOf(i + 1));
        }
        for (Button b:options)
            b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        dovakin.healthBonus = story.current_situation.healthBonus;
        dovakin.damageBonus = story.current_situation.damageBonus;
        dovakin.manaBonus = story.current_situation.manaBonus;
        dovakin.health += dovakin.healthBonus;
        dovakin.damage += dovakin.damageBonus;
        dovakin.mana += dovakin.manaBonus;
        dovakin.cheese += story.current_situation.dCheese;
        int num = Integer.parseInt((String) b.getText());
        story.go(num-1);
        message.setText(story.current_situation.text);
        showStats();
        for (int i = 0; i < 4; i++) {
            options[i].setVisibility(View.INVISIBLE);
        }
        for (int i = 0; i < story.current_situation.direction.length; i++) {
            options[i].setVisibility(View.VISIBLE);
            options[i].setText(String.valueOf(i + 1));
        }
    }

    public void showStats() {
        String txt = message.getText().toString();
        String stats = "Здоровье: " + String.valueOf(dovakin.health) + " Урон: " +
                String.valueOf(dovakin.damage) + " Мана: " + String.valueOf(dovakin.mana) + " Сыр: " +
                String.valueOf(dovakin.cheese);
        txt += "\n" + stats;
        message.setText(txt);
    }
}