package com.example.gamemath;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_choix extends AppCompatActivity {

    Button facile,moyen,dificile;
    public  void nivauMath ( String nivaux){

        Intent in=getIntent();
        String res=in.getStringExtra("R");
        Class c =addition.class;;
        if (res.equals("addition")){
            c = addition.class;
        }
        if(res.equals("soustraction")){
            c = soustraction.class;
        }
        if(res.equals("multiplication")){
            c = multiplication.class;
        }
        if(res.equals("division")){
            c = division.class;
        }
        Intent i=new Intent(menu_choix.this,c);
        i.putExtra("nivau",nivaux);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_choix);

        facile=findViewById(R.id.facile);
        dificile=findViewById(R.id.dificile);
        moyen=findViewById(R.id.moyene);



        facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             nivauMath("facile");
            }
        });

       moyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nivauMath("moyen");
            }
        });

        dificile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivauMath("dificile");
            }
        });

    }
}
