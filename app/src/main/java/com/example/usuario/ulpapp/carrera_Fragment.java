package com.example.usuario.ulpapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.Database.model.Carrera;
import com.example.usuario.ulpapp.Database.model.Residencia;
import com.example.usuario.ulpapp.mycarreraa;


/**
 * A simple {@link Fragment} subclass.
 */
public class carrera_Fragment extends Fragment implements   View.OnClickListener{

    private Carrera carrera1= new Carrera(null,null,1);



    public carrera_Fragment() {
        // Required empty public constructor
    }
    TextView text;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_carrera_, container, false);
        Button btDesarrollo = (Button) rootView.findViewById(R.id._desarrollo);
        Button btGestion = (Button) rootView.findViewById(R.id._gestion);
        Button btTurismo = (Button) rootView.findViewById(R.id._turismo);
        Button btGuia = (Button) rootView.findViewById(R.id._guiaT);


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
