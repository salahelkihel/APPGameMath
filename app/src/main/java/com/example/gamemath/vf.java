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

public class vf extends AppCompatActivity {



    Button buttonv ,buttonf ;
    TextView T1 ,T2 ,nbr,Top,resulta;
    Timer timer;
    int cmp=0,nbrvrai=0,nbrfau=0;
    String [] tableOp={"+","-","*","/"};
    String op="";
    int res=0;
    Random ro =new Random();

    Random r =new Random();
    public void rnb(){

        Thread thread= new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(500);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            buttonv.setBackgroundResource(R.drawable.bg_but);
                            buttonf.setBackgroundResource(R.drawable.bg_but);

                            cmp++;
                            if (cmp==21){nbr.setText("20/20");}
                            else { nbr.setText(cmp+"/20");}

                            if (cmp==20){
                                final AlertDialog.Builder builder =new AlertDialog.Builder(vf.this);
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
                                res=0;

                                op=tableOp[ro.nextInt(4)] ;


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

                                int [] tr ={res+3,res+6,res+2,res,res};

                             resulta.setText(Integer.toString(tr[r.nextInt(5)]));


                            }

                        }
                    });

                }
                catch (InterruptedException e){ }

            }

        };
        thread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vf);
        buttonv=findViewById(R.id.buttonv);
        buttonf=findViewById(R.id.buttonf);
        T1=findViewById(R.id.textView1vf);
        T2=findViewById(R.id.textView3vf);
        Top=findViewById(R.id.textView2vf);
        resulta=findViewById(R.id.textView5vf);
        nbr=findViewById(R.id.nbrvf);


        rnb();


        buttonv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (res==Integer.parseInt(resulta.getText().toString())) {

                   buttonv.setBackgroundResource(R.drawable.bg_vrai);
                   nbrvrai++;
               }
               else {
                   buttonv.setBackgroundResource(R.drawable.bg_faux);
                   nbrfau++;
               }
                rnb();

            }});

        buttonf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (res==Integer.parseInt(resulta.getText().toString())) {

                    buttonf.setBackgroundResource(R.drawable.bg_faux);
                    nbrfau++;

                }
                else {

                    buttonf.setBackgroundResource(R.drawable.bg_vrai);
                    nbrvrai++;

                }
                rnb();

            }
        });

    }
    public void onBackPressed() {
        final AlertDialog.Builder builder =new AlertDialog.Builder(vf.this);
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
