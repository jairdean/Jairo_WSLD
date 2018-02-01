package com.example.jairo.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Modulo1 extends AppCompatActivity {
    private TextView txtSaludo;
    private Button btnvueltaMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo1);

        //Localizar los controles
        txtSaludo = findViewById(R.id.txtSaludo);
        btnvueltaMain = findViewById(R.id.btnvueltaMain);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtSaludo.setText("LISTA\n"+ bundle.getString("PASO_NOMBRE"));


        btnvueltaMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent la comunicación entre los distintos componentes y aplicaciones en Android se realiza mediante intents
                Intent intent = new Intent(Modulo1.this, MainActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }//fin ON CREATE






}
