package com.example.gamemath;

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

public class vs extends AppCompatActivity {


    Button button1vs1 ,button2vs1 ,button3vs1,button4vs1,button1vs2 ,button2vs2 ,button3vs2,button4vs2;
    TextView T1vs1 ,T2vs1 ,nbr,Topvs1,T1vs2 ,T2vs2 ,Topvs2,nbfvs1,nbvvs1,nbfvs2,nbvvs2;
    Timer timer;
    int cmp=0,nbrvraiVS1=0,nbrfauVS1=0,nbrvraiVS2=0,nbrfauVS2=0;
    String [] tableOp={"+","-","*","/"};
    String op="";
    Random ro =new Random();
    int res=0;
    boolean clickvs1 =false ,clickvs2 =false ;

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
                           clickvs1 =false ;
                            clickvs2 =false;
                            button1vs1.setBackgroundResource(R.drawable.bg_bnd);
                            button2vs1.setBackgroundResource(R.drawable.bg_bnd);
                            button3vs1.setBackgroundResource(R.drawable.bg_bnd);
                            button4vs1.setBackgroundResource(R.drawable.bg_bnd);
                            button1vs2.setBackgroundResource(R.drawable.bg_vs2);
                            button2vs2.setBackgroundResource(R.drawable.bg_vs2);
                            button3vs2.setBackgroundResource(R.drawable.bg_vs2);
                            button4vs2.setBackgroundResource(R.drawable.bg_vs2);
                            cmp++;
                            if (cmp==21){nbr.setText("20/20");}
                            else { nbr.setText(cmp+"/20");}

