import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import javafx.util.StringConverter;
import javax.swing.Icon;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Controller {


    @FXML
    private Button INSCRIPTION;

    @FXML
    private Button CONNEXION;


   
    @FXML
    private TextArea pseudocnx; // Correspond à l'ID pseudocnx dans le fichier FXML
    
    @FXML
    private TextArea pseudoinsc;



    @FXML
    private TextArea nbtachemin;



    @FXML
    private Button inscrire;
    


    @FXML
    void inscription(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
     
        stage.show();
        
    }

   

    @FXML
    void connexion(ActionEvent event) throws IOException {


            Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();     
    }


    @FXML
    void periode(ActionEvent event) throws IOException {
       
        Authgestion gestion = new Authgestion() ; 
        String nom = pseudoinsc.getText();
       // System.out.println("LE pseudo est  : " + nom);

        String  nb = nbtachemin.getText();
        int nombre = Integer.parseInt(nb);
        //System.out.println("Nombre de taches min  : " + nombre);

        Utilisateur user = new Utilisateur(nom, nombre);
         boolean inscription = gestion.Inscrire(user);
       //LE RESTE DE IKRAM 
       if (inscription) {
        executeApresInscription();
     } else {
        JOptionPane.showMessageDialog(null, "Le pseudo est déjà utilisé ! Choisissez un autre.");
     }
       
    }

    public void executeApresInscription() throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("crenETperiod.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Calendrier");
        primaryStage.setScene(scene);
        primaryStage.show();
    
        AtomicReference<YearMonth> currentYearMonth = new AtomicReference<>(YearMonth.now());
        Planning planning = new Planning();
    
        // Création de la grille du calendrier
        GridPane calendarGrid = new GridPane();
        calendarGrid.setAlignment(Pos.CENTER);
        calendarGrid.setHgap(10);
        calendarGrid.setVgap(10);
    
        Calendrier calendrier = new Calendrier(currentYearMonth.get(), calendarGrid, planning);
    
        // Affichage initial du calendrier
        calendrier.updateCalendar(currentYearMonth.get());
    
        // Boutons de navigation
        Button prevButton = new Button("<<");
        Button nextButton = new Button(">>");
    
        prevButton.setOnAction(e -> {
            currentYearMonth.set(currentYearMonth.get().minusMonths(1));
            calendrier.updateCalendar(currentYearMonth.get());
        });
    
        nextButton.setOnAction(e -> {
            currentYearMonth.set(currentYearMonth.get().plusMonths(1));
            calendrier.updateCalendar(currentYearMonth.get());
        });
    
        // Création de la scène
        GridPane rootPane = (GridPane) root;
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.add(prevButton, 0, 0);
        rootPane.add(nextButton, 2, 0);
        rootPane.add(calendarGrid, 0, 1, 3, 1);
    }
    


    /*public void retour(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bienvenue.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }*/


    @FXML
    private ComboBox<String> type;
    
    @FXML
    private ComboBox<String> priorite; 
    @FXML
    private TextArea nomtache;

    @FXML
    private Button confirmer;

    @FXML
    private DatePicker datelimite;
    @FXML
    private TextArea duree;

    @FXML
    private TextArea heurelimite;

   

    
    public  void type()//METHODE POUR INITIALISER LE COMBOBOX DES TYPES DES TACHES 
     {
        List<String> liste = Arrays.asList("Simple", "Décomposable" , "Périodique" );
        ObservableList<String> options = FXCollections.observableArrayList(liste);
        type.setItems(options);
    }


    public void priorite()  //UNE METHODE QUI INITIALISE LE COMBOBOX DES PRIORITEES
    {
        List<String> liste = Arrays.asList("Haute", "Moyenne" , "Basse");
        ObservableList<String> options = FXCollections.observableArrayList(liste);
        priorite.setItems(options);
    }

 
    @FXML
    private Button planifiermanuelle;

    @FXML
    private Button planifierauto;

    @FXML
    private Button projet;

    
    @FXML
    void ajoutertache(ActionEvent event) throws IOException {
//BOUTON QUI APPELLE CETTE METHODE 
    FXMLLoader loader = new FXMLLoader(getClass().getResource("tache.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    
    // Récupérer la référence du contrôleur du fichier FXML tache.fxml
    Controller tacheController = loader.getController();
    
    // Appeler les méthodes pour initialiser les ComboBox
    tacheController.type();
   tacheController.priorite();

        
    }

   
    private List<Simple> listeSimple = new ArrayList<>();
    private List<Decomposable> listeDecomposable = new ArrayList<>();
    @FXML
    private ColorPicker couleur;
    @FXML
    private TextArea nomcategorie;
    

    @FXML
    void  confirmertache(ActionEvent event) {


        String selectedType = type.getValue(); // Récupère le type 
        String selectedPriorite = priorite.getValue(); // Récupère la prioritée
        String nom = nomtache.getText(); // Récupère le 'nomtache'
        LocalDate selectedDate = datelimite.getValue(); // Récupère la date sélectionnée dans le DatePicker 'datelimite'
        String dureeText = duree.getText(); // Récupère lA'duree'
        String selectedHeure =  heurelimite.getText(); // Récupère la valeur sélectionnée dans le Spinner 'heurelimite'
      // Récupère les valeurs sélectionnées dans  'categorie'
        Color selectedColor = couleur.getValue();
        String nomCategorieText = nomcategorie.getText();

        Categorie selectedCategorie= new Categorie(nomCategorieText , selectedColor);

        System.out.println("Priorite:" + selectedPriorite);
        System.out.println(nom);
        System.out.println("datelimite" + selectedDate);
        System.out.println( "duree : " + dureeText);
        System.out.println(selectedHeure);
       System.out.println(selectedCategorie.getNom());
        System.out.println(selectedCategorie.getCouleur());

       System.out.println("type:" + selectedType);


       if (selectedType.equals("Simple"))  {

       //AFFICHER UN MESSAGE S4IL LA VEUT PERIODIQUE 
       String[] options = {"Oui", "Non"};
       int option = JOptionPane.showOptionDialog(null, "Voulez-vous que cette tâche soit périodique ?", "Periodicité Tache!",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
       
       if (option == 0) {
        Simple tache = new Simple(nom, dureeText, selectedDate, selectedHeure, selectedPriorite, selectedCategorie, true)  ; 
        System.out.println("TACHE PERIODIQUE");
          listeSimple.add(tache);


       } else if (option == 1) {
        Simple tache = new Simple(nom, dureeText, selectedDate, selectedHeure, selectedPriorite, selectedCategorie, false)  ; 
        listeSimple.add(tache); }
       }


     else {
        if (selectedType == "Décomposable") {
        Decomposable tache = new Decomposable(nom, dureeText, selectedDate, selectedHeure, selectedPriorite, selectedCategorie)  ; 
        listeDecomposable.add(tache);}}

    }
    
    

    public List<Simple> getListeSimple() {
        return listeSimple;} 


    public List<Decomposable> getListeDecomposable() {
        return listeDecomposable;}

    /* POUUUUR OBTENIR LES DEUX  LISTES 
     FXMLLoader loader = new FXMLLoader(getClass().getResource("votre_fichier.fxml"));
Parent root = loader.load();
Controller controller = loader.getController();

List<Simple> listeSimple = controller.getListeSimple();
List<Decomposable> listeDecomposable = controller.getListeDecomposable();
 */



  @FXML
    public void  terminertache(ActionEvent event) {} //AVANCER A LA PAGE SUIVANTE SOIT PLANIFIER MANUELLE OU AUTOMATIQUE 




   

   

 
   

   


  @FXML
    void Calendrier(ActionEvent event) throws IOException {

        Authgestion gestion = new Authgestion() ; 
        String nom = pseudocnx.getText();
        //System.out.println("Cest le pseudo : " + nom);

        boolean authentifier = gestion.Connecter(nom);

        if ( authentifier ){ 
        JOptionPane.showMessageDialog(null, "Bienvenue dans votre Planning !"); 
        ///AMOOODIFIER

        Parent root = FXMLLoader.load(getClass().getResource("calendrier.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        //COMME ON A DEJA DESERIALISE LE USER ET IL CONTIENT UN PLANNING ON VA LAFFICHER 
    }
    }
    
    @FXML
    void creerprojet(ActionEvent event) {

    }

}

    




