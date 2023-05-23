public class App {
    public static void main(String[] args) {
        // Création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur("user1", 5);
Authgestion sys = new  Authgestion( );
        /*Appel de la méthode pour fixer une période
        String periode = utilisateur.fixerperiode();
        System.out.println("Période fixée : " + periode);

        // Ajout d'une tâche complétée
        Tache tache = new Tache("Tâche 1");
        utilisateur.completeTask(tache);*/

        // Enregistrement de l'utilisateur
        sys.Inscrire(utilisateur);

        // Authentification de l'utilisateur
        String pseudo = "Ikraaam";
         boolean authentifie = sys.Connecter(pseudo);

        if (authentifie) {
            System.out.println("Authentification réussie pour l'utilisateur : " + pseudo);
        } else {
            System.out.println("Authentification échouée pour l'utilisateur : " + pseudo);
        }
    }
}
