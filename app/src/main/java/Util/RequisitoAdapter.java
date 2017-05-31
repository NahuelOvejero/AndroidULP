package Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class RequisitoAdapter{
    private static final String NAME="Requisito";
    private SQLiteDatabase sqlDB;

    public RequisitoAdapter(SQLiteDatabase sqlDB)
    {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String ID = "Id_requisito";
        public final static String DESCRIPCION = "Descripcion";
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
    private final static String[] COLUMNS = { Columns.ID, Columns.DESCRIPCION};

    public final static String CR_TABLE = "create table if not exists "+ NAME + "( "
            +Columns.ID + " integer primary key autoincrement, " +Columns.DESCRIPCION+" text not null)";

    public static String getName()
    {
        return NAME;

    }

    public String[] getColumns()
    {
        return COLUMNS;
    }

    public static String getColumnId(){
        return Columns.ID;
    }

    public boolean insert(int IdRequisito,String descripcion)
    {
        ContentValues values = new ContentValues();
        values.put(Columns.ID,IdRequisito);
        values.put(Columns.DESCRIPCION, descripcion);
        return sqlDB.insert(NAME, null, values ) >0;
    }

    public boolean delete(int id)
    {
        String whereClause= Columns.ID+"= ?";
        String[] whereArgs={ String.valueOf(id)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }

    public Cursor getRequisitos()
    {
        String [] col={ Columns.ID, Columns.DESCRIPCION};
        return  sqlDB.query(NAME,col,null,null,null,null,null);
    }
}