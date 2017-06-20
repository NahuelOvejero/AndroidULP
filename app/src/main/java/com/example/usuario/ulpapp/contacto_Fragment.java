package com.example.usuario.ulpapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;


import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Lugar;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class contacto_Fragment extends Fragment{


    private LayoutInflater inflater;
    private ViewGroup parent;
    private ListView lv;
    private Integer listaFotos = new Integer(0);
    private MapView mapView,ictMap;
    private GoogleMap ulpMapa,ictMapa;
    private Lugar ulp,ict;
    private LatLng latLngULP,latLngICT;
    public contacto_Fragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_contacto_, container, false);
        ulp=((BaseApplication)getContext().getApplicationContext()).getULP();
        ict=((BaseApplication)getContext().getApplicationContext()).getICT();
        latLngICT=new LatLng(ict.getLat(),ict.getLng());
        latLngULP=new LatLng(ulp.getLat(),ulp.getLng());
        mapView=(MapView)v.findViewById(R.id.mapULP);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(new mapaULP());
        ictMap=(MapView)v.findViewById(R.id.mapICT);
        ictMap.onCreate(savedInstanceState);
        ictMap.onResume();
        ictMap.getMapAsync(new mapaICT());
        ImageView im=(ImageView) v.findViewById(R.id.contactoPortada);
        ((TextView)v.findViewById(R.id.telULP)).setText("Teléfono: "+ulp.getTelefono());
        ((TextView)v.findViewById(R.id.dirULP)).setText("Dirección: "+ulp.getDireccion());
        ((TextView)v.findViewById(R.id.dirICT)).setText("Dirección: "+ict.getDireccion());
        ((TextView)v.findViewById(R.id.telICT)).setText("Teléfono: "+ict.getTelefono());
        TextView urlSitioWeb=((TextView)v.findViewById(R.id.urlWebSite));
        urlSitioWeb.setText(Html.fromHtml("<a href=\"http://www.ulp.edu.ar\">Universidad de La Punta</a>"));
        urlSitioWeb.setClickable(true);
        urlSitioWeb.setMovementMethod(LinkMovementMethod.getInstance());
        listaFotos=((BaseApplication)getContext().getApplicationContext()).getCabeceraContacto();
        im.setImageResource(listaFotos);
        return v;
    }

    private class mapaULP  implements OnMapReadyCallback{
        @Override
        public void onMapReady(GoogleMap map){
            ulpMapa =map;
            CameraPosition camPos=new CameraPosition.Builder().target(latLngULP).zoom(19).bearing(45).tilt(70).build();
            CameraUpdate camUpdULP= CameraUpdateFactory.newCameraPosition(camPos);
            ulpMapa.animateCamera(camUpdULP);
            map.addMarker(new MarkerOptions().position(latLngULP)).setTitle("ULP");

        }

    }
    private class mapaICT  implements OnMapReadyCallback{
        @Override
        public void onMapReady(GoogleMap map){
            ictMapa =map;
            CameraPosition camPos=new CameraPosition.Builder().target(latLngICT).zoom(19).bearing(45).tilt(70).build();
            CameraUpdate camUpdICT= CameraUpdateFactory.newCameraPosition(camPos);
           ictMapa.animateCamera(camUpdICT);

            map.addMarker(new MarkerOptions().position(latLngICT)).setTitle("ICT");
        }
    }
}

