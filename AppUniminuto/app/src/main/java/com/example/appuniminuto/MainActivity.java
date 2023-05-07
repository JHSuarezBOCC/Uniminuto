package com.example.appuniminuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.Control;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Conectamos elementos (botones de nuestra interfaz grafica), con objetos de nuestro codigo.
        Button btnRegCita = (Button) findViewById(R.id.btnAgendarCita);
        Button btnConsultCita = (Button) findViewById(R.id.btnConsultaCita);
        Button btnEliminaCita = (Button) findViewById(R.id.btnCancelarCita);
        Button btnModificarCita = (Button) findViewById(R.id.btnModificarCita);
        ControllerBD obj_SQL = new ControllerBD();
        model obj_model = new model();

        btnRegCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean condition = obj_SQL.conectSQL();
                if (condition){
                    Intent intentRegister = new Intent(MainActivity.this,ViewAgentCita.class);
                    startActivity(intentRegister);
                }else {
                    Toast.makeText(MainActivity.this,"Failed Insert.",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnConsultCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConsultar = new Intent(MainActivity.this, ViewConsultarData.class);
                startActivity(intentConsultar);
            }
        });
        btnEliminaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEliminar = new Intent(MainActivity.this, ViewEliminarCita.class);
                startActivity(intentEliminar);
            }
        });
        btnModificarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interModificar = new Intent(MainActivity.this, ViewModificarCita.class);
                startActivity(interModificar);
            }
        });
    }
}