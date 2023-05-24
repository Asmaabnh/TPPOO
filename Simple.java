import java.time.LocalDate;

public class Simple extends Tache{
    private boolean periodique ; 

    public Simple(String nom, String duree, LocalDate datefin, String heurefin, String priorite, Categorie categorie , boolean periodique) {
        super(nom, duree, datefin, heurefin, priorite, categorie);
        this.periodique = periodique ; 
    }



    
}
