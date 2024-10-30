package com.ariofrio.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        openApp();
        ImageView thunder = findViewById(R.id.logosplash);
        TextView nom = findViewById(R.id.txtIni);

        Animation animTxt = AnimationUtils.loadAnimation(this,R.anim.fade);
        nom.startAnimation(animTxt);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.rotate_ani);
        thunder.startAnimation(myanim);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openApp() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//abre la tarea de Login
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);//Borra la tarea anterior, en este caso la de splash
                startActivity(intent);
            }
        }, 5000);
    }
}