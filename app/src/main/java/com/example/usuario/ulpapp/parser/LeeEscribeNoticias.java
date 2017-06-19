package com.example.usuario.ulpapp.parser;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.usuario.ulpapp.Application.BaseApplication;
import com.example.usuario.ulpapp.MainActivity;
import com.example.usuario.ulpapp.R;
import com.example.usuario.ulpapp.principal_Fragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Usuario on 16/06/2017.
 */

public class LeeEscribeNoticias extends IntentService {



    public static final String ACTION_PROGRESO ="com.example.usuario.ulpapp.parser.PROGRESO";
    public static final String ACTION_FIN ="com.example.usuario.ulpapp.parser.FIN";

    //Constructor
    public LeeEscribeNoticias(){
        super("LeeEscribeNoticias");
    }






    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("Servicio","Servicio");
        ((BaseApplication) getApplicationContext()).vaciarTabla();
         UlpParser ulp=new UlpParser("http://noticias.ulp.edu.ar/rss/ultimas_rss.rss",getApplicationContext());
        ulp.parse();
        Intent bcIntent = new Intent();
        bcIntent.setAction(ACTION_FIN);
        sendBroadcast(bcIntent);



    }




}
