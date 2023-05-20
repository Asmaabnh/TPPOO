import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
public class Ctrlr {
  


    
    public void handleConnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleInscriptionq(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleConnecter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("apCnx.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleInscrire(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Code.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleconfirmer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("apCnx.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handlepropres(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Apropos.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleAcceuil(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("apCnx.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleContact(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("contact.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleDeconnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        //hna n9der n3ayat l css
        stage.show();
    }
    public void handleArrow(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("apCnx.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    /*public void handleArro(MouseDragEvent event) throws IOException {
        Button btn=new Button("creer automatiquement une carte");
        btn.setLayoutX(10.0);
        btn.setLayoutY(60.0);
    }*/

  
    public void handleGnr(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cours1cp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleCour(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cours1cp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleCours(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cours2cp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleCourss(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cours1CS.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleCoursss(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cours2CS.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleSID(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("COURS2CSSID.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleSIL(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("COURS2CSSIL.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleSIQ(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("COURS2CSSIQ.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleSIT(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("COURS2CSSIT.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void handleretour(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cours2CS.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}

