package com.example.jairo.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    private String LISTARDATOSDE,
            ClaseBeneficiario="ModBeneficiario",
            ClaseCasaSalesiana="Mod_CasaSalesiana",
            ClaseColaborador="ModColaborador",
            ClaseLugar="ModLugar",
            ClaseObraSalesiana="ModObraSalesiana",
            ClaseTipoColaborador="ModTipoColaborador";
    private TableLayout myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        //Construimos el mensaje a mostrar
        LISTARDATOSDE=bundle.getString("LISTARDATOSDE");//esta sera la variable del boton listar y sabre cual esta llamando

        //sirve para estableces la tabla de datos a la ventana lytJairoLista
        myData = findViewById(R.id.lytJairoLista);
        myData.setStretchAllColumns(true);
        myData.bringToFront();
        switch (LISTARDATOSDE){
            case "ModBeneficiario":
                int i=0;
                for( i= 0; i < 40; i++){
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
                break;
            case "Mod_CasaSalesiana":

            break;
            case "ModColaborador":

            break;
            case "ModLugar":

            break;
            case "ModObraSalesiana":

            break;
            case "ModTipoColaborador":

            break;
                default:

                    break;
        }


    }
}
