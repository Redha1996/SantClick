package com.example.santclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CabinetMedical extends AppCompatActivity {

    private Button car;
    private Button chirdent;
    private Button der;
    private Button gen;
    private Button gas;
    private Button gyn;
    private Button oph;
    private Button ort;
    private Button ped;
    private Button pne;
    private Button psy;
    private Button rad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet_medical);

        this.car = (Button) findViewById(R.id.car);
        this.chirdent = (Button) findViewById(R.id.chirdent);
        this.der = (Button) findViewById(R.id.der);
        this.gen = (Button) findViewById(R.id.gen);
        this.gas = (Button) findViewById(R.id.gas);
        this.gyn = (Button) findViewById(R.id.gyn);
        this.oph = (Button) findViewById(R.id.oph);
        this.ort = (Button) findViewById(R.id.ort);
        this.ped = (Button) findViewById(R.id.ped);
        this.psy = (Button) findViewById(R.id.psy);
        this.rad = (Button) findViewById(R.id.rad);
        this.pne = (Button) findViewById(R.id.pne);

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardiologue = new Intent(getApplicationContext(),cardiologue.class);
                startActivity(cardiologue);
            }
        });
        chirdent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chirdent;
                chirdent = new Intent(getApplicationContext(),chirdent.class);
                startActivity(chirdent);
            }
        });
        der.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dermatologue = new Intent(getApplicationContext(),dermatologue.class);
                startActivity(dermatologue);
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent generaliste = new Intent(getApplicationContext(),generaliste.class);
                startActivity(generaliste);
            }
        });
        gyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gynecologue = new Intent(getApplicationContext(),gynecologue.class);
                startActivity(gynecologue);
            }
        });
        gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gastrologue = new Intent(getApplicationContext(),gastrologue.class);
                startActivity(gastrologue);
            }
        });
        oph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ophtalmologiste = new Intent(getApplicationContext(),ophtalmologiste.class);
                startActivity(ophtalmologiste);
            }
        });
        ped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pediatre = new Intent(getApplicationContext(),pediatre.class);
                startActivity(pediatre);
            }
        });
        pne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pneumologue = new Intent(getApplicationContext(), pneumologue.class);
                startActivity(pneumologue);
            }
        });
        psy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent psychiatre = new Intent(getApplicationContext(),psychiatre.class);
                startActivity(psychiatre);
            }
        });
        ort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orthopediste = new Intent(getApplicationContext(),orthopediste.class);
                startActivity(orthopediste);
            }
        });
        rad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent radiologue = new Intent(getApplicationContext(),radiologue.class);
                startActivity(radiologue);
            }
        });
    }
}
