import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Planning {

    private List<Journee> journees;





    public static  void replanifier(){} //static?????
    public static  void repporter(){} 
    public static  void automatique(){} 

   

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

    /*void afficherPlanning() {
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
    }*/void afficherPlanning() {
    System.out.println("Planning :");

    for (Journee journee : getJournees()) {
        System.out.println("Journée : " + journee.getDate());
        List<Creneau> creneaux = journee.getCreneauLibre();
        if (creneaux.isEmpty()) {
            System.out.println("Aucun créneau libre.");
        } else {
            System.out.println("Créneaux libres :");
            for (Creneau creneau : creneaux) {
                System.out.println("   - " + formatCreneau(creneau));
            }
        }
        System.out.println();
    }
}
String formatCreneau(Creneau creneau) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    // Conversion des LocalTime en Date
    LocalTime heureDebut = creneau.getHeureDebut();
    LocalTime heureFin = creneau.getHeureFin();
    Date dateDebut = Date.from(heureDebut.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
    Date dateFin = Date.from(heureFin.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());

    // Formatage des dates
    String heureDebutFormatee = dateFormat.format(dateDebut);
    String heureFinFormatee = dateFormat.format(dateFin);

    return heureDebutFormatee + " - " + heureFinFormatee;
}
Journee getJournee(LocalDate date) {
    for (Journee journee : getJournees()) {
        if (journee.getDate().equals(date)) {
            return journee;
        }
    }
    return null;
}

public List<Creneau> getCreneauxForDate(LocalDate date) {
    List<Creneau> creneauxForDate = new ArrayList<>();
    for (Journee journee :  getJournees()) {
        if (journee.getDate().equals(date)) {
            List<Creneau> creneaux = journee.getCreneauLibre();
            creneauxForDate.addAll(creneaux);
        }
    }
    return creneauxForDate;
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Journee journee : journees) {
        sb.append(journee.getDate().toString()).append("\n");
    }
    return sb.toString();
}




public boolean planifierManuelle(Tache tache, Creneau creneau) {
    // Conversion de la durée de la tâche en minutes
    int dureeTacheMinutes = convertirDureeEnMinutes(tache.getDuree());

    // Calcul de la durée du créneau en minutes
    int dureeCreneauMinutes = creneau.getHeureFin().getHour() * 60 + creneau.getHeureFin().getMinute()
        - creneau.getHeureDebut().getHour() * 60 - creneau.getHeureDebut().getMinute();

    // Vérification si les durées sont égales
    if (dureeTacheMinutes == dureeCreneauMinutes) {
        // Affecter le créneau à la tâche
        tache.setCreneau(creneau);
        creneau.setOccupe(true);
        return true; // La planification a réussi
    } else {
        return false; // La durée de la tâche ne correspond pas à la durée du créneau
    }
}


private int convertirDureeEnMinutes(String duree) {
    String[] elements = duree.split(":");
    int heures = Integer.parseInt(elements[0]);
    int minutes = Integer.parseInt(elements[1]);
    return heures * 60 + minutes;
}

}