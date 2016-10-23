package nyc.c4q.akashaarcher.aa_simongame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   Button bStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bStart = (Button) findViewById(R.id.button_start);
        bStart.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        Intent newIntent = new Intent(MainActivity.this, Home.class);
        startActivity(newIntent);

    }
}


