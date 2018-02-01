package com.example.jairo.proyecto;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Mod_CasaSalesiana extends AppCompatActivity {

    private EditText txt4,txt5,txt6,txt7,txt8,txt9;
    private Button btnIngresar,btnListar;
    String IPaqui="192.168.100.171";
    String recibotxt4,recibotxt5,recibotxt6,recibotxt7,recibotxt8,recibotxt9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_casa_salesiana);

        txt4 = findViewById(R.id.editText4);//casa salesiana
        txt5= findViewById(R.id.editText5);//direccion
        txt6= findViewById(R.id.editText6);//telefono
        txt7= findViewById(R.id.editText7);//director
        txt8= findViewById(R.id.editText8);//nombre casa CORTO
        txt9= findViewById(R.id.editText9);//correo electronico

        btnIngresar= findViewById(R.id.btnIngresar);
        btnListar= findViewById(R.id.btnListar);


        //Implementamos el evento click del botón
        //boton ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.
                recibotxt4=txt4.getText().toString();
                recibotxt5=txt5.getText().toString();
                recibotxt6=txt6.getText().toString();
                recibotxt7=txt7.getText().toString();
                recibotxt8=txt8.getText().toString();
                recibotxt9=txt9.getText().toString();
                TareaCasaSalesiaan llamada= new TareaCasaSalesiaan();
                llamada.execute();


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

    private class TareaCasaSalesiaan extends AsyncTask<String, Integer, Boolean> {
        protected Boolean doInBackground(String... params) {
            boolean resul = true;
            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://"+IPaqui+":8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "insertarCasaSalesiana";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


            request.addProperty("nombrecasa",recibotxt4);
            request.addProperty("dircasa",recibotxt5);
            request.addProperty("telcasa",recibotxt6);
            request.addProperty("directorcasa",recibotxt7);
            request.addProperty("cortocasa",recibotxt8);
            request.addProperty("correo",recibotxt9);

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+recibotxt4);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = false;
            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(NAMESPACE + "/" + METHOD_NAME, envelope);
                SoapPrimitive resultado_xml= (SoapPrimitive) envelope.getResponse();
                String res=resultado_xml.toString();
                if(!res.equals(1)){
                    resul=false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                resul = false;
            }
            return resul;
        }
    }//fin sub clase
}//fin CLASE
