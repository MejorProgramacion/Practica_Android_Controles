package com.mejorprogramacion.controles;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

public class ListAdapter extends SimpleCursorAdapter {

    private Cursor cursor;

    public ListAdapter(Context contexto, Cursor cursor, String[] from, int[] to) {
        super(contexto, R.layout.list_item, cursor, from, to);
        this.cursor = cursor;
    }

}