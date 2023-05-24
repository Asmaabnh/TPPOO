import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pseudo;
    private Planning planning;
    private Badge badge;
    private int cptTache;
    private int nbTacheMin;



    private static final String FichierUsers = "utilisateurs.dat";

    private static Map<String, Utilisateur> Users = new HashMap<>();

    public Utilisateur(String pseudo, int nbTacheMin) {
        this.pseudo = pseudo;
        this.nbTacheMin = nbTacheMin;
        this.cptTache = 0;
        this.badge = Badge.NONE;
    }

    public String getPseudo() {
        return pseudo;
    }

    /*public void setPlanning(Planning planning) {
        this.planning = planning;
    }*/

  
    public String fixerPeriode() {
        // Méthode pour fixer une période
        return null;
    }

    public void completeTask(Tache task) {
        cptTache++;
        checkBadges();
    }

    private void checkBadges() {
        if (cptTache >= nbTacheMin && badge == Badge.NONE) {
            badge = Badge.GOOD;
            System.out.println("Félicitations ! Vous avez obtenu le badge GOOD.");
        } else if (badge == Badge.GOOD && cptTache >= nbTacheMin * 2) {
            badge = Badge.VERYGOOD;
            System.out.println("Félicitations ! Vous avez obtenu le badge VERYGOOD.");
        } else if (badge == Badge.VERYGOOD && cptTache >= nbTacheMin * 3) {
            badge = Badge.EXCELLENT;
            System.out.println("Félicitations ! Vous avez obtenu le badge EXCELLENT.");
        }
    }


    
}