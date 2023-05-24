import java.time.LocalTime;

public class Creneau {
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private boolean occupé;
    private boolean bloqué;
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
        
        // Autres méthodes de la classe
    }
    


