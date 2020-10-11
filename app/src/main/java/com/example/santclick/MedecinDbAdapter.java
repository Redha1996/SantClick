package com.example.santclick;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MedecinDbAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_NAME = "name";
    public static final String KEY_SPE = "spe";
    public static final String KEY_Adress = "adress";

    private static final String TAG = "MedecinDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "World";
    private static final String SQLITE_TABLE = "Medecin";
    private static final int DATABASE_VERSION = 2;

    private final Context mCtx;

    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                    KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                    KEY_PHONE + "," +
                    KEY_NAME + "," +
                    KEY_SPE + "," +
                    KEY_Adress + "," +
                    " UNIQUE (" + KEY_PHONE +"));";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
            onCreate(db);
        }
    }

    public MedecinDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public MedecinDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public long createMedecin(String phone, String name, String spe, String address) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_PHONE, phone);
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_SPE, spe);
        initialValues.put(KEY_Adress, address);

        return mDb.insert(SQLITE_TABLE, null, initialValues);
    }

    public boolean deleteAllMedecins() {

        int doneDelete = 0;
        doneDelete = mDb.delete(SQLITE_TABLE, null , null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

    public Cursor fetchMedecinsByName(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
                            KEY_PHONE, KEY_NAME, KEY_SPE, KEY_Adress},
                    null, null, null, null, null);

        }
        else {
            mCursor = mDb.query(true, SQLITE_TABLE, new String[] {KEY_ROWID,
                            KEY_PHONE, KEY_NAME, KEY_SPE, KEY_Adress},
                    KEY_SPE + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public Cursor fetchAllMedecins() {

        Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
                        KEY_PHONE, KEY_NAME, KEY_SPE, KEY_Adress},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public void insertSomeMedecin() {

        createMedecin("0664864468","Karina","Pediatre","Vigneux Sur seine ");
        createMedecin("0762017599","Redha","Cardiologue","Alger Centre ");
        createMedecin("0771850125","Mehdi","Ophtalmologue","Oran ");
        createMedecin("0771680088","Youcef","Gynécologue","Setif ");
        createMedecin("0553521197","Tahar","Orthopédiste","Annaba");
        createMedecin("0662062187","Leila","Generaliste","Alger Centre ");
        createMedecin("0663954126","Amine","Dentiste","Alger Centre ");
        createMedecin("0754169853","Nesrine","Ophtalmologue","Alger Centre ");
        createMedecin("0123569874","Sami","Cardiologue","Alger Centre ");
        createMedecin("0123654789","Tamila","Pediatre","Alger Centre ");
        createMedecin("0762017599","Neil","Cardiologue","Alger Centre ");
        createMedecin("0762017598","Jenna","Ophtalmologue","Alger Centre ");
        createMedecin("0762017597","Mohamed","Cardiologue","Alger Centre ");
        createMedecin("0762017596","Nadia","Cardiologue","Alger Centre ");
        createMedecin("0762017595","Fares","Ophtalmologue","Alger Centre ");
        createMedecin("0762017594","Ilyas","Pediatre","Alger Centre ");
        createMedecin("0762017593","Sofiane","Cardiologue","Alger Centre ");
        createMedecin("0762017592","Anis","Generaliste","Alger Centre ");
        createMedecin("0762017591","Rabah","Orthopédiste","Alger Centre ");
        createMedecin("0762017590","Mohand","Generaliste","Alger Centre ");
        createMedecin("0762017589","Salim","Cardiologue","Alger Centre ");
        createMedecin("0762017588","Fouzi","Pneumologue","Alger Centre ");
        createMedecin("0762017587","Said","Dentiste","Alger Centre ");

    }
}
