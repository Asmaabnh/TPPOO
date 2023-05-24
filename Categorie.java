import java.util.List;

import javafx.scene.paint.Color;

public class Categorie {
    


    private String nom;
    private Color couleur ; 



    public Categorie(String nom , Color couleur) {
        this.nom = nom;
        this.couleur = couleur;

    }

    public Categorie(String nom ) {
        this.nom = nom;

    }

    @Override
    public String toString() {
        return nom;
    } 

    
    public String getNom() {
        return this.nom;
    }




    public Color getCouleur() {
        return this.couleur;
    }

   

    /*POUR LES AJOUTER A TACHE 
    
    private Categorie categorie;

    public Tache(String description) {
        this.description = description;
    }

    public void assignerCategorie(Categorie categorie) {
        this.categorie = categorie;
    }*/ 
}
