package com.example.coach.modele;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

public class ProfilTest {

    // création profil
    private Profil profil = new Profil(new Date(), 63, 160, 35, 0);
    //resultat IMG
    private float img =(float)32.2;
    //message
    private String message = "trop élevé";

    @Test
    public void getImg() throws Exception{
        assertEquals(img, profil.getImg(), (float)0.1);
    }

    @Test
    public void getMessage() throws Exception {
        assertEquals(message, profil.getMessage());
    }
}