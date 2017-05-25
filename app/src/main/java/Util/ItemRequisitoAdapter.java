package Util;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ItemRequisitoAdapter {
    private static final String NAME="Requisito_Item";
    private SQLiteDatabase sqlDB;

    public ItemRequisitoAdapter(SQLiteDatabase sqlDB)
    {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String REQ_ID = "Id_requisito";
        public final static String ITM_ID = "Id_item";
    }

    private final static String[] COLUMNS = { Columns.REQ_ID,Columns.ITM_ID};

    public final static String CR_TABLE = "create table if not exists "+ NAME + "( "
            +Columns.REQ_ID + "integer, " +Columns.ITM_ID+" integer, "
            +" foreing key ("+Columns.REQ_ID+") references "+RequisitoAdapter.getName()+ "("+ RequisitoAdapter.getColumnId()+")"
            +" foreing key ("+Columns.ITM_ID+") references "+ItemAdapter.getName()+ "("+ ItemAdapter.getColumnId()+")"
            +" primary key ("+Columns.REQ_ID+","+Columns.ITM_ID+"))";

    public String getName(){
        return NAME;
    }

    public String[] getColumns(){
        return COLUMNS;
    }

    public boolean insert(int IdReq, int IdItem)
    {
        ContentValues values = new ContentValues();
        values.put(Columns.REQ_ID, IdReq);
        values.put(Columns.ITM_ID, IdItem);
        return sqlDB.insert(NAME, null, values )>0;
    }

    public boolean delete(int IdReq, int IdItem)
    {
        String whereClause= Columns.REQ_ID+"= ? and "+Columns.ITM_ID +"= ?";
        String[] whereArgs={ String.valueOf(IdReq), String.valueOf(IdItem)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }

    public Cursor getRelRequisitoItem()
    {
        String [] col={Columns.REQ_ID,Columns.ITM_ID};
        return  sqlDB.query(NAME,col,null,null,null,null,null);
    }


}