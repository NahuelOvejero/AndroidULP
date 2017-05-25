package Application;

import android.app.Application;

import java.util.ArrayList;


import android.database.Cursor;

import Util.DBAdapter;

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

    public boolean insertarCarrera(int Id, String titulo,float Duracion){
        return dbAdapter.insertCarrear(Id,titulo,Duracion);
    }

    public boolean insertarComodidad(){
        return false;
    }

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
}
