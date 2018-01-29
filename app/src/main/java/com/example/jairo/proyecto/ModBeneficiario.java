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

        lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        cmbOpciones = (Spinner)findViewById(R.id.CmbOpciones);

        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        cmbOpciones.setAdapter(adaptador);

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
