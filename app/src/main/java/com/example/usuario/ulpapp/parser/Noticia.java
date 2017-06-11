package com.example.usuario.ulpapp.parser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Usuario on 25/05/2017.
 */

public class Noticia {
    private String titulo;
    private String link;
    private String descripcion;
    private String guid;
    private String Fecha;
    private String Foto;
    private Bitmap FotoImagen;

    public Noticia(String titulo, String link, String descripcion, String guid, String fecha, String foto) {
        this.titulo = titulo;
        this.link = link;
        this.descripcion = descripcion;
        this.guid = guid;
        Fecha = fecha;
        Foto = foto;
        this.setFotoImagen();
    }

    public Noticia(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public Bitmap getFotoImagen() {
        return FotoImagen;
    }

    //cuando se crea por primera vez
    public void setFotoImagen() {
        FotoImagen = cargaImagen(this.Foto);
    }
    //cuando viene de la base de datos
    public void setFotoImagen(Bitmap imagen) {
        FotoImagen =  imagen;
    }


    private Bitmap cargaImagen(String ruta){


        URL imageUrl = null;
        HttpURLConnection conn = null;
        Bitmap imagen=null;

        try {

            imageUrl = new URL(ruta);
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4; // el factor de escala a minimizar la imagen, siempre es potencia de 2

            imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);




        } catch (MalformedURLException e) {
            Log.d("Ulr mal","Mal url");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("Io mal","Mal io");
            e.printStackTrace();
        }
        return imagen;
    }
}
