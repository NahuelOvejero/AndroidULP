package com.example.usuario.ulpapp;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Residencia;
import com.example.usuario.ulpapp.parser.Noticia;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class resi_Fragment extends Fragment {

    private ArrayList<String> listaDocumentacion = new ArrayList<String>();
    private ArrayList<String> listaObjetivos = new ArrayList<String>();
    private ArrayList<String> listaComodidades = new ArrayList<String>();
    private ArrayList<String> listaDescripcion = new ArrayList<String>();
    private String descripcion;
    private Residencia res=new Residencia(descripcion,null,null,null,null);

    public resi_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_resi_, container, false);

        res=((BaseApplication)getContext().getApplicationContext()).getResidencia();
        listaDescripcion.add(0,""+res.getDescripcion());
        ListView lvDesc= (ListView) v.findViewById(R.id.resiDesc);
        ArrayAdapter<String> adDesc=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listaDescripcion);
        lvDesc.setAdapter(adDesc);


        listaDocumentacion=((BaseApplication)getContext().getApplicationContext()).getDocumentacionResi();
        ListView lvDocum= (ListView) v.findViewById(R.id.resiDocu);
        ArrayAdapter<String> adDocum=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listaDocumentacion);
        lvDocum.setAdapter(adDocum);


        listaObjetivos= ((BaseApplication)getContext().getApplicationContext()).getObjetivosResi();
        ListView lvObj= (ListView) v.findViewById(R.id.resiObj);
        ArrayAdapter<String> adObj=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listaObjetivos);
        lvObj.setAdapter(adObj);

        listaComodidades= ((BaseApplication)getContext().getApplicationContext()).getComodidadesResi();
        ListView lvComodi=(ListView) v.findViewById(R.id.resiComodidades);
        ArrayAdapter<String> adComod=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listaComodidades);
        lvComodi.setAdapter(adComod);
        // Inflate the layout for this fragment
        return v;
    }

}