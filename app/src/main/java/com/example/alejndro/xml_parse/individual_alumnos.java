package com.example.alejndro.xml_parse;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class individual_alumnos extends Activity {

    // cramos los nodos de la aplicacion
    static final String KEY_NC = "no_control";
    static final String KEY_NOMBRE = "nomblre";
    static final String KEY_APP = "apellido_p";
    static final String KEY_APM = "apellido_m";
    static final String KEY_CARRERA = "carrera";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_alumnos);

        // intent
        Intent in = getIntent();
        //variables
        String no_control = in.getStringExtra(KEY_NC);
        String nomblre = in.getStringExtra(KEY_NOMBRE);
        String apellido_p = in.getStringExtra(KEY_APP);
        String apellido_m = in.getStringExtra(KEY_APM);
        String carrera = in.getStringExtra(KEY_CARRERA);

        //variabls con si elementos graficos
        TextView noc=(TextView)findViewById(R.id.clave2);
        TextView nom=(TextView)findViewById(R.id.nombre2);
        TextView app=(TextView)findViewById(R.id.apellidop2);
        TextView apm=(TextView)findViewById(R.id.apellidom2);
        TextView car=(TextView)findViewById(R.id.carrera2);

        noc.setText(no_control);
        nom.setText(nomblre);
        app.setText(apellido_p);
        apm.setText(apellido_m);
        car.setText(carrera);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_individual_alumnos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
