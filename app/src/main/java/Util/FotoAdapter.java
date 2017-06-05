package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 20/05/2017.
 */

public class FotoAdapter {


    //RECORDATORIO : SI EL ID_CARRERA ES NULO, SUCEDERA QUE LA FOTO PERTENECE A LA RESIDENCIA.

    private static final String NAME = "Foto";
    private SQLiteDatabase sqlDB;

    public FotoAdapter(SQLiteDatabase sqlDB) {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String _ID="Id_foto";
        public final static String URL_FOTO = "URL_foto";
        public final static String ID_CARRERA = "Descripcion";
    }

    //


    private static String[] COLUMNS = {
            Columns.URL_FOTO,
            Columns.ID_CARRERA
    };


    public final static String CR_TABLE = "create table if not exists " + NAME + " ("
            +Columns._ID+" integer primary key autoincrement , "+ Columns.URL_FOTO + " text , " +
            Columns.ID_CARRERA + " integer)";

    public boolean insert(String urlfoto, int id_carrera) {
        ContentValues valores = new ContentValues();
        valores.put(Columns.URL_FOTO,urlfoto);
        valores.put(Columns.ID_CARRERA,id_carrera);
        return sqlDB.insert(NAME, null, valores) > 0;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }

    public boolean delete(String urlfoto) {
        String whereClause = Columns.URL_FOTO + "=?";
        String[] whereArgs = {String.valueOf(urlfoto)};
        return sqlDB.delete(NAME, whereClause, whereArgs) > 0;
    }

    public String getName() {
        return NAME;
    }

    public String[] getCOLUMNS() {
        return COLUMNS;
    }

}
