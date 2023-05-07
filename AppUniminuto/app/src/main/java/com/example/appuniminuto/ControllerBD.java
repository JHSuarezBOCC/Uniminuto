package com.example.appuniminuto;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ControllerBD {
    private String ipServer = "35.226.50.138";
    private String nameDB = "BD_CLINICA_ANDROID";
    private String port = "3306";
    private String url2 = "jdbc:mysql://:35.226.50.138:3306/BD_CLINICA_ANDROID";
    private String url = "jdbc:mysql://"+ipServer+":"+port+"/"+nameDB;
    private String user = "daetobo";
    private String password = "12345";
    private String QuerySQL;
    Connection conect;
    public boolean conectSQL (){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection(url, user, password);
            Log.d("myTag", "Succesfull connection");
            return true;
        }
        catch (Exception err){
            Log.d("Mytag",err.toString());
            return false;
        }
    }
    public boolean insertSQL (int id, String name, String nameDoc, String date){
        QuerySQL = "INSERT INTO MEDICAL_CLIENTS VALUES (" + id + ", '" + name + "', '" + nameDoc + "', '" +  date +  "')";
        try {
            conect.prepareStatement(QuerySQL).execute();
            return true;
        }
        catch (Exception err){
            Log.d("Mytag",err.toString());
            return false;
        }
    }
    public ArrayList<String> consultTable () {
        QuerySQL = "SELECT * FROM MEDICAL_CLIENTS";
        ArrayList <String> datos = new ArrayList <String>();
        try {
            ResultSet results = conect.prepareStatement(QuerySQL).executeQuery();
            while (results.next()) {
                datos.add(results.getString("Documento:") + " " + results.getString("Nombre Cliente:") + " "
                        + results.getString("Nombre Doctor") + " " + results.getString("Fecha Cita:"));
            }
        } catch (Exception err) {
            Log.d("myTag", err.toString());
        }
        return datos;
    }
}
