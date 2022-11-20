package com.example.usuario.ahorcado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PrimeraActividad extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button boton;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_actividad);
        radioGroup=(RadioGroup)findViewById(R.id.radiogrupo);
        boton=(Button) findViewById(R.id.button);
        texto=(TextView)findViewById(R.id.textView);
        boton.setOnClickListener(this);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
      setSupportActionBar(toolbar1);


    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.primero,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(menuItem.getItemId()==R.id.opcion1primero){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            System.exit(0);
        }
        return  super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View v) {
        if(R.id.button==v.getId()){
            Intent intent=new Intent(PrimeraActividad.this,MainActivity.class);
            if(radioGroup.getCheckedRadioButtonId()==R.id.radioButtonAnimales){
                intent.putExtra("Dato","1");
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.radioButtonCiudades){
                intent.putExtra("Dato","2");
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.radioButtonFrutas){
                intent.putExtra("Dato","3");
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.radioButtonPaises){
                intent.putExtra("Dato","4");
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.radioButtonNombres){
                intent.putExtra("Dato","5");
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.radioButtonComics){
                intent.putExtra("Dato","6");
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.radioButtonAleatorio){
                Random r=new Random();
                int i=(r.nextInt(5)+1);
                String aux = String.valueOf(i);
                intent.putExtra("Dato",aux);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Seleccione primero una opcion",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
