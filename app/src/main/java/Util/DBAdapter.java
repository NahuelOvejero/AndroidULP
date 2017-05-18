package Util;

/**
 * Created by Usuario on 18/05/2017.
 */


import android.database.Cursor;

import  android.content.Context;

public class DBAdapter {

   // private DBHelper dbHelper;
   // private SQLITEDatabase sqlDB;

    private final static int DB_VERSION = 1;

    private final static String DB_NAME = "ULP";

    // DEFINIR LOS ADAPTERS DE CADA TABLA


    public DBAdapter(Context con) {
        //dbHelper = new DBHelper(con);
    }



    public boolean insertCarrear(int id,String nombre,float año){
        //hacer insercion
        return true;

    }

    public void open() {

        //sqlDB = dbHelper.getWriteableDatabase();

        //instancias de cada tabla-adapter
        //carrera = new CarreraAdapter(sqlDB)
    }

    public void close() {
        //    sql.close();
    }

    public Cursor getDatosCarrera() {
        Cursor r = null ;
//JOIN
        return r;
    }

}
