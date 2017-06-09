package com.example.usuario.ulpapp.Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 31/05/2017.
 */

public class PorQueEstudiarAdapter {
    private final static String NAME="Por_que_estudiar";
    private SQLiteDatabase sqlDB;
    public PorQueEstudiarAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    public String getName(){
        return NAME;
    }
    private class Columns implements BaseColumns{
        public final static String _ID = "Id_por_que";
        public final static String DESCRIPCION = "Descripcion";
    }
    private String[] COLUMNS={Columns._ID,Columns.DESCRIPCION};
    public boolean insert(int IdPorQue,String descripcion)
    {
        ContentValues values = new ContentValues();
        values.put(Columns._ID,IdPorQue);
        values.put(Columns.DESCRIPCION, descripcion);
        return sqlDB.insert(NAME, null, values ) >0;
    }
    public Cursor getPorque(){
        String [] col={ Columns._ID, Columns.DESCRIPCION};
        return  sqlDB.query(NAME,col,null,null,null,null,null);
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
    public static final String CR_TABLE="create table if not exists "+NAME+"( "
            +Columns._ID + " integer primary key autoincrement, " +Columns.DESCRIPCION+" text not null)";
}
