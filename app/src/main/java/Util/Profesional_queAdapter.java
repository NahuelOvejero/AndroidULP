package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 25/05/2017.
 */

public class Profesional_queAdapter {
    private static final String NAME="Profesional_que";
    private SQLiteDatabase sqlDB;
    private class Columns implements BaseColumns{
        public static final String _ID ="Id_profesional_que";
        public static final String DESCRIPCION="Descripcion";
        public static final String IDCARRERA="Id_carrera";
    }
    public Profesional_queAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    public static String getName(){
        return NAME;
    }
    public static String getColumnId(){
        return Columns._ID;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
    private String[] COLUMNS={Columns._ID,Columns.DESCRIPCION,Columns.IDCARRERA};
    public String[] getColumns(){
        return COLUMNS;
    }
    public static String CR_TABLE="create table if not exists "+NAME+" ("+Columns._ID +" integer primary key autoincrement," +
            Columns.DESCRIPCION+" text,"+ Columns.IDCARRERA+" integer)";
    public boolean insert(int idProf,String descr,int IdCarrera){
        ContentValues values=new ContentValues();
        values.put(Columns._ID,idProf);
        values.put(Columns.DESCRIPCION,descr);
        values.put(Columns.IDCARRERA,IdCarrera);
        return sqlDB.insert(NAME,null,values)>0;
    }
}
