package com.example.usuario.ulpapp.Application;
import android.app.Application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import android.database.Cursor;
import android.util.Log;

import com.example.usuario.ulpapp.Database.model.Autoridades;
import com.example.usuario.ulpapp.Database.model.Carrera;
import com.example.usuario.ulpapp.Database.model.Lugar;
import com.example.usuario.ulpapp.Database.model.Residencia;
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
    public Residencia getResidencia(){
        return dbAdapter.getResidencia();
    }
    public ArrayList<String> getDocumentaciónResi(){
        return dbAdapter.getDocumentacionResi();
    }
    public ArrayList<String> getComodidadesResi(){
        return  dbAdapter.getComodidadesResi();
    }
    public ArrayList<String> getObjetivosResi(){
        return dbAdapter.getObjetivoResi();
    }
    public ArrayList<String> getFotosResi(){
        return dbAdapter.getFotosResi();
    }

    public ArrayList<String>getRequisitosInscripcion(){
        return dbAdapter.getRequisitosInscripcion();
    }
    //métodos Gestión Empresarial
    public Carrera getGestionEmp(){
        return dbAdapter.getCarrera(1);
    }
    public Lugar getLugarEmp(){
        return  dbAdapter.getLugar(1);
    }
    public ArrayList<String> getCompetenteEnEmp(){
        return dbAdapter.getCompetente(1);
    }
    public ArrayList<String> getProfesionalQueEmp(){
        return dbAdapter.getProfesionalQue(1);
    }
    public ArrayList<String> getFotoEmp(){
        return dbAdapter.getFotos(1);
    }
    //métodos Softw
    public Carrera getSoft(){
        return dbAdapter.getCarrera(2);
    }
    public Lugar getLugarSoft(){
        return  dbAdapter.getLugar(2);
    }
    public ArrayList<String> getCompetenteEnSoft(){
        return dbAdapter.getCompetente(2);
    }
    public ArrayList<String> getProfesionalQueSoft(){
        return dbAdapter.getProfesionalQue(2);
    }
    public ArrayList<String> getFotoSoft(){
        return dbAdapter.getFotos(2);
    }
    //métodos Turismo
    public Carrera getTur(){
        return dbAdapter.getCarrera(3);
    }
    public Lugar getLugarTur(){
        return  dbAdapter.getLugar(3);
    }
    public ArrayList<String> getCompetenteEnTur(){
        return dbAdapter.getCompetente(3);
    }
    public ArrayList<String> getProfesionalQueTur(){
        return dbAdapter.getProfesionalQue(3);
    }
    public ArrayList<String> getFotoTur(){
        return dbAdapter.getFotos(3);
    }
    //métodos Guía Turismo
    public Carrera getGuiaTur(){
        return dbAdapter.getCarrera(4);
    }
    public Lugar getLugarGuiaTur(){
        return  dbAdapter.getLugar(4);
    }
    public ArrayList<String> getCompetenteEnGuiaTur(){
        return dbAdapter.getCompetente(4);
    }
    public ArrayList<String> getProfesionalQueGuiaTur(){
        return dbAdapter.getProfesionalQue(4);
    }
    public ArrayList<String> getFotoGuiaTur(){
        return dbAdapter.getFotos(4);
    }
    public List<Noticia> listaNoticias(){
        return dbAdapter.listaDeNoticias();
    }
}