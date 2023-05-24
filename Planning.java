import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Planning {

    private List<Journee> journees;





    public static  void replanifier(){} //static?????
    public static  void repporter(){} 
    public static  void manuelle(){} 
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

    // Dans la classe Planning

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Journee journee : journees) {
        sb.append(journee.getDate().toString()).append("\n");
    }
    return sb.toString();
}



}