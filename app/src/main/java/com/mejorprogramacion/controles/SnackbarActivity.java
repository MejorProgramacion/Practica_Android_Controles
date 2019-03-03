package com.mejorprogramacion.controles;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SnackbarActivity extends AppCompatActivity {

    Button BtnNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        setTitle("Snackbar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BtnNotificacion = (Button)findViewById(R.id.BtnNotificacion);
        BtnNotificacion.setOnClickListener(new ClickEvent());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(SnackbarActivity.this, Notificaciones.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ClickEvent implements View.OnClickListener{
        public void onClick(View Btn){
            if(Btn == BtnNotificacion){
                Snackbar.make(Btn, "Snackbar Notificación", Snackbar.LENGTH_LONG)
                        .setAction("Toast", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(SnackbarActivity.this, "Toast Ejemplo", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        }
    }
}
