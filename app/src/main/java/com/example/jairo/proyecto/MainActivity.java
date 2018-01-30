package com.example.jairo.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{
    private EditText txtNombre;
    private Button btnAceptar;
    private Button btnCasaSalesiana,btnBeneficiario,btnColaborador,btnLugar,btnObraSalesiana,btnTipoColaborador;
    Spinner s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        s1.setOnItemSelectedListener(this);


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
                        new Intent(MainActivity.this, ModColaborador.class);

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
                        new Intent(MainActivity.this, ModLugar.class);

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

    }//fin ON CREATE

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


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        String sp1= String.valueOf(s1.getSelectedItem());
        Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Income")) {
            List<String> list = new ArrayList<String>();
            list.add("Salary");//You should add items from db here (first spinner)
            list.add("jairo");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("Expense")) {
            List<String> list = new ArrayList<String>();
            list.add("Conveyance");//you should add items from db here(2nd spinner)
            list.add("Jhon");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}//FIN DE LA CLASE
