package Util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Usuario on 19/05/2017.
 */

public class CarreraxMateriaAdapter {
    private static final String NAME="CarreraxMateria";
    private SQLiteDatabase sqlDB;
    public CarreraxMateriaAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }
    private class Columns implements BaseColumns{
        private static final String IDMATERIA="Id_materia";
        private static final String IDCARRERA="Id_carrera";
    }
    private static String[] COLUMNS={
            Columns.IDMATERIA,Columns.IDCARRERA
    };
    public final static String CR_TABLE ="create table if not exists "+NAME+" ("
            +Columns.IDMATERIA+" integer primary key autoincrement, "+Columns.IDCARRERA
            +" integer not null," +
            "foreign key "+Columns.IDMATERIA+" references "+MateriaAdapter.getName()+"("+MateriaAdapter.getColumnId()+")," +
            "foreign key "+Columns.IDCARRERA+" references "+ CarreraAdapter.getName()+"("+CarreraAdapter.getColumnId()+"))";
    public boolean insert(int idMateria,int idCarrera){
        ContentValues valores=new ContentValues();
        valores.put(Columns.IDCARRERA,idCarrera);
        valores.put(Columns._ID,idMateria);
        return sqlDB.insert(NAME,null,valores)>0;
    }
    public boolean isEmpty(){
        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null).getCount()==0;
    }
}
