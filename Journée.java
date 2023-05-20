import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List; 
 
public class Journée { 
    //heures  
 
    private List<Creneau> creneauxLibres;
    private String NombreTacheMin  ;  
     private LocalDate date;   
   
   
     public List<Creneau> specifierCreneauxLibres(LocalTime heureDebut, LocalTime heureFin , List<Creneau> creneauxLibres ) { 
    
        
     
        // Créneau libre avant l'heure de début de travail 
        Creneau creneauLibre = new Creneau (heureDebut, heureFin); 
        creneauxLibres.add(creneauLibre); 
        return creneauxLibres;
     
      
    } 


  

    public Journée(LocalDate date, List<Creneau> creneauxLibres) {
        this.date = date;
        this.creneauxLibres = creneauxLibres;
    }
   
 
}