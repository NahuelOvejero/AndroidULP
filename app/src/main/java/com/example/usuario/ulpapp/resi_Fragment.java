package com.example.usuario.ulpapp;


import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Residencia;
import com.example.usuario.ulpapp.parser.Noticia;

import org.w3c.dom.Text;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class resi_Fragment extends Fragment {

    private ArrayList<String> listaDocumentacion = new ArrayList<String>();
    private ArrayList<String> listaObjetivos = new ArrayList<String>();
    private ArrayList<String> listaComodidades = new ArrayList<String>();
    private ArrayList<Integer> listaFotos = new ArrayList<Integer>();
    private Residencia res=new Residencia(null,null,null,null,null);

    public resi_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_resi_, container, false);

        res=((BaseApplication)getContext().getApplicationContext()).getResidencia();
        TextView tvDesc= (TextView) v.findViewById(R.id.resiDesc);
        tvDesc.setText(res.getDescripcion());

        listaObjetivos= ((BaseApplication)getContext().getApplicationContext()).getObjetivosResi();
        TextView tvObj= (TextView) v.findViewById(R.id.resiObj);
        String obj="";
        for(String s:listaObjetivos)
        {
            obj=obj+s+" ";
        }
        tvObj.setText(obj);

        listaComodidades= ((BaseApplication)getContext().getApplicationContext()).getComodidadesResi();
        TextView tvComodidades=(TextView) v.findViewById(R.id.resiComodidades);
        String com="";
        for(String s:listaComodidades)
        {
            com=com+"• "+s+"\n";
        }
        tvComodidades.setText(com);

        listaDocumentacion=((BaseApplication)getContext().getApplicationContext()).getDocumentacionResi();
        TextView tvDocum= (TextView) v.findViewById(R.id.resiDocu);
        String doc="";
        for(String s:listaDocumentacion)
        {
            doc=doc+"• "+s+"\n";
        }
        tvDocum.setText(doc);

        TextView tvCupo= (TextView) v.findViewById(R.id.resiCupo);
        tvCupo.setText(res.getCupo());

        TextView tvContacto= (TextView) v.findViewById(R.id.resiContacto);
        tvContacto.setText(res.getContacto());

        TextView tvUrlIngreso= (TextView) v.findViewById(R.id.resiUrlIngreso);
        tvUrlIngreso.setText("Ficha de ingreso residencias\n"+res.getURLFichaIngreso());

        TextView tvUrlDdjj= (TextView) v.findViewById(R.id.resiUrlDdjj);
        tvUrlDdjj.setText("Declaracion Jurada\n"+res.getURLDeclaracionJurada());

        ImageView im=(ImageView) v.findViewById(R.id.resiPortada);
        listaFotos=((BaseApplication)getContext().getApplicationContext()).getFotosResi();
        Integer rutaFoto= listaFotos.get(0);
        im.setImageResource(rutaFoto);
        // Inflate the layout for this fragment
        return v;
    }

}