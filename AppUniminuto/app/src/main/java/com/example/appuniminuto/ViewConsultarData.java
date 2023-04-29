package com.example.appuniminuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.time.chrono.MinguoChronology;

public class ViewConsultarData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_consultar_data);
        Button btnConsultData = (Button) findViewById(R.id.btnConsult);
        Button btnbackmain = (Button) findViewById(R.id.btnBackMain);
        ListView listRecords = (ListView) findViewById(R.id.ListRecords);
        ViewAgentCita obj_agendar = new ViewAgentCita();
        model obj_model = new model();

        btnbackmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackMenu = new Intent(ViewConsultarData.this, MainActivity.class);
                startActivity(intentBackMenu);
            }
        });
        btnConsultData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*obj_model.setName(NameClient.getText().toString());
                obj_model.setDocument(Integer.parseInt(Document.getText().toString()));
                obj_model.setTypeCita(TypeCita.getText().toString());
                obj_model.setDate(Date.getText().toString());*/
                obj_agendar.onCreate();
                String [] data = {"\nNombre cliente: \nTipo Cita:"};
                ArrayAdapter adapter = new ArrayAdapter(ViewConsultarData.this,
                        com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                        data);
                listRecords.setAdapter(adapter);
            }
        });
    }
}