package com.example.usuario.ulpapp.Database.model;

/**
 * Created by Usuario on 12/06/2017.
 */

public class Autoridades {
    String Nombre,Cargo;
    public Autoridades(String Nombre,String Cargo){
        this.Nombre=Nombre;
        this.Cargo=Cargo;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getCargo(){
        return Cargo;
    }
}
