package com.example.usuario.ulpapp;


import android.content.pm.ActivityInfo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto: abc@xyz.com"));
                startActivity(Intent.createChooser(emailIntent, "Send feedback"));
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//Actualizo el Frame Principal para que de entrada muestre las noticias

        principal_Fragment principal=new principal_Fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.relative_for_frag,
                principal,
                principal.getTag()
        ).commit();

    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_institucional) {

            Inst_Fragment institucional=new Inst_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    institucional,
                    institucional.getTag()
            ).commit();

            // Handle the camera action
        }   else if (id == R.id._contacto) {
            contacto_Fragment contacto=new contacto_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    contacto,
                    contacto.getTag()
            ).commit();

        } else if (id == R.id._residencias) {
            ImageView imagen=(ImageView)findViewById(R.id.LogoEstaticoMain);
            ListView texto=(ListView)findViewById(R.id.listView);
            imagen.setVisibility(View.INVISIBLE);
            texto.setVisibility(View.INVISIBLE);

            resi_Fragment residencias=new resi_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    residencias,
                    residencias.getTag()
            ).commit();

        }else if (id == R.id.nav_prin) {
            //Accedo a la imagen de cabecera y al listView ambos de Content_Main
            final ImageView imagen=(ImageView)findViewById(R.id.LogoEstaticoMain);
            ListView lv=(ListView) findViewById(R.id.listView);
            //Los hago invisibles
            imagen.setVisibility(View.VISIBLE);
            lv.setVisibility(View.VISIBLE);
            imagen.setAdjustViewBounds(true);

            principal_Fragment principal=new principal_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    principal,
                    principal.getTag()
            ).commit();
        }else if (id == R.id._carreras) {
            //Accedo a la imagen de cabecera y al listView ambos de Content_Main

            ImageView imagen=(ImageView)findViewById(R.id.LogoEstaticoMain);
            ListView texto=(ListView) findViewById(R.id.listView);
            //Los hago invisibles
            imagen.setVisibility(View.INVISIBLE);

            carrera_Fragment carreras= new carrera_Fragment();


            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.relative_for_frag,
                    carreras,
                    carreras.getTag()
            ).commit();



        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }







}
