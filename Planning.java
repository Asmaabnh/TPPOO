import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
<<<<<<< Updated upstream

public class Planning {
    private List<Journee> journees;





    public static  void replanifier(){} //static?????
    public static  void repporter(){} 
    public static  void manuelle(){} 
    public static  void automatique(){} 
=======

public class Planning {
    private List<Journee> journees;
>>>>>>> Stashed changes

    public Planning() {
        journees = new ArrayList<>();
    }

    public void addDate(LocalDate date) {
        Journee journee = new Journee(date);
        journees.add(journee);
    }

    public void removeDate(LocalDate date) {
        journees.removeIf(journee -> journee.getDate().equals(date));
    }

<<<<<<< Updated upstream
    public Planning() {
        journees = new ArrayList<>();
    }

    public void addDate(LocalDate date) {
        Journee journee = new Journee(date);
        journees.add(journee);
    }

    public void removeDate(LocalDate date) {
        journees.removeIf(journee -> journee.getDate().equals(date));
    }

=======
>>>>>>> Stashed changes
    public List<Journee> getJournees() {
        return journees;
    }

    public void addJournee(Journee journee) {
        journees.add(journee);
    }

    public boolean containsDate(LocalDate date) {
        for (Journee journee : journees) {
            if (journee.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

<<<<<<< Updated upstream
    void afficherPlanning() {
        System.out.println("Planning :");
    
        for (Journee journee : getJournees()) {
            System.out.println("Journée : " + journee.getDate());
            List<Creneau> creneaux = journee.getCreneauLibre();
            if (creneaux.isEmpty()) {
                System.out.println("Aucun créneau libre.");
            } else {
                System.out.println("Créneaux libres :");
                for (Creneau creneau : creneaux) {
                    System.out.println("   - De " + creneau.getHeureDebut() + " à " + creneau.getHeureFin());
                }
            }
            System.out.println();
        }
    }
    
=======
    // Dans la classe Planning
>>>>>>> Stashed changes

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Journee journee : journees) {
        sb.append(journee.getDate().toString()).append("\n");
    }
    return sb.toString();
}

}