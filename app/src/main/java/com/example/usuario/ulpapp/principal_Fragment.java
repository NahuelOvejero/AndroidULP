package com.example.usuario.ulpapp;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.PermissionChecker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.ulpapp.Database.model.Residencia;
import com.example.usuario.ulpapp.parser.LeeEscribeNoticias;
import com.example.usuario.ulpapp.parser.Noticia;
import com.example.usuario.ulpapp.parser.UlpParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.usuario.ulpapp.Application.BaseApplication;


/**
 * A simple {@link Fragment} subclass.
 */
public class principal_Fragment extends Fragment {

    private static final String PREF_IS_RUNNING ="conexion" ;
    private LayoutInflater inflater;
    private ViewGroup parent;
    private ListView lv;


    private List<Noticia> listaC=new ArrayList<>();
    public principal_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vi=inflater.inflate(R.layout.fragment_principal_, container, false);
        lv=(ListView) vi.findViewById(R.id.listView);
        MainActivity.servicios++;

        this.inflater=inflater;
        this.parent=container;

        cargaEquipos();
        cargaVista(inflater,container,lv);


        return vi;
    }



    private void cargaVista(LayoutInflater inflater,ViewGroup parent,ListView lv) {

        ArrayAdapter<Noticia> aa=new MyAdapter(getContext());
        lv.setAdapter(aa);

    }


    private void cargaEquipos() {




            //Verifico el mes de a ultima actualización
            int mes = ((BaseApplication) getContext().getApplicationContext()).ultimaActualizacionNoticia();
            Date hoy = new Date();

            if (hoy.getMonth() != mes ) {
                vistaDefault(listaC);



            } else {

                try {
                    listaC = ((BaseApplication) getContext().getApplicationContext()).listaNoticias();
                }catch (NullPointerException e){
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putBoolean(PREF_IS_RUNNING, false);
                    editor.apply();
                    vistaDefault(listaC);
                }

            }



        }





    private class MyAdapter extends ArrayAdapter<Noticia> {
        private Context contexto;

        public MyAdapter(Context contexto) {
            super(contexto,R.layout.view_item,listaC);
            this.contexto=contexto;

        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView =convertView;
            if( itemView==null){
                LayoutInflater vi =(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                itemView=vi.inflate(R.layout.view_item, parent, false);

            }

            Noticia noticiaActual=listaC.get(position);

            ImageView imagen =(ImageView)itemView.findViewById(R.id.foto);

            if(!noticiaActual.getTitulo().equals("Noticias")){
                imagen.setImageBitmap(noticiaActual.getFotoImagen());
            }else{
                imagen.setImageResource(R.drawable.software);
            }


            TextView titulo=(TextView)itemView.findViewById(R.id.titulo);
            titulo.setText(noticiaActual.getTitulo());

            TextView descripcion=(TextView)itemView.findViewById(R.id.descripcion);
            descripcion.setText(noticiaActual.getDescripcion());

            TextView fecha=(TextView)itemView.findViewById(R.id.fecha);
            fecha.setText(noticiaActual.getFecha());


            return itemView;
        }
    }

private void vistaDefault(List<Noticia> lista){

        for(int i=0;i<10;i++){
            Noticia n=new Noticia();
            n.setTitulo("Noticias");
            n.setDescripcion("Mientras esperás a que se actualicen las noticias, " +
                    "te invitamos a recorrer el menú de nuestra aplicación, para que conozcas un poco más " +
                    "nuestra prestigiosa institución. ");



            lista.add(n);
        }
    }
}
