package Util;

/**
 * Created by Usuario on 18/05/2017.
 */


import android.database.Cursor;

import  android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {

    private DBHelper dbHelper;
   private SQLiteDatabase sqlDB;
    private CarreraAdapter carrera;
    private LugarAdapter lugar;
    private final static int DB_VERSION = 1;

    private final static String DB_NAME = "ULP";

    // DEFINIR LOS ADAPTERS DE CADA TABLA


    public DBAdapter(Context con) {
        dbHelper = new DBHelper(con);

    }
    //Funciona el join
    public Cursor joinCarreraLugar(int IdCarrera){
        String TC=CarreraAdapter.getName();
        String TL=LugarAdapter.getName();
       String query= "Select Telefono,Latitud,Longitud,Direccion,Titulo,Duracion from "+TC+" inner join "+ TL+" on "+TL+"."+ LugarAdapter.getIdColumn()+"="+TC+".Id_lugar_cursado where "+CarreraAdapter.getIdColumn()+"=?";
       return sqlDB.rawQuery(query,new String[]{String.valueOf(IdCarrera)});
    }
    public boolean insertCarrear(int id,String nombre,double año,int lugar){
        //hacer insercion
       return carrera.insert(id,nombre,año,lugar);
    }
    public boolean insertLugar(String dir,String tel,int lat,int longitud,int idLugar){
        return lugar.insert(dir,tel,lat,longitud,idLugar);
    }
    public void open() {

        //sqlDB = dbHelper.getWriteableDatabase();

        //instancias de cada tabla-adapter
        sqlDB=dbHelper.getWritableDatabase();
        carrera = new CarreraAdapter(sqlDB);
        lugar= new LugarAdapter(sqlDB);

    }

    public void close() {
        //    sql.close();
        sqlDB.close();
    }

    public Cursor getDatosCarrera() {
        Cursor r = null ;
//JOIN
        return r;
    }
    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){
            super(context,DB_NAME,null,DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(CarreraAdapter.CR_TABLE);
            db.execSQL(LugarAdapter.CR_TABLE);
        }

        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            db.execSQL("drop table if exists "+ CarreraAdapter.CR_TABLE);
            db.execSQL("drop table if exists "+ LugarAdapter.CR_TABLE);
            onCreate(db);
        }
    }

}
