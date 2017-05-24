package Util;

import android.content.ContentValues;
import android.database.Cursor;
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
        public final static String ID = "Id_item";
        public final static String DESCRIPCION = "Descripcion";
    }

    private final static String[] COLUMNS = { Columns.ID, Columns.DESCRIPCION};

    public final static String CR_TABL = "create table if not exists "+ NAME + "( "+
            Columns.ID + "integer primary key autoincrement, " +Columns.DESCRIPCION+" text not null)";

    public static String getName(){
        return NAME;
    }

    public String[] getColumns(){
        return COLUMNS;
    }

    public static String getColumnId()
    {
        return Columns.ID;
    }

    public boolean insert(String descripcion)
    {
        ContentValues values = new ContentValues();
        values.put(Columns.DESCRIPCION, descripcion);
        return sqlDB.insert(NAME, null, values ) >0;
    }

    public boolean delete(int id)
    {
        String whereClause= Columns.ID +"= ?";
        String[] whereArgs={ String.valueOf(id)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }

    public Cursor getItems()
    {
        String[] col = {Columns.ID, Columns.DESCRIPCION};
        return sqlDB.query(NAME,col,null,null,null,null,null);
    }
}