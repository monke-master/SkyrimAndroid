package com.example.skyrimandroid;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class Story {
    private Situation start_story;
    public Situation current_situation;
    public String race;
    Story(StoryActivity sa) {
        start_story = new Situation(sa.getString(R.string.exitingEditor), 2, 0, 0, 0, 0, 0, 0);
        start_story.direction[0] = new Situation(sa.getString(R.string.tryToRun), 0,
                0, 0, 0,0, 0, 0);
        start_story.direction[1] = new Situation(sa.getString(R.string.executioner), 3,
                0, 0, 0,0, 0, 0);
        start_story.direction[1].direction[0] = new Situation(sa.getString(R.string.stay), 0,
                0,0,0,0,0,0);
        start_story.direction[1].direction[1] = new Situation(sa.getString(R.string.hide), 2, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[1].direction[0] = new Situation(sa.getString(R.string.tower_1),
                0, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[1].direction[1] = new Situation(sa.getString(R.string.barracks), 2, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[1].direction[1].direction[0] = new Situation(sa.getString(R.string.checkBarracks), 1, 50, 15, 0, 1, 0,0);
        start_story.direction[1].direction[1].direction[1].direction[1] = new Situation(sa.getString(R.string.cellar), 1, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[1].direction[1].direction[0].direction[0] = start_story.direction[1].direction[1].direction[1].direction[1];
        start_story.direction[1].direction[1].direction[1].direction[1].direction[0] = new Situation(sa.getString(R.string.bandits), 2, 0, 0, 0, 0, 120, 25);
        start_story.direction[1].direction[1].direction[1].direction[1].direction[0].direction[0] = new Situation(sa.getString(R.string.end_1),
                0, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[1].direction[1].direction[1].direction[0].direction[1] = new Situation(sa.getString(R.string.killedByBandit),
                0, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[2] = new Situation(sa.getString(R.string.run),2, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[2].direction[0] = new Situation(sa.getString(R.string.gates),
                0, 0, 0, 0,0 ,0, 0);
        start_story.direction[1].direction[2].direction[1] = new Situation(sa.getString(R.string.tower_2), 2, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0] = new Situation(sa.getString(R.string.haystack), 2, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[1] = new Situation(sa.getString(R.string.end_2), 0, 0, 0, 0,0  ,0 , 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[0] = start_story.direction[1].direction[2].direction[0];
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1] = new Situation(sa.getString(R.string.castle), 2, 50, 15, 0, 0, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[1] = start_story.direction[1].direction[1].direction[1].direction[1];
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0] = new Situation(sa.getString(R.string.dungeon), 3, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[0] = new Situation(sa.getString(R.string.sneak), 1, 0, 0, 0, 1, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[1] = new Situation(sa.getString(R.string.no_fight), 2, 0, 0, 0, 0, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[1].direction[1] = new Situation(sa.getString(R.string.fight_1), 1, 0, 0, 0, 0, 150, 30);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[1].direction[0] = new Situation(sa.getString(R.string.lost_equip), 1, -50, -15, 0, 0, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[1].direction[1].direction[0] = new Situation(sa.getString(R.string.fight_2), 1, 60, 30, 0, 1, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[2] = new Situation(sa.getString(R.string.unexp_fight), 1, 30, 10, 0, 1, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[2].direction[0] = new Situation(sa.getString(R.string.wizards), 1, 0, 0, 0, 0, 170, 25 );
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[0].direction[0] =
                start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[2].direction[0];
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[1].direction[0].direction[0] =
                start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[2].direction[0];
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[1].direction[1].direction[0].direction[0] =
                start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[2].direction[0];
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[2].direction[0].direction[0] = new Situation(sa.getString(R.string.win),1, 0, 0, 20, 0, 0, 0);
        start_story.direction[1].direction[2].direction[1].direction[0].direction[1].direction[0].direction[2].direction[0].direction[0].direction[0] = new Situation(sa.getString(R.string.end_3), 0, 0, 0, 0, 0, 0, 0);
        current_situation = start_story;
    }
    public void go(int num) {
        current_situation = current_situation.direction[num];
    }
    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }

}