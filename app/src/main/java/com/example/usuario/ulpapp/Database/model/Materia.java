package com.example.usuario.ulpapp.Database.model;

/**
 * Created by Usuario on 12/06/2017.
 */

public class Materia {
    private String nombre;
    private int año;
    public Materia(String nombre,int año){
        this.nombre=nombre;
        this.año=año;
    }
    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return año;
    }
}
