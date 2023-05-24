import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Pane calendarPane;

  

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

        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
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
  

    @FXML
    private TextArea nomtache;

    @FXML
    private Button confirmer;

    @FXML
    private DatePicker deadline;

    @FXML
    private ComboBox<String> type;

    @FXML
    private ComboBox<String> priorite;
    
    public void type() {
        List<String> liste = Arrays.asList("Simple", "Décomposable");
        ObservableList<String> options = FXCollections.observableArrayList(liste);
        type.setItems(options);
    }

    public void priorite() {
        List<String> liste = Arrays.asList("Haute", "Moyenne" , "Basse");
        ObservableList<String> options = FXCollections.observableArrayList(liste);
        priorite.setItems(options);
    }



    public void setCalendarPane(Pane calendarPane) {
        this.calendarPane = calendarPane;
    }
    
    
    

}

