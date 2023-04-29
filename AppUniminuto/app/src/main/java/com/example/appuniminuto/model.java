package com.example.appuniminuto;

public class model {
    private String name;
    private int Document;
    private String TypeCita;
    private String date;

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    private String [] data = {};
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDocument() {
        return Document;
    }

    public void setDocument(int document) {
        Document = document;
    }

    public String getTypeCita() {
        return TypeCita;
    }

    public void setTypeCita(String typeCita) {
        TypeCita = typeCita;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}
