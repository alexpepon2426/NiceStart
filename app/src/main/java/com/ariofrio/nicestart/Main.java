package com.ariofrio.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class Main extends AppCompatActivity {
    private TextView mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //TextView mycontext = findViewById(R.id.vista);
        mycontext = findViewById(R.id.vista);
        registerForContextMenu(mycontext);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "item copied", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.item2) {
            final ConstraintLayout mLayout = findViewById(R.id.main);
            Snackbar snackbar = Snackbar
                    .make(mLayout,"Esto es un snackbar",Snackbar.LENGTH_LONG)
                    .setAction("Deshacer", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout,"Accion Deshecha",Snackbar.LENGTH_LONG);
                            snackbar1.show();

                        }
                    });
            snackbar.show();
            return true;
        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.item1) {
//            showAlertDialogButtonClicked(Main.this);

            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();

        }
        if (id == R.id.item2) {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            Intent intent = new Intent(this,Profile.class);
            startActivity(intent);
            toast.show();
        }

        return super.onOptionsItemSelected(item);
    }

}