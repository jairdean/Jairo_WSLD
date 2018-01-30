package com.example.jairo.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModLugar extends AppCompatActivity {

    private Spinner cmb1,cmb2;
    private EditText txt1,txt2,txt3,txt4,txt5;
    private TextView textView1,textView2;
    private Button btnListar,btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_lugar);

        cmb1 = findViewById(R.id.cmb1);
        textView1 = findViewById(R.id.textView1);

        cmb2 = findViewById(R.id.cmb2);
        textView2 = findViewById(R.id.textView2);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);

        btnIngresar = findViewById(R.id.btnIngresar);
        btnListar = findViewById(R.id.btnListar);

        //Implementamos el evento click del botón INGRESAR
        //BOTON INGRESAR
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AQUI VA EL CODIGO PARA INGRESAR LA INFORMACION


            }
        });//fin BTN INGRESAR

        //boton listar
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.


            }
        });//FIN BTN LISTAR


    }//fin ON CREATE
}
