package com.mejorprogramacion.controles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    Button BtnToastNormal, BtnToastGravity, BtnToastCustom, BtnToastCustom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        setTitle("Toast");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BtnToastNormal = (Button)findViewById(R.id.BtnToastNormal);
        BtnToastNormal.setOnClickListener(new ClickEvent());

        BtnToastGravity = (Button)findViewById(R.id.BtnToastGravity);
        BtnToastGravity.setOnClickListener(new ClickEvent());

        BtnToastCustom = (Button)findViewById(R.id.BtnToastCustom);
        BtnToastCustom.setOnClickListener(new ClickEvent());

        BtnToastCustom2 = (Button)findViewById(R.id.BtnToastCustom2);
        BtnToastCustom2.setOnClickListener(new ClickEvent());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(ToastActivity.this,Notificaciones.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ClickEvent implements View.OnClickListener {
        public void onClick(View Btn) {
            if(Btn == BtnToastNormal){
                Toast ToastNormal =  Toast.makeText(ToastActivity.this, "Mensaje Toast Normal", Toast.LENGTH_SHORT);
                ToastNormal.show();
            }else if(Btn == BtnToastGravity){
                Toast ToastGravity =  Toast.makeText(ToastActivity.this, "Mensaje Toast Gravity", Toast.LENGTH_SHORT);
                ToastGravity.setGravity(Gravity.CENTER,0,0);
                ToastGravity.show();
            }else if(Btn == BtnToastCustom){
                LayoutInflater Inflater = getLayoutInflater();
                View Layout = Inflater.inflate(R.layout.toast_custom, (ViewGroup) findViewById(R.id.ToastCustom1));
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(Layout);
                toast.show();
            }else if(Btn == BtnToastCustom2){
                LayoutInflater Inflater = getLayoutInflater();
                View Layout = Inflater.inflate(R.layout.toast_custom_2, (ViewGroup) findViewById(R.id.ToastCustom2));
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(Layout);
                toast.show();
            }
        }
    }


}