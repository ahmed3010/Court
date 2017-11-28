package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int aGoals=0;
    private int bGoals=0;
    private int aOffsides=0;
    private int bOffsides=0;
    private int aFouls=0;
    private int bFouls=0;
    private TextView aGoalScore;
    private TextView aOffsideScore;
    private TextView aFoulScore;
    private TextView bGoalScore;
    private TextView bOffsideScore;
    private TextView bFoulScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aGoalScore = findViewById(R.id.team_a_goals_score);
        aOffsideScore = findViewById(R.id.team_a_offsides_score);
        aFoulScore = findViewById(R.id.team_a_fouls_score);
        bGoalScore = findViewById(R.id.team_b_goals_score);
        bOffsideScore = findViewById(R.id.team_b_offsides_score);
        bFoulScore = findViewById(R.id.team_b_fouls_score);

    }



    public void display(View view) {
        display(view.getId());
    }

//This method defines which button is clicked and call setText method
    private void display(int viewId) {
        switch (viewId) {
            case R.id.team_a_goals_button:
                aGoals++;
                setText(aGoalScore,aGoals);
                break;
            case R.id.team_a_offsides_button:
                aOffsides++;
                setText(aOffsideScore,aOffsides);
                break;
            case R.id.team_a_fouls_buttons:
                aFouls++;
                setText(aFoulScore,aFouls);
                break;
            case R.id.team_b_goals_button:
                bGoals++;
                setText(bGoalScore,bGoals);
                break;
            case R.id.team_b_offsides_button:
                bOffsides++;
                setText(bOffsideScore,bOffsides);
                break;
            case R.id.team_b_fouls_button:
                bFouls++;
                setText(bFoulScore,bFouls);
                break;
        }
    }
    //THis method reset all values to 0
    public void reset(View view){
        aGoals=0;
        bGoals=0;
        aOffsides=0;
        bOffsides=0;
        aFouls=0;
        bFouls=0;
        setText(bGoalScore,bGoals);
        setText(bFoulScore,bFouls);
        setText(bOffsideScore,bOffsides);
        setText(aGoalScore,aGoals);
        setText(aFoulScore,aFouls);
        setText(aOffsideScore,aOffsides);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setContentView(R.layout.settings);

        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //This method changes Team A and Team B name
public void go(View view){
    EditText teamANewName = findViewById(R.id.editText);
    EditText teamBNewName = findViewById(R.id.editText2);
    String teamAName=teamANewName.getText().toString();
    String teamBName =teamBNewName.getText().toString();
    setContentView(R.layout.activity_main);
    changeName(teamAName,teamBName);
    reset(view);
    }
    //This method takes 2 arg os Strings and set the name of team A and Team b
private void changeName(String teamAName,String teamBName){
    TextView teamAPreviousName = findViewById(R.id.team_a_name);
    TextView teamBPreviousName = findViewById(R.id.team_b_name);
    if (!teamAName.equals(""))
    teamAPreviousName.setText(teamAName);
    if (!teamBName.equals(""))
    teamBPreviousName.setText(teamBName);
}
//This method takes 2 arg the textView and integer value to be viewed in he textView
private void setText(View view,int i){
    TextView myView = (TextView) view;
    myView.setText(String.valueOf(i));
}
}
