import java.sql.Date;
import java.time.LocalDate;

public abstract class  Tache {
    protected String nom;
    protected String  duree;// à vérifier si un string 
    protected LocalDate datelimite;
    protected String heurlimite;
    protected EtatTache etat; 
    protected String priorite ; 
    protected Categorie categorie ;
    protected Creneau  creneau ; 
    protected boolean bloque ; 
     
  
    public Tache(String nom, String duree, LocalDate datelimite, String heurlimite, String priorite, Categorie categorie,boolean bloque ) {
        this.nom = nom;
        this.duree = duree;
        this.datelimite = datelimite;
        this.heurlimite = heurlimite;
        this.etat  = EtatTache.NOT_REALIZED;
        this.priorite = priorite;
        this.categorie = categorie;
        this.bloque = false ;
    }


    public String getDuree() {
        return duree;
    }


    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    
}
