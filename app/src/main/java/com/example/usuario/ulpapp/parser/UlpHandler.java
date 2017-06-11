package com.example.usuario.ulpapp.parser;

/**
 * Created by Usuario on 25/05/2017.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UlpHandler extends DefaultHandler{
    private List<Noticia> noticias;
    private Noticia noticia;
    private StringBuilder sbText;
    public Boolean parsingError = false;



    public List<Noticia> getNoticias(){
        return noticias;
    }


    @Override
    public void startDocument() throws SAXException {

        super.startDocument();

        noticias = new ArrayList<Noticia>();
        sbText = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String titulo, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, titulo, attributes);

        if (localName.equals("item")) {

            noticia = new Noticia(titulo, null, null, null,null,null);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        super.characters(ch, start, length);

        if (this.noticia != null)
            sbText.append(ch, start, length);
    }


    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {

        super.endElement(uri, localName, name);
        double value;
        if (this.noticia != null) {

            if (localName.equals("title")) {
                noticia.setTitulo(sbText.toString().trim());
            } else if (localName.equals("link")) {
                   noticia.setLink(sbText.toString().trim());
            } else if (localName.equals("description")) {
                    noticia.setDescripcion(sbText.toString().trim());
            } else if (localName.equals("fecha")) {

               noticia.setFecha(sbText.toString().trim());

            }  else if (localName.equals("img")) {
                //Verificar si existe en la base de datos.
                noticia.setFotoImagen(cargaImagen("http://noticias.ulp.edu.ar/img/img_portadas/"+sbText.toString().trim()));
                noticia.setFoto("http://noticias.ulp.edu.ar/img/img_portadas/"+sbText.toString().trim());


            }else if (localName.equals("item")) {
                noticias.add(noticia);
            }

            sbText.setLength(0);
        }
    }


    public Bitmap cargaImagen(String ruta){


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
