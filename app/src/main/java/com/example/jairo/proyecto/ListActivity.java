package com.example.jairo.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    private String LISTARDATOSDE;
    private TableLayout myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        LISTARDATOSDE=bundle.getString("LISTARDATOSDE");


                    myData = findViewById(R.id.lytJairoLista);
        myData.setStretchAllColumns(true);
        myData.bringToFront();
        int i=0;
        for( i= 0; i < 3; i++){
            //crea la fila
            TableRow tr =  new TableRow(this);
            //obtener los datos de la BASE
            TextView c1 = new TextView(this);
            c1.setText(LISTARDATOSDE);
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
