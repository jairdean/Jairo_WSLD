package com.example.jairo.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class List_CasaSalesiana extends AppCompatActivity {
    private TableLayout myData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__casa_salesiana);


        myData = findViewById(R.id.lytactivity_list__casa_salesiana);
        myData.setStretchAllColumns(true);
        myData.bringToFront();
        int i=0;
        for( i= 0; i < 3; i++){
            //crea la fila
            TableRow tr =  new TableRow(this);

            //obtener los datos
            TextView c1 = new TextView(this);
            c1.setText("uno "+i);

            TextView c2 = new TextView(this);
            c2.setText("dos "+i);

            TextView c3 = new TextView(this);
            c3.setText("tres "+i);

            //agregar los datos en la tabla
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            myData.addView(tr);
        }




    }
}
