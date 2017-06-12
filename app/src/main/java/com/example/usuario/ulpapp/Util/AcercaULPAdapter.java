package com.example.usuario.ulpapp.Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 12/06/2017.
 */

public class AcercaULPAdapter {
    private static final String NAME="AcercaULP";
    private SQLiteDatabase sqlDB;
    public AcercaULPAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    private class Columns implements BaseColumns {
        public final static String _ID="Id_acerca";
        public final static String DESCRIPCION="Descripcion";

    }
    private static String[] COLUMNS={Columns._ID,Columns.DESCRIPCION};

    public final static String CR_TABLE="create table if not exists "+ NAME+" ("
            +Columns._ID+" integer primary key autoincrement, "+Columns.DESCRIPCION +" text)";
    public boolean insert (int IdAcerca,String descr){
        ContentValues valores=new ContentValues();
        valores.put(Columns._ID,IdAcerca);
        valores.put(Columns.DESCRIPCION,descr);
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
    public Cursor getAcerca(){
        String[] col={Columns.DESCRIPCION};
        return sqlDB.query(NAME,col,null,null,null,null,null);
    }
}
