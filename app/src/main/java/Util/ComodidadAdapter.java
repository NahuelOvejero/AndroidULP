package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 20/05/2017.
 */

public class ComodidadAdapter {

    private static final String NAME = "Documentacion";
    private SQLiteDatabase sqlDB;

    public ComodidadAdapter(SQLiteDatabase sqlDB) {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String _ID = "Id_residencia";
        public final static String DESCRIPCION = "Descripcion";
        public final static String _IDRESIDENCIA = "Id_residencia";
    }


    //


    private static String[] COLUMNS = {
            Columns._ID,
            Columns.DESCRIPCION,
            Columns._IDRESIDENCIA
    };


    public final static String CR_TABLE = "create talbe if not exist " + NAME + " ("
            + Columns._ID + " integer primary key autoincrement, " +
            Columns._IDRESIDENCIA + "integer ," +
            Columns.DESCRIPCION + " text)";

    public boolean insert(int id, String descripcion, int id_residencia) {
        ContentValues valores = new ContentValues();
        valores.put(Columns._ID,id);
        valores.put(Columns.DESCRIPCION,descripcion);
        valores.put(Columns._IDRESIDENCIA,id_residencia);
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
}
