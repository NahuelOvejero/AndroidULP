package com.example.usuario.ulpapp.Util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.provider.BaseColumns;
import android.text.format.DateFormat;
import android.util.Log;

import com.example.usuario.ulpapp.parser.Noticia;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by Usuario on 18/05/2017.
 */

public class NoticiaAdapter {
    private static final String NAME="Noticia";
    private SQLiteDatabase sqlDB;
    public NoticiaAdapter(SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }

    private class Columns implements BaseColumns{
        public final static String _ID="Id_noticia";
        public final static String TITULO="Titulo";
        public final static String DESCRIPCION="Descripcion";
        public final static String FECHA="Fecha";
        public final static String FOTOURL="Foto";
        public final static String FOTOBITMAP = "Bitmap";
        public final static String ACTUALIZACION="Actualizacion";
    }
    private static String[] COLUMNS={Columns._ID,Columns.TITULO,Columns.DESCRIPCION,Columns.FECHA,Columns.FOTOURL, Columns.FOTOBITMAP,Columns.ACTUALIZACION};

    public final static String CR_TABLE="create table if not exists "+ NAME+" ("
            +Columns._ID+" integer primary key autoincrement, "+Columns.TITULO+" text, "
            +Columns.DESCRIPCION +" text, "+Columns.FECHA+" text, "+Columns.FOTOURL+" text, "+ Columns.FOTOBITMAP+ " BLOB, " +Columns.ACTUALIZACION+" text )";
    public boolean insert (int IdCarrera,String Titulo,String descr, String fecha,Bitmap foto, String urlfoto){
        ContentValues valores=new ContentValues();
        valores.put(Columns._ID,IdCarrera);
        valores.put(Columns.TITULO,Titulo);
        valores.put(Columns.DESCRIPCION,descr);
        valores.put(Columns.FECHA,fecha);
        valores.put(Columns.FOTOURL,urlfoto);
        Date d = new Date();
        CharSequence s  = DateFormat.format("dd/MM/yyyy", d.getTime());
        valores.put(Columns.ACTUALIZACION,s.toString());
        valores.put(Columns.FOTOBITMAP, BitmapAByte(foto));

        return sqlDB.insert(NAME,null,valores)>0;
    }
    public boolean delete(int Id){
        String whereClause=Columns._ID+"=?";
        String[] whereArgs={String.valueOf(Id)};
        return sqlDB.delete(NAME,whereClause,whereArgs)>0;
    }
    public Cursor noticia(int Id){
        String whereClause=Columns._ID+"=?";
        String[] whereArgs={String.valueOf(Id)};
        String [] col={Columns.ACTUALIZACION};

        return sqlDB.query(NAME,col,whereClause,whereArgs,null,null,null,null);
    }
    public Cursor Noticias(){
        String [] col={Columns.TITULO,Columns.DESCRIPCION,Columns.FECHA,Columns.FOTOURL,Columns.FOTOBITMAP,Columns.ACTUALIZACION};
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

    public void vaciarTabla(){

       sqlDB.delete(NAME,null,null);
    }


    //este metodo encapsula el conversor de url a bitmap, y de bitmap lo lleva un array de bytes
    // para poder ser guardado en la BD cono BLOB

     private byte[] BitmapAByte(Bitmap bitmap) {

         if(bitmap!=null){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
             return stream.toByteArray();}

         else{
             return null;}

    }


}
