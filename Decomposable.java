import java.time.LocalDate;

public class Decomposable extends Tache{



    public Decomposable(String nom, String duree, LocalDate datefin, String heurefin, String priorite,Categorie categorie , boolean bloque) {
        super(nom, duree, datefin, heurefin, priorite, categorie, bloque);
    }

    public void décomposerTache(){}

    
} 
