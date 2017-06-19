package com.example.usuario.ulpapp.parser;

/**
 * Created by Usuario on 25/05/2017.
 */
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.usuario.ulpapp.Application.BaseApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class UlpParser {
    private static final String PREF_IS_RUNNING ="conexion" ;
    private URL rssUrl;
    private Context context;

    public UlpParser(String url,Context context)
    {
        Log.d("Parser","On");
        this.context=context;
        try
        {
            this.rssUrl = new URL(url);
        }
        catch (MalformedURLException e)
        {
            Log.d("Parser","Error");
            throw new RuntimeException(e);
        }
    }

    public void parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try
        {
            SAXParser parser = factory.newSAXParser();
            Log.d("Parser","Parseando");
            UlpHandler handler = new UlpHandler(context);
            parser.parse(this.getInputStream(), handler);

            ((BaseApplication)context).insertarNoticias(handler.getNoticias()); ;
            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            mNotificationManager.cancel(23492);
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
            SharedPreferences.Editor editor = pref.edit();

            editor.putBoolean(PREF_IS_RUNNING, true);
            editor.apply();
        }
        catch (Exception e)
        {
            Log.d("Errorrrrrr","er");
            throw new RuntimeException(e);
        }
    }

    private InputStream getInputStream()
    {
        try
        {
            return rssUrl.openConnection().getInputStream();
        }
        catch (IOException e)
        {
            Log.d("Error otro","Error");

            throw new RuntimeException(e);
        }
    }




}

