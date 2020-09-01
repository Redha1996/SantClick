package com.example.santclick;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Clinique_Details extends AppCompatActivity {
    private TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinique_details);

        txtDetail = findViewById(R.id.detail_clinique_view);
        Intent intent = getIntent();
        String listCliniquejson = intent.getStringExtra("CliniqueKey");
        ListClinique Clinique = clinique.getGson().fromJson(listCliniquejson, ListClinique.class);
        shwoDetail(Clinique);
    }

    private void shwoDetail(ListClinique Clinique) {
        txtDetail.setText(Clinique.getName());
    }
}