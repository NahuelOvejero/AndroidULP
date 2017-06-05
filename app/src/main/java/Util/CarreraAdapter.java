package Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.provider.SyncStateContract;

/**
 * Created by Usuario on 18/05/2017.
 */

public class CarreraAdapter {
    private static final String NAME="Carrera";
    private SQLiteDatabase sqlDB;
    public CarreraAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    private class Columns implements BaseColumns{
        public final static String _ID="Id_carrera";
        public final static String IDLUGAR="Id_lugar_cursado";
        public final static String TITULO="Titulo";
        public final static String DESCRIPCION="Descripcion";
        public final static String DURACION="Duracion";
    }
    private static String[] COLUMNS={Columns._ID,Columns.DURACION,Columns.TITULO,Columns.DESCRIPCION,Columns.IDLUGAR};
    public final static String CR_TABLE="create table if not exists "+ NAME+" ("
            +Columns._ID+" integer primary key autoincrement, "+Columns.TITULO+" text, "
            +Columns.DURACION +" float,"+ Columns.IDLUGAR+" integer not null ,"+Columns.DESCRIPCION +" text)";
    public boolean insert (int IdCarrera,String Titulo,float Duracion,int IdLugar,String descr){
        ContentValues valores=new ContentValues();
        valores.put(Columns._ID,IdCarrera);
        valores.put(Columns.DURACION,Duracion);
        valores.put(Columns.TITULO,Titulo);
        valores.put(Columns.IDLUGAR,IdLugar);
        valores.put(Columns.DESCRIPCION,descr);
        return sqlDB.insert(NAME,null,valores)>0;
    }
    public boolean delete(int Id){
        String whereClause=Columns._ID+"=?";
        String[] whereArgs={String.valueOf(Id)};
       return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }
    public Cursor getCarreras(){
        String [] col={Columns.TITULO,Columns.DURACION};
        return  sqlDB.query(NAME,col,null,null,null,null,null);
    }
    public static String getColumnId(){
        return Columns._ID;
    }
    public static String getName(){
        return NAME;
    }
    public String[] getCOLUMNS(){
    return COLUMNS;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
}
