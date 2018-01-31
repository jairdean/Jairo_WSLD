package com.example.jairo.proyecto;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ListActivity extends AppCompatActivity {
     String LISTARDATOSDE,strAum;

    TableLayout myData;
    TableRow tr;
    TextView c1,c2,c3;
    TextView txtview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        strAum= new String();
        txtview= new TextView(this);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        //Construimos el mensaje a mostrar
        LISTARDATOSDE = bundle.getString("LISTARDATOSDE");//esta sera la variable del boton listar y sabre cual esta llamando

        //sirve para estableces la tabla de datos a la ventana lytJairoLista
        myData = findViewById(R.id.lytJairoLista);
        myData.setStretchAllColumns(true);
        myData.bringToFront();

        int i = 0;
        switch (LISTARDATOSDE) {
            case "ModBeneficiario":
                TareaListaBeneficiario tarea1 = new TareaListaBeneficiario();
                tarea1.execute();
                break;
            case "Mod_CasaSalesiana":
                TareaListaCasaSalesiana tarea2 = new TareaListaCasaSalesiana();
                tarea2.execute();
                /*
                for (i = 0; i < 40; i++) {
                    //crea la fila
                    TableRow tr = new TableRow(this);
                    //obtener los datos de la BASE
                    TextView c1 = new TextView(this);
                    c1.setText(LISTARDATOSDE);
                    TextView c2 = new TextView(this);
                    c2.setText("dos " + i);
                    TextView c3 = new TextView(this);
                    c3.setText("tres " + i);
                    //agregar los datos en la tabla
                    tr.addView(c1);
                    tr.addView(c2);
                    tr.addView(c3);
                    myData.addView(tr);
                }
                */
                break;
            case "ModColaborador":
                //problemas
                TareaListaColaboradores tarea3 = new TareaListaColaboradores();
                tarea3.execute();
                break;
            case "ModLugar":

                break;
            case "ModObraSalesiana":

                break;
            case "ModTipoColaborador":
                TareaListaTipoCol tarea = new TareaListaTipoCol();
                tarea.execute();
                break;
            default:

                break;

        }
        //myData.addView(tr);

    }//fin ON CREATE


    //Tarea Asíncrona para llamar al WS de consulta en segundo plano
    private class TareaListaTipoCol extends AsyncTask<String, Integer, Boolean> {

        //private Cliente[] listaClientes;
        String n, a, c, p;

        protected Boolean doInBackground(String... params) {

            boolean resul = true;

            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://172.16.24.19:8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "listTipoColaborador";


            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(NAMESPACE + "/" + METHOD_NAME, envelope);

                //SoapObject resSoap = (SoapObject) envelope.getResponse();
                SoapObject resSoap = (SoapObject) envelope.bodyIn;
                int x = resSoap.getPropertyCount();

                for (int i = 0; i < x; i++) {

                    SoapObject objeto = (SoapObject) resSoap.getProperty(i);
                    n = objeto.getProperty(0).toString();
                    a = objeto.getProperty(1).toString();
                    c = objeto.getProperty(2).toString();

                    strAum=strAum+c+"  "+a+"  "+n+"\n";

                    System.out.println(strAum);

                }


                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent =  new Intent(ListActivity.this, Modulo1.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("PASO_NOMBRE", strAum);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);

                //String nombre = resSoap.getProperty(1).toString();

                /*listaClientes = new Cliente[resSoap.getPropertyCount()];

                for (int i = 0; i < listaClientes.length; i++)
                {
                    SoapObject ic = (SoapObject)resSoap.getProperty(i);

                    Cliente cli = new Cliente();
                    cli.id = Integer.parseInt(ic.getProperty(0).toString());
                    cli.nombre = ic.getProperty(1).toString();
                    cli.telefono = Integer.parseInt(ic.getProperty(2).toString());

                    listaClientes[i] = cli;
                }*/
            } catch (Exception e) {
                e.printStackTrace();
                resul = false;
            }

            return resul;
        }
    }//fin sub clase

    //Tarea Asíncrona para llamar al WS de consulta en segundo plano
    private class TareaListaBeneficiario extends AsyncTask<String, Integer, Boolean> {
        String a,b,c,d,e;
        protected Boolean doInBackground(String... params) {
            boolean resul = true;

            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://172.16.24.19:8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "listBeneficiarios";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(NAMESPACE + "/" + METHOD_NAME, envelope);
                SoapObject resSoap = (SoapObject) envelope.bodyIn;
                int x = resSoap.getPropertyCount();

                for (int i = 0; i < x; i++) {
                    SoapObject objeto = (SoapObject) resSoap.getProperty(i);
                    a = objeto.getProperty(0).toString();
                    b = objeto.getProperty(1).toString();
                    c = objeto.getProperty(2).toString();
                    d = objeto.getProperty(3).toString();
                    e = objeto.getProperty(4).toString();
                    strAum = strAum + a + "  " + b + "  " +c+ "  "+ d + "\n\n";
                    System.out.println(strAum);
                }
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent = new Intent(ListActivity.this, Modulo1.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("PASO_NOMBRE", strAum);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                resul = false;
            }
            return resul;
        }
    }//fin sub clase
    private class TareaListaCasaSalesiana extends AsyncTask<String, Integer, Boolean> {
        String a,b,c,d,e;
        protected Boolean doInBackground(String... params) {
            boolean resul = true;

            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://172.16.24.19:8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "listCasaSalesiana";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(NAMESPACE + "/" + METHOD_NAME, envelope);
                SoapObject resSoap = (SoapObject) envelope.bodyIn;
                int x = resSoap.getPropertyCount();

                for (int i = 0; i < x; i++) {
                    SoapObject objeto = (SoapObject) resSoap.getProperty(i);
                    a = objeto.getProperty(0).toString();
                    b = objeto.getProperty(1).toString();
                    c = objeto.getProperty(2).toString();
                    d = objeto.getProperty(3).toString();
                    e = objeto.getProperty(4).toString();
                    strAum = strAum + a + "  " + b + "  " +c+ "  "+ d + " "+e+"\n\n";
                    System.out.println(strAum);
                }
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent = new Intent(ListActivity.this, Modulo1.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("PASO_NOMBRE", strAum);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                resul = false;
            }
            return resul;
        }
    }//fin sub clase

    private class TareaListaColaboradores extends AsyncTask<String, Integer, Boolean> {
        String a,b,c,d;
        protected Boolean doInBackground(String... params) {
            boolean resul = true;

            final String NAMESPACE = "http://xmlns.jj.com/services/v1/ups";
            final String URL = "http://172.16.24.19:8080/WSDLandroid/proceso_wc";
            final String METHOD_NAME = "listColaboradores";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(NAMESPACE + "/" + METHOD_NAME, envelope);
                SoapObject resSoap = (SoapObject) envelope.bodyIn;
                int x = resSoap.getPropertyCount();

                for (int i = 0; i < x; i++) {
                    SoapObject objeto = (SoapObject) resSoap.getProperty(i);
                    a = objeto.getProperty(0).toString();
                    b = objeto.getProperty(1).toString();
                    c = objeto.getProperty(2).toString();
                    d = objeto.getProperty(3).toString();
                    strAum = strAum + a + "  " + b + "  " +c+ "  "+ d + "\n\n";
                    System.out.println(strAum);
                }
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent = new Intent(ListActivity.this, Modulo1.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("PASO_NOMBRE", strAum);
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                resul = false;
            }
            return resul;
        }
    }//fin sub clase
}