package com.example.jairo.proyecto;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ModColaborador extends AppCompatActivity {
    private EditText txt1;
    private Button btnIngresar,btnListar;
    private Spinner cmb1,cmb2,cmb3,cmb4;
    private TextView textView1,textView2,textView3,textView5;
    String IPaqui="172.16.24.19",obtentxt1,obtencmb3,obtencmb4;
    String IPdeBASEDATOS="172.16.24.17";

    //para cmb3
    ResultSet rs=null;
    HashMap<Integer,String> hmDatosCasa;
    ArrayList<String> vecCasa=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_colaborador);
        hmDatosCasa= new HashMap<>();
        rs=null;

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

        sqlThread.start();
        try {
            sqlThread.join();
        }catch (Exception e){

        }

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, vecCasa);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmb3.setAdapter(adapter);


          //Implementamos el evento click del botón INGRESAR
        //BOTON INGRESAR
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AQUI VA EL CODIGO PARA INGRESAR LA INFORMACION
                obtencmb3 = hmDatosCasa.get(cmb3.getSelectedItemPosition());
                obtentxt1 =txt1.getText().toString();
                //obtencmb4

                TareaColaborador llamada= new TareaColaborador();
                llamada.execute();
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


    Thread sqlThread = new Thread() {
        public void run() {
            Connection conn=null;
            try {
                Class.forName("org.postgresql.Driver");
                // "jdbc:postgresql://IP:PUERTO/DB", "USER", "PASSWORD");
                // Si estás utilizando el emulador de android y tenes el PostgreSQL en tu misma PC no utilizar 127.0.0.1 o localhost como IP, utilizar 10.0.2.2
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://"+IPdeBASEDATOS+":5432/20150820", "postgres", "postgres");
                //En el stsql se puede agregar cualquier consulta SQL deseada.
                String stsql = "Select * from tb_lugar";
                Statement st = conn.createStatement();
                rs = st.executeQuery(stsql);

                int i=0;
                try {

                    while(rs.next()){
                        hmDatosCasa.put(i,String.valueOf(rs.getInt(1)));
                        vecCasa.add(rs.getString(4));
                        i++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            } catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }
    };
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

    private class TareaColaborador extends AsyncTask<String, Integer, Boolean> {
        protected Boolean doInBackground(String... params) {
            boolean resul = true;
            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://"+IPaqui+":8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "insertarColaborador";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


            request.addProperty("idlug",obtencmb3);
            request.addProperty("cantcolabob",obtentxt1);
            request.addProperty("idTipoCol",1);


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

}//fin clase