package com.mejorprogramacion.controles;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.sql.DatabaseMetaData;

public class BaseDatosActivity extends AppCompatActivity {

    Button BtnInsert, BtnUpdate, BtnDelete;
    int Conteo = 1;
    String Registro = "";
    SQLiteDatabase db;
    SQLiteDatabase dt;
    ListView Lista;
    private ListAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);

        setTitle("Base de datos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = openOrCreateDatabase("mejor_p", Context.MODE_PRIVATE, null);

        /*File dbFile = new File("/sdcard/Controles/mejor_p.db");
        dt = SQLiteDatabase.openOrCreateDatabase(dbFile, null);
        dt = SQLiteDatabase.openOrCreateDatabase("/sdcard/Controles/mejor_p.db", null);
        */

        db.execSQL("CREATE TABLE IF NOT EXISTS clientes (Id INTEGER PRIMARY KEY, Nombre NVARCHAR(100), Telefono NVARCHAR(100), Pais NVARCHAR(15), Estado NVARCHAR(15))");
        db.execSQL("DELETE FROM clientes");

        BtnInsert = (Button) findViewById(R.id.BtnInsert);
        BtnInsert.setOnClickListener(new ClicEvent());

        BtnUpdate = (Button) findViewById(R.id.BtnUpdate);
        BtnUpdate.setOnClickListener(new ClicEvent());

        BtnDelete = (Button) findViewById(R.id.BtnDelete);
        BtnDelete.setOnClickListener(new ClicEvent());

        Lista = (ListView) findViewById(R.id.ListaBD);
        CrearLista();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(BaseDatosActivity.this, Principal.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ClicEvent implements View.OnClickListener{
        public void onClick(View Btn){
            if(Btn == BtnInsert){
                Registro = "Registro " + Conteo;
                db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('Registro " + Conteo + "','','','')");
                Conteo++;
                CrearLista();
            }
            else if(Btn == BtnUpdate){
                db.execSQL("UPDATE clientes SET Nombre='Regostro Modificado " + Conteo + "' WHERE Id IN (SELECT Id FROM clientes ORDER BY Id DESC LIMIT 1)");
                Conteo++;
                CrearLista();
            }
            else if(Btn == BtnDelete){
                db.execSQL("DELETE FROM clientes WHERE Id IN (SELECT Id FROM clientes ORDER BY Id DESC LIMIT 1)");
                Conteo--;
                CrearLista();
            }
        }
    }

    private void CrearLista() {
        //
        Cursor cursor = db.rawQuery("SELECT Id AS _id,Id || ' ' || Nombre AS Nombre,'' AS Telefono,'' AS Pais,'' AS Estado FROM clientes", null);
        String[] from = new String[] { "Nombre", "Telefono", "Pais", "Estado"};
        int[] to = new int[] { R.id.TxtNombre, R.id.TxtTelefono, R.id.TxtPais, R.id.TxtEstado};

        cursorAdapter = new ListAdapter(this, cursor, from, to);
        Lista.setAdapter(cursorAdapter);
    }

}
