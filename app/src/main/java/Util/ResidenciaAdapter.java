package Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 20/05/2017.
 */

public class ResidenciaAdapter {

    private static final String NAME = "Residencia";
    private SQLiteDatabase sqlDB;

    public ResidenciaAdapter(SQLiteDatabase sqlDB) {
        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {
        public final static String _ID = "Id_residencia";
        public final static String DESCRIPCION = "Descripcion";
        public final static String CUPO = "Cupo";
        public final static String CONTACTO = "Contacto";
        public final static String TITULO = "URL_reglamento";
        public final static String URL_FICHA_INGRESO = "URL_ficha_ingreso";
        public final static String URL_DECLARACION_JURADA = "URL_declaracion_jurada";


    }

    //


    private static String[] COLUMNS = {
            Columns._ID,
            Columns.DESCRIPCION,
            Columns.CUPO,
            Columns.CONTACTO,
            Columns.TITULO,
            Columns.URL_FICHA_INGRESO,
            Columns.URL_DECLARACION_JURADA
    };
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }

    public final static String CR_TABLE = "create table if not exists " + NAME + " ("
            + Columns._ID + " integer primary key autoincrement, " + Columns.DESCRIPCION + " text, "
            + Columns.CUPO + " text, " + Columns.CONTACTO  + " text ," +
            Columns.TITULO + " text, " + Columns.URL_FICHA_INGRESO + " text, " +
            Columns.URL_DECLARACION_JURADA + " text)";

    public boolean insert(int id, String descripcion, String cupo, String contacto,String titulo,String urlficha, String urldeclaracion) {
        ContentValues valores = new ContentValues();
        valores.put(Columns._ID,id);
        valores.put(Columns.DESCRIPCION,descripcion);
        valores.put(Columns.CUPO,cupo);
        valores.put(Columns.CONTACTO,contacto);
        valores.put(Columns.TITULO,titulo);
        valores.put(Columns.URL_FICHA_INGRESO,urlficha);
        valores.put(Columns.URL_DECLARACION_JURADA,urldeclaracion);

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
