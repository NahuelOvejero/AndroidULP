package com.example.usuario.ulpapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class carrera_Fragment extends Fragment {

    private static String parameter;



    public carrera_Fragment() {
        // Required empty public constructor
    }
    TextView text;


    public static  void setParameter(String p) {
       parameter = p;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_carrera_, container, false);
        text = (TextView)view.findViewById(R.id.name_carrera);
        text.setText(parameter);


        return view;
    }

}
