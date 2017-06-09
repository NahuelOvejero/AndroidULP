package com.example.usuario.ulpapp.Util;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class RequisitoxCarreraAdapter {
    private static final String NAME="ItemxCarrera";
    private SQLiteDatabase sqlDB;

    public RequisitoxCarreraAdapter(SQLiteDatabase sqlDB)
    {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String _ID = "Id_carrera";
        public final static String IDITEM = "Id_Requisito";
    }

    private final static String[] COLUMNS = { Columns._ID,Columns.IDITEM};

    public final static String CR_TABLE = "create table if not exists "+ NAME + "( "
            +Columns._ID + " integer, " +Columns.IDITEM+" integer)";

    public String getName(){
        return NAME;
    }

    public String[] getColumns(){
        return COLUMNS;
    }

    public boolean insert(int IdRequisito, int IdCarr)
    {
        ContentValues values = new ContentValues();
        values.put(Columns._ID, IdCarr);
        values.put(Columns.IDITEM, IdRequisito);
        return sqlDB.insert(NAME, null, values )>0;
    }

    public boolean delete(int IdRequisito,int IdCarrera)
    {
        String whereClause= Columns._ID +"= ? and "+Columns.IDITEM +"= ?";
        String[] whereArgs={ String.valueOf(IdRequisito),String.valueOf(IdCarrera)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
}