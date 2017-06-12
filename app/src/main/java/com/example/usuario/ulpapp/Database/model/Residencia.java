package com.example.usuario.ulpapp.Database.model;

/**
 * Created by Usuario on 12/06/2017.
 */

public class Residencia {
    String Descripcion,Cupo,Contacto,URLFichaIngreso,URLDeclaracionJurada;
    public Residencia(String Descripcion,String Cupo,String Contacto,String URLFichaIngreso,String URLDeclaracionJurada){
        this.Descripcion=Descripcion;
        this.Cupo=Cupo;
        this.Contacto=Contacto;
        this.URLFichaIngreso=URLFichaIngreso;
        this.URLDeclaracionJurada=URLDeclaracionJurada;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getCupo() {
        return Cupo;
    }

    public String getContacto() {
        return Contacto;
    }

    public String getURLFichaIngreso() {
        return URLFichaIngreso;
    }

    public String getURLDeclaracionJurada() {
        return URLDeclaracionJurada;
    }
}
