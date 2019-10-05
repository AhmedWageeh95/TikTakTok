package com.example.awageeh.tiktaktok;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    TextView player;

    int play =1;
    int buttonState[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intview();

        addLisener();

        buttonState =new int[]{0,0,0,0,0,0,0,0,0};
    }


    private void intview() {
        btn1 = (Button) findViewById(R.id.row1_1);
        btn2 = (Button) findViewById(R.id.row1_2);
        btn3 = (Button) findViewById(R.id.row1_3);
        btn4 = (Button) findViewById(R.id.row2_1);
        btn5 = (Button) findViewById(R.id.row2_2);
        btn6 = (Button) findViewById(R.id.row2_3);
        btn7 = (Button) findViewById(R.id.row3_1);
        btn8 = (Button) findViewById(R.id.row3_2);
        btn9 = (Button) findViewById(R.id.row3_3);
        player = (TextView) findViewById(R.id.player);

    }

    private void addLisener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);




    }



    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.row1_1 :
                    checWiner(0,v);
                break;
            case R.id.row1_2 :
                checWiner(1,v);
                break;
            case R.id.row1_3 :
                checWiner(2,v);
                break;
            case R.id.row2_1 :
                checWiner(3,v);
                break;
            case R.id.row2_2 :
                checWiner(4,v);
                break;
            case R.id.row2_3 :
                checWiner(5,v);
                break;
            case R.id.row3_1 :
                checWiner(6,v);
                break;
            case R.id.row3_2 :
                checWiner(7,v);
                break;
            case R.id.row3_3 :
                checWiner(8,v);
                break;
        }
    }

    private void checWiner(int i ,View v) {
        changeText(v,i);
        if(buttonState[i]==0){
            buttonState[i]=play;
        }
        if (buttonState[0]==play &&buttonState[1]==play &&buttonState[2]==play
                ||buttonState[0]==play &&buttonState[3]==play &&buttonState[6]==play
                ||buttonState[0]==play &&buttonState[4]==play &&buttonState[8]==play
                ||buttonState[2]==play &&buttonState[5]==play &&buttonState[8]==play
                ||buttonState[6]==play &&buttonState[7]==play &&buttonState[8]==play
                ||buttonState[1]==play &&buttonState[4]==play &&buttonState[7]==play
                ||buttonState[3]==play &&buttonState[4]==play &&buttonState[5]==play
                ||buttonState[2]==play &&buttonState[4]==play &&buttonState[6]==play ){


            showAlterDialog();
        }

        }

    private void showAlterDialog() {
        AlertDialog.Builder bulider = new AlertDialog.Builder(this);
        bulider.setTitle("YOU Win")
                .setMessage("Do You Want to Replay ... ?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recreate();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alterDialog =bulider.create();
        alterDialog.show();
    }


    private void changeText(View v, int i) {
        Button selcted = (Button) v;

        if (buttonState[i] == 0) {
            if (play == 1) {
                selcted.setText("x");
                selcted.setTextColor(Color.parseColor("#FF0000"));
                play = 2;
            } else if (play == 2) {
                selcted.setText("0");
                selcted.setTextColor(Color.parseColor("#0000FF"));
                play = 1;
            }
            player.setText("Player :" + play);
        }
    }
}
