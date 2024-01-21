package com.example.coach.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.coach.outils.MySQLiteOpenHelper;

import java.util.Date;

public class AccesLocal {

    //propriétés
    private String nomBase = "bdCoach.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    /**
     * Constructeur
     * @param contexte
     */
    public AccesLocal(Context contexte){
        accesBD = new MySQLiteOpenHelper(contexte, nomBase, null, versionBase);
    }

    /**
     * Ajout d'un profil dans la base de données
     * @param profil
     */
    public void ajout(Profil profil) {
        bd = accesBD.getWritableDatabase();
        String req = "insert into profil (datemesure, poids, taille, age, sexe) values ";
        req += "(\""+profil.getDateMesure()+"\","+profil.getPoids()+","+profil.getTaille()+","+profil.getAge()+","+profil.getSexe()+")";
        bd.execSQL(req);
    }

    /**
     * récupération du dernier profil de la base de données
     * @return
     */
    public Profil recupDernier(){
        bd = accesBD.getReadableDatabase();
        Profil profil = null;
        String req = "select * from profil";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date dateMesure = new Date();
            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            profil = new Profil(dateMesure, poids, taille, age, sexe);
        }
        curseur.close();
        return profil;
    }
}
