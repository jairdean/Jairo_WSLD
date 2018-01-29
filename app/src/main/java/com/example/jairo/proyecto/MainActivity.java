package com.example.jairo.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private Button btnAceptar;
    private Button btnCasaSalesiana,btnBeneficiario,btnColaborador,btnLugar,btnObraSalesiana,btnTipoColaborador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnBeneficiario= findViewById(R.id.btnBeneficiario);//1
        btnCasaSalesiana = findViewById(R.id.btnCasaSalesiana);//2
        btnColaborador= findViewById(R.id.btnColaborador);//3
        btnLugar= findViewById(R.id.btnLugar);//4
        btnObraSalesiana= findViewById(R.id.btnObraSalesiana);//5
        btnTipoColaborador= findViewById(R.id.btnTipoColaborador);//6

        //Implementamos el evento click del botón
        //1
        btnBeneficiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(MainActivity.this, ModBeneficiario.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        //2
        btnCasaSalesiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(MainActivity.this, Mod_CasaSalesiana.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        //3
        btnColaborador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(MainActivity.this, Mod_CasaSalesiana.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });


        //4
        btnLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(MainActivity.this, Mod_CasaSalesiana.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        //5
        btnObraSalesiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(MainActivity.this, Mod_CasaSalesiana.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        //6
        btnTipoColaborador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(MainActivity.this, Mod_CasaSalesiana.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });



//Obtenemos una referencia a los controles de la interfaz
       // txtNombre = findViewById(R.id.txtNombre);
       // btnAceptar = findViewById(R.id.btnAceptar);


        /*Implementamos el evento click del botón
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =
                        new Intent(MainActivity.this, Modulo1.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("PASO_NOMBRE", txtNombre.getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
*/




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
