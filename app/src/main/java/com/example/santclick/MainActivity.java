package com.example.santclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button cab;
    private Button cli;
    private Button lab;
    private Button pha;
    private Button rad;
    private Button hop;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.cab = (Button) findViewById(R.id.cab);
        this.cli = (Button) findViewById(R.id.cli);
        this.lab = (Button) findViewById(R.id.lab);
        this.pha = (Button) findViewById(R.id.pha);
        this.rad = (Button) findViewById(R.id.rad);
        this.hop = (Button) findViewById(R.id.hop);

        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cabinet = new Intent(getApplicationContext(), CabinetMedical.class);
                startActivity(cabinet);

            }

        });
        cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Clinique = new Intent(getApplicationContext(), Clinique.class);
                startActivity(Clinique);

            }
        });

        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent laboratoire = new Intent(getApplicationContext(), laboratoire.class);
                startActivity(laboratoire);

            }
        });


        pha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pharmacie = new Intent(getApplicationContext(), pharmacie.class);
                startActivity(pharmacie);

            }
        });
        rad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent radiologue = new Intent(getApplicationContext(), radiologue.class);
                startActivity(radiologue);

            }
        });
        hop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hopital = new Intent(getApplicationContext(), hopital.class);
                startActivity(hopital);

            }
        });
    }
}
