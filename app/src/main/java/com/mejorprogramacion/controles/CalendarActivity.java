package com.mejorprogramacion.controles;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    TextView TxtFecha, TxtHoras;
    Button BtnFecha,BtnHoras;
    DatePicker DatePicker;
    TimePicker TimePicker;
    int Año, Mes, Dia, Hora, Min, Seg;
    String Horario = " a.m.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        TxtFecha = (TextView) findViewById(R.id.TxtFecha);
        TxtHoras = (TextView) findViewById(R.id.TxtHoras);
        BtnFecha = (Button) findViewById(R.id.BtnFecha);
        BtnFecha.setOnClickListener(new ClickEvent());
        BtnHoras = (Button) findViewById(R.id.BtnHoras);
        BtnHoras.setOnClickListener(new ClickEvent());

        Calendar Calendario = Calendar.getInstance();
        Dia = Calendario.get(Calendar.DAY_OF_MONTH);
        Mes = Calendario.get(Calendar.MONTH);
        Año = Calendario.get(Calendar.YEAR);
        Hora = Calendario.get(Calendar.HOUR);
        Min = Calendario.get(Calendar.MINUTE);
        Seg = Calendario.get(Calendar.SECOND);

        if(Calendario.get(Calendar.HOUR_OF_DAY)>12) Horario = " p.m.";
        else Horario = " a.m.";

       CambiarFecha(Año,Mes+1,Dia);
       CambiarHoras(Hora,Min,Seg,Horario);

        DatePicker = (DatePicker) findViewById(R.id.Calendario);
        DatePicker.init(Año, Mes, Dia, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                CambiarFecha(year,month+1,day);
            }
        });

        TimePicker = (TimePicker) findViewById(R.id.Horas);
        TimePicker.setOnTimeChangedListener(new android.widget.TimePicker.OnTimeChangedListener(){
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay>12) Horario = " p.m.";
                else Horario = " a.m.";
                CambiarHoras(hourOfDay,minute,Seg,Horario);
            }});
    }

    class ClickEvent implements View.OnClickListener {
        public void onClick(View Btn) {
            if (Btn == BtnFecha) {
                ObtenerFecha();
            }
            if(Btn == BtnHoras){
                ObtenerHora();
            }
        }
    }

    private  void CambiarFecha(int Año, int Mes, int Dia){
        String CeroD = "", CeroM = "";
        if(Dia<10) CeroD = "0";
        if(Mes<10) CeroM = "0";
        TxtFecha.setText(CeroD + Dia + " / " + CeroM + Mes + " / " + Año);
    }

    private void CambiarHoras(int Hora, int Min, int Seg, String Horario){
        String CeroH = "", CeroM = "", CeroS="";
        if(Hora<10) CeroH = "0";
        if(Min<10) CeroM = "0";
        if(Seg<10) CeroS = "0";
        TxtHoras.setText(CeroH + Hora + " : " + CeroM + Min + " : " + CeroS + Seg + Horario);
    }

    private void ObtenerFecha(){
        DatePickerDialog SeleccionarFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                CambiarFecha(year,month+1,dayOfMonth);
            }
        },Año, Mes, Dia);
        SeleccionarFecha.show();
    }

    private void ObtenerHora(){
        TimePickerDialog SeleccionarHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay>12) Horario = " p.m.";
                else Horario = " a.m.";
                CambiarHoras(hourOfDay,minute,Seg, Horario);
            }
        }, Hora, Min, false);
        SeleccionarHora.show();
    }

}
