package com.mejorprogramacion.controles;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewActivity extends AppCompatActivity{

    TextView TxtCambioTexto;
    Button BtnCambiarTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TxtCambioTexto = (TextView) findViewById(R.id.TxtCambioTexto);
        BtnCambiarTexto = (Button) findViewById(R.id.BtnCambiarTexto);
        BtnCambiarTexto.setOnClickListener(new ClickEvent());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(TextViewActivity.this,Principal.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ClickEvent implements View.OnClickListener{
        public void onClick(View Btn){
            if(Btn == BtnCambiarTexto){
                TxtCambioTexto.setText("Este texto fue cambiado por código");
                TxtCambioTexto.setTextColor(Color.RED);
            }
        }
    }
}
