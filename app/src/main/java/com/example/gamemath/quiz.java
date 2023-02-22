package com.example.gamemath;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;

public class quiz extends AppCompatActivity {


    Button button1 ,button2 ,button3,button4;
    TextView T1 ,T2 ,nbr,Top;
    Timer timer;
    int cmp=0,nbrvrai=0,nbrfau=0;
    String [] tableOp={"+","-","*","/"};
       String op="";
Random ro =new Random();

    Random r =new Random();
    public void rnb(final Button [] tbb){

        Thread thread= new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(500);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            button1.setBackgroundResource(R.drawable.bg_but);
                            button2.setBackgroundResource(R.drawable.bg_but);
                            button3.setBackgroundResource(R.drawable.bg_but);
                            button4.setBackgroundResource(R.drawable.bg_but);
                            cmp++;
                            if (cmp==31){nbr.setText("30/30");}
                            else { nbr.setText(cmp+"/30");}

                            if (cmp==30){
                                final AlertDialog.Builder builder =new AlertDialog.Builder(quiz.this);
                                View layoutView = getLayoutInflater().inflate(R.layout.resulta, null);
                                builder.setView(layoutView);
                                Button qt = layoutView.findViewById(R.id.qt);
                                final Button play = layoutView.findViewById(R.id.play);

                                final TextView vrais =layoutView.findViewById(R.id.vr);
                                final TextView faux=layoutView.findViewById(R.id.f);
                                final TextView scorimg =layoutView.findViewById(R.id.scorimg);
                                final TextView scortxt=layoutView.findViewById(R.id.scortext);
                                vrais.setText(Integer.toString( nbrvrai));
                                faux.setText(Integer.toString(nbrfau));

                                if (nbrfau==0){

                                    scorimg.setBackgroundResource(R.drawable.score);

                                    scorimg.setText("");
                                    scortxt.setText("* Bravo Le meilleur score *");
                                }

                                else {

                                    scorimg.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                                    scorimg.setText("Résultat");
                                    scortxt.setText("");
                                }
                                qt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        finish();
                                    }
                                });

                                play.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        finish();
                                        startActivity(getIntent());

                                    }
                                });

                                builder.show();

                            }

                            else {


                                  int  n=r.nextInt(51);
                                  int  n2=r.nextInt(51);


                                if (n>n2)
                                {
                                    T1.setText(Integer.toString(n));
                                    T2.setText(Integer.toString(n2));
                                }
                                else
                                {
                                    T1.setText(Integer.toString(n2));
                                    T2.setText(Integer.toString(n));

                                }

                              op=tableOp[ro.nextInt(4)] ;

                                int res=0;
                                if (op.equals("+")) {
                                    Top.setText("+");
                                     res = Integer.parseInt(T1.getText().toString()) + Integer.parseInt(T2.getText().toString());
                                }
                                if (op.equals("*")) {
                                    Top.setText("*");
                                     res = Integer.parseInt(T1.getText().toString()) * Integer.parseInt(T2.getText().toString());
                                }
                                if (op.equals("-")) {
                                    Top.setText("-");
                                     res = Integer.parseInt(T1.getText().toString()) - Integer.parseInt(T2.getText().toString());
                                }
                                if (op.equals("/")) {
                                    Top.setText("/");
                                     res = Integer.parseInt(T1.getText().toString()) / Integer.parseInt(T2.getText().toString());
                                }

                                button1.setText("00");
                                button2.setText("00");
                                button3.setText("00");
                                button4.setText("00");

                                tbb[r.nextInt(4)].setText(Integer.toString(res));


                                if(!button1.getText().equals(Integer.toString(res))){
                                    button1.setText(Integer.toString(res+4));
                                }
                                if(!button2.getText().equals(Integer.toString(res))){
                                    button2.setText(Integer.toString(res+2));
                                }
                                if(!button3.getText().equals(Integer.toString(res))){
                                    button3.setText(Integer.toString(res+1));
                                }
                                if(!button4.getText().equals(Integer.toString(res))) {
                                    button4.setText(Integer.toString(res+3));


                                }}

                        }
                    });

                }
                catch (InterruptedException e){ }

            }

        };
        thread.start();
    }

    public void test (Button button){
        int res=0;
        if (op.equals("+")) {
             res = Integer.parseInt(T1.getText().toString()) + Integer.parseInt(T2.getText().toString());
        }
        if (op.equals("*")) {
             res = Integer.parseInt(T1.getText().toString()) * Integer.parseInt(T2.getText().toString());
        }
        if (op.equals("-")) {
            res = Integer.parseInt(T1.getText().toString()) - Integer.parseInt(T2.getText().toString());
        }
        if (op.equals("/")) {
             res = Integer.parseInt(T1.getText().toString()) / Integer.parseInt(T2.getText().toString());
        }
        Toast.makeText(this, "La réponse :"+res, Toast.LENGTH_SHORT).show();
        if (!button.getText().equals(Integer.toString(res))){

            button.setBackgroundResource(R.drawable.bg_faux);
            nbrfau++;

        }
        else {

            button.setBackgroundResource(R.drawable.bg_vrai);
            nbrvrai++;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        button1=findViewById(R.id.button1qz);
        button2=findViewById(R.id.button2qz);
        button3=findViewById(R.id.button3qz);
        button4=findViewById(R.id.button4qz);
        T1=findViewById(R.id.textView1qz);
        T2=findViewById(R.id.textView3qz);
        Top=findViewById(R.id.textView2qz);
        nbr=findViewById(R.id.nbrqz);
        final Button[] tb ={button1,button2,button3,button4};

        rnb(tb);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test(button1);
                rnb(tb);

            }});

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test(button2);
                rnb(tb);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test(button3);
                rnb(tb);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test(button4);
                rnb(tb);

            }
        });


    }
    public void onBackPressed() {
        final AlertDialog.Builder builder =new AlertDialog.Builder(quiz.this);
        View layoutView = getLayoutInflater().inflate(R.layout.quitter_jeu, null);
        final Button non = layoutView.findViewById(R.id.nonqj);
        final Button oui = layoutView.findViewById(R.id.ouiqj);
        builder.setView(layoutView);
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });

        oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


            }
        });

        dialog.show();
    }
}
