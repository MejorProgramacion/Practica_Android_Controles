package com.mejorprogramacion.controles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button BtnTextView, BtnEditText, BtnButton, BtnListView, BtnCalendar, BtnOptions, BtnImages, BtnTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BtnTextView = (Button) findViewById(R.id.BtnTextView);
        BtnTextView.setOnClickListener(new ClickEvent());

        BtnEditText = (Button) findViewById(R.id.BtnEditText);
        BtnEditText.setOnClickListener(new ClickEvent());

        BtnButton = (Button) findViewById(R.id.BtnButton);
        BtnButton.setOnClickListener(new ClickEvent());

        BtnListView = (Button) findViewById(R.id.BtnListView);
        BtnListView.setOnClickListener(new ClickEvent());

        BtnCalendar = (Button) findViewById(R.id.BtnCalendar);
        BtnCalendar.setOnClickListener(new ClickEvent());

        BtnOptions = (Button) findViewById(R.id.BtnOptions);
        BtnOptions.setOnClickListener(new ClickEvent());

        BtnImages = (Button) findViewById(R.id.BtnImages);
        BtnImages.setOnClickListener(new ClickEvent());

        BtnTabs = (Button) findViewById(R.id.BtnTabs);
        BtnTabs.setOnClickListener(new ClickEvent());

    }


    class ClickEvent implements View.OnClickListener{
        public void onClick(View Btn){
            if(Btn == BtnTextView){
                Intent i = new Intent(Principal.this,TextViewActivity.class);
                startActivity(i);
            }
            else if(Btn == BtnEditText){
                Intent i = new Intent(Principal.this,EditTextActivity.class);
                startActivity(i);
            }
            else if(Btn == BtnButton){
                Intent i = new Intent(Principal.this,ButtonActivity.class);
                startActivity(i);
            }
            else if(Btn == BtnListView){
                Intent i = new Intent(Principal.this,ListViewActivity.class);
                startActivity(i);
            }
            else if(Btn == BtnCalendar){
                Intent i = new Intent(Principal.this,CalendarActivity.class);
                startActivity(i);
            }
            else if(Btn == BtnOptions){
                Intent i = new Intent(Principal.this,OoptionsActivity.class);
                startActivity(i);
            }
            else if(Btn == BtnImages){
                Intent i = new Intent(Principal.this,ImageActivity.class);
                startActivity(i);
            }
            else if(Btn == BtnTabs){
                Intent i = new Intent(Principal.this,TabActivity.class);
                startActivity(i);
            }

        }
    }





}