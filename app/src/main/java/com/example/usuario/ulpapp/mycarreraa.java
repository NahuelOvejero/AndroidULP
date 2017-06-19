package com.example.usuario.ulpapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Carrera;
import com.example.usuario.ulpapp.Database.model.Materia;

import java.util.ArrayList;


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
    TextView c_titulo;TextView c_duracion;TextView c_descripcion;
    TextView c_año1;TextView c_añoo2;TextView c_año3;
    TextView c_proff;TextView c_coments;



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

        if (numcarrera==1) {
            Carrera carrera=new Carrera("DESARROLLO DE SOFTWARE","La carrera está diseñada para permitir una rápida inserción en el ámbito laboral. Los conocimientos adquiridos le permitirán al egresado insertarse en compañías de la industria tecnológica y de otras actividades de la economía, como así también, en el ámbito gubernamental.",3);
//DESCOMENTAR Y VER ERROR
            materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasSoft();
            coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnSoft();
            profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueSoft();

            año1=llenoxaño(materiasCarrera,1);
            año2=llenoxaño(materiasCarrera,2);
            año3=llenoxaño(materiasCarrera,3);

            
            c_titulo = (TextView) v.findViewById(R.id.duracion);
            c_duracion= (TextView)v.findViewById((R.id.nombrecar));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));

            c_año1=(TextView)v.findViewById((R.id.pri));
            c_añoo2=(TextView)v.findViewById((R.id.seg));
            c_año3=(TextView)v.findViewById((R.id.ter));

            c_coments=(TextView) v.findViewById(R.id.obj);
            c_proff=(TextView) v.findViewById(R.id.profes);

            String doc="";
            for(String s:coment)
            {
                doc=doc+"• "+s+"\n";
            }
            c_coments.setText(doc);

            String doc1="";
            for(String s:profe)
            {
                doc1=doc1+"• "+s+"\n";
            }
            c_proff.setText(doc1);




            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");

            String com="";
            String compara="Introducción a la Programación";
            String cabezera;
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
            c_año1.setText(com);

            String com1="";
            String compara1="Programación Web 1";

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
            c_añoo2.setText(com1);


            String com2="";
            String compara2="Redes y Seguridad Informática";

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
            c_año3.setText(com2);

        }
        else if (numcarrera==2) {
            Carrera carrera=new Carrera("TECNICATURA EN GESTIÓN EMPRESARIAL","Está diseñada en respuesta a la demanda del mercado que, ante un crecimiento económico y un aumento en la competitividad, necesita de profesionales que agilicen la gestión dentro de las empresas. El profesional contará con las herramientas para optimizar la utilización de los recursos de la empresa. También, podrá generar su propio emprendimiento.",3);

            materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasGestion();

            coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnEmp();
            profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueEmp();

            año1=llenoxaño(materiasCarrera,1);
            año2=llenoxaño(materiasCarrera,2);
            año3=llenoxaño(materiasCarrera,3);


            c_titulo = (TextView) v.findViewById(R.id.duracion);
            c_duracion= (TextView)v.findViewById((R.id.nombrecar));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));

            c_año1=(TextView)v.findViewById((R.id.pri));
            c_añoo2=(TextView)v.findViewById((R.id.seg));
            c_año3=(TextView)v.findViewById((R.id.ter));

            c_coments=(TextView) v.findViewById(R.id.obj);
            c_proff=(TextView) v.findViewById(R.id.profes);

            String doc="";
            for(String s:coment)
            {
                doc=doc+"• "+s+"\n";
            }
            c_coments.setText(doc);

            String doc1="";
            for(String s:profe)
            {
                doc1=doc1+"• "+s+"\n";
            }
            c_proff.setText(doc1);


            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");

            String com="";
            String compara="Inglés I";
            String cabezera;
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
            c_año1.setText(com);

            String com1="";
            String compara1="Laboratorio Taller:Sistemas de Información Gerencial y Contable II";

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
            c_añoo2.setText(com1);


            String com2="";
            String compara2="Análisis Financiero";

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
            c_año3.setText(com2);


        }
        else if (numcarrera==3) {
            Carrera carrera=new Carrera("TECNICATURA EN GUIA DE TURISMO","San Luis se ha convertido en uno de los principales destinos turísticos del país, gracias a las políticas aplicadas por el Gobierno provincial. En esta tecnicatura se brinda una propuesta formativa que integre los aspectos básicos, aplicados, prácticos y éticos profesionales desde una perspectiva multidisciplinaria e interdisciplinaria. Al finalizar la carrera el profesional estará capacitado para brindar información específica en contacto con el turista, en senderos de interpretación, circuitos guiados y podrá coordinar excursiones programadas.",3);



            materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasGuia();

            coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnGuiaTur();
            profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueGuiaTur();

            año1=llenoxaño(materiasCarrera,1);
            año2=llenoxaño(materiasCarrera,2);
            año3=llenoxaño(materiasCarrera,3);


            c_titulo = (TextView) v.findViewById(R.id.duracion);
            c_duracion= (TextView)v.findViewById((R.id.nombrecar));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));

            c_año1=(TextView)v.findViewById((R.id.pri));
            c_añoo2=(TextView)v.findViewById((R.id.seg));
            c_año3=(TextView)v.findViewById((R.id.ter));

            c_coments=(TextView) v.findViewById(R.id.obj);
            c_proff=(TextView) v.findViewById(R.id.profes);

            String doc="";
            for(String s:coment)
            {
                doc=doc+"• "+s+"\n";
            }
            c_coments.setText(doc);

            String doc1="";
            for(String s:profe)
            {
                doc1=doc1+"• "+s+"\n";
            }
            c_proff.setText(doc1);

            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");

            String com="";
            String compara="Organicaciones Turísticas";
            String cabezera;
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
            c_año1.setText(com);

            String com1="";
            String compara1="Geografía de San Luis";

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
            c_añoo2.setText(com1);


            String com2="";
            String compara2="Laboratorio Taller de Interpretación II";

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
            c_año3.setText(com2);


        }
        else if (numcarrera==4) {
            Carrera carrera=new Carrera("TECNICATURA EN TURISMO","Desde una perspectiva local, la provincia de San Luis ha definido a la actividad turística como una de las áreas centrales para su desarrollo, convirtiéndose en un destino turístico centrado en su riqueza cultural, histórica y natural. El profesional egresado reunirá aptitudinalmente las condiciones para administrar y conformar agencias de viajes y turismo, como así también formular proyectos inherentes",3);



            materiasCarrera=((BaseApplication)getContext().getApplicationContext()).getMateriasTurismo();

            coment=((BaseApplication)getContext().getApplicationContext()).getCompetenteEnTur();
            profe=((BaseApplication)getContext().getApplicationContext()).getProfesionalQueTur();

            año1=llenoxaño(materiasCarrera,1);
            año2=llenoxaño(materiasCarrera,2);
            año3=llenoxaño(materiasCarrera,3);


            c_titulo = (TextView) v.findViewById(R.id.duracion);
            c_duracion= (TextView)v.findViewById((R.id.nombrecar));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));

            c_año1=(TextView)v.findViewById((R.id.pri));
            c_añoo2=(TextView)v.findViewById((R.id.seg));
            c_año3=(TextView)v.findViewById((R.id.ter));

            c_coments=(TextView) v.findViewById(R.id.obj);
            c_proff=(TextView) v.findViewById(R.id.profes);

            String doc="";
            for(String s:coment)
            {
                doc=doc+"• "+s+"\n";
            }
            c_coments.setText(doc);

            String doc1="";
            for(String s:profe)
            {
                doc1=doc1+"• "+s+"\n";
            }
            c_proff.setText(doc1);

            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");

            String com="";
            String compara="Introducción al Turismo";
            String cabezera;
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
            c_año1.setText(com);

            String com1="";
            String compara1="Circuitos Turísticos Nacionales II";

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
            c_añoo2.setText(com1);


            String com2="";
            String compara2="Laboratorio Taller de Formulación de Proyectos Turísticos";

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
            c_año3.setText(com2);



        }

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

}
