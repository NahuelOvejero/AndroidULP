package Util;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ItemxCarreraAdapter {
    private static final String NAME="ItemxCarrera";
    private SQLiteDatabase sqlDB;

    public ItemxCarreraAdapter(SQLiteDatabase sqlDB)
    {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String IDCARRERA = "Id_carrera";
        public final static String IDITEM = "Id_item";
    }

    private final static String[] COLUMNS = { Columns.IDCARRERA,Columns.IDITEM};

    public final static String CR_TABLE = "create table if not exists "+ NAME + "( "
            +Columns.IDCARRERA + " integer, " +Columns.IDITEM+" integer, "
            +" foreing key ("+Columns.IDITEM+") references "+ItemAdapter.getName()+ "("+ ItemAdapter.getColumnId()+")"
            +" foreing key ("+Columns.IDCARRERA+") references "+CarreraAdapter.getName()+ "("+ CarreraAdapter.getColumnId()+")"
            +" primary key ("+Columns.IDITEM+","+Columns.IDCARRERA+"))";

    public String getName(){
        return NAME;
    }

    public String[] getColumns(){
        return COLUMNS;
    }

    public boolean insert(int IdItem, int IdCarr)
    {
        ContentValues values = new ContentValues();
        values.put(Columns.IDCARRERA, IdCarr);
        values.put(Columns.IDITEM, IdItem);
        return sqlDB.insert(NAME, null, values )>0;
    }

    public boolean delete(int IdItem,int IdCarrera)
    {
        String whereClause= Columns.IDCARRERA+"= ? and "+Columns.IDITEM +"= ?";
        String[] whereArgs={ String.valueOf(IdItem),String.valueOf(IdCarrera)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
}