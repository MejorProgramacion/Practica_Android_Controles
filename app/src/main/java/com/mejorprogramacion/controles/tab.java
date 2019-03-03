package com.mejorprogramacion.controles;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class tab extends Fragment {

    ImageView Imagen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        Drawable myDrawable = getResources().getDrawable(R.drawable.youtube_boton);

        Imagen = (ImageView) view.findViewById(R.id.Imagen1);
        Imagen.setImageDrawable(myDrawable);

        return view;
    }
}
