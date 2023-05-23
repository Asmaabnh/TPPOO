import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class App1 extends Application {
 
 @Override
 public void start(Stage stage) {
  try {
    Parent root1 = FXMLLoader.load(getClass().getResource("Bienvenu.fxml"));
    Scene scene2 = new Scene(root1);
    stage.setScene(scene2);
    stage.show();
   

   
  } catch(Exception e) {
   e.printStackTrace();
  } 
 
 } 



  
    public static void main(String[] args) {
        launch(args);
        
    }
}

