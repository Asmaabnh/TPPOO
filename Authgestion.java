import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Authgestion {


    private static final String FichierUsers = "utilisateurs.dat";
    private static Map<String, Utilisateur> Users = new HashMap<>();

    public static void Inscrire(Utilisateur utilisateur) {
        chargerUtilisateurs();
        if (!pseudoExiste(utilisateur.getPseudo())) {
            Users.put(utilisateur.getPseudo(), utilisateur);
            sauvegarderUtilisateurs();
        } else {
            JOptionPane.showMessageDialog(null, "Le pseudo est déjà utilisé ! Choisissez un autre.");
        }
    }






    public static boolean  Connecter(String pseudo) {
        chargerUtilisateurs();
        if ( pseudoExiste( pseudo)) { return true ;  }
        else {  
     JOptionPane.showMessageDialog(null, "L'utilisateur n'existe pas!");
     return false ; 
    }
            
    }

    

    private static void sauvegarderUtilisateurs() { //SERIALIZATION
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(FichierUsers))) {
            objectOut.writeObject(Users);
        } 
        catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des utilisateurs : " + e.getMessage());
        }
    }

    private static void chargerUtilisateurs() { //DESERIALIZATION
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

  /*  public static void main(String[] args) {
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
    }*/
    
}











