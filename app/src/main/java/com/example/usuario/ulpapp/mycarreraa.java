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
    private ArrayList<Materia> materia1año = new ArrayList<Materia>();

    private static  String titulos;
    TextView c_titulo;TextView c_duracion;TextView c_descripcion;



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
            Carrera carrera=new Carrera("Desarrollo de Software","La carrera está diseñada para permitir una rápida inserción en el ámbito laboral. Los conocimientos adquiridos le permitirán al egresado insertarse en compañías de la industria tecnológica y de otras actividades de la economía, como así también, en el ámbito gubernamental.",3);
//DESCOMENTAR Y VER ERROR
          //  materia1año=((BaseApplication)getContext().getApplicationContext()).getMateriasSoft();

            c_titulo = (TextView) v.findViewById(R.id.nombrecar);
            c_duracion= (TextView)v.findViewById((R.id.duracion));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));





            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");


        }
        else if (numcarrera==2) {
            Carrera carrera=new Carrera("Tecnicatura en Gestión Empresarial","Está diseñada en respuesta a la demanda del mercado que, ante un crecimiento económico y un aumento en la competitividad, necesita de profesionales que agilicen la gestión dentro de las empresas. El profesional contará con las herramientas para optimizar la utilización de los recursos de la empresa. También, podrá generar su propio emprendimiento.",3);



            c_titulo = (TextView) v.findViewById(R.id.nombrecar);
            c_duracion= (TextView)v.findViewById((R.id.duracion));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));

            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");


        }
        else if (numcarrera==3) {
            Carrera carrera=new Carrera("Tecnicatura en Guía de Turismo","San Luis se ha convertido en uno de los principales destinos turísticos del país, gracias a las políticas aplicadas por el Gobierno provincial. En esta tecnicatura se brinda una propuesta formativa que integre los aspectos básicos, aplicados, prácticos y éticos profesionales desde una perspectiva multidisciplinaria e interdisciplinaria. Al finalizar la carrera el profesional estará capacitado para brindar información específica en contacto con el turista, en senderos de interpretación, circuitos guiados y podrá coordinar excursiones programadas.",3);



            c_titulo = (TextView) v.findViewById(R.id.nombrecar);
            c_duracion= (TextView)v.findViewById((R.id.duracion));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));

            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");


        }
        else if (numcarrera==4) {
            Carrera carrera=new Carrera("Tecnicatura en Turismo","Desde una perspectiva local, la provincia de San Luis ha definido a la actividad turística como una de las áreas centrales para su desarrollo, convirtiéndose en un destino turístico centrado en su riqueza cultural, histórica y natural. El profesional egresado reunirá aptitudinalmente las condiciones para administrar y conformar agencias de viajes y turismo, como así también formular proyectos inherentes",3);



            c_titulo = (TextView) v.findViewById(R.id.nombrecar);
            c_duracion= (TextView)v.findViewById((R.id.duracion));
            c_descripcion=(TextView)v.findViewById((R.id.descripcion));

            c_titulo.setText(carrera.getTitulo());
            c_descripcion.setText(carrera.getDescripcion());
            //c_duracion.setText(Float.toString(carrera.getDuracion()));
            c_duracion.setText("3 años");


        }

        return v;



    }

}
