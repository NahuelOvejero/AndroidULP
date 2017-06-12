package com.example.usuario.ulpapp.Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 12/06/2017.
 */

public class AutoridadesULPAdapter {
    private static final String NAME="AutoridadesULP";
    private SQLiteDatabase sqlDB;
    public AutoridadesULPAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    private class Columns implements BaseColumns {
        public final static String _ID="Id_Autoridad";
        public final static String NOMBRE="Nombre";
        public final static String CARGO="Cargo";

    }
    private static String[] COLUMNS={Columns._ID,Columns.NOMBRE,Columns.CARGO};
    public final static String CR_TABLE="create table if not exists "+ NAME+" ("
            +Columns._ID+" integer primary key autoincrement, "+Columns.NOMBRE +" text, "+Columns.CARGO +" text)";
    public boolean insert (int IdAutoridad,String Nombre,String Cargo){
        ContentValues valores=new ContentValues();
        valores.put(Columns._ID,IdAutoridad);
        valores.put(Columns.NOMBRE,Nombre);
        valores.put(Columns.CARGO,Cargo);
        return sqlDB.insert(NAME,null,valores)>0;
    }
    public boolean delete(int Id){
        String whereClause=Columns._ID+"=?";
        String[] whereArgs={String.valueOf(Id)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }

    public static String getColumnId(){
        return Columns._ID;
    }
    public static String getName(){
        return NAME;
    }
    public String[] getCOLUMNS(){
        return COLUMNS;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
    public Cursor getAutoridades(){
        String[] col={Columns.NOMBRE,Columns.CARGO};
        return sqlDB.query(NAME,col,null,null,null,null,null);
    }
}
