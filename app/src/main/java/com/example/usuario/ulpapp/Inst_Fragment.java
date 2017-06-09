package com.example.usuario.ulpapp;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.ulpapp.parser.Noticia;
import com.example.usuario.ulpapp.parser.UlpParser;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Inst_Fragment extends Fragment {


    public Inst_Fragment() {
        // Required empty public constructor
    }


    private List<Noticia> listaC=new ArrayList<Noticia>();





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_inst_, container, false);
    }

}




