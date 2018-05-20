package com.mejorprogramacion.controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    TextView TxtCambioTexto;
    Button BtnCambiarTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        TxtCambioTexto = (TextView) findViewById(R.id.TxtCambioTexto);
        BtnCambiarTexto = (Button) findViewById(R.id.BtnButton);



    }
}
