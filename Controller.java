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
    private TextArea pseudo;

    @FXML
    private TextArea nbtachemin;



    @FXML
    private Button inscrire;

   
   

    @FXML
    void inscription(ActionEvent event) {

      //INSCRIRE 
        Authgestion gestion = new Authgestion() ; 
        //SERIALISATION 
        //INSCIRE() 
        INSCRIPTION.setOnAction(e -> {
        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        String nom = pseudo.getText();
        System.out.println("Contenu du TextArea : " + nom);

        String (int) nb = nbtachemin.getText();
        System.out.println("Contenu du TextArea : " + nb);
        Utilisateur user = new Utilisateur(nom, nb);



       

         

        gestion.Inscrire(null);


        });
        
       
        
    }

    @FXML
    void connexion(ActionEvent event) {

        CONNEXION.setOnAction(e -> {
            Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    
            String nom = pseudo.getText();



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

