package com.example.usuario.ulpapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Carrera;
import com.example.usuario.ulpapp.Database.model.Residencia;
import com.example.usuario.ulpapp.mycarreraa;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class carrera_Fragment extends Fragment implements   View.OnClickListener{

    private Carrera carrera1= new Carrera(null,null,1);
    private ArrayList<String> porQueEstudiar;


    public carrera_Fragment() {
        // Required empty public constructor
    }
    TextView text;

    private class MyAdapter extends ArrayAdapter<String> {
        private Context contexto;
        private ArrayList<String> lista;
        public MyAdapter(Context contexto,ArrayList<String> lista){
            super(contexto,R.layout.list_item,lista);
            this.contexto=contexto;
            this.lista=lista;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView =convertView;
            if( itemView==null){
                LayoutInflater vi =(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                itemView=vi.inflate(R.layout.list_item, parent, false);

            }

            String item=lista.get(position);

            TextView tItem=(TextView)itemView.findViewById(R.id.textItem);
            tItem.setText(item);
            ImageView icono=(ImageView)itemView.findViewById(R.id.icono);
            icono.setImageResource(R.mipmap.icono_notici);
            return itemView;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        porQueEstudiar=((BaseApplication)getContext().getApplicationContext()).getPorQueEstudiar();

        View rootView = inflater.inflate(R.layout.fragment_carrera_, container, false);
        Button btDesarrollo = (Button) rootView.findViewById(R.id._desarrollo);
        Button btGestion = (Button) rootView.findViewById(R.id._gestion);
        Button btTurismo = (Button) rootView.findViewById(R.id._turismo);
        Button btGuia = (Button) rootView.findViewById(R.id._guiaT);
        ListView porque=(ListView)rootView.findViewById(R.id.porqueEstudiarList);
        porque.setAdapter(new MyAdapter(getContext(),porQueEstudiar));

        btDesarrollo.setOnClickListener(this);
        btGestion.setOnClickListener(this);
        btTurismo.setOnClickListener(this);
        btGuia.setOnClickListener(this);
        return rootView;

        // Inflate the layout for this fragment







    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id._desarrollo) {

            //carrera1=((BaseApplication)getContext().getApplicationContext()).getSoft();
            mycarreraa carrera = new mycarreraa();
            carrera.setParameter(1);
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    carrera,
                    carrera.getTag()
            ).addToBackStack(null).commit();
        }

        else if (view.getId()== R.id._gestion){
            //carrera1=((BaseApplication)getContext().getApplicationContext()).getSoft();
            mycarreraa carrera=new mycarreraa();
            carrera.setParameter(2);
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    carrera,
                    carrera.getTag()
            ).addToBackStack(null).commit();

        }
        else if (view.getId()== R.id._guiaT){
            //carrera1=((BaseApplication)getContext().getApplicationContext()).getSoft();
            mycarreraa carrera=new mycarreraa();
            carrera.setParameter(4);
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    carrera,
                    carrera.getTag()
            ).addToBackStack(null).commit();

        }
        else if (view.getId()== R.id._turismo){
            //carrera1=((BaseApplication)getContext().getApplicationContext()).getSoft();
            mycarreraa carrera=new mycarreraa();
            carrera.setParameter(3);
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    carrera,
                    carrera.getTag()
            ).addToBackStack(null).commit();

        }

    }



}
