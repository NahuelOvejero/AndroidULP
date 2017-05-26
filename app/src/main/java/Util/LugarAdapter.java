package Util;

import android.content.ContentValues;
import android.database.Cursor;
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
    private final static String[] COLUMNS={
            Columns._ID,Columns.LONGITUD,Columns.LATITUD,Columns.TELEFONO,Columns.DIRECCION
    };
    public final static String CR_TABLE="create table if not exists "+NAME+" ("+Columns._ID
            +" integer primary key autoincrement, "+Columns.DIRECCION+" text ,"+Columns.TELEFONO+" text,"
            + Columns.LATITUD+" double,"+ Columns.LONGITUD+ " double)";
    public boolean insert(int Id,String direccion,String telefono,double latitud,double longitud){
        ContentValues valores=new ContentValues();
        valores.put(Columns._ID,Id);
        valores.put(Columns.DIRECCION,direccion);
        valores.put(Columns.LATITUD,latitud);
        valores.put(Columns.LONGITUD,longitud);
        valores.put(Columns.TELEFONO,telefono);
        return sqlDB.insert(NAME,null,valores)>0;
    }
    public boolean delete(int Id){
        String whereClause=Columns._ID+"=?";
        String [] whereArgs={String.valueOf(Id)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }
    public static String getName(){

        return NAME;
    }
    public static String getColumnId(){
        return Columns._ID;
    }
    public String[] getColumns(){
        return COLUMNS;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
    public Cursor getLugares(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null,null);
    }

}
