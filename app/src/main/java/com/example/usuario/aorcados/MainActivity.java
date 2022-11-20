package com.example.usuario.ahorcado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public TextView texto1, respuesta, textiempo, puntajemax, puntaje, textoFinal;
    public TextView letras[] = new TextView[11];
    public TextView lineas[] = new TextView[11];
    public ImageView imagen, imagenfinal;
    public String palabra;
    public char cadena[];
    public int tamaño = 0, contadoraciertos = 0, contadorfallas = 0;
    public MediaPlayer mp;
    public String categoria = "1";
    public  CountDownTimer contandor;
    private boolean def;
    public Button botones[]=new Button[28];
    public void setDef(boolean def) {
        this.def = def;
    }

    public boolean isDef() {
        return def;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        declarciones();
        capturareventos();
        String linea = null;

        try {
            InputStream fraw = getResources().openRawResource(R.raw.puntaje);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            linea = brin.readLine();
            fraw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }
        puntajemax.setText(linea.split(",")[0]);
        puntaje.setText(linea.split(",")[1]);
        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            int dato = Integer.parseInt(extra.getString("Dato"));
            Random r = new Random();
            int i = 1;
            if (dato == 1) {
                texto1.setText(texto1.getText() + " ANIMALES");
                i = (r.nextInt(84));
                categoria = "1";
            } else if (dato == 2) {
                texto1.setText(texto1.getText() + " CIUDADES");
                i = (r.nextInt(62));
                categoria = "2";
            } else if (dato == 3) {
                texto1.setText(texto1.getText() + " FRUTAS");
                i = (r.nextInt(40));
                categoria = "3";
            } else if (dato == 4) {
                texto1.setText(texto1.getText() + " PAISES");
                i = (r.nextInt(125));
                categoria = "4";
            } else if (dato == 5) {
                texto1.setText(texto1.getText() + " NOMBRES");
                i = (r.nextInt(80));
                categoria = "5";
            } else if (dato == 6) {
                texto1.setText(texto1.getText() + " COMICS");
                i = (r.nextInt(80));
                categoria = "6";
            }
            try {
                obtener_data(i, dato);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(menuItem.getItemId()==R.id.opcion1){
            contandor.cancel();
            Intent intent=new Intent(getApplicationContext(),PrimeraActividad.class);
            startActivity(intent);
        }
        else if(menuItem.getItemId()==R.id.opcion2){
            Toast.makeText(getApplicationContext(),"Que ha hecho cara de techo",Toast.LENGTH_LONG).show();
        }else if(menuItem.getItemId()==R.id.opcion3){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            System.exit(0);
        }
        return  super.onOptionsItemSelected(menuItem);
    }

    public void declarciones() {
        texto1 = (TextView) findViewById(R.id.textViewfinal);
        imagenfinal = (ImageView) findViewById(R.id.imagenfianl);
        texto1 = (TextView) findViewById(R.id.Categoria);
        textiempo = (TextView) findViewById(R.id.textiempo);
        puntajemax = (TextView) findViewById(R.id.puntajemax);
        puntaje = (TextView) findViewById(R.id.puntaje);
        respuesta = (TextView) findViewById(R.id.respuesta);
        imagen = (ImageView) findViewById(R.id.imagen);
        botones[1] = (Button) findViewById(R.id.botonA);
        botones[2] = (Button) findViewById(R.id.botonB);
        botones[3] = (Button) findViewById(R.id.botonC);
        botones[4] = (Button) findViewById(R.id.botonD);
        botones[5] = (Button) findViewById(R.id.botonE);
        botones[6] = (Button) findViewById(R.id.botonF);
        botones[7] = (Button) findViewById(R.id.botonG);
        botones[8] = (Button) findViewById(R.id.botonH);
        botones[9] = (Button) findViewById(R.id.botonI);
        botones[10] = (Button) findViewById(R.id.botonJ);
        botones[11] = (Button) findViewById(R.id.botonK);
        botones[12] = (Button) findViewById(R.id.botonL);
        botones[13] = (Button) findViewById(R.id.botonM);
        botones[14] = (Button) findViewById(R.id.botonN);
        botones[15] = (Button) findViewById(R.id.botonÑ);
        botones[16] = (Button) findViewById(R.id.botonO);
        botones[17] = (Button) findViewById(R.id.botonP);
        botones[18] = (Button) findViewById(R.id.botonQ);
        botones[19] = (Button) findViewById(R.id.botonR);
        botones[20] = (Button) findViewById(R.id.botonS);
        botones[21] = (Button) findViewById(R.id.botonT);
        botones[23] = (Button) findViewById(R.id.botonV);
        botones[22] = (Button) findViewById(R.id.botonU);
        botones[24] = (Button) findViewById(R.id.botonW);
        botones[25] = (Button) findViewById(R.id.botonX);
        botones[26] = (Button) findViewById(R.id.botonY);
        botones[27] = (Button) findViewById(R.id.botonZ);

        lineas[0] = (TextView) findViewById(R.id.txtlinea1);
        lineas[1] = (TextView) findViewById(R.id.txtlinea2);
        lineas[2] = (TextView) findViewById(R.id.txtlinea3);
        lineas[3] = (TextView) findViewById(R.id.txtlinea4);
        lineas[4] = (TextView) findViewById(R.id.txtlinea5);
        lineas[5] = (TextView) findViewById(R.id.txtlinea6);
        lineas[6] = (TextView) findViewById(R.id.txtlinea7);
        lineas[7] = (TextView) findViewById(R.id.txtlinea8);
        lineas[8] = (TextView) findViewById(R.id.txtlinea9);
        lineas[9] = (TextView) findViewById(R.id.txtlinea10);
        lineas[10] = (TextView) findViewById(R.id.txtlinea11);
        letras[0] = (TextView) findViewById(R.id.txtletra1);
        letras[1] = (TextView) findViewById(R.id.txtletra2);
        letras[2] = (TextView) findViewById(R.id.txtletra3);
        letras[3] = (TextView) findViewById(R.id.txtletra4);
        letras[4] = (TextView) findViewById(R.id.txtletra5);
        letras[5] = (TextView) findViewById(R.id.txtletra6);
        letras[6] = (TextView) findViewById(R.id.txtletra7);
        letras[7] = (TextView) findViewById(R.id.txtletra8);
        letras[8] = (TextView) findViewById(R.id.txtletra9);
        letras[9] = (TextView) findViewById(R.id.txtletra10);
        letras[10] = (TextView) findViewById(R.id.txtletra11);
        contandor = new CountDownTimer(50000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textiempo.setText("" + millisUntilFinished/1000);
                if (millisUntilFinished < 10000) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.conteo);
                        textiempo.setTextColor(Color.RED);
                        mp.start();
                }
            }
            @Override
            public void onFinish() {
                    filtro('#');
            }
        }.start();
    }

    public void capturareventos() {
        botones[1].setOnClickListener(this);
        botones[2].setOnClickListener(this);
        botones[3].setOnClickListener(this);
        botones[4].setOnClickListener(this);
        botones[5].setOnClickListener(this);
        botones[6].setOnClickListener(this);
        botones[7].setOnClickListener(this);
        botones[8].setOnClickListener(this);
        botones[9].setOnClickListener(this);
        botones[10].setOnClickListener(this);
        botones[11].setOnClickListener(this);
        botones[12].setOnClickListener(this);
        botones[13].setOnClickListener(this);
        botones[14].setOnClickListener(this);
        botones[15].setOnClickListener(this);
        botones[16].setOnClickListener(this);
        botones[17].setOnClickListener(this);
        botones[18].setOnClickListener(this);
        botones[19].setOnClickListener(this);
        botones[20].setOnClickListener(this);
        botones[21].setOnClickListener(this);
        botones[22].setOnClickListener(this);
        botones[23].setOnClickListener(this);
        botones[24].setOnClickListener(this);
        botones[25].setOnClickListener(this);
        botones[26].setOnClickListener(this);
        botones[27].setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botonA) {
            botones[1].setTextColor(Color.BLACK);
            botones[1].setEnabled(false);
            filtro('a');
        }
        if (v.getId() == R.id.botonB) {
            botones[2].setTextColor(Color.BLACK);
            botones[2].setEnabled(false);
            filtro('b');
        }
        if (v.getId() == R.id.botonC) {
            botones[3].setTextColor(Color.BLACK);
            botones[3].setEnabled(false);
            filtro('c');
        }
        if (v.getId() == R.id.botonD) {
            botones[4].setTextColor(Color.BLACK);
            botones[4].setEnabled(false);
            filtro('d');
        }
        if (v.getId() == R.id.botonE) {
            botones[5].setTextColor(Color.BLACK);
            botones[5].setEnabled(false);
            filtro('e');
        }
        if (v.getId() == R.id.botonF) {
            botones[6].setTextColor(Color.BLACK);
            botones[6].setEnabled(false);
            filtro('f');
        }
        if (v.getId() == R.id.botonG) {
            botones[7].setTextColor(Color.BLACK);
            botones[7].setEnabled(false);
            filtro('g');
        }
        if (v.getId() == R.id.botonH) {
            botones[8].setTextColor(Color.BLACK);
            botones[8].setEnabled(false);
            filtro('h');
        }
        if (v.getId() == R.id.botonI) {
            botones[9].setTextColor(Color.BLACK);
            botones[9].setEnabled(false);
            filtro('i');
        }
        if (v.getId() == R.id.botonJ) {
            botones[10].setTextColor(Color.BLACK);
            botones[10].setEnabled(false);
            filtro('j');
        }
        if (v.getId() == R.id.botonK) {
            botones[11].setTextColor(Color.BLACK);
            botones[11].setEnabled(false);
            filtro('k');
        }
        if (v.getId() == R.id.botonL) {
            botones[12].setTextColor(Color.BLACK);
            botones[12].setEnabled(false);
            filtro('l');
        }
        if (v.getId() == R.id.botonM) {
            botones[13].setTextColor(Color.BLACK);
            botones[13].setEnabled(false);
            filtro('m');
        }
        if (v.getId() == R.id.botonN) {
            botones[14].setTextColor(Color.BLACK);
            botones[14].setEnabled(false);
            filtro('n');
        }
        if (v.getId() == R.id.botonÑ) {
            botones[15].setTextColor(Color.BLACK);
            botones[15].setEnabled(false);
            filtro('ñ');
        }
        if (v.getId() == R.id.botonO) {
            botones[16].setTextColor(Color.BLACK);
            botones[16].setEnabled(false);
            filtro('o');
        }
        if (v.getId() == R.id.botonP) {
            botones[17].setTextColor(Color.BLACK);
            botones[17].setEnabled(false);
            filtro('p');
        }
        if (v.getId() == R.id.botonQ) {
            botones[18].setTextColor(Color.BLACK);
            botones[18].setEnabled(false);
            filtro('q');
        }
        if (v.getId() == R.id.botonR) {
            botones[19].setTextColor(Color.BLACK);
            botones[19].setEnabled(false);
            filtro('r');
        }
        if (v.getId() == R.id.botonS) {
            botones[20].setTextColor(Color.BLACK);
            botones[20].setEnabled(false);
            filtro('s');
        }
        if (v.getId() == R.id.botonT) {
            botones[21].setTextColor(Color.BLACK);
            botones[21].setEnabled(false);
            filtro('t');
        }
        if (v.getId() == R.id.botonU) {
            botones[22].setTextColor(Color.BLACK);
            botones[22].setEnabled(false);
            filtro('u');
        }
        if (v.getId() == R.id.botonV) {
            botones[23].setTextColor(Color.BLACK);
            botones[23].setEnabled(false);
            filtro('v');
        }
        if (v.getId() == R.id.botonW) {
            botones[24].setTextColor(Color.BLACK);
            botones[24].setEnabled(false);
            filtro('w');
        }
        if (v.getId() == R.id.botonX) {
            botones[25].setTextColor(Color.BLACK);
            botones[25].setEnabled(false);
            filtro('x');
        }
        if (v.getId() == R.id.botonY) {
            botones[26].setTextColor(Color.BLACK);
            botones[26].setEnabled(false);
            filtro('y');
        }
        if (v.getId() == R.id.botonZ) {
            botones[27].setTextColor(Color.BLACK);
            botones[27].setEnabled(false);
            filtro('z');
        }
    }

    public void obtener_data(int n, int categoria) throws IOException {
        String linea = null;
        InputStream fraw = null;
        try {
            if (categoria == 1) {
                fraw = getResources().openRawResource(R.raw.animales);
            } else if (categoria == 2) {
                fraw = getResources().openRawResource(R.raw.ciudades);
            } else if (categoria == 3) {
                fraw = getResources().openRawResource(R.raw.frutas);
            } else if (categoria == 4) {
                fraw = getResources().openRawResource(R.raw.paises);
            } else if (categoria == 5) {
                fraw = getResources().openRawResource(R.raw.nombres);
            } else if (categoria == 6) {
                fraw = getResources().openRawResource(R.raw.comics);
            }
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            linea = brin.readLine();
            fraw.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }
        palabra = linea.split(",")[n];
        cadena = palabra.toCharArray();
        tamaño = cadena.length;
        dibujarlineas(tamaño);
    }

    public void dibujarlineas(int c) {
        for (int i = 0; i <= 10 - c; i++) {
            lineas[10 - i].setVisibility(View.INVISIBLE);
        }

    }

    public void filtro(char caracter) {
        int contador = 0;
        boolean fin = false;
        if(caracter=='#'){
            contadorfallas=5;
        }

        for (int i = 0; i < tamaño; i++) {
            if (cadena[i] == caracter) {
                contadoraciertos++;
                letras[i].setText("" + cadena[i]);
            } else {
                contador++;
                if (contador == tamaño) {
                    contadorfallas++;
                    if (contadorfallas == 1) {
                        imagen.setImageResource(R.drawable.ima1);
                    } else if (contadorfallas == 2) {
                        imagen.setImageResource(R.drawable.ima2);
                    } else if (contadorfallas == 3) {
                        imagen.setImageResource(R.drawable.ima4);
                    } else if (contadorfallas == 4) {
                        imagen.setImageResource(R.drawable.ima5);
                    } else {
                        imagen.setImageResource(R.drawable.ima6);
                        Animation animation= AnimationUtils.loadAnimation(this,R.anim.alpha);
                        imagen.startAnimation(animation);
                        fin = true;
                    }
                }

            }

        }
        if (fin == true) {
            contandor.cancel();
            respuesta.setText("La respuestes es: " + palabra);
            bloquear();
            reproductor(false);
            setDef(false);
        }
        if (contadoraciertos == tamaño) {
            contandor.cancel();
            imagen.setImageResource(R.drawable.ganador);
            Animation animation= AnimationUtils.loadAnimation(this,R.anim.trans);
            imagen.startAnimation(animation);
            setDef(true);
            bloquear();
            reproductor(true);
        }

    }
    public void bloquear(){
        for(int i=1;i<28;i++){
            botones[i].setEnabled(false);
        }
    }

    public void reproductor(final boolean filtra) {

        if (filtra == true) {
            mp = MediaPlayer.create(MainActivity.this, R.raw.victoria);
        } else {
            mp = MediaPlayer.create(MainActivity.this, R.raw.derrota);
        }
        mp.start();
        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                confirmacion();
            }
        }.start();
    }

    public void confirmacion() {
        FragmentManager fragmentManager = getFragmentManager();
        if (isDef() == true) {
            Dialogoganador dialogoganador = new Dialogoganador();
            dialogoganador.show(fragmentManager, "confirmacion");
        } else {
            DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
            dialogoConfirmacion.show(fragmentManager, "confirmacion");
        }

    }


    public void puntos(boolean sentecia) {
        if (sentecia == true) {
            try {
                OutputStreamWriter fout =
                        new OutputStreamWriter(
                                openFileOutput("R/res/raw/puntaje.txt", Context.MODE_PRIVATE));
                fout.write("" + puntajemax.getText() + "," + 50 + "," + 1);
                fout.close();
            } catch (Exception ex) {
                Log.e("Ficheros", "Error al escribir fichero a memoria interna");
            }


        }
    }

}
