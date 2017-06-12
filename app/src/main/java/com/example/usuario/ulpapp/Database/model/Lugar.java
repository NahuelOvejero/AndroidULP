package com.example.usuario.ulpapp.Database.model;

import android.graphics.Point;
import android.location.Location;

/**
 * Created by Usuario on 12/06/2017.
 */

public class Lugar {

    String direccion,telefono;
    double lat,lng;
    public Lugar(String direccion,String telefono,double lat,double lng){
        this.direccion=direccion;
        this.telefono=telefono;
        this.lat=lat;
        this.lng=lng;
    }
    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

}
