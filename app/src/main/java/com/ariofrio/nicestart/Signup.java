package com.ariofrio.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        ImageView mboy = findViewById(R.id.boy);
        Glide.with(this)
                        .load("https://images.unsplash.com/photo-1728915687386-8558c8dff0df?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                                .transition(DrawableTransitionOptions.withCrossFade(1000))
                                        .centerCrop()
                                                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.orange)))
                                                        .into(mboy);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goLogin(View view) {
        Intent intent = new Intent(Signup.this,Login.class);
        startActivity(intent);
    }

    public void goMain(View view) {
        Intent intent = new Intent(Signup.this, Profile.class);
        startActivity(intent);
    }
}