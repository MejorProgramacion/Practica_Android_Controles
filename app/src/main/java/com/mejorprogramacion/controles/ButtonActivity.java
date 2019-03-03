package com.mejorprogramacion.controles;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    Button BtnNormal, BtnRectangular;
    ImageButton BtnImagen,BtnImagen2, BtnVector;
    FloatingActionButton BtnFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        setTitle("Buttons");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BtnNormal = (Button) findViewById(R.id.BtnNormal);
        BtnNormal.setOnClickListener(new ClickEvent());
        BtnRectangular = (Button) findViewById(R.id.BtnRectangular);
        BtnRectangular.setOnClickListener(new ClickEvent());
        BtnImagen = (ImageButton) findViewById(R.id.BtnImagen);
        BtnImagen.setOnClickListener(new ClickEvent());
        BtnImagen2 = (ImageButton) findViewById(R.id.BtnImagen2);
        BtnImagen2.setOnClickListener(new ClickEvent());
        BtnVector = (ImageButton) findViewById(R.id.BtnVector);
        BtnVector.setOnClickListener(new ClickEvent());
        BtnFloat = (FloatingActionButton) findViewById(R.id.BtnFloat);
        BtnFloat.setOnClickListener(new ClickEvent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.botones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(ButtonActivity.this,Principal.class);
                startActivity(i);
                return true;
            case R.id.MenuAgregar:
                Toast.makeText(getApplicationContext(),"Agregar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MenuRegresar:
                Toast.makeText(getApplicationContext(),"Regresar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MenuEnviar:
                Toast.makeText(getApplicationContext(),"Enviar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MenuGuardar:
                Toast.makeText(getApplicationContext(),"Guardar", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    class ClickEvent implements View.OnClickListener{
        public void onClick(View Btn){
            if(Btn == BtnNormal){
                Toast.makeText(getApplicationContext(),"Botton normal", Toast.LENGTH_SHORT).show();
            }
            else if(Btn == BtnRectangular){
                Toast.makeText(getApplicationContext(),"Boton con estilo rectangular", Toast.LENGTH_SHORT).show();
            }
            else if(Btn == BtnFloat){
                Toast.makeText(getApplicationContext(),"Boton flotante", Toast.LENGTH_SHORT).show();
            }
            else if(Btn == BtnImagen){
                Toast.makeText(getApplicationContext(),"Boton con imagen sin redimencionar", Toast.LENGTH_SHORT).show();
            }
            else if(Btn == BtnImagen2){
                Toast.makeText(getApplicationContext(),"Boton con imagen redimencionada", Toast.LENGTH_SHORT).show();
            }
            else if(Btn == BtnVector){
                Toast.makeText(getApplicationContext(),"Boton con un icono de vector", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
