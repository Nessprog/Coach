package com.example.coach.controleur;

import android.content.Context;

import com.example.coach.modele.AccesLocal;
import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

import java.util.Date;

public final class Controle {

    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    private static AccesLocal accesLocal;

    /**
     * Constructeur private
     */
    private Controle(){
        super();
    }

    /**
     * Création de l'instance
     * @return instance
     */
    public static final Controle getInstance(Context contexte){
        if(Controle.instance == null){
            Controle.instance = new Controle();
            accesLocal = new AccesLocal(contexte);
            profil = accesLocal.recupDernier();
           // recupSerialize(contexte);
        }
        return Controle.instance;
    }

    /**
     *
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme et 0 pour femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context contexte){
        profil = new Profil(new Date(),poids, taille, age, sexe);
       // Serializer.serialize(nomFic, profil, contexte);
        accesLocal.ajout(profil);
    }

    /**
     * Récupération img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * Récupération message de profil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * récupération de l'objet serialisé (le profil)
     * @param contexte
     */
    private static void recupSerialize(Context contexte) {
        profil = (Profil)Serializer.deSerialise(nomFic, contexte);
    }

    public Integer getPoids(){
        if(profil == null){
            return null;
        }else{
            return profil.getPoids();
        }
    }

    public Integer getTaille(){
        if(profil == null){
            return null;
        }else{
            return profil.getTaille();
        }
    }

    public Integer getAge(){
        if(profil == null){
            return null;
        }else{
            return profil.getAge();
        }
    }

    public Integer getSexe(){
        if(profil == null){
            return null;
        }else{
            return profil.getSexe();
        }
    }
}

