import java.sql.Date;
import java.time.LocalTime;

public abstract class  Tache {
    private String nom;
    private String  duree;// à vérifier si un string 
    private LocalTime datefin;
    private String heurefin;
    private EtatTache etat; 
    private String priorite ; 
    private Categorie categorie ;
     
  
    public Tache(String nom, String duree, LocalTime datefin, String heurefin, String priorite, Categorie categorie) {
        this.nom = nom;
        this.duree = duree;
        this.datefin = datefin;
        this.heurefin = heurefin;
        this.etat  = EtatTache.NOT_REALIZED;
        this.priorite = priorite;
        this.categorie = categorie;
    }


    
}
