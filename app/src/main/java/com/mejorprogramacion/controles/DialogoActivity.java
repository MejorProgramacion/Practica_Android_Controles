package com.mejorprogramacion.controles;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogoActivity extends AppCompatActivity {

    Button BtnDialogAlert, BtnDialogLayout;
    final private static int DIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo);

        setTitle("Dialogos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BtnDialogAlert = (Button) findViewById(R.id.BtnDialogAlert);
        BtnDialogAlert.setOnClickListener(new ClickEvent());
        BtnDialogLayout = (Button) findViewById(R.id.BtnDialogoLayout);
        BtnDialogLayout.setOnClickListener(new ClickEvent());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(DialogoActivity.this, Notificaciones.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ClickEvent implements View.OnClickListener {
        public void onClick(View Btn) {
            if (Btn == BtnDialogAlert) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogoActivity.this);

                builder.setTitle("Titulo del dialogo")
                        .setMessage("Descripción para el usuario")
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(DialogoActivity.this, "Respuesta Positiva", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("CANCELAR",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(DialogoActivity.this, "Respuesta Negativa", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNeutralButton("DESPUES",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(DialogoActivity.this, "Respuesta Neutral", Toast.LENGTH_SHORT).show();
                                    }
                                });
                builder.show();

            } else if (Btn == BtnDialogLayout) {
                showDialog(DIALOG);
            }
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog dialogDetails = null;

        switch (id) {
            case DIALOG:
                LayoutInflater inflater = LayoutInflater.from(this);
                View dialogview = inflater.inflate(R.layout.dialog_layout, null);

                AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);
                dialogbuilder.setCancelable(false);
                dialogbuilder.setView(dialogview);
                dialogDetails = dialogbuilder.create();
                break;
        }
        return dialogDetails;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        switch (id) {
            case DIALOG:
                //Instanciamos todos los controles que contiene nuestro dialogo
                final AlertDialog alertDialog = (AlertDialog) dialog;
                final EditText TxtDescripcion = (EditText) alertDialog.findViewById(R.id.TxtDescripcion);

                final Button BtnAceptar = (Button) alertDialog.findViewById(R.id.BtnAceptar);
                final Button BtnCancelar = (Button) alertDialog.findViewById(R.id.BtnCancelar);

                BtnAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogoActivity.this, TxtDescripcion.getText().toString(), Toast.LENGTH_SHORT).show();
                        TxtDescripcion.setText("");
                        alertDialog.dismiss();
                    }
                });
                BtnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                break;
        }
    }



}