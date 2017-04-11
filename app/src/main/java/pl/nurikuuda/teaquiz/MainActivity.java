package pl.nurikuuda.teaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume() {
        super.onResume();
        score = 0;
    }

    public void showScore(View view) {
        //q1
        if (((RadioButton) findViewById(R.id.q1_3)).isChecked())
        {score++;}
        //q2
        if (((RadioButton) findViewById(R.id.q2_1)).isChecked())
        {score++;}
        //q3
        if ((((CheckBox) findViewById(R.id.checkBox2)).isChecked())
                &&(((CheckBox) findViewById(R.id.checkBox5)).isChecked())
                &&!(((CheckBox) findViewById(R.id.checkBox1)).isChecked())
                &&!(((CheckBox) findViewById(R.id.checkBox3)).isChecked())
                &&!(((CheckBox) findViewById(R.id.checkBox4)).isChecked()))
        {score++;}
        //q4
        EditText favouriteTea_EditText = (EditText)findViewById(R.id.q4_editText);
        String favouriteTea = favouriteTea_EditText.getText().toString();
        if (favouriteTea.length()>0)
        {score++;}


        Intent intento = new Intent(this, ScoreActivity.class);
        intento.putExtra("SCORE_VALUE", score);
        startActivity(intento);
    }
}
