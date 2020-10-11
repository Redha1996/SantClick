package com.example.santclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.Toast;

public class CabinetMedical extends AppCompatActivity {
    private MedecinDbAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet_medical);
        dbHelper = new MedecinDbAdapter(this);
        dbHelper.open();


        //Clean all data
        dbHelper.deleteAllMedecins();
        //Add some data
        dbHelper.insertSomeMedecin();

        //Generate ListView from SQLite Database
        displayListView();

    }

    private void displayListView() {


        Cursor cursor = dbHelper.fetchAllMedecins();

        // The desired columns to be bound
        String[] columns = new String[] {
                MedecinDbAdapter.KEY_PHONE,
                MedecinDbAdapter.KEY_NAME,
                MedecinDbAdapter.KEY_SPE,
                MedecinDbAdapter.KEY_Adress
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.phone,
                R.id.name,
                R.id.spe,
                R.id.adress,
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.layout_medecin_info,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
                String medecinCode =
                        cursor.getString(cursor.getColumnIndexOrThrow("phone"));
                Toast.makeText(getApplicationContext(),
                        medecinCode, Toast.LENGTH_SHORT).show();

            }
        });

        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return dbHelper.fetchMedecinsByName(constraint.toString());
            }
        });

    }
}
