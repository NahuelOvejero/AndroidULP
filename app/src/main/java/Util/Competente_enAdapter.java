package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 25/05/2017.
 */

public class Competente_enAdapter {
    private static final String NAME="Competente_en";
    private SQLiteDatabase sqlDB;
    public Competente_enAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    private class Columns implements BaseColumns{
        public static final String _ID="Id_competente_en";
        public static final String DESCRIPCION="Descripcion";
        public static final String IDCARRERA="Id_carrera";
    }
    public static String CR_TABLE="create table if not exists "+NAME+" ("+Columns._ID+" integer primary key autoincrement, "+Columns.DESCRIPCION+" text, "+Columns.IDCARRERA+" " +
            "integer)";
    public static String getName(){
        return NAME;
    }
    public static String getColumnId(){
        return Columns._ID;
    }
    private String[] COLUMNS={Columns._ID,Columns.DESCRIPCION};
    public String[] getCOLUMNS(){
        return COLUMNS;
    }
    public boolean insert(int IdCompe,String desc,int IdCar){
        ContentValues values=new ContentValues();
        values.put(Columns._ID,IdCompe);
        values.put(Columns.DESCRIPCION,desc);
        values.put(Columns.IDCARRERA,IdCar);
        return sqlDB.insert(NAME,null,values)>0;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }

}
