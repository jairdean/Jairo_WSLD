package com.example.jairo.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ModBeneficiario extends AppCompatActivity{

    private TextView lblMensaje,textView1,textView2,textView3;
    private Spinner cmbOpciones,cmb1,cmb2,cmb3;
    private EditText txt1,txt2;
    private Button btnIngresar,btnListar;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_beneficiario);

        lblMensaje = findViewById(R.id.LblMensaje);
       textView1 = findViewById(R.id.textView1);
       textView2 = findViewById(R.id.textView2);
       textView3 = findViewById(R.id.textView3);
        cmbOpciones = findViewById(R.id.CmbOpciones);
        cmb1 = findViewById(R.id.cmb1);//id casa
        cmb2 = findViewById(R.id.cmb2);//id obra
        cmb3 = findViewById(R.id.cmb3);//id lugar
       txt1 = findViewById(R.id.txt1);//descripcion
       txt2 = findViewById(R.id.txt2);//numero de beneficiarios
       btnIngresar = findViewById(R.id.btnIngresar);//boton ingresar
       btnListar = findViewById(R.id.btnListar);//boton listar

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
                   public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                       lblMensaje.setText("Seleccionado: " +
                               parent.getItemAtPosition(position));
                   }

                   public void onNothingSelected(AdapterView<?> parent) {
                       lblMensaje.setText("Seleccione una opcion");
                   }
               });


       //Implementamos el evento click del botón
       //boton ingresar
       btnIngresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //aqui se pone la accion que haria el boton.


           }
       });


       btnListar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //aqui se pone la accion que haria el boton.


           }
       });
    }
    //end ON CREATE







}
