package com.mejorprogramacion.controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class OoptionsActivity extends AppCompatActivity {

    Spinner CmbOpciones;
    CheckBox ChkRutaLunes, ChkRutaMiercoles, ChkRutaViernes;
    RadioButton RadioCrear, RadioConsultar, RadioEliminar;
    Button BtnComprobar;
    RadioGroup RadioOpciones;
    TextView LblResultado;

    String CmbCatalogo="", RadioAcciones="", ChkRutaL="", ChkRutaM="", ChkRutaV="", Resultado="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ooptions);

        CmbOpciones = (Spinner) findViewById(R.id.CmbOpciones);
        ChkRutaLunes = (CheckBox) findViewById(R.id.ChkRuta1);
        ChkRutaMiercoles = (CheckBox) findViewById(R.id.ChkRuta2);
        ChkRutaViernes = (CheckBox) findViewById(R.id.ChkRuta3);

        ArrayList<String> ArregloOpciones = new ArrayList<String>();
        String [] Opciones = new String[] {"", "Clientes", "Proveedores", "Articulos"};
        Collections.addAll(ArregloOpciones, Opciones);

        ArrayAdapter<String> ListaSpinner = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, R.id.TxtSpinerItem,ArregloOpciones);
        CmbOpciones.setAdapter(ListaSpinner);
        CmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView,View selectedItemView, int position, long id) {
                CmbCatalogo = parentView.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        RadioCrear = (RadioButton) findViewById(R.id.RadioCrear);
        RadioConsultar = (RadioButton) findViewById(R.id.RadioConsultar);
        RadioEliminar = (RadioButton) findViewById(R.id.RadioEliminar);
        RadioOpciones = (RadioGroup) findViewById(R.id.RadioGrupo);
        RadioOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.RadioCrear:
                        RadioAcciones = "Crear";
                        break;
                    case R.id.RadioConsultar:
                        RadioAcciones = "Consultar";
                        break;
                    case R.id.RadioEliminar:
                        RadioAcciones = "Eliminar";
                        break;
                }
            }
        });

        LblResultado = (TextView) findViewById(R.id.LblResultado);
        BtnComprobar = (Button) findViewById(R.id.BtnOpciones);
        BtnComprobar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (ChkRutaLunes.isChecked()) ChkRutaL = "Lunes"; else ChkRutaL = "";
                if (ChkRutaMiercoles.isChecked()) ChkRutaM = "Miercoles"; else ChkRutaM = "";
                if (ChkRutaViernes.isChecked()) ChkRutaV = "Viernes"; else ChkRutaV = "";

                if(!ChkRutaL.equals("") && !ChkRutaM.equals("") && !ChkRutaV.equals("")) ChkRutaL += ", ";
                else if(!ChkRutaL.equals("") && !ChkRutaM.equals("")) ChkRutaL += ", ";
                else if(!ChkRutaL.equals("") && !ChkRutaV.equals("")) ChkRutaL += ", ";
                if(!ChkRutaM.equals("") && !ChkRutaV.equals("")) ChkRutaM += ", ";



               if(!Resultado.equals("")){
                   Resultado = "";
               }else {
                   Resultado = "Vas a " + RadioAcciones + " las rutas " + ChkRutaL + ChkRutaM + ChkRutaV + " del catalogo de " +  CmbCatalogo;
               }
                LblResultado.setText(Resultado);
            }
        });
    }
}
