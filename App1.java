import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class App1 extends Application {
 
 @Override
 public void start(Stage stage) {
  try {
 Parent root1 = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    Scene scene2 = new Scene(root1);
   

   stage.setScene(scene2);
 String csss = this.getClass().getResource("signin.css").toExternalForm();
    scene2.getStylesheets().add(csss);
   stage.show();
  } catch(Exception e) {
   e.printStackTrace();
  } 
 
  
 } 



  
    public static void main(String[] args) {
        launch(args);
        
    }
}




