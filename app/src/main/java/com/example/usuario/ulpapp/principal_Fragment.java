package com.example.usuario.ulpapp;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
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
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vi=inflater.inflate(R.layout.fragment_principal_, container, false);
        lv=(ListView) vi.findViewById(R.id.listView);

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int mLastFirstVisibleItem;
            private int up=-1;
            private int down=-1;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if(mLastFirstVisibleItem<firstVisibleItem && down==-1)
                {

                    ImageView im=(ImageView)vi.findViewById(R.id.LogoEstaticoFragmento);
                    ImageView main= (ImageView) parent.findViewById(R.id.LogoEstaticoMain);
                    main.setVisibility(View.INVISIBLE);
                    im.setVisibility(View.GONE);
                    down=0;
                    up=-1;




                }
                if(mLastFirstVisibleItem>firstVisibleItem && up==-1)
                {


                    ImageView im=(ImageView)vi.findViewById(R.id.LogoEstaticoFragmento);
                    ImageView main= (ImageView) parent.findViewById(R.id.LogoEstaticoMain);
                    //main.setVisibility(View.VISIBLE);
                    im.setVisibility(View.VISIBLE);
                    im.setAdjustViewBounds(true);
                    up=0;
                    down=-1;
                }
                mLastFirstVisibleItem=firstVisibleItem;

            }
        });
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



    class CargaTask extends AsyncTask<UlpParser,ProgressDialog,List<Noticia>> {


        private ProgressDialog pd = new ProgressDialog(getContext(), R.style.Theme_AppCompat_Dialog);
        private List<Noticia> lista = null;


        @Override
        protected List<Noticia> doInBackground(UlpParser... params) {
            //Verifico el mes de a ultima actualización
            int mes = ((BaseApplication) getContext().getApplicationContext()).ultimaActualizacionNoticia();

            Date hoy = new Date();
            //Log.d("Mes",mes+"");
            //Log.d("Mes de sistema",hoy.getMonth()+"");

            if (hoy.getMonth() != mes) {

                ((BaseApplication) getContext().getApplicationContext()).vaciarTabla();
                params[0] = new UlpParser("http://noticias.ulp.edu.ar/rss/ultimas_rss.rss");
                lista = params[0].parse();
            } else {
                lista = ((BaseApplication) getContext().getApplicationContext()).listaNoticias();

            }


            return lista;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            pd.setMessage("Cargando...");

            pd.setCancelable(false);

            pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);

            pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            pd.show();
        }


        protected void onPostExecute(List<Noticia> lista) {


            listaC = lista;
            //Verifico el mes de la última actualización
            int mes = ((BaseApplication) getContext().getApplicationContext()).ultimaActualizacionNoticia();

            Date hoy = new Date();
            if (hoy.getMonth() != mes) {

                ((BaseApplication) getContext().getApplicationContext()).insertarNoticias(listaC);

            }
            pd.dismiss();
            cargaVista(inflater, parent, lv);
            Residencia res= ((BaseApplication) getContext().getApplicationContext()).getResidencia();


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
