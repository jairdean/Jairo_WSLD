package com.example.jairo.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ModBeneficiario extends AppCompatActivity{

    private TextView lblMensaje;
    private Spinner cmbOpciones;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_beneficiario);

        lblMensaje = findViewById(R.id.LblMensaje);
        cmbOpciones = findViewById(R.id.CmbOpciones);

        //esta es la lista que se obtendira de la base
        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        //aqui se manda los datos al spinner
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        //spinner carga los datos como recurso
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        //aqui se pone los datos en el spinner y son vistos por el usuario
        cmbOpciones.setAdapter(adaptador);

        //este es un oyente del tipo que ha seleccionado el usuairo cmbOpciones
        cmbOpciones.setOnItemSelectedListener(
               new OnItemSelectedListener() {
                   public void onItemSelected(AdapterView<?> parent,
                                              android.view.View v, int position, long id) {
                       lblMensaje.setText("Seleccionado: " +
                               parent.getItemAtPosition(position));
                   }

                   public void onNothingSelected(AdapterView<?> parent) {
                       lblMensaje.setText("Seleccione una opcion");
                   }
               });


    }
    //end ON CREATE







}
