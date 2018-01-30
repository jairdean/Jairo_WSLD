package com.example.jairo.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mod_CasaSalesiana extends AppCompatActivity {

    private EditText txt4,txt5,txt6,txt7,txt8;
    private Button btnIngresar,btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_casa_salesiana);

        txt4 = findViewById(R.id.editText4);//casa salesiana
        txt5= findViewById(R.id.editText5);//direccion
        txt6= findViewById(R.id.editText6);//telefono
        txt7= findViewById(R.id.editText7);//director
        txt8= findViewById(R.id.editText8);//nombre casa CORTO

        btnIngresar= findViewById(R.id.btnIngresar);
        btnListar= findViewById(R.id.btnListar);


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
        Intent intent = new Intent(Mod_CasaSalesiana.this, ListActivity.class);
        //indico con una variable el nombre de la lista que quiero ver
        //Creamos la información a pasar entre actividades
        Bundle b = new Bundle();
        b.putString("LISTARDATOSDE", "Mod_CasaSalesiana");
        //Añadimos la información al intent
        intent.putExtras(b);
        //Iniciamos la nueva actividad
        startActivity(intent);
    }


}//fin CLASE
