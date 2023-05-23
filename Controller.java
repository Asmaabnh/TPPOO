import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;



public class Controller {


    @FXML
    private Button INSCRIPTION;

    @FXML
    private Button CONNEXION;


    @FXML
    private TextArea pseudocnx;
    @FXML
    private TextArea pseudoinsc;

    @FXML
    private TextArea nbtachemin;



    @FXML
    private Button inscrire;

   
   

    @FXML
    void inscription(ActionEvent event) throws IOException {

        Authgestion gestion = new Authgestion() ; 
        //INSCIRE() 
        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        String nom = pseudoinsc.getText();
        System.out.println("Contenu du TextArea : " + nom);

        String  nb = nbtachemin.getText();
        int nombre = Integer.parseInt(nb);
        System.out.println("Contenu du TextArea : " + nombre);

        Utilisateur user = new Utilisateur(nom, nombre);
        gestion.Inscrire(user);   
        
    }



    @FXML
    void connexion(ActionEvent event) throws IOException {

         Authgestion gestion = new Authgestion() ; 

            Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    
            String nom = pseudocnx.getText();
            boolean authentifier = gestion.Connecter(nom); 
            if ( authentifier ){}  ///AMOOODIFIER
    }




    @FXML
    void periode(ActionEvent event) {


    }


    /*  public void handleConnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }*/
  

}

