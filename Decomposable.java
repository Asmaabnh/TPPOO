import java.time.LocalTime;

public class Decomposable extends Tache{



    public Decomposable(String nom, String duree, LocalTime datefin, String heurefin, String priorite,Categorie categorie) {
        super(nom, duree, datefin, heurefin, priorite, categorie);
    }

    public void décomposerTache(){}

    
} 
