package com.example.usuario.ulpapp.Application;

/**
 * Created by Usuario on 18/05/2017.
 */


public class clsCarrera {

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the imagenesURL
     */
    public String[] getImagenesURL() {
        return imagenesURL;
    }

    /**
     * @param imagenesURL the imagenesURL to set
     */
    public void setImagenesURL(String[] imagenesURL) {
        this.imagenesURL = imagenesURL;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the requisitos
     */
    public String getRequisitos() {
        return requisitos;
    }

    /**
     * @param requisitos the requisitos to set
     */
    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    /**
     * @return the plan
     */
    public String getPlan() {
        return plan;
    }

    /**
     * @param plan the plan to set
     */
    public void setPlan(String plan) {
        this.plan = plan;
    }

    private String nombre;
    private String[] imagenesURL;
    private String perfil;
    private String requisitos;
    private String plan;


    public clsCarrera(){}

    public clsCarrera(String nombre , String[] url , String perfil, String requisitos,String plan){
        this.nombre = nombre;
        imagenesURL = url;
        this.perfil = perfil;
        this.requisitos = requisitos;
        this.plan = plan;
    }

    public String getNombre(){
        return nombre;
    }

    public String[] getImagenes(){
        return getImagenesURL();
    }

    public String getPerfil(){
        return perfil;
    }



}
