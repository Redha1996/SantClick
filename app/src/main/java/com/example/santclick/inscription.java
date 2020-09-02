package com.example.santclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class inscription extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG ="inscription";
    private Button add;
    private EditText nom;
    private EditText prenom;
    private EditText numero;
    private EditText mail;
    private EditText adresse;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        add = (Button) findViewById(R.id.add);
        prenom = (EditText) findViewById(R.id.prenom);
        numero = (EditText) findViewById(R.id.numero);
        mail = (EditText) findViewById(R.id.mail);
        adresse = (EditText) findViewById(R.id.adresse);
        spinner = (Spinner) findViewById(R.id.spinner);

        //Setting the ArrayAdapter data on the Spinner
        spinner.setOnItemSelectedListener(this);
    }


    @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            }

            @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
