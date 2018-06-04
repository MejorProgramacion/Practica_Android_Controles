package com.mejorprogramacion.controles;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity{

    TextView TxtCambioTexto;
    Button BtnCambiarTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        TxtCambioTexto = (TextView) findViewById(R.id.TxtCambioTexto);
        BtnCambiarTexto = (Button) findViewById(R.id.BtnCambiarTexto);
        BtnCambiarTexto.setOnClickListener(new ClickEvent());


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
