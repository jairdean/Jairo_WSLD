package com.example.jairo.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mod_CasaSalesiana extends AppCompatActivity {

    private EditText editText4,editText5,editText6,editText7,editText8;
    private Button btnIngresar,btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_casa_salesiana);

        editText4 = findViewById(R.id.editText4);
        editText5= findViewById(R.id.editText5);
        editText6= findViewById(R.id.editText6);
        editText7= findViewById(R.id.editText7);
        editText8= findViewById(R.id.editText8);
        btnIngresar= findViewById(R.id.btnIngresar);
        btnListar= findViewById(R.id.btnListar);


        //Implementamos el evento click del botón
        //boton ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.


            }
        });

        //boton listar
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(Mod_CasaSalesiana.this, List_CasaSalesiana.class);

                //Iniciamos la nueva actividad
                startActivity(intent);

            }
        });



    }//fin ON CREATE




}//fin CLASE
