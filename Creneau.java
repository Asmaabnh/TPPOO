import java.time.LocalTime;

public class Creneau {
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private Tache tache;

    public Creneau(LocalTime heureDebut, LocalTime heureFin) {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Tache getTache() {
        return tache;
    }

}
