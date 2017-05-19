package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 18/05/2017.
 */

public class LugarAdapter {
    private static final String NAME="Lugar";
    private SQLiteDatabase sqlDB;
    public LugarAdapter(SQLiteDatabase sqlDB){this.sqlDB=sqlDB;}
    private class Columns implements BaseColumns{
        public final static String _ID="Id_lugar_cursado";
        public final static String TELEFONO="Telefono";
        public final static String DIRECCION="Direccion";
        public final static String LATITUD="Latitud";
        public final static String LONGITUD="Longitud";
    }

    public final static String CR_TABLE="create table if not exists "+NAME+" ("+Columns._ID
            +" integer primary key autoincrement, "+Columns.DIRECCION+" text ,"+Columns.TELEFONO+" text,"
            + Columns.LATITUD+" integer,"+ Columns.LONGITUD+ "integer)";
    public boolean insert(String direccion,String telefono,int latitud,int longitud){
        ContentValues valores=new ContentValues();
        valores.put(Columns.DIRECCION,direccion);
        valores.put(Columns.LATITUD,latitud);
        valores.put(Columns.LONGITUD,longitud);
        valores.put(Columns.TELEFONO,telefono);
        return sqlDB.insert(NAME,null,valores)>0;
    }

}
