package com.example.appuniminuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.ListResourceBundle;

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
        ControllerBD obj_SQL = new ControllerBD();

        btnConsultData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj_SQL.conectSQL();
                ArrayList<String> data = obj_SQL.consultTable();
                //String [] data = {"\nNombre: Javier Hernando Suarez - \nDocumento: 1022427506 \nTipo Cita: Medicina General - \nFecha cita: 2023/04/25"};
                ArrayAdapter adapter = new ArrayAdapter(ViewConsultarData.this,
                        com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                        data);
                listRecords.setAdapter(adapter);
            }
        });
        btnbackmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBackMenu = new Intent(ViewConsultarData.this, MainActivity.class);
                startActivity(intentBackMenu);
            }
        });
    }
}