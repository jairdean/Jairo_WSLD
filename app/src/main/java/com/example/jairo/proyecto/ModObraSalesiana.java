package com.example.jairo.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModObraSalesiana extends AppCompatActivity {

    private Button btnIngresar,btnListar;
    private Spinner cmb1,cmb2;
    private EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    private TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_obra_salesiana);

        cmb1= findViewById(R.id.cmb1);//cmb1 id casa
        textView1= findViewById(R.id.textView1);

        cmb2= findViewById(R.id.cmb2);//cmb2 id tipo obra
        textView2= findViewById(R.id.textView2);

        txt1=findViewById(R.id.txt1);//denominacion obra
        txt2=findViewById(R.id.txt2);//campo servicio obra
        txt3=findViewById(R.id.txt3);//productos obra
        txt4=findViewById(R.id.txt4);//10:00 a 15:00
        txt5=findViewById(R.id.txt5);//informacion obra
        txt6=findViewById(R.id.txt6);//pagina web obra
        txt7=findViewById(R.id.txt7);//nombre corto obra


        btnIngresar = findViewById(R.id.btnIngresar);//boton ingresar
        btnListar = findViewById(R.id.btnListar);//boton listar

        //Implementamos el evento click del botón
        //boton ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.




                //este de ley va al final porque se llama a la lista para ver el nuevo dato ingresado
                invocar_lista();
            }
        });

        //boton listar
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.
                invocar_lista();
            }
        });
    }//fin ON CREATE

    private void invocar_lista(){
        //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
        Intent intent = new Intent(ModObraSalesiana.this, ListActivity.class);
        //indico con una variable el nombre de la lista que quiero ver
        //Creamos la información a pasar entre actividades
        Bundle b = new Bundle();
        b.putString("LISTARDATOSDE", "ModObraSalesiana");
        //Añadimos la información al intent
        intent.putExtras(b);
        //Iniciamos la nueva actividad
        startActivity(intent);
    }
}
