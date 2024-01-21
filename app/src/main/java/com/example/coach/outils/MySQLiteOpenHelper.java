package com.example.coach.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //propriétés
    private String creation="create table profil("
            + "datemesure TEXT PRIMARY KEY,"
            + "poids INTEGER NOT NULL,"
            + "taille INTEGER NOT NULL,"
            + "age INTEGER NOT NULL,"
            + "sexe INTEGER NOT NULL);";
    /**
     * Constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Si changement de base de données
     * @param sqlLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqlLiteDatabase) {
        sqlLiteDatabase.execSQL(creation);
    }

    /**
     * Si changement de version
     * @param sqLiteDatabase The database.
     * @param i ancienne version
     * @param il nouvelle versonin.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {

    }
}
