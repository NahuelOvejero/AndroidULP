package Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 20/05/2017.
 */

public class DocumentacionAdapter {

    private static final String NAME = "Documentacion";
    private SQLiteDatabase sqlDB;

    public DocumentacionAdapter(SQLiteDatabase sqlDB) {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String _ID = "Id_Documentacion";
        public final static String DESCRIPCION = "Descripcion";
        public final static String _IDRESIDENCIA = "Id_residencia";
    }


    //


    private static String[] COLUMNS = {
            Columns._ID,
            Columns.DESCRIPCION,
            Columns._IDRESIDENCIA
    };


    public final static String CR_TABLE = "create table if not exists " + NAME + " ("
            + Columns._ID + " integer primary key autoincrement, " +
            Columns._IDRESIDENCIA + " integer ," +
            Columns.DESCRIPCION + " text)";

    public boolean insert(int id, String descripcion,int idResidencia) {
        ContentValues valores = new ContentValues();
        valores.put(Columns._ID, id);
        valores.put(Columns.DESCRIPCION, descripcion);
        return sqlDB.insert(NAME, null, valores) > 0;
    }

    public boolean delete(int Id) {
        String whereClause = Columns._ID + "=?";
        String[] whereArgs = {String.valueOf(Id)};
        return sqlDB.delete(NAME, whereClause, whereArgs) > 0;
    }

    public String getName() {
        return NAME;
    }

    public String[] getCOLUMNS() {
        return COLUMNS;
    }

    public Cursor getDocumentacion(){
        String[] col={Columns.DESCRIPCION};
        return sqlDB.query(NAME,col,null,null,null,null,null);
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
}
