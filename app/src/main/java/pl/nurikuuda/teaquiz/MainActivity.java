package pl.nurikuuda.teaquiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    Button sc_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sc_button = (Button) findViewById(R.id.score_button);
        sc_button.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pulse));

    }

    protected void onResume() {
        super.onResume();
        score = 0;
    }

    public void showScore(View view) {
        hideSoftKeyboard(MainActivity.this, view);
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

        Context context = getApplicationContext();

        String message;
        if (score == 0) {
            message = "Try again..";
        } else if (score == 1) {
            message = "You can do it better!";
        } else if (score == 2) {
            message = "You shoot well :)";
        } else if (score == 3) {
            message = "That's your lucky day?";
        } else {
            message = "Congratulations, you are the master of tea!";
        }

        String result = "You got " + score + " points out of 4! " + message;
        Toast toast = Toast.makeText(context, result, Toast.LENGTH_LONG);
        toast.show();

        score = 0;


//        Intent intento = new Intent(this, ScoreActivity.class);
//        intento.putExtra("SCORE_VALUE", score);
//        startActivity(intento);
    }

    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }
}
