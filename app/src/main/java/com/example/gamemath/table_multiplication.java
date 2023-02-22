package com.example.gamemath;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Array;

public class table_multiplication extends AppCompatActivity {
    TextView tv;
 ImageView img;
 Button btn_s,btn_pr;
    int i=0;

 int [] im=new int[]{
         R.drawable.table_1,
         R.drawable.table_2,
         R.drawable.table_3,
         R.drawable.table_4,
         R.drawable.table_5,
         R.drawable.table_6,
         R.drawable.table_7,
         R.drawable.table_8,
         R.drawable.table_9,
         R.drawable.table_10
 };
    String [] n=new String[]{
            "Table de 1",
            "Table de 2",
            "Table de 3",
            "Table de 4",
            "Table de 5",
            "Table de 6",
            "Table de 7",
            "Table de 8",
            "Table de 9",
            "Table de 10"

    };
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);
        tv=findViewById(R.id.txt_t);
        img=findViewById(R.id.img_t);
        btn_s=findViewById(R.id.btn_sv);
         btn_pr=findViewById(R.id.btn_pr);



        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (i<9){
                i++;
                tv.setText(n[i]);
                img.setImageResource(im[i]);
            }
            }
        });

        btn_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i>0){
                    i--;
                    tv.setText(n[i]);
                    img.setImageResource(im[i]);

                }


            }
        });

    }

}
