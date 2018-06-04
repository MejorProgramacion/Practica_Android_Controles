package com.mejorprogramacion.controles;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class ListViewActivity extends AppCompatActivity {

    ListView Listado;
    private ListAdapter cursorAdapter;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        db = openOrCreateDatabase("mejor_p", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS clientes (Id INTEGER PRIMARY KEY, Nombre NVARCHAR(100), Telefono NVARCHAR(100), Pais NVARCHAR(15), Estado NVARCHAR(15))");
        db.execSQL("DELETE FROM clientes");
        db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('Juan Perez','5512365894','México','CDMX')");
        db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('John Smith','8004568465','USA','New York')");
        db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('Fulanito De Tal','6612365894','México','Oaxaca')");
        db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('Martina Flores','3312365894','México','Jalisco')");
        db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('Pia Molina','9638527410','España','Barcelona')");
        db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('Iñaki Secada','9632584563','España','Madrid')");
        db.execSQL("INSERT INTO clientes (Nombre, Telefono, Pais, Estado) VALUES ('Madison Taylor','7412586541','USA','California')");

        Listado = (ListView)findViewById(R.id.Listado);
        Listado.setOnItemClickListener(new OnItemClickListener() {public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                Cursor Persona = db.rawQuery("SELECT Nombre,Telefono FROM clientes WHERE Id=" + id,null);
                Persona.moveToFirst();
                String Nombre = Persona.getString(0);
                String Telefono = Persona.getString(1);

            Toast.makeText(ListViewActivity.this, "Nombre: " + Nombre + ", Teléfono: " + Telefono, Toast.LENGTH_SHORT).show();
            }
        });

        CrearLista();
        registerForContextMenu(Listado);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        android.view.MenuInflater inflater = getMenuInflater();

       // AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(android.view.MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.opcion_borrar:
                db.execSQL("DELETE FROM clientes WHERE Id=" + (int) info.id);
                CrearLista();
                return true;
            default:
                return super.onContextItemSelected((android.view.MenuItem) item);
        }
    }

    private void CrearLista() {
        Cursor cursor = db.rawQuery("SELECT Id AS _id,Nombre,Telefono,Pais,Estado FROM clientes", null);
        String[] from = new String[] { "Nombre", "Telefono", "Pais", "Estado"};
        int[] to = new int[] { R.id.TxtNombre, R.id.TxtTelefono, R.id.TxtPais, R.id.TxtEstado};

        cursorAdapter = new ListAdapter(this, cursor, from, to);
        Listado.setAdapter(cursorAdapter);
    }
}
