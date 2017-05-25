package Util;

/**
 * Created by Usuario on 18/05/2017.
 */


import android.content.ClipData;
import android.database.Cursor;

import  android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {

    private DBHelper dbHelper;
    private SQLiteDatabase sqlDB;

    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "ULP";

    private CarreraAdapter carreraAdapter;
    private ComodidadAdapter comodidadAdapter;
    private DocumentacionAdapter documentacionAdapter;
    private FotoAdapter fotoAdapter;
    private ItemAdapter itemAdapter;
    private ItemRequisitoAdapter itemRequisitoAdapter;
    private LugarAdapter lugarAdapter;
    private MateriaAdapter materiaAdapter;
    private ObjetivoAdapter objetivoAdapter;
    private  PerfilAdapter perfilAdapter;
    private PlanAdapter planAdapter;
    private RequisitoAdapter requisitoAdapter;
    private  ResidenciaAdapter residenciaAdapter;


    // DEFINIR LOS ADAPTERS DE CADA TABLA


    public DBAdapter(Context con) {
        dbHelper = new DBHelper(con);
    }



    public boolean insertCarrera(int id,String nombre,float año){
       return carreraAdapter.insert(nombre,año,id);
    }

    public boolean insertComodidad(int id, String desc, int res){
        return comodidadAdapter.insert(id,desc,res);
    }

    public boolean insertDocumentacion(int id, String desc){
        return documentacionAdapter.insert(id,desc);
    }

    public boolean insertFoto(String url, int idcarrera){
        return fotoAdapter.insert(url,idcarrera);
    }

    public boolean insertItem(String descripcion){
        return itemAdapter.insert(descripcion);
    }

    public boolean insertItemRequisito(String descripcion){
        return requisitoAdapter.insert(descripcion);
    }

    public boolean insertLugar(String dir, String tel, int latitud,int longitud){
        return lugarAdapter.insert(dir,tel,latitud,longitud);
    }

    public boolean insertMateria(int id,String nombre,int año){
        return materiaAdapter.insert(id,nombre,año);
    }

    public boolean insertObjetivo (int id, String des, int res){
        return objetivoAdapter.insert(id,des,res);
    }

    /*
    public boolean booleaninsertPerfil(){

    }*/

    public boolean insertPlan(int id,int carreraID){
        return planAdapter.insert(id,carreraID);
    }

    public boolean insertRequisito(String desc){
        return requisitoAdapter.insert(desc);
    }

    public boolean insertResidencia(int id, String desc, String pago, String contact,String titulo, String urlficha,String urldeclaracion){

        return residenciaAdapter.insert(id,desc,pago,contact,titulo,urlficha,urldeclaracion);

    }


    public void open() {

        sqlDB = dbHelper.getWritableDatabase();


    }

    public void close() {
        sqlDB.close();
    }

    public Cursor getDatosCarrera() {
        Cursor r = null ;
//JOIN
        return r;
    }



    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context){
            super(context,DB_NAME, null , DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db){

            db.execSQL(carreraAdapter.CR_TABLE);
            db.execSQL(comodidadAdapter.CR_TABLE);
            db.execSQL(documentacionAdapter.CR_TABLE);
            db.execSQL(fotoAdapter.CR_TABLE);
            db.execSQL(itemAdapter.CR_TABLE);
            db.execSQL(itemRequisitoAdapter.CR_TABLE);
            db.execSQL(lugarAdapter.CR_TABLE);
            db.execSQL(materiaAdapter.CR_TABLE);
            //db.execSQL(PerfilAdapter.CR_TABLE);
            db.execSQL(objetivoAdapter.CR_TABLE);
            db.execSQL(planAdapter.CR_TABLE);
            db.execSQL(requisitoAdapter.CR_TABLE);
            db.execSQL(residenciaAdapter.CR_TABLE);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //no se van a actualizar las tablas de momento
            //sorry.
            //Nahuel Ovejero.
        }


    }



}

