package com.example.jairo.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModColaborador extends AppCompatActivity {
    private EditText txt1;
    private Button btnIngresar,btnListar;
    private Spinner cmb1,cmb2,cmb3,cmb4;
    private TextView textView1,textView2,textView3,textView5;
    String IPaqui="172.16.24.19",obtentxt1,obtencmb3,obtencmb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_colaborador);

        //hago una instancia a todas las variables que se crean en la VISTA
       /*
        cmb1 = findViewById(R.id.cmb1);//cmb1 seleccionar casa
        textView1 = findViewById(R.id.textView1);
        cmb2 = findViewById(R.id.cmb2);//cmb2 seleccionar obra
        textView2 = findViewById(R.id.textView2);
        */
        cmb3 = findViewById(R.id.cmb3);//cmb3 seleccionar lugar
        textView3 = findViewById(R.id.textView3);

        txt1 = findViewById(R.id.txt1);//numero de colaborador

        cmb4 = findViewById(R.id.cmb4);//cmb4 tipo colaborador
        textView5 = findViewById(R.id.textView5);

        btnIngresar = findViewById(R.id.btnIngresar);
        btnListar = findViewById(R.id.btnListar);


          //Implementamos el evento click del botón INGRESAR
        //BOTON INGRESAR
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AQUI VA EL CODIGO PARA INGRESAR LA INFORMACION



                //este de ley va al final porque se llama a la lista para ver el nuevo dato ingresado
                invocar_lista();
            }
        });//fin BTN INGRESAR

        //boton listar
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.
                invocar_lista();
            }
        });//FIN BTN LISTAR

    }//fin ONCREATE

    private void invocar_lista(){
        //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
        Intent intent = new Intent(ModColaborador.this, ListActivity.class);
        //indico con una variable el nombre de la lista que quiero ver
        //Creamos la información a pasar entre actividades
        Bundle b = new Bundle();
        b.putString("LISTARDATOSDE", "ModColaborador");
        //Añadimos la información al intent
        intent.putExtras(b);
        //Iniciamos la nueva actividad
        startActivity(intent);
    }
}//fin clase