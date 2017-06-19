package com.example.usuario.ulpapp;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Autoridades;
import com.example.usuario.ulpapp.parser.Noticia;
import com.example.usuario.ulpapp.parser.UlpParser;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Inst_Fragment extends Fragment {


    public Inst_Fragment() {
        // Required empty public constructor


    }








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<String> listaAcerca=((BaseApplication)getContext().getApplicationContext()).getAcercaULP();
        String mision=((BaseApplication)getContext().getApplicationContext()).getMisionULP();
        String vision=((BaseApplication)getContext().getApplicationContext()).getVisionULP();

        View v=   inflater.inflate(R.layout.fragment_inst_, container, false);

        //carga seccion/texto Acerca de

        TextView textAcerca= (TextView)v.findViewById(R.id.Acercade);
        String textoAcercade="";

        for (String s: listaAcerca) {
            textoAcercade=textoAcercade+"\n"+s;
        }




        textAcerca.setText(textoAcercade);
        textAcerca.setMovementMethod(new ScrollingMovementMethod());


        //carga seccion/texto mision

        TextView textMision =(TextView)v.findViewById(R.id.Mision);
        textMision.setText(mision);
        textMision.setMovementMethod(new ScrollingMovementMethod());
        TextView textVision =(TextView)v.findViewById(R.id.Vision);
        textVision.setText(vision);
        textVision.setMovementMethod(new ScrollingMovementMethod() );

        //catga seccion/texto valores

        ArrayList<String> listaValores=((BaseApplication)getContext().getApplicationContext()).getValoresULP();
        String textoValores="";
        for(String s: listaValores){

            textoValores=textoValores+"• "+s+"\n";
        }
        TextView valores=(TextView)v.findViewById(R.id.Valores);
        valores.setMovementMethod(new ScrollingMovementMethod());
        valores.setText(textoValores);



        //metodo para lllenar el list con las autoridades
        List<Autoridades> Listautoridades=((BaseApplication)getContext().getApplicationContext()).getAutoridadesULP();
        String textAutoridades="";
        for(Autoridades a: Listautoridades){

            textAutoridades=textAutoridades+"<b>• "+a.getCargo()+"</b><br><br>  "+a.getNombre()+"<br><br>";
        }
        TextView autoridades=(TextView)v.findViewById(R.id.Autoridades);
        autoridades.setMovementMethod(new ScrollingMovementMethod());
        autoridades.setText(Html.fromHtml(textAutoridades));



       //carga de imagen cabecera

        ImageView im=(ImageView)v.findViewById(R.id.Ins_cabecera);
        Integer var=((BaseApplication)getContext().getApplicationContext()).getCabeceraInstitucional();
        im.setImageResource(var);

        //carga de imagen del medio

        ImageView imm=(ImageView)v.findViewById(R.id.Ins_medio);
        Integer var2=((BaseApplication)getContext().getApplicationContext()).getCabeceraRectorado();
        imm.setImageResource(var2);

        return  v;
    }

}





