package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 19/05/2017.
 */

public class PlanAdapter {
    private static final String NAME="Plan_de_estudio";
    private SQLiteDatabase sqlDB;
    public PlanAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    private class Columns implements BaseColumns{
        private static final String _ID="Id_materia";
        private static final String IDCARRERA="Id_carrera";
    }
    private static String[] COLUMNS={
            Columns._ID,Columns.IDCARRERA
    };
    public final static String CR_TABLE ="create table if not exists "+NAME+" ("
            +Columns._ID+" integer primary key autoincrement, "+Columns.IDCARRERA
            +" integet not null)";
    public boolean insert(int idPlan,int idCarrera){
        ContentValues valores=new ContentValues();
        valores.put(Columns.IDCARRERA,idCarrera);
        valores.put(Columns._ID,idPlan);
        return sqlDB.insert(NAME,null,valores)>0;
    }
}
