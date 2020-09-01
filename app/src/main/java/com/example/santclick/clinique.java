package com.example.santclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clinique extends AppCompatActivity {

    /*private ListView cardio_list;
    private ArrayAdapter aAdapter;
    private String[] users = { "Suresh Dasari", "Rohini Alavala", "Trishika Dasari", "Praveen Alavala", "Madav Sai", "Hamsika Yemineni"};
*/
    private static final String BASE_URL = "https://raw.githubusercontent.com/Redha1996/SantClick/master/";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinique);

        sharedPreferences = getSharedPreferences("clinique_display", Context.MODE_PRIVATE);
        gson = new GsonBuilder().setLenient().create();

        List<ListClinique> cliniqueList = getDataFromCache();

        if(cliniqueList != null) {
            showList(cliniqueList);
        }else{
            makeApiCall();
        }


        // cardio_list = (ListView) findViewById(R.id.clinique_list);
        //aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        //cardio_list.setAdapter(aAdapter);
    }

    private List<ListClinique> getDataFromCache() {
       String jsonClinique = sharedPreferences.getString("jsonCliniqueList",null);
       if (jsonClinique == null){
           return null;
       } else {
           Type listType = new TypeToken<List<ListClinique>>(){}.getType();
           return gson.fromJson(jsonClinique, listType);
       }

    }


    private void showList( List<ListClinique> cliniqueList){
        recyclerView = (RecyclerView) findViewById(R.id.clinic_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
       /* List<String> input = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                input.add("Test" + i);
        }// define an adapter */
        mAdapter = new ListAdapterClinique(cliniqueList);
        recyclerView.setAdapter(mAdapter);
    }


    private void makeApiCall(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        CliniqueApi cliniqueApi= retrofit.create(CliniqueApi.class);


        Call<RestCliniqueResponse> call = cliniqueApi.getCliniqueResponse();

        call.enqueue(new Callback<RestCliniqueResponse>() {

          @Override
          public void onResponse(Call<RestCliniqueResponse> call, Response<RestCliniqueResponse> response) {
              if (response.isSuccessful() && response.body() != null) {
                  List<ListClinique> ListClinique = response.body().getResults();
                  saveList(ListClinique);
                  Toast.makeText(getApplicationContext(), "API Success", Toast.LENGTH_SHORT).show();
                  showList(ListClinique);

              } else {
                  showError();
              }
          }


          @Override
          public void onFailure(Call<RestCliniqueResponse> call, Throwable t) {
              showError();
          }
      });

    }

    private void saveList(List<ListClinique> cliniqueList){
        String jsonString = gson.toJson(cliniqueList);
        sharedPreferences
                .edit()
                .putString("jsonCliniqueList", jsonString)
                .apply();
        Toast.makeText(getApplicationContext(), "List good", Toast.LENGTH_SHORT).show();

    }

    public void showError (){
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();

    }
}