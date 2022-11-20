package com.example.usuario.ahorcado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.util.Random;

public class Dialogoganador extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.ganaste, null));
        builder.setNegativeButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(getActivity(),MainActivity.class);
                Random r=new Random();
                int i=(r.nextInt(6)+1);
                String aux = String.valueOf(i);
                intent.putExtra("Dato",aux);
                startActivity(intent);
            }
        }).setPositiveButton("Seleccionar Categoria", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(getActivity(),PrimeraActividad.class);
                startActivity(intent);
            }
        });
        return builder.create();
    }
}
