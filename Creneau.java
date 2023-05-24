import java.time.LocalTime;

public class Creneau {
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private boolean occupé;
    private boolean bloqué;
    private static LocalTime creneauMin ; // Déclaration en tant que membre static
    
 

    public Creneau(LocalTime heureDebut, LocalTime heureFin) {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

   
        
        // Autres attributs et méthodes de la classe
        
        public LocalTime getHeureDebut() {
            return heureDebut;
        }
        
        public LocalTime getHeureFin() {
            return heureFin;
        }
        

        
    public static LocalTime getCreneauMin() {
        return creneauMin;
    }
    
    public static void setCreneauMin(LocalTime creneauMin) {
        Creneau.creneauMin = creneauMin;
    }

        // Autres méthodes de la classe
    }
    


