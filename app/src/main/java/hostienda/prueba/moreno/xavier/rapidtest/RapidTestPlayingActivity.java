package hostienda.prueba.moreno.xavier.rapidtest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RapidTestPlayingActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton imageButtonBack;
    private TextView questionText;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;
    private Intent intentToFinish;
    private Intent intentToBack;
    private Client client;
    private Call<List<Question>> call;
    private List<Question> listGet;
    private int[] counter;
    private int score;
    private int views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapid_test_playing);

        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBack);
        questionText = (TextView) findViewById(R.id.question_text);
        buttonOption1 = (Button) findViewById(R.id.button_option1);
        buttonOption2 = (Button) findViewById(R.id.button_option2);
        buttonOption3 = (Button) findViewById(R.id.button_option3);
        buttonOption4 = (Button) findViewById(R.id.button_option4);

        counter = new int[4];
        score = 0;
        views = 1;

        initResponse(views);

        imageButtonBack.setOnClickListener(this);
        buttonOption1.setOnClickListener(this);
        buttonOption2.setOnClickListener(this);
        buttonOption3.setOnClickListener(this);
        buttonOption4.setOnClickListener(this);



    }

    public void initResponse(int views)
    {
        client = GeneratorService.createService(Client.class);
        call = client.questions(views);
        call.enqueue(new Callback<List<Question>>()
        {
             @Override
             public void onResponse(Call<List<Question>> call, Response<List<Question>> response)
             {
                 if(response.isSuccessful())
                 {
                     listGet = response.body();
                     questionText.setText(listGet.get(0).getQuestion().toString());
                     buttonOption1.setText(listGet.get(0).getChoices().get(0).getChoice().toString());
                     counter[0]= listGet.get(0).getChoices().get(0).getVotes();
                     buttonOption2.setText(listGet.get(0).getChoices().get(1).getChoice().toString());
                     counter[1]= listGet.get(0).getChoices().get(1).getVotes();
                     buttonOption3.setText(listGet.get(0).getChoices().get(2).getChoice().toString());
                     counter[2]= listGet.get(0).getChoices().get(2).getVotes();
                     buttonOption4.setText(listGet.get(0).getChoices().get(3).getChoice().toString());
                     counter[3]= listGet.get(0).getChoices().get(3).getVotes();
                 }
                 else
                 {
                     GoFinishView();
                 }
             }

             @Override
             public void onFailure(Call<List<Question>> call, Throwable t)
             {
             }
        });
    }

    public void GoFinishView()
    {
        intentToFinish = new Intent(getApplicationContext(), ResultActivity.class);
        intentToFinish.putExtra("SCORE", score);
        startActivity(intentToFinish);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button_option1:
                score += counter[0];
                views+=1;
                initResponse(views);
            break;

            case R.id.button_option2:
                score += counter[1];
                views+=1;
                initResponse(views);
            break;

            case R.id.button_option3:
                score += counter[2];
                views+=1;
                initResponse(views);
            break;

            case R.id.button_option4:
                score += counter[3];
                views+=1;
                initResponse(views);
            break;

            case R.id.imageButtonBack:
                intentToBack = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intentToBack);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
            break;

            default:
            break;
        }

    }
}