package nyc.c4q.akashaarcher.aa_simongame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class Home extends AppCompatActivity {
    private Handler myHandler;
    private Handler mHandler;
    public int level = 1;
    public int timeRemaining = level * 2;
    public int startCurrentString = 0;
    public String ourString = "";
    public int ourStLength = 1;
    public String userString = "";
    public int userStLength = 1;
    public String result = "";


    Random ran = new Random();
    Button btnG2, btnR2, btnY2, btnB2;
    TextView tvLevel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnG2 = (Button)findViewById(R.id.btnG);
        btnR2 = (Button)findViewById(R.id.btnR);
        btnY2 = (Button)findViewById(R.id.btnY);
        btnB2 = (Button)findViewById(R.id.btnB);
        tvLevel2 = (TextView)findViewById(R.id.tvLevel);

        Toast.makeText(Home.this, "Remember the colors are going to turn on!\nReady? Go...", Toast.LENGTH_SHORT).show();

        ourString = ourString + nextChar();
        turnColorsOn(ourString);

        btnG2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (timeRemaining > 0) {// this means until timeRmaining becomes zero onClick button is gonna do nothing

                } else {

                    userString = userString + "G";
                    ourStLength = ourString.length();
                    userStLength = userString.length();

                    if (userStLength == level) {

                        if (ourString.equals(userString)) {

                            Toast.makeText(Home.this, "Level " + level + " completed!", Toast.LENGTH_SHORT).show();
                            level++;
                            //next Level is going to start, we are going to change some of the variables' values like they were in the beginning
                            timeRemaining = level * 2;
                            startCurrentString = 0;
                            userString = "";
                            userStLength = 1;
                            ourString = ourString + nextChar();
                            // next Level starts here
                            tvLevel2.setText("" + level);
                            turnColorsOn(ourString);
                        } else {


                            for (int i = 0; i < ourString.length(); i++) {


                                if (userString.charAt(i) != ourString.charAt(i)) {

                                    result = result + userString.charAt(i) + " instead of " + ourString.charAt(i) + "\n";
                                }

                            }
                            result = "Game is over because you pressed: \n" + result + "\nSCORES: " + (level - 1 + "\n\n");
                            //Alert dialog asking, showing the result and asking Play again?
                            AlertDialog.Builder builderBal = new AlertDialog.Builder(Home.this);
                            builderBal.setMessage(result + "Play again?")

                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            //start again from the beginning
                                            level = 1;
                                            timeRemaining = level * 2;
                                            startCurrentString = 0;
                                            ourString = "";
                                            ourStLength = 1;
                                            userString = "";
                                            userStLength = 1;
                                            ourString = ourString + nextChar();

                                            tvLevel2.setText("" + level);
                                            turnColorsOn(ourString);
                                        }
                                    })
                                    //if selected No, close the app

                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Home.super.onBackPressed();
                                        }
                                    })

                                    .setCancelable(false);  // it doesn't allow you to click outside the alert dialog

                            AlertDialog alertBal = builderBal.create();
                            alertBal.show();


                        }
                    }

                }
            }
        });

        btnR2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (timeRemaining > 0) {// this means until timeRmaining becomes zero onClick button is gonna do nothing

                } else {
                    userString = userString + "R";

                    ourStLength = ourString.length();
                    userStLength = userString.length();

                    if (userStLength == level) {

                        if (ourString.equals(userString)) { //if user pressed the right colors

                            Toast.makeText(Home.this, "Level " + level + " completed!", Toast.LENGTH_SHORT).show();
                            level++;
                            //next Level is going to start, we are going to change some of the variables' values like they were in the beginning
                            timeRemaining = level * 2;
                            startCurrentString = 0;
                            userString = "";
                            userStLength = 1;
                            ourString = ourString + nextChar();
                            // next Level starts here
                            tvLevel2.setText("" + level);
                            turnColorsOn(ourString);
                        } else { //if user did not pressed the right colors
                            String result = "";
                            for (int i = 0; i < ourString.length(); i++) {


                                if (userString.charAt(i) != ourString.charAt(i)) {

                                    result = result + userString.charAt(i) + " instead of " + ourString.charAt(i) + "\n";
                                }

                            }
                            result = "Game is over because you pressed: \n" + result + "\nSCORES: " + (level - 1 + "\n\n");
                            //Alert dialog asking, showing the result and asking Play again?
                            AlertDialog.Builder builderBal = new AlertDialog.Builder(Home.this);
                            builderBal.setMessage(result + "Play again?")

                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            //start again from the beginning
                                            level = 1;
                                            timeRemaining = level * 2;
                                            startCurrentString = 0;
                                            ourString = "";
                                            ourStLength = 1;
                                            userString = "";
                                            userStLength = 1;
                                            ourString = ourString + nextChar();
                                            tvLevel2.setText("" + level);
                                            turnColorsOn(ourString);
                                        }
                                    })
                                    //if selected No, close the app

                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Home.super.onBackPressed();
                                        }
                                    })

                                    .setCancelable(false);  // it doesn't allow you to click outside the alert dialog

                            AlertDialog alertBal = builderBal.create();
                            alertBal.show();
                        }
                    }
                }
            }
        });

        btnY2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (timeRemaining > 0) {// this means until timeRmaining becomes zero onClick button is gonna do nothing

                } else {
                    userString = userString + "Y";

                    ourStLength = ourString.length();
                    userStLength = userString.length();

                    if (userStLength == level) {

                        if (ourString.equals(userString)) {

                            Toast.makeText(Home.this, "Level " + level + " completed!", Toast.LENGTH_LONG).show();
                            level++;

                            //next Level is going to start, we are going to change some of the variables' values like they were in the beginning
                            timeRemaining = level * 2;
                            startCurrentString = 0;
                            userString = "";
                            userStLength = 1;
                            ourString = ourString + nextChar();
                            // next Level starts here
                            tvLevel2.setText("" + level);
                            turnColorsOn(ourString);
                        } else {
                            String result = "";
                            for (int i = 0; i < ourString.length(); i++) {


                                if (userString.charAt(i) != ourString.charAt(i)) {

                                    result = result + userString.charAt(i) + " instead of " + ourString.charAt(i) + "\n";
                                }
                            }
                            result = "Game is over because you pressed: \n" + result + "\nSCORES: " + (level - 1 + "\n\n");
                            //Alert dialog asking, showing the result and asking Play again?
                            AlertDialog.Builder builderBal = new AlertDialog.Builder(Home.this);
                            builderBal.setMessage(result + "Play again?")

                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            //start again from the beginning
                                            level = 1;
                                            timeRemaining = level * 2;
                                            startCurrentString = 0;
                                            ourString = "";
                                            ourStLength = 1;
                                            userString = "";
                                            userStLength = 1;
                                            ourString = ourString + nextChar();

                                            tvLevel2.setText("" + level);
                                            turnColorsOn(ourString);
                                        }
                                    })
                                    //if selected No, close the app

                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Home.super.onBackPressed();
                                        }
                                    })

                                    .setCancelable(false);  // it doesn't allow you to click outside the alert dialog

                            AlertDialog alertBal = builderBal.create();
                            alertBal.show();
                        }
                    }
                }
            }
        });

        btnB2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (timeRemaining > 0) {// this means until timeRmaining becomes zero onClick button is gonna do nothing

                } else {
                    userString = userString + "B";

                    ourStLength = ourString.length();
                    userStLength = userString.length();

                    if (userStLength == level) {

                        if (ourString.equals(userString)) {

                            Toast.makeText(Home.this, "Level " + level + " completed!", Toast.LENGTH_SHORT).show();
                            level++;
                            //next Level is going to start, we are going to change some of the variables' values like they were in the beginning
                            timeRemaining = level * 2;
                            startCurrentString = 0;
                            userString = "";
                            userStLength = 1;
                            ourString = ourString + nextChar();
                            // next Level starts here
                            tvLevel2.setText("" + level);
                            turnColorsOn(ourString);
                        } else {
                            String result = "";
                            for (int i = 0; i < ourString.length(); i++) {


                                if (userString.charAt(i) != ourString.charAt(i)) {

                                    result = result + userString.charAt(i) + " instead of " + ourString.charAt(i) + "\n";
                                }
                            }
                            result = "Game is over because you pressed: \n" + result + "\nSCORES: " + (level - 1 + "\n\n");
                            //Alert dialog asking, showing the result and asking Play again?
                            AlertDialog.Builder builderBal = new AlertDialog.Builder(Home.this);
                            builderBal.setMessage(result + "Play again?")

                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            //start again from the beginning
                                            level = 1;
                                            timeRemaining = level * 2;
                                            startCurrentString = 0;
                                            ourString = "";
                                            ourStLength = 1;
                                            userString = "";
                                            userStLength = 1;
                                            ourString = ourString + nextChar();

                                            tvLevel2.setText("" + level);
                                            turnColorsOn(ourString);
                                        }
                                    })
                                    //if selected No, close the app

                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Home.super.onBackPressed();
                                        }
                                    })

                                    .setCancelable(false);  // it doesn't allow you to click outside the alert dialog

                            AlertDialog alertBal = builderBal.create();
                            alertBal.show();
                        }
                    }
                }
            }
        });


    }

    public void turnColorsOn(final String currentBtn) {

        myHandler = new Handler();

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {


                if (timeRemaining % 2 == 0) {

                    if (currentBtn.charAt(startCurrentString) == 'G') {

                        btnG2.setBackgroundColor(getResources().getColor(R.color.greenOn));

                    } else if (currentBtn.charAt(startCurrentString) == 'R') {

                        btnR2.setBackgroundColor(getResources().getColor(R.color.redOn));

                    } else if (currentBtn.charAt(startCurrentString) == 'Y') {

                        btnY2.setBackgroundColor(getResources().getColor(R.color.yellowOn));

                    } else if (currentBtn.charAt(startCurrentString) == 'B') {

                        btnB2.setBackgroundColor(getResources().getColor(R.color.blueOn));

                    }

                } else {

                    if (currentBtn.charAt(startCurrentString) == 'G') {

                        btnG2.setBackgroundColor(getResources().getColor(R.color.greenOff));
                        startCurrentString ++;

                    }else if (currentBtn.charAt(startCurrentString) == 'R') {

                        btnR2.setBackgroundColor(getResources().getColor(R.color.redOff));
                        startCurrentString ++;

                    }else if (currentBtn.charAt(startCurrentString) == 'Y') {

                        btnY2.setBackgroundColor(getResources().getColor(R.color.yellowOff));
                        startCurrentString ++;

                    }else if (currentBtn.charAt(startCurrentString) == 'B') {

                        btnB2.setBackgroundColor(getResources().getColor(R.color.blueOff));
                        startCurrentString ++;

                    }


                }


                timeRemaining --;

                if (timeRemaining > 0) {

                    myHandler.postDelayed(this, 500);
                }
            }

        };
        myHandler.postDelayed(myRunnable, 3000);
    }

    public static String nextChar (){
        String nextColor="";
        Random ran = new Random();

        int next = ran.nextInt(4) + 1;

        if (next == 1){
            nextColor = "Y";
        }else if (next == 2){
            nextColor = "G";
        }else if (next == 3){
            nextColor = "R";
        }else if (next == 4){
            nextColor = "B";
        }

        return nextColor;
    }




}
