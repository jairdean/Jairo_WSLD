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

public class ModTipoColaborador extends AppCompatActivity {

    private Button btnIngresar,btnListar;
    private EditText txt1;
    String IPaqui="192.168.100.171",strAum,recibotxt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_tipo_colaborador);

        txt1 = findViewById(R.id.txt1);//tipo colaborador

        btnIngresar = findViewById(R.id.btnIngresar);//boton ingresar
        btnListar = findViewById(R.id.btnListar);//boton listar


        //Implementamos el evento click del botón
        //boton ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui se pone la accion que haria el boton.
                recibotxt1=txt1.getText().toString();//recupero la data

                TareaListaTipoCol llamada= new TareaListaTipoCol();
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
        Intent intent = new Intent(ModTipoColaborador.this, ListActivity.class);
        //indico con una variable el nombre de la lista que quiero ver
        //Creamos la información a pasar entre actividades
        Bundle b = new Bundle();
        b.putString("LISTARDATOSDE", "ModTipoColaborador");
        //Añadimos la información al intent
        intent.putExtras(b);
        //Iniciamos la nueva actividad
        startActivity(intent);
    }//fin metodo

    private class TareaListaTipoCol extends AsyncTask<String, Integer, Boolean> {
        protected Boolean doInBackground(String... params) {
            boolean resul = true;
            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://"+IPaqui+":8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "insertarTipoColaborador";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            request.addProperty("descripcion",recibotxt1);
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+recibotxt1);

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

}
