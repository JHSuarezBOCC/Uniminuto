package com.example.appuniminuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewAgentCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_agent_cita);
        Button btnRegistrarCitas = (Button) findViewById(R.id.btnAgendar);
        Button btnElimina = (Button) findViewById(R.id.btnBackRegis);
        EditText NameClient = (EditText) findViewById(R.id.txtName);
        EditText Document = (EditText) findViewById(R.id.txtDocument);
        EditText TypeCita = (EditText) findViewById(R.id.txtTypeCita);
        EditText Date = (EditText) findViewById(R.id.txtFecha);
        model obj_model = new model();

        btnElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackMenu = new Intent(ViewAgentCita.this, MainActivity.class);
                startActivity(intentBackMenu);
            }
        });
        btnRegistrarCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Establecemos los valores, con el uso del modelo (MVC).
                obj_model.setName(NameClient.getText().toString());
                obj_model.setDocument(Integer.parseInt(Document.getText().toString()));
                obj_model.setTypeCita(TypeCita.getText().toString());
                obj_model.setDate(Date.getText().toString());
                String [] data = {"\nNombre cliente: "+ obj_model.getName() + "\nTipo Cita:" + obj_model.getTypeCita()};
                obj_model.setData(data);
                /*Contexto en que View estamos, en donde va a imprimir ese mensaje.
                Toast.makeText(ViewAgentCita.this, data,Toast.LENGTH_LONG).show();*/
            }
        });
    }

}