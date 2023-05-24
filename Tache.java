import java.sql.Date;
import java.time.LocalDate;

public abstract class  Tache {
    private String nom;
    private String  duree;// à vérifier si un string 
    private LocalDate datelimite;
    private String heurlimite;
    private EtatTache etat; 
    private String priorite ; 
    private Categorie categorie ;
     
  
    public Tache(String nom, String duree, LocalDate datelimite, String heurlimite, String priorite, Categorie categorie) {
        this.nom = nom;
        this.duree = duree;
        this.datelimite = datelimite;
        this.heurlimite = heurlimite;
        this.etat  = EtatTache.NOT_REALIZED;
        this.priorite = priorite;
        this.categorie = categorie;
    }


    
}
