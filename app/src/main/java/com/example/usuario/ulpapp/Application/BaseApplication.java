package com.example.usuario.ulpapp.Application;
import android.app.Application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import android.database.Cursor;
import android.util.Log;

import com.example.usuario.ulpapp.Database.model.Autoridades;
import com.example.usuario.ulpapp.parser.Noticia;

import com.example.usuario.ulpapp.Util.DBAdapter;

/**
 *
 * @author Usuario
 */
public class BaseApplication extends Application {

    DBAdapter dbAdapter;

    public void onCreate(){

        dbAdapter = new DBAdapter(getApplicationContext());
        dbAdapter.open();
        super.onCreate();
    }

    public void onTerminate(){
        dbAdapter.close();
        super.onTerminate();
    }

    //duracion se basa en años, 3 representaria 3 años, y 1,5 un año y medio.

    /*public boolean insertarCarrera(int Id, String titulo,float Duracion){
        return dbAdapter.insertCarrear(Id,titulo,Duracion);
    }*/



    public ArrayList<String> nombresCarreras(){
        ArrayList<String> lista = new ArrayList<String>();

        Cursor c = dbAdapter.getDatosCarrera();

        if(c.moveToFirst()){

            do{
                //VERIFICAR INDICE DEL NOMBRE DE LA CARRERA EN LA TABLA
                lista.add(c.getString(1));
            }while(c.moveToNext());

        }
        return lista;

    }

    public clsCarrera infoCarrera(String nombre){
        Cursor c = dbAdapter.getDatosCarrera();

        clsCarrera resultado = new clsCarrera();



        return resultado;
    }
    public void insertarNoticias(List<Noticia> lista){
        if(dbAdapter.insertarNoticias(lista)){
            Log.d("Resultado","Okkkk");}


    }
    public void vaciarTabla(){
        dbAdapter.vaciarTablaNoticia();
    }

    public int ultimaActualizacionNoticia(){
        return dbAdapter.ultimaActualizacionNoticias();
    }
    public ArrayList<String> getAcercaULP(){
        return dbAdapter.getAcercaULP();
    }
    public  ArrayList<Autoridades> getAutoridadesULP(){
        return dbAdapter.getAutoridades();
    }
    public String getMisionULP(){
        return dbAdapter.getMisionUlp();
    }
    public ArrayList<String> getValoresULP(){
        return dbAdapter.getValores();
    }
    public String getVisionULP(){
        return dbAdapter.getVision();
    }
}

    public List<Noticia> listaNoticias(){
        return dbAdapter.listaDeNoticias();
    }
}