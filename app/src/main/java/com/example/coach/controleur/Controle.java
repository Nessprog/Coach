package com.example.coach.controleur;

import com.example.coach.modele.Profil;

public final class Controle {

    private static Controle instance = null;
    private Profil profil;

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
    public static final Controle getInstance(){
        if(Controle.instance == null){
            Controle.instance = new Controle();
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
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){
        profil = new Profil(poids, taille, age, sexe);
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
}

