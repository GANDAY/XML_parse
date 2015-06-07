package com.example.alejndro.xml_parse;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

public class principal extends ListActivity{
    //URL del archivo almacenado en un servidor online
    static final String URL ="http://eulisesrdz.260mb.net/alejandro/";

    //Nodos XML del archivo y tags utilizados en la aplicacion
    static final String KEY_TAG = "alumno"; // Nodo padre
    static final String KEY_NC = "no_control"; // Nodos de los atributos
    static final String KEY_NOMBRE = "nomblre";
    static final String KEY_APP = "apellido_p";
    static final String KEY_APM = "apellido_m";
    static final String KEY_CARRERA = "carrera";

    @Override
    protected void onCReate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Arreglo que almacenara los datos
        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        final  XMLparser parser = new XMLparser();
        String xml = parser.getXmlFromUrl(URL);
        Document doc = parser.getDomElement(xml);

        //Identifica el nodo padre de los regisros del archivo
        NodeList nl = doc.getElementsByTagName(KEY_TAG);
        //Contador para leer cada uno de los registros
        for (int i = 1; i < nl.getLength(); i++){
            //Creando nuevo arreglo
            HashMap<String, String> map = new HashMap<String, String>();
            org.w3c.dom.Element e = (Element) nl.item(i);

            //Agregando cada uno de los registros en el arreglo
            map.put(KEY_NC,parser.getValue(( e, KEY_NC));
            map.put(KEY_NOMBRE, parser.getValue(e, KEY_NOMBRE));
            map.put(KEY_APP,parser.getValue(e, KEY_APP));
            map.put(KEY_APM,parser.getValue(e, KEY_APM));
            map.put(KEY_CARRERA,parser.getValue(e, KEY_CARRERA));
            menuItems.add(map);
        }

        ListAdapter adapter = new SimpleAdapter(this, menuItems, R.layout.list_alumno, new String[]{KEY_NC, KEY_NOMBRE, KEY_CARRERA}, new int[]{R.id.clave2_2, R.id.nombre2_2, R.id.carrera2_2} );

        setListAdapter(adapter);

        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clv = ((TextView) view.findViewById(R.id.clave2)).getText().toString();
                String nom =((TextView) view.findViewById(R.id.nombre2)).getText().toString();
                String app =((TextView) view.findViewById(R.id.apellidop2)).getText().toString();
                String apm =((TextView) view.findViewById(R.id.apellidom2)).getText().toString();
                String car =((TextView) view.findViewById(R.id.carrera2)).getText().toString();

                Intent in = new Intent(getApplicationContext(), individual_alumnos.class);
                in.putExtra(KEY_NC,clv);
                in.putExtra(KEY_NOMBRE,nom);
                in.putExtra(KEY_APP,app);
                in.putExtra(KEY_APM,apm);
                in.putExtra(KEY_CARRERA,car);
                startActivity(in);

            }
        });


    }

}
