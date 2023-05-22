import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;



public class signUpController {

    @FXML
    private Button signUpbutton;

    @FXML
    void signUp(ActionEvent event) { //INSCRIRE 
        //SERIALISATION 
        //INSCIRE() 
        Parent root = FXMLLoader.load(getClass().getResource("PERIODE.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

