package hostienda.prueba.moreno.xavier.rapidtest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xavier on 28/07/16.
 */
public class ResultActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView textViewScore;
    private Button buttonPlayAgain;
    private Button buttonExit;
    private int score;
    private Intent intentBack;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewScore = (TextView) findViewById(R.id.textViewScore);
        buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
        buttonExit = (Button) findViewById(R.id.buttonExit);

        buttonPlayAgain.setOnClickListener(this);
        buttonExit.setOnClickListener(this);

        intentBack = getIntent();
        bundle = intentBack.getExtras();

        score = gettingScore(bundle);
        textViewScore.setText("Score\n"+score);
    }

    public int gettingScore(Bundle bundle)
    {
        if (bundle != null)
        {
            return bundle.getInt("SCORE");
        }
        return 0;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.buttonPlayAgain:
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            break;

            case R.id.buttonExit:
                finishAffinity();
            break;
        }

    }
}
