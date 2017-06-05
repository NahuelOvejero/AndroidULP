package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ItemAdapter{
    private static final String NAME="Item";
    private SQLiteDatabase sqlDB;

    public ItemAdapter(SQLiteDatabase sqlDB)
    {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String _ID = "Id_item";
        public final static String  DESCRIPCION= "Descripcion";
    }

    private final static String[] COLUMNS = { Columns._ID, Columns.DESCRIPCION};

    public final static String CR_TABLE = "create table if not exists "+ NAME + "( "+
            Columns._ID + " integer primary key autoincrement, " +Columns.DESCRIPCION+" text";

    public static String getName(){
        return NAME;
    }

    public String[] getColumns(){
        return COLUMNS;
    }

    public static String getColumnId()
    {
        return Columns._ID;
    }

    public boolean insert(int Id_item,String descripcion)
    {
        ContentValues values = new ContentValues();
        values.put(Columns._ID,Id_item);
        values.put(Columns.DESCRIPCION, descripcion);
        return sqlDB.insert(NAME, null, values ) >0;
    }

    public boolean delete(int id)
    {
        String whereClause= Columns._ID +"= ?";
        String[] whereArgs={ String.valueOf(id)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }

}