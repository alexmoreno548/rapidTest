package hostienda.prueba.moreno.xavier.rapidtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageButton imageButtonGo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageButtonGo = (ImageButton) findViewById(R.id.imageButtonGo);
        imageButtonGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.imageButtonGo:
                intent = new Intent(this, RapidTestPlayingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            default:
                break;
        }


    }
}
