import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class Calendrier  {
    private YearMonth currentYearMonth;
    private GridPane calendarGrid;
    private Planning planning;


    public Calendrier(YearMonth currentYearMonth, GridPane calendarGrid, Planning planning) {
        this.currentYearMonth = currentYearMonth;
        this.calendarGrid = calendarGrid;
        this.planning = planning;
    }






    public  void updateCalendar(YearMonth currentYearMonth) {
        calendarGrid.getChildren().clear();

        // Obtention de l'année et du mois actuels
        int year = currentYearMonth.getYear();
        int month = currentYearMonth.getMonthValue();

        // Obtention du premier jour du mois
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

        // Affichage de l'année et du mois
        Label monthLabel = new Label(currentYearMonth.getMonth().toString() + " " + year);
        calendarGrid.add(monthLabel, 0, 0, 7, 1);

        // Affichage des jours de la semaine
        String[] daysOfWeek = {"Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim"};
        for (int i = 0; i < daysOfWeek.length; i++) {
            Label dayLabel = new Label(daysOfWeek[i]);
            calendarGrid.add(dayLabel, i, 1);
        }

        // Affichage des jours du mois
        int row = 2;
        int col = startDayOfWeek - 1;
        int daysInMonth = currentYearMonth.lengthOfMonth();

        for (int day = 1; day <= daysInMonth; day++) {
            Button dayButton = new Button(Integer.toString(day));
            dayButton.setPrefWidth(40);

            LocalDate date = LocalDate.of(year, month, day);
            dayButton.setOnAction(e -> {
                // Action lorsque l'utilisateur sélectionne un jour
                if (date.isBefore(LocalDate.now())) {
                    showAlert("Sélection invalide", "Veuillez sélectionner une date égale ou supérieure à la date actuelle.");
                } else {
                    if (planning.containsDate(date)) {
                        planning.removeDate(date);
                        dayButton.setStyle("-fx-background-color: transparent;");
                    } else {
                        Journee journee = new Journee(date);
                        Creneau.selectCreneau(journee); // Appel de la méthode pour sélectionner le créneau libre
                        if (journee.getCreneauLibre() != null) {
                            planning.addJournee(journee);
                            dayButton.setStyle("-fx-background-color: lightblue;");
                        } else {
                            // Aucun créneau sélectionné, ne pas ajouter la journée au planning
                            showAlert("Sélection invalide", "Veuillez sélectionner un créneau libre pour la journée.");
                            planning.removeDate(date); // Supprimer la date de la journée de la liste des journées du planning
                            dayButton.setStyle("-fx-background-color: transparent;");
                        }
                    }
                    
                    System.out.println(date); // Afficher la date sélectionnée dans le terminal
                }
            });

            calendarGrid.add(dayButton, col, row);

            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
        
        System.out.println("---------------------------------------------------------------"); // Afficher la liste des dates sélectionnées dans le terminal
        afficherPlanning();}



        private void afficherPlanning() {
            System.out.println("Planning :");
        
            for (Journee journee : planning.getJournees()) {
                System.out.println("Journée : " + journee.getDate());
                List<Creneau> creneaux = journee.getCreneauLibre();
                if (creneaux.isEmpty()) {
                    System.out.println("Aucun créneau libre.");
                } else {
                    System.out.println("Créneaux libres :");
                    for (Creneau creneau : creneaux)
                     {
                    System.out.println("   - De " + creneau.getHeureDebut() + " à " + creneau.getHeureFin());
                     }
                }
                System.out.println();
            }
        }

 
    

    

  


    
    
    



 /*    private void selectCreneau(Journee journee) {
        Dialog<List<Creneau>> dialog = new Dialog<>();
        dialog.setTitle("Sélectionner un créneau libre");
        dialog.setHeaderText(null);
    
        ButtonType okButton = new ButtonType("Ok", ButtonData.OK_DONE);
        ButtonType addButton = new ButtonType("Ajouter", ButtonData.APPLY);
        ButtonType cancelButton = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, addButton, cancelButton);
    
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
            if (dialogButton == okButton) {
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
                    List<Creneau> creneaux = new ArrayList<>();
                    creneaux.add(creneau);
                    return creneaux;
                } catch (NumberFormatException e) {
                    showAlert("Sélection invalide", "Veuillez entrer des valeurs numériques valides pour l'heure.");
                    return null;
                }
            } else if (dialogButton == addButton) {
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
    }*/
    
    
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

   
}
