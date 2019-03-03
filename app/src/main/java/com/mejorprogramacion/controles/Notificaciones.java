package com.mejorprogramacion.controles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Notificaciones extends AppCompatActivity {

    Button BtnToast, BtnDialog, BtnBarraEstado, BtnBarraInferior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        setTitle("Notificaciones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BtnToast = (Button)findViewById(R.id.BtnToast);
        BtnToast.setOnClickListener(new ClickEvent());

        BtnDialog = (Button)findViewById(R.id.BtnDialog);
        BtnDialog.setOnClickListener(new ClickEvent());

        BtnBarraEstado = (Button)findViewById(R.id.BtnBarraEstado);
        BtnBarraEstado.setOnClickListener(new ClickEvent());

        BtnBarraInferior = (Button)findViewById(R.id.BtnBarraInferior);
        BtnBarraInferior.setOnClickListener(new ClickEvent());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(Notificaciones.this,Principal.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ClickEvent implements View.OnClickListener {
        public void onClick(View Btn) {
            if(Btn == BtnToast){
                Intent i = new Intent(Notificaciones.this,ToastActivity.class);
                startActivity(i);
            }else if(Btn == BtnDialog){
                Intent i = new Intent(Notificaciones.this,DialogoActivity.class);
                startActivity(i);
            }else if(Btn == BtnBarraEstado){
                Intent i = new Intent(Notificaciones.this,PushActivity.class);
                startActivity(i);
            }else if(Btn == BtnBarraInferior){
                Intent i = new Intent(Notificaciones.this,SnackbarActivity.class);
                startActivity(i);
            }

        }
    }



}
