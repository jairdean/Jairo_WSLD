package com.example.jairo.proyecto;

import android.content.Intent;
import android.os.AsyncTask;
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

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ModBeneficiario extends AppCompatActivity{

    private TextView lblMensaje,textView1,textView2,textView3;
    private Spinner cmbOpciones,cmb1,cmb2,cmb3;
    private EditText txt1,txt2;
    private Button btnIngresar,btnListar;
    HashMap<Integer,String> hmDatosCasa;
    ArrayList<String> vecCasa=new ArrayList<>();
    ResultSet rs=null;
    String IPaqui="172.16.24.19";
    String obtenertxt1,obtenertxt2,obtenercmb3;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_beneficiario);
       hmDatosCasa= new HashMap<>();
       rs=null;

       /*
       cmbOpciones = findViewById(R.id.CmbOpciones);
        lblMensaje = findViewById(R.id.LblMensaje);
        */

        cmb1 = findViewById(R.id.cmb1);//id casa
       textView1 = findViewById(R.id.textView1);

        cmb2 = findViewById(R.id.cmb2);//id obra
       textView2 = findViewById(R.id.textView2);

        cmb3 = findViewById(R.id.cmb3);//id lugar
       textView3 = findViewById(R.id.textView3);

       txt1 = findViewById(R.id.txt1);//descripcion
       txt2 = findViewById(R.id.txt2);//numero de beneficiarios

       btnIngresar = findViewById(R.id.btnIngresar);//boton ingresar
       btnListar = findViewById(R.id.btnListar);//boton listar
/*
        for (int i=1;i<=24;i++){
            hmDatosCasa.put(i,String.valueOf(i));
            vecCasa[i]=String.valueOf(i);

        }



*/

        sqlThread.start();
        try {
            sqlThread.join();
        }catch (Exception e){

        }

       ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, vecCasa);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       cmb3.setAdapter(adapter);

/*
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

*/
       //Implementamos el evento click del botón
       //boton ingresar
       btnIngresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //aqui se pone la accion que haria el boton.
               obtenertxt1=txt1.getText().toString();
               obtenertxt2=txt2.getText().toString();
               String indice=cmb3.getSelectedItem().toString();
               obtenercmb3 = hmDatosCasa.get(cmb3.getSelectedItemPosition());
               TareaBeneficiario llamada= new TareaBeneficiario();
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
    }//end ON CREATE

    Thread sqlThread = new Thread() {
        public void run() {
            Connection conn=null;
            try {
                Class.forName("org.postgresql.Driver");
                // "jdbc:postgresql://IP:PUERTO/DB", "USER", "PASSWORD");
                // Si estás utilizando el emulador de android y tenes el PostgreSQL en tu misma PC no utilizar 127.0.0.1 o localhost como IP, utilizar 10.0.2.2
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://192.168.100.196:5432/20150820", "postgres", "postgres");
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
    Intent intent = new Intent(ModBeneficiario.this, ListActivity.class);
    //indico con una variable el nombre de la lista que quiero ver
    //Creamos la información a pasar entre actividades
    Bundle b = new Bundle();
    b.putString("LISTARDATOSDE", "ModBeneficiario");
    //Añadimos la información al intent
    intent.putExtras(b);
    //Iniciamos la nueva actividad
    startActivity(intent);
}


    private class TareaBeneficiario extends AsyncTask<String, Integer, Boolean> {
        protected Boolean doInBackground(String... params) {
            boolean resul = true;
            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://"+IPaqui+":8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "insertarBeneficiario";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);


            request.addProperty("descripcion",obtenertxt1);
            request.addProperty("numero_ben",obtenertxt2);
            request.addProperty("id_lug",obtenercmb3);


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
