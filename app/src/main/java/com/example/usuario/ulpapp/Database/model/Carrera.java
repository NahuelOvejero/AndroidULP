package com.example.usuario.ulpapp.Database.model;

/**
 * Created by Usuario on 18/05/2017.
 */


public class Carrera {
    private String titulo,descripcion;
    private float duracion;
    public Carrera(String titulo,String descripcion,float duracion){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.duracion=duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getDuracion() {
        return duracion;
    }
}
