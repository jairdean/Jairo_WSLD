package com.example.jairo.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ModColaborador extends AppCompatActivity {
    private EditText txt1;
    private Button btnIngresar;
    private Spinner cmb1,cmb2,cmb3,cmb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_colaborador);

        //hago una instancia a todas las variables que se crean en la VISTA
        cmb1 = findViewById(R.id.cmb1);
        txt1 = findViewById(R.id.txt1);
        btnIngresar = findViewById(R.id.btnIngresar);
        cmb2 = findViewById(R.id.cmb2);
        cmb3 = findViewById(R.id.cmb3);
        cmb4 = findViewById(R.id.cmb4);


          //Implementamos el evento click del botón INGRESAR
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AQUI VA EL CODIGO PARA INGRESAR LA INFORMACION


            }
        });//fin BTN INGRESAR

    }//fin ONCREATE

}//fin clase