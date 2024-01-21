package com.example.coach.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //propriétés
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;


    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init(){
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        rdFemme = (RadioButton) findViewById(R.id.rdFemme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        ecouteCalcul();
        this.controle = Controle.getInstance(this);
        //recupProfil();
    }

    /**
     * Ecoute évènements sur bouton Calcul
     */
    private void ecouteCalcul(){
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
               // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();

                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;
                // récupération des données saisies
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch (Exception e) {};
                if(rdHomme.isChecked()){
                    sexe = 1;
                }
                // contrôle des données saisies
                if(poids==0 || taille==0 || age==0){
                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                }else{
                    afficheResult(poids, taille, age, sexe);
                }
            }
        });
    }

    /**
     * affichage de l'IMG, du messge et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe){
        //création du profil et récupération des informations
        this.controle.creerProfil(poids, taille, age, sexe, this);
        float img = this.controle.getImg();
        String message = this.controle.getMessage();
        //affichage
        if(message=="normal"){
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setTextColor(Color.GREEN);
        }else{
            lblIMG.setTextColor(Color.RED);
            if(message=="trop faible"){
                imgSmiley.setImageResource(R.drawable.maigre);
            }else{
                imgSmiley.setImageResource(R.drawable.graisse);
            }
        }
        lblIMG.setText(String.format("%.01f", img)+" : IMG "+message);

    }

    /**
     * Récupération du profil s'il a été serialisé
     */
    private void recupProfil(){
        if(controle.getPoids() != null){
            txtPoids.setText(controle.getPoids().toString());
            txtTaille.setText(controle.getTaille().toString());
            txtAge.setText(controle.getAge().toString());
            rdFemme.setChecked(true);
            if(controle.getSexe()==1) {
                rdHomme.setChecked(true);
            }
            //Simule le clic sur le bouton calcul
            ((Button)findViewById(R.id.btnCalc)).performClick();
        }
    }
}