import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Controller {


    @FXML
    private Button INSCRIPTION;

    @FXML
    private Button CONNEXION;


   
    @FXML
    private TextArea pseudocnx; // Correspond à l'ID pseudocnx dans le fichier FXML
    
    @FXML
    private TextArea pseudoinsc;



    @FXML
    private TextArea nbtachemin;



    @FXML
    private Button inscrire;
    


    @FXML
    void inscription(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("tache.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
     
        stage.show();
       
        
   
        
    }

   


   

    @FXML
    void connexion(ActionEvent event) throws IOException {


            Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    
           
         
    }



  @FXML
    void Calendrier(ActionEvent event) throws IOException {

        Authgestion gestion = new Authgestion() ; 
        String nom = pseudocnx.getText();
        //System.out.println("Cest le pseudo : " + nom);

        boolean authentifier = gestion.Connecter(nom);

        if ( authentifier ){ 
        JOptionPane.showMessageDialog(null, "Bienvenue dans votre Planning !"); 
        ///AMOOODIFIER

        Parent root = FXMLLoader.load(getClass().getResource("calendrier.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        //COMME ON A DEJA DESERIALISE LE USER ET IL CONTIENT UN PLANNING ON VA LAFFICHER 
    }
    }


    /**/

    @FXML
    void periode(ActionEvent event) {
       
        Authgestion gestion = new Authgestion() ; 
        String nom = pseudoinsc.getText();
       // System.out.println("LE pseudo est  : " + nom);

        String  nb = nbtachemin.getText();
        int nombre = Integer.parseInt(nb);
        //System.out.println("Nombre de taches min  : " + nombre);

        Utilisateur user = new Utilisateur(nom, nombre);
        gestion.Inscrire(user);


    }


    /*  public void handleConnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }*/
  

   

   

  

    /*public void retour(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bienvenue.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }*/


    @FXML
    private ComboBox<String> type;
    
    @FXML
    private ComboBox<String> priorite; 
    @FXML
    private TextArea nomtache;

    @FXML
    private Button confirmer;

    @FXML
    private DatePicker datelimite;
    @FXML
    private TextArea duree;

    @FXML
    private Spinner<String> heurelimite;

    @FXML
    private ComboBox<Categorie> categorie;

    
    public  void type()//METHODE POUR INITIALISER LE COMBOBOX DES TYPES DES TACHES 
     {
        List<String> liste = Arrays.asList("Simple", "Décomposable" , "Périodique" );
        ObservableList<String> options = FXCollections.observableArrayList(liste);
        type.setItems(options);
    }


    
    @FXML
    void ajoutertache(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("tache.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    
    // Récupérer la référence du contrôleur du fichier FXML tache.fxml
    Controller tacheController = loader.getController();
    
    // Appeler les méthodes pour initialiser les ComboBox
    tacheController.type();
   
    tacheController.priorite();
   
        
    }



    public void priorite()  //UNE METHODE QUI INITIALISE LE COMBOBOX DES PRIORITEES
    {
        List<String> liste = Arrays.asList("Haute", "Moyenne" , "Basse");
        ObservableList<String> options = FXCollections.observableArrayList(liste);
        priorite.setItems(options);
    }

    
    @FXML
    void confirmertache(ActionEvent event) {

        String selectedType = type.getValue(); // Récupère le type 
        String selectedPriorite = priorite.getValue(); // Récupère la prioritée
        String nom = nomtache.getText(); // Récupère le 'nomtache'
        LocalDate selectedDate = datelimite.getValue(); // Récupère la date sélectionnée dans le DatePicker 'datelimite'
        String dureeText = duree.getText(); // Récupère lA'duree'
        String selectedHeure =  heurelimite.getValue(); // Récupère la valeur sélectionnée dans le Spinner 'heurelimite'
        Categorie selectedCategorie = (Categorie) categorie.getValue(); // Récupère la valeur sélectionnée dans le  'categorie'

        System.out.println(selectedPriorite);
        System.out.println(nom);
        System.out.println(selectedDate);
        System.out.println(dureeText);
        System.out.println(selectedHeure);
        System.out.println(selectedCategorie);

if (selectedType == "Simple")  {

    //AFFICHER UN MESSAGE S4IL LA VEUT PERIODIQUE 
       // Simple tache = new Simple()  ; 

}


if (selectedType == "Décomposable") {
       // Decomposable tache = new Decomposable()  ; 

}




        
        }
    
   
   
    

}


