import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatePickerApp extends Application {
    private List<LocalDate> selectedDates;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        selectedDates = new ArrayList<>();

        Button selectDatesButton = new Button("Sélectionner des dates");
        selectDatesButton.setOnAction(e -> showDatePickerModal(primaryStage));

        VBox root = new VBox(10, selectDatesButton);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Sélection de dates multiples");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showDatePickerModal(Stage ownerStage) {
        Stage modalStage = new Stage();
        modalStage.initOwner(ownerStage);
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Sélectionnez les dates");

        DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(e -> {
            LocalDate selectedDate = datePicker.getValue();
            if (!selectedDates.contains(selectedDate)) {
                selectedDates.add(selectedDate);
            }
        });

        Button doneButton = new Button("Terminer");
        doneButton.setOnAction(e -> modalStage.close());

        VBox modalRoot = new VBox(10, datePicker, doneButton);
        modalRoot.setAlignment(Pos.CENTER);
        Scene modalScene = new Scene(modalRoot, 300, 200);

        modalStage.setScene(modalScene);
        modalStage.showAndWait();

        // Afficher les dates sélectionnées
        System.out.println("Dates sélectionnées :");
        for (LocalDate date : selectedDates) {
            System.out.println(date);
        }
    }
}
