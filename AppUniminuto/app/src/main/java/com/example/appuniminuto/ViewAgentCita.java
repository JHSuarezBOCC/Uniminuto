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
        Button btnBack = (Button) findViewById(R.id.btnBackRegis);
        EditText NameClient = (EditText) findViewById(R.id.txtName);
        EditText Document = (EditText) findViewById(R.id.txtDocument);
        EditText nameDoctor = (EditText) findViewById(R.id.txtNameDoctor);
        EditText Date = (EditText) findViewById(R.id.txtFecha);
        model obj_model = new model();
        ControllerBD obj_SQL = new ControllerBD();

        btnRegistrarCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Establecemos los valores, con el uso del modelo (MVC).
                obj_model.setName(NameClient.getText().toString());
                obj_model.setDocument(Integer.parseInt(Document.getText().toString()));
                obj_model.setNameDoctor(nameDoctor.getText().toString());
                obj_model.setDate(Date.getText().toString());
                obj_SQL.conectSQL();
                boolean condition = obj_SQL.insertSQL(obj_model.getDocument(), obj_model.getName(), obj_model.getNameDoc(), obj_model.getDate());
                if (condition){
                    Toast.makeText(ViewAgentCita.this, "Correct Register",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ViewAgentCita.this,"Failed Register",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackMenu = new Intent(ViewAgentCita.this, MainActivity.class);
                startActivity(intentBackMenu);
            }
        });
    }

}