import javafx.scene.control.Alert;

public class Exceptiondatedebut extends Exception {
	
	public void getmessage() {
		showAlert("Sélection invalide", "Veuillez sélectionner une date égale ou supérieure à la date actuelle.");
	}

	private  void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

}

