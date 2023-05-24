import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.YearMonth;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;


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




// Méthode pour afficher le calendrier et récupérer les dates et les créneaux sélectionnés, et renvoyer le planning modifié
private Planning displayCalendarAndUpdatePlanning() {
    calendarGrid.getChildren().clear();

    // Obtention de l'année et du mois actuels
    int year = currentYearMonth.getYear();
    int month = currentYearMonth.getMonthValue();

    // Obtention du premier jour du mois
    LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
    int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

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

    // Affichage des jours de la semaine
    String[] daysOfWeek = {"Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim"};
    for (int i = 0; i < daysOfWeek.length; i++) {
        Label dayLabel = new Label(daysOfWeek[i]);
        calendarGrid.add(dayLabel, i, 1);
    }

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

 
    

    

  

    // Mettre à jour le planning
 updatePlanningTable(planning);
    return planning; // Renvoyer le planning modifié
}

// Méthode pour afficher le planning dans le TableView
private void updatePlanningTable(Planning planning) {
    // TableView pour afficher les journées et les créneaux libres
    TableView<Journee> planningTable = new TableView<>();
    TableColumn<Journee, LocalDate> dateColumn = new TableColumn<>("Date");
    TableColumn<Journee, Void> creneauxColumn = new TableColumn<>("Créneaux");

    // Colonne pour afficher la date
    dateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDate()));

    // Colonne pour afficher les boutons de créneaux libres
    creneauxColumn.setCellFactory(param -> new TableCell<>() {
        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                int rowIndex = getIndex();
                Journee journee = planningTable.getItems().get(rowIndex);
                List<Creneau> creneauxLibres = journee.getCreneauLibre();
                HBox hbox = new HBox();
                hbox.setSpacing(5);
                for (Creneau creneau : creneauxLibres) {
                    Button creneauButton = new Button("de " + creneau.getHeureDebut() + " à " + creneau.getHeureFin());
                    handleCreneauButtonClick(creneauButton);
                    hbox.getChildren().add(creneauButton);
                }
                setGraphic(hbox);
            }
        }
    });

    // Créez et initialisez l'ObservableList<Journee> avec les journées du planning
    ObservableList<Journee> observableJournees = FXCollections.observableArrayList(planning.getJournees());

    planningTable.getColumns().addAll(dateColumn, creneauxColumn);
    planningTable.setItems(observableJournees);

    // Ajouter le TableView à la grille du calendrier
  calendarGrid.add(planningTable, 0, 8, 7, 1); 

}

private String selectedCreneauText;

// Méthode pour gérer le clic sur un bouton de créneau libre
private void handleCreneauButtonClick(Button creneauButton) {
    creneauButton.setOnAction(e -> {
        selectedCreneauText = creneauButton.getText();
        System.out.println(selectedCreneauText);
    });
}
}