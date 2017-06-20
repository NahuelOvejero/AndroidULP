package com.example.usuario.ulpapp;


import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Carrera;
import com.example.usuario.ulpapp.Database.model.Lugar;
import com.example.usuario.ulpapp.Database.model.Materia;

import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 */
public class mycarreraa extends Fragment {

    private static int numcarrera;
    private ArrayList<Materia> materiasCarrera = new ArrayList<Materia>();
    private ArrayList<String> año1= new ArrayList<String>();
    private ArrayList<String> año2= new ArrayList<String>();
    private ArrayList<String> año3= new ArrayList<String>();
    private ArrayList<String> coment=new ArrayList<String>();
    private ArrayList<String> profe=new ArrayList<String>();

    private static  String titulos;
    TextView c_titulo, c_duracion, c_descripcion, c_año1, c_añoo2, c_año3, c_proff, c_coments, c_sede;
    ImageView c_cabe, img_carrera;
    VideoView video;

    public static void setParameter(int p){
        numcarrera=p;
    }

    public mycarreraa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mycarreraa, container, false);
        View rootView;
        HorizontalScrollView hsv = (HorizontalScrollView) v.findViewById(R.id.hsvEgresado);
        Carrera carrera = new Carrera(null,null,0);
        Lugar lugar = new Lugar(null,null,0,0);
        String doc="";
        String doc1="";
        String com="";
        String cabezera="";
        String compara="";
        String com1="";
        String compara1="";
        String com2="";
        String compara2="";

        c_titulo = (TextView) v.findViewById(R.id.duracion);
        c_duracion= (TextView)v.findViewById((R.id.nombrecar));
        c_descripcion=(TextView)v.findViewById((R.id.descripcion));
        c_año1=(TextView)v.findViewById((R.id.pri));
        c_añoo2=(TextView)v.findViewById((R.id.seg));
        c_año3=(TextView)v.findViewById((R.id.ter));
        c_coments=(TextView) v.findViewById(R.id.obj);
        c_proff=(TextView) v.findViewById(R.id.profes);
        c_cabe=(ImageView)v.findViewById((R.id.imgcabez));
        c_sede=(TextView) v.findViewById(R.id.sede);

        switch (numcarrera)
        {
            case 1:
                rootView = inflater.inflate(R.layout.videos, container, false);
                hsv.addView(rootView);
                setUpVideo(v);
                carrera = new Carrera("Desarrollo de Software","La carrera está diseñada para permitir una rápida inserción en el ámbito laboral. Los conocimientos adquiridos le permitirán al egresado insertarse en compañías de la industria tecnológica y de otras actividades de la economía, como así también, en el ámbito gubernamental.",3);
                materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasSoft();
                coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnSoft();
                profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueSoft();
                lugar=((BaseApplication)getContext().getApplicationContext()).getLugarSoft();
                c_cabe.setImageResource(((BaseApplication)getContext().getApplicationContext()).getCabeceraSoft());
                compara="Introducción a la Programación";
                compara1="Programación Web 1";
                compara2="Redes y Seguridad Informática";
                break;
            case 2:
                rootView = inflater.inflate(R.layout.imagenes, container, false);
                hsv.addView(rootView);
                setUpImg(v);
                carrera=new Carrera("Gestión Empresarial","Está diseñada en respuesta a la demanda del mercado que, ante un crecimiento económico y un aumento en la competitividad, necesita de profesionales que agilicen la gestión dentro de las empresas. El profesional contará con las herramientas para optimizar la utilización de los recursos de la empresa. También, podrá generar su propio emprendimiento.",3);
                materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasGestion();
                coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnEmp();
                profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueEmp();
                lugar=((BaseApplication)getContext().getApplicationContext()).getLugarEmp();
                c_cabe.setImageResource(((BaseApplication)getContext().getApplicationContext()).getCabeceraGestion());
                img_carrera.setImageResource(((BaseApplication)getContext().getApplicationContext()).getFotoEmp());
                compara="Inglés I";
                compara1="Laboratorio Taller:Sistemas de Información Gerencial y Contable II";
                compara2="Análisis Financiero";
                break;
            case 3:
                rootView = inflater.inflate(R.layout.imagenes, container, false);
                hsv.addView(rootView);
                setUpImg(v);
                carrera=new Carrera("Guia de Turismo","San Luis se ha convertido en uno de los principales destinos turísticos del país, gracias a las políticas aplicadas por el Gobierno provincial. En esta tecnicatura se brinda una propuesta formativa que integre los aspectos básicos, aplicados, prácticos y éticos profesionales desde una perspectiva multidisciplinaria e interdisciplinaria. Al finalizar la carrera el profesional estará capacitado para brindar información específica en contacto con el turista, en senderos de interpretación, circuitos guiados y podrá coordinar excursiones programadas.",3);
                materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasGuia();
                coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnGuiaTur();
                profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueGuiaTur();
                lugar=((BaseApplication)getContext().getApplicationContext()).getLugarGuiaTur();
                c_cabe.setImageResource(((BaseApplication)getContext().getApplicationContext()).getCabeceraGuia());
                img_carrera.setImageResource(((BaseApplication)getContext().getApplicationContext()).getFotoGuiaTur());
                compara="Organicaciones Turísticas";
                compara1="Geografía de San Luis";
                compara2="Laboratorio Taller de Interpretación II";
                break;
            case 4:
                rootView = inflater.inflate(R.layout.imagenes, container, false);
                hsv.addView(rootView);
                setUpImg(v);
                carrera=new Carrera("Tecnicatura en Turismo","Desde una perspectiva local, la provincia de San Luis ha definido a la actividad turística como una de las áreas centrales para su desarrollo, convirtiéndose en un destino turístico centrado en su riqueza cultural, histórica y natural. El profesional egresado reunirá aptitudinalmente las condiciones para administrar y conformar agencias de viajes y turismo, como así también formular proyectos inherentes",3);
                materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasTurismo();
                coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnTur();
                profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueTur();
                lugar=((BaseApplication)getContext().getApplicationContext()).getLugarTur();
                c_cabe.setImageResource(((BaseApplication)getContext().getApplicationContext()).getCabeceraTurismo());
                img_carrera.setImageResource(((BaseApplication)getContext().getApplicationContext()).getFotoTur());
                compara="Introducción al Turismo";
                compara1="Circuitos Turísticos Nacionales II";
                compara2="Laboratorio Taller de Formulación de Proyectos Turísticos";
                break;
        }

        año1=llenoxaño(materiasCarrera,1);
        año2=llenoxaño(materiasCarrera,2);
        año3=llenoxaño(materiasCarrera,3);

        for(String s:coment)
        {
            doc=doc+"• "+s+"\n";
        }
        for(String s:profe)
        {
            doc1=doc1+"• "+s+"\n";
        }
        for(String s:año1)
        {
            if(s.equals(compara)) {
                cabezera="Primer Año";
                com = cabezera+ "\n"+ "\n" +"• " + s + "\n";
            }
            else{
                com=com+"• "+s+"\n";
            }
        }
        for(String s:año2)
        {
            if(s.equals(compara1)) {
                cabezera="Segundo Año";
                com1 = cabezera+ "\n" + "\n"+"• " + s + "\n";
            }
            else{
                com1=com1+"• "+s+"\n";
            }
        }
        for(String s:año3)
        {
            if(s.equals(compara2)) {
                cabezera="Tercer Año";
                com2 = cabezera+ "\n"+"\n"+"• " + s + "\n";
            }
            else{
                com2=com2+"• "+s+"\n";
            }
        }
        c_proff.setText(doc1);
        c_titulo.setText(carrera.getTitulo());
        c_descripcion.setText(carrera.getDescripcion());
        c_duracion.setText(String.valueOf(carrera.getDuracion())+" años");
        c_coments.setText(doc);
        c_año1.setText(com);
        c_añoo2.setText(com1);
        c_año3.setText(com2);
        c_sede.setText(lugar.getDireccion());
        c_titulo.setFocusableInTouchMode(true);
        c_titulo.setFocusable(true);
        c_titulo.requestFocus();

        return v;
    }

    public ArrayList<String> llenoxaño(ArrayList<Materia> m,int año){
        ArrayList<String> añolist=new ArrayList<String>();
        for (Materia a :m){
            if(a.getAño()==año){
                añolist.add(a.getNombre());
            }
        }
        return  añolist;
    }

    public void setUpVideo(View v)
    {
        video = (VideoView) v.findViewById(R.id.videoCuk);
        String path = "android.resource://" + v.getContext().getPackageName() + "/" + R.raw.promo;
        MediaController mc1 = new MediaController(video.getContext());
        mc1.setAnchorView(video);
        video.setMediaController(mc1);
        video.setVideoURI(Uri.parse(path));
        if(c_titulo.requestFocus())
        {
            video.clearFocus();
        }
    }

    public void setUpImg(View v)
    {
        img_carrera = (ImageView) v.findViewById(R.id.imgCarrera);
    }

}
