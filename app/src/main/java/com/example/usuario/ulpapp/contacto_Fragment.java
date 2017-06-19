package com.example.usuario.ulpapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.usuario.ulpapp.Application.BaseApplication;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class contacto_Fragment extends Fragment {


    private LayoutInflater inflater;
    private ViewGroup parent;
    private ListView lv;
    private Integer listaFotos = new Integer(0);

    public contacto_Fragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_contacto_, container, false);

        ImageView im=(ImageView) v.findViewById(R.id.contactoPortada);
        listaFotos=((BaseApplication)getContext().getApplicationContext()).getCabeceraContacto();
        im.setImageResource(listaFotos);
        return v;
    }

}

