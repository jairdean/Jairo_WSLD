package com.example.jairo.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModTipoColaborador extends AppCompatActivity {

    private Button btnIngresar,btnListar;
    private EditText txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_tipo_colaborador);

        txt1 = findViewById(R.id.txt1);

        btnIngresar = findViewById(R.id.btnIngresar);//boton ingresar
        btnListar = findViewById(R.id.btnListar);//boton listar


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


            }
        });

    }//fin ON CREATE
}
