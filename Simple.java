import java.time.LocalDate;

public class Simple extends Tache{
    private boolean periodique ; 
    

    public Simple(String nom, String duree, LocalDate datefin, String heurefin, String priorite, Categorie categorie , boolean periodique , boolean bloque) {
        super(nom, duree, datefin, heurefin, priorite, categorie , bloque);
        this.periodique = periodique ; 
    }

    public String getNom() {
        return null;
    }

    public String getHeureFin() {
        return null;
    }

    public String isBloque() {
        return null;
    }

    public String getCategorie() {
        return null;
    }

    public String isPeriodique() {
        return null;
    }

    public String getPriorite() {
        return null;
    }



    
}
