import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.converter.LocalTimeStringConverter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class testcalendrierchatgpt extends Application {

    private DatePicker datePicker;
    private TableView<ObservableList<String>> taskTableView;
    private List<TableColumn<ObservableList<String>, String>> hourColumns;
    private TextField taskTextField;

    private ObservableList<ObservableList<String>> tasks;

    @Override
    public void start(Stage primaryStage) {
        datePicker = new DatePicker();
        datePicker.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            updateTaskTableView(selectedDate);
        });

        taskTableView = new TableView<>();
        taskTableView.setEditable(true);

        hourColumns = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            LocalTime hour = LocalTime.of(i, 0);
            TableColumn<ObservableList<String>, String> hourColumn = createHourColumn(hour);
            hourColumns.add(hourColumn);
            taskTableView.getColumns().add(hourColumn);
        }

        taskTextField = new TextField();
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addTask());

        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(taskTextField, addButton);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(datePicker, taskTableView, inputBox);
        VBox.setVgrow(taskTableView, Priority.ALWAYS);

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Planning");
        primaryStage.show();

        tasks = FXCollections.observableArrayList();
        taskTableView.setItems(tasks);
    }

    private void updateTaskTableView(LocalDate selectedDate) {
        tasks.clear();
        for (int i = 0; i < 24; i++) {
            LocalTime hour = LocalTime.of(i, 0);
            ObservableList<String> row = FXCollections.observableArrayList();
            row.add(hour.format(DateTimeFormatter.ofPattern("HH:mm")));
            tasks.add(row);
        }
    }

    private TableColumn<ObservableList<String>, String> createHourColumn(LocalTime hour) {
        TableColumn<ObservableList<String>, String> hourColumn = new TableColumn<>(hour.format(DateTimeFormatter.ofPattern("HH:mm")));
        hourColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        hourColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        return hourColumn;
    }

    private void addTask() {
        String taskDescription = taskTextField.getText();

        if (!taskDescription.isEmpty()) {
            for (ObservableList<String> row : tasks) {
                row.add(taskDescription);
            }
            taskTextField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
