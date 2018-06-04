package com.mejorprogramacion.controles;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
