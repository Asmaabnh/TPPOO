import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Journee {
    private LocalDate date;
    private List<Creneau> creneauLibre;

    public Journee(LocalDate date) {
        this.date = date;
        this.creneauLibre = new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Creneau> getCreneauLibre() {
        return creneauLibre;
    }

    public void setCreneauLibre(List<Creneau> creneaux) {
        creneauLibre = creneaux;
    }
}
