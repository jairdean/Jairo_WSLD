package com.example.jairo.proyecto;

import android.content.Intent;
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

        cmb1 = findViewById(R.id.cmb1);//cmb1 id casa
        textView1 = findViewById(R.id.textView1);

        cmb2 = findViewById(R.id.cmb2);//cmb2 id obra
        textView2 = findViewById(R.id.textView2);

        txt1 = findViewById(R.id.txt1);//nombre del lugar
        txt2 = findViewById(R.id.txt2);//descripcion del lugar
        txt3 = findViewById(R.id.txt3);//responsable del lugar
        txt4 = findViewById(R.id.txt4);//direccion del lugar
        txt5 = findViewById(R.id.txt5);//telefono del lugar

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

    }//fin ON CREATE

    private void invocar_lista(){
        //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
        Intent intent = new Intent(ModLugar.this, ListActivity.class);
        //indico con una variable el nombre de la lista que quiero ver
        //Creamos la información a pasar entre actividades
        Bundle b = new Bundle();
        b.putString("LISTARDATOSDE", "ModLugar");
        //Añadimos la información al intent
        intent.putExtras(b);
        //Iniciamos la nueva actividad
        startActivity(intent);
    }
}//fin clase
