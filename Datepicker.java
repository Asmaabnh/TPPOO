import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Datepicker extends Application {

    private DatePicker datePicker;
    private boolean isFirstClick = true;
    private String startDate;
    private String endDate;

    @Override
    public void start(Stage primaryStage) {
        // Create a DatePicker
        datePicker = new DatePicker();

        // Create a layout container
        VBox root = new VBox(datePicker);

        // Create a Scene with the layout container
        Scene scene = new Scene(root, 300, 200);

        // Set the title of the window
        primaryStage.setTitle("DatePicker Example");

        // Set the Scene of the Stage
        primaryStage.setScene(scene);

        // Add an event handler to handle date selection
        datePicker.setOnAction(e -> {
            if (isFirstClick) {
                startDate = datePicker.getValue().toString();
                System.out.println("Start Date: " + startDate);
                isFirstClick = false;
            } else {
                endDate = datePicker.getValue().toString();
                System.out.println("End Date: " + endDate);
                isFirstClick = true;
            }
        });

        // Show the Stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
