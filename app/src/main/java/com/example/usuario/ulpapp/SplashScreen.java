package com.example.usuario.ulpapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private final  int splash =2800;
    TextView mensaje;
    private static final int DURACION=1500;
    private  static final int TIEMPO_DESPUES=1000;

    private final int REPETICION=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final AlphaAnimation fadeIn=new AlphaAnimation(0.0f,1.0f);
        fadeIn.setDuration(DURACION);
        fadeIn.setStartOffset(TIEMPO_DESPUES);
        fadeIn.setFillAfter(true);

        mensaje=(TextView)findViewById(R.id.Mensaje_Intro);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                mensaje.setText(String.valueOf("Tu decisión, tu futuro"));
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mensaje.startAnimation(fadeIn);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, splash);

    }

}
