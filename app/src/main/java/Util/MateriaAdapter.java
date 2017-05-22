package Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.StringBuilderPrinter;

/**
 * Created by Usuario on 19/05/2017.
 */

public class MateriaAdapter {
    private static final String NAME="Materia";
    private SQLiteDatabase sqlDB;
    private class Columns implements BaseColumns{
        public static final String _ID="Id_materia";
        public static final String NOMBRE="Nombre";
        public static final String AÑO="Año";
    }
    private final static String[] COLUMNS={Columns._ID,Columns.AÑO,Columns.NOMBRE};
    public final static String CR_TABLE="create table if not exists "+NAME+" ("
            +Columns._ID+" integer primary key autoincrement, "+Columns.NOMBRE+" text, "+ Columns.AÑO+" integer)";
    public boolean insert(int Id,String nombre,int año){
        ContentValues valores= new ContentValues();
        valores.put(Columns._ID,Id);
        valores.put(Columns.NOMBRE,nombre);
        valores.put(Columns.AÑO,año);
        return sqlDB.insert(NAME,null,valores)>0;
    }
    public boolean delete(int idMateria){
        String[] whereArgs={String.valueOf(idMateria)};
        return sqlDB.delete(NAME,"Id_matera=?",whereArgs)>0;
    }
    public String getName(){
        return NAME;
    }
    public String[] getColumns(){
        return COLUMNS;
    }
    public Cursor getMaterias(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null);
    }
}