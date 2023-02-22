package com.example.gamemath;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class menu_math extends AppCompatActivity {
    GridLayout mainGrid;
    private LinearLayout ad ,so,mu,di ,tm,qz,Vf,vs;

    public void onBackPressed() {
        final AlertDialog.Builder builder =new AlertDialog.Builder(menu_math.this);
        View layoutView = getLayoutInflater().inflate(R.layout.quitter, null);
        final Button non = layoutView.findViewById(R.id.non);
        final Button oui = layoutView.findViewById(R.id.oui);
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_math);

        mainGrid = findViewById(R.id.mainGrid);
        ad=  findViewById(R.id.btn_addition);
        so=  findViewById(R.id.btn_soustraction);
        mu=  findViewById(R.id.btn_multiplication);
        di=  findViewById(R.id.btn_division);
        Vf=findViewById(R.id.vf);
       tm=  findViewById(R.id.tm);
       qz=findViewById(R.id.qz);
       vs=findViewById(R.id.vs);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,menu_choix.class);
                i.putExtra("R","addition");
                startActivity(i);
            }
        });
        so.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,menu_choix.class);
                i.putExtra("R","soustraction");
                startActivity(i);
            }
        });
        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,menu_choix.class);
                i.putExtra("R","multiplication");
                startActivity(i);
            }
        });
        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,menu_choix.class);
                i.putExtra("R","division");
                startActivity(i);
            }
        });

        tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,table_multiplication.class);
                startActivity(i);
            }
        });
        qz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,quiz.class);
                startActivity(i);
            }
        });
        Vf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,vf.class);
                startActivity(i);
            }
        });
        vs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(menu_math.this,vs.class);
                startActivity(i);
            }
        });



    }
}
