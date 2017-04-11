package pl.nurikuuda.teaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        TextView scoreTextView = (TextView) findViewById(R.id.scoreView);
        int score = getIntent().getIntExtra("SCORE_VALUE", 0);
        scoreTextView.setText(Integer.toString(score));
    }



}