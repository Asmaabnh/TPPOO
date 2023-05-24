import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

public class Journee {
    private LocalDate date;
    private List<Creneau> creneauLibre;

    public Journee(LocalDate date) {
        this.date = date;
        this.creneauLibre = new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Creneau> getCreneauLibre() {
        return creneauLibre;
    }

    public void setCreneauLibre(List<Creneau> creneaux) {
        creneauLibre = creneaux;
    }
  
    
    void selectCreneau(Journee journee) {
        Dialog<List<Creneau>> dialog = new Dialog<>();
        dialog.setTitle("Sélectionner un créneau libre");
        dialog.setHeaderText(null);
        ButtonType cancelButton = new ButtonType("Terminer", ButtonData.CANCEL_CLOSE);
        ButtonType addButton = new ButtonType("Ajouter", ButtonData.APPLY);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, cancelButton);
    
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    
        TextField startHourField = new TextField();
        TextField startMinuteField = new TextField();
        TextField endHourField = new TextField();
        TextField endMinuteField = new TextField();
    
        gridPane.add(new Label("Heure de début (HH:MM)"), 0, 0);
        gridPane.add(startHourField, 1, 0);
        gridPane.add(new Label(":"), 2, 0);
        gridPane.add(startMinuteField, 3, 0);
    
        gridPane.add(new Label("Heure de fin (HH:MM)"), 0, 1);
        gridPane.add(endHourField, 1, 1);
        gridPane.add(new Label(":"), 2, 1);
        gridPane.add(endMinuteField, 3, 1);
    
        dialog.getDialogPane().setContent(gridPane);
    
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                String startHour = startHourField.getText();
                String startMinute = startMinuteField.getText();
                String endHour = endHourField.getText();
                String endMinute = endMinuteField.getText();
    
                try {
                    int startHourValue = Integer.parseInt(startHour);
                    int startMinuteValue = Integer.parseInt(startMinute);
                    int endHourValue = Integer.parseInt(endHour);
                    int endMinuteValue = Integer.parseInt(endMinute);
    
                    LocalTime startTime = LocalTime.of(startHourValue, startMinuteValue);
                    LocalTime endTime = LocalTime.of(endHourValue, endMinuteValue);
    
                    if (startTime.isAfter(endTime)) {
                        showAlert("Sélection invalide", "L'heure de fin doit être ultérieure à l'heure de début.");
                        return null;
                    }
    
                    Creneau creneau = new Creneau(startTime, endTime);
                    List<Creneau> creneaux = journee.getCreneauLibre();
                    creneaux.add(creneau);
                    return creneaux;
                } catch (NumberFormatException e) {
                    showAlert("Sélection invalide", "Veuillez entrer des valeurs numériques valides pour l'heure.");
                    return null;
                }
            }
    
            return null;
        });
    
        Optional<List<Creneau>> result = dialog.showAndWait();
    
        if (result.isPresent() && result.get() != null) {
            List<Creneau> creneaux = result.get();
            journee.setCreneauLibre(creneaux);
            selectCreneau(journee);
        }
       
    }


    static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

    
    
    
}
