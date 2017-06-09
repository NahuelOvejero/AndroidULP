package com.example.usuario.ulpapp;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

    private LayoutInflater inflater;
    private ViewGroup parent;
    private ListView lv;

    private List<Noticia> listaC=new ArrayList<Noticia>();
    public principal_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi=inflater.inflate(R.layout.fragment_principal_, container, false);
        lv=(ListView) vi.findViewById(R.id.listView);


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

        UlpParser ulp=null;
        principal_Fragment.CargaTask t=new principal_Fragment.CargaTask();
        t.execute(ulp);


    }


    class CargaTask extends AsyncTask<UlpParser,UlpParser,List<Noticia>> {

        private List<Noticia> lista = null;

        @Override
        protected List<Noticia> doInBackground(UlpParser... params) {
            //Verifico el mes de a ultima actualización
            int mes=((BaseApplication)getContext().getApplicationContext()).ultimaActualizacionNoticia();
            Date hoy=new Date();
            Log.d("Mes",mes+"");
            Log.d("Mes de sistema",hoy.getMonth()+"");
            if(hoy.getMonth()!=mes){

                ((BaseApplication)getContext().getApplicationContext()).vaciarTabla();
                params[0] = new UlpParser("http://noticias.ulp.edu.ar/rss/ultimas_rss.rss");
                lista = params[0].parse();
            }else {


            }




            return lista;
        }

        protected void onPostExecute(List<Noticia> lista) {


            listaC=lista;
            //Verifico el mes de la última actualización
            int mes=((BaseApplication)getContext().getApplicationContext()).ultimaActualizacionNoticia();
            Date hoy=new Date();
            if(hoy.getMonth()!=mes){

                ((BaseApplication)getContext().getApplicationContext()).insertarNoticias(listaC);

            }

            cargaVista(inflater,parent,lv);



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

            imagen.setImageBitmap(noticiaActual.getFotoImagen());

            TextView titulo=(TextView)itemView.findViewById(R.id.titulo);
            titulo.setText(noticiaActual.getTitulo());

            TextView descripcion=(TextView)itemView.findViewById(R.id.descripcion);
            descripcion.setText(noticiaActual.getDescripcion());

            TextView fecha=(TextView)itemView.findViewById(R.id.fecha);
            fecha.setText(noticiaActual.getFecha());


            return itemView;
        }
    }


}