                            if (cmp==21){
                                final AlertDialog.Builder builder =new AlertDialog.Builder(vs.this);
                                View layoutView = getLayoutInflater().inflate(R.layout.resulta_vs, null);
                                Button qt = layoutView.findViewById(R.id.qtvs);
                                final Button play = layoutView.findViewById(R.id.playvs);
                                final TextView vJ1 =layoutView.findViewById(R.id.vrJ1);
                                final TextView fJ1=layoutView.findViewById(R.id.fJ1);
                                final TextView vJ2 =layoutView.findViewById(R.id.vrJ2);
                                final TextView fJ2=layoutView.findViewById(R.id.fJ2);
                                final TextView ganJ1 =layoutView.findViewById(R.id.ganJ1);
                                final TextView ganJ2=layoutView.findViewById(R.id.ganJ2);
                                vJ1.setText(Integer.toString(nbrvraiVS1));
                                fJ1.setText(Integer.toString(nbrfauVS1));
                                vJ2.setText(Integer.toString(nbrvraiVS2));
                                fJ2.setText(Integer.toString(nbrfauVS2));

                                int noteJ1 =nbrvraiVS1-nbrfauVS1 , noteJ2 =nbrvraiVS2-nbrfauVS2;

                                if (noteJ1>noteJ2)
                                {
                                    ganJ1.setBackgroundResource(R.drawable.ganee);
                                    ganJ2.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                                }
                                else
                                {
                                    ganJ2.setBackgroundResource(R.drawable.ganee);
                                    ganJ1.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                                }

                                builder.setView(layoutView);
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


                                int  n=r.nextInt(21);
                                int  n2=r.nextInt(21);


                                if (n>n2)
                                {
                                    T1vs1.setText(Integer.toString(n));
                                    T2vs1.setText(Integer.toString(n2));
                                    T1vs2.setText(Integer.toString(n));
                                    T2vs2.setText(Integer.toString(n2));
                                }
                                else
                                {
                                    T1vs1.setText(Integer.toString(n2));
                                    T2vs1.setText(Integer.toString(n));
                                    T1vs2.setText(Integer.toString(n2));
                                    T2vs2.setText(Integer.toString(n));

                                }



                                op=tableOp[ro.nextInt(4)] ;


                                if (op.equals("+")) {
                                    Topvs1.setText("+");
                                    res = Integer.parseInt(T1vs1.getText().toString()) + Integer.parseInt(T2vs1.getText().toString());
                                }
                                if (op.equals("*")) {
                                    Topvs1.setText("*");
                                    res = Integer.parseInt(T1vs1.getText().toString()) * Integer.parseInt(T2vs1.getText().toString());
                                }
                                if (op.equals("-")) {
                                    Topvs1.setText("-");
                                    res = Integer.parseInt(T1vs1.getText().toString()) - Integer.parseInt(T2vs1.getText().toString());
                                }
                                if (op.equals("/")) {
                                    Topvs1.setText("/");
                                    res = Integer.parseInt(T1vs1.getText().toString()) / Integer.parseInt(T2vs1.getText().toString());
                                }

                                button1vs1.setText("00");
                                button2vs1.setText("00");
                                button3vs1.setText("00");
                                button4vs1.setText("00");
                                button1vs2.setText("00");
                                button2vs2.setText("00");
                                button3vs2.setText("00");
                                button4vs2.setText("00");
                                Topvs2.setText(Topvs1.getText().toString());
                                tbb[r.nextInt(4)].setText(Integer.toString(res));


                                if(!button1vs1.getText().equals(Integer.toString(res))){
                                    button1vs1.setText(Integer.toString(res+4));
                                }
                                if(!button2vs1.getText().equals(Integer.toString(res))){
                                    button2vs1.setText(Integer.toString(res+2));
                                }
                                if(!button3vs1.getText().equals(Integer.toString(res))){
                                    button3vs1.setText(Integer.toString(res+1));
                                }
                                if(!button4vs1.getText().equals(Integer.toString(res))) {
                                    button4vs1.setText(Integer.toString(res+3));


                                }

                                button1vs2.setText(button1vs1.getText().toString());
                                button2vs2.setText(button2vs1.getText().toString());
                                button3vs2.setText(button3vs1.getText().toString());
                                button4vs2.setText(button4vs1.getText().toString());

                            }

                        }
                    });

                }
                catch (InterruptedException e){ }

            }

        };
        thread.start();
    }

    public boolean test (Button button,TextView nbf,TextView nbv ,String j){


        Toast.makeText(this, "La réponse :"+res, Toast.LENGTH_SHORT).show();
        if (!button.getText().equals(Integer.toString(res))){

            button.setBackgroundResource(R.drawable.bg_faux);
            if (j.equals("vs1")){
           if (clickvs1==false)
            {
                nbrfauVS1++;
                nbf.setText(Integer.toString(nbrfauVS1));
            }}

            if (j.equals("vs2")) {
                if (clickvs2 == false) {
                    nbrfauVS2++;
                    nbf.setText(Integer.toString(nbrfauVS2));
                }
            }
            return false;

        }
        else {

            button.setBackgroundResource(R.drawable.bg_vrai);

            if (j.equals("vs1")){
            if (clickvs1==false)
           {
                nbrvraiVS1++;
                nbv.setText(Integer.toString(nbrvraiVS1));

           }}
            if (j.equals("vs2")) {
            if (clickvs2==false)
            {
                nbrvraiVS2++;
                nbv.setText(Integer.toString(nbrvraiVS2));

            }
            }


            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs);


        button1vs1=findViewById(R.id.button1vs1);
        button2vs1=findViewById(R.id.button2vs1);
        button3vs1=findViewById(R.id.button3vs1);
        button4vs1=findViewById(R.id.button4vs1);
        button1vs2=findViewById(R.id.button1vs2);
        button2vs2=findViewById(R.id.button2vs2);
        button3vs2=findViewById(R.id.button3vs2);
        button4vs2=findViewById(R.id.button4vs2);
        T1vs1=findViewById(R.id.textView1vs1);
        T2vs1=findViewById(R.id.textView3vs1);
        Topvs1=findViewById(R.id.textView2vs1);
        T1vs2=findViewById(R.id.textView1vs2);
        T2vs2=findViewById(R.id.textView3vs2);
        Topvs2=findViewById(R.id.textView2vs2);
        nbfvs1= findViewById(R.id.nbrFvs1);
        nbvvs1=findViewById(R.id.nbrVvs1);
        nbfvs2=findViewById(R.id.nbrFvs2);
        nbvvs2=findViewById(R.id.nbrVvs2);

        nbr=findViewById(R.id.nbrvs);
        final Button[] tb ={button1vs1,button2vs1,button3vs1,button4vs1};

        rnb(tb);

        button1vs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if ( test(button1vs1,nbfvs1,nbvvs1,"vs1"))
            {
                rnb(tb);
            }
                clickvs1 =true;

            }});

        button2vs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(test(button2vs1,nbfvs1,nbvvs1,"vs1"))
                {
                    rnb(tb);
                }
                clickvs1 =true;
            }
        });

        button3vs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (test(button3vs1,nbfvs1,nbvvs1,"vs1"))
                {
                    rnb(tb);
                }
                clickvs1 =true;
            }
        });

        button4vs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(test(button4vs1,nbfvs1,nbvvs1,"vs1"))
                {
                    rnb(tb);
                }
                clickvs1 =true;

            }
        });




        button1vs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(test(button1vs2,nbfvs2,nbvvs2,"vs2"))
                {
                    rnb(tb);
                }
                clickvs2 =true;
            }});

        button2vs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(test(button2vs2,nbfvs2,nbvvs2,"vs2"))
                {
                    rnb(tb);
                }
                clickvs2 =true;
            }
        });

        button3vs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(test(button3vs2,nbfvs2,nbvvs2,"vs2"))
                {
                    rnb(tb);
                }
                clickvs2 =true;
            }
        });

        button4vs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(test(button4vs2,nbfvs2,nbvvs2,"vs2"))
                {
                    rnb(tb);
                }
                clickvs2 =true;
            }
        });


    }
    public void onBackPressed() {
        final AlertDialog.Builder builder =new AlertDialog.Builder(vs.this);
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
