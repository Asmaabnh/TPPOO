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

    public void planifier() {
        // Méthode de planification
    }

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


    
    public static void Inscrire(Utilisateur utilisateur) {
        chargerUtilisateurs();
        if (!pseudoExiste(utilisateur.getPseudo())) {
            Users.put(utilisateur.getPseudo(), utilisateur);
            sauvegarderUtilisateurs();
        } else {
            JOptionPane.showMessageDialog(null, "Le pseudo est déjà utilisé ! Choisissez un autre.");
        }
    }






    public static boolean Connecter(String pseudo) {
        chargerUtilisateurs();
        return Users.containsKey(pseudo);
    }
    

    private static void sauvegarderUtilisateurs() {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(FichierUsers))) {
            objectOut.writeObject(Users);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des utilisateurs : " + e.getMessage());
        }
    }

    private static void chargerUtilisateurs() {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(FichierUsers))) {
            Users = (Map<String, Utilisateur>) objectIn.readObject();
        }
         catch (IOException | ClassNotFoundException e) {
                System.err.println("Erreur lors de la lecture du fichier des utilisateurs : " + e.getMessage());
                System.err.println("Erreur lors de la désérialisation des utilisateurs : " + e.getMessage());
            
        }
    }

    private static boolean pseudoExiste(String pseudo) {
        return Users.containsKey(pseudo);
    }

    public static void main(String[] args) {
        // Création d'objets Utilisateur fictifs
        Utilisateur user1 = new Utilisateur("user1", 5);
        Utilisateur user2 = new Utilisateur("user2", 10);
    
        // Enregistrement des utilisateurs
        Inscrire(user1);
        Inscrire(user2);
    
        // Sérialisation et sauvegarde des utilisateurs dans le fichier
        sauvegarderUtilisateurs();
    
        // Réinitialisation du HashMap utilisateursExistants
        Users = new HashMap<>();
    
        // Désérialisation et chargement des utilisateurs à partir du fichier
        chargerUtilisateurs();
    
        // Vérification des utilisateurs désérialisés
        System.out.println("Utilisateurs désérialisés :");
        
        for (Utilisateur utilisateur : Users.values()) {
            System.out.println("Pseudo : " + utilisateur.getPseudo());
            // Afficher d'autres informations si nécessaire
        }
    }
    
}
