import java.util.Scanner;
import javafx.scene.layout  ;

public class Utilisateur {
    private String pseudo ; 
    //int id  ; 
    private Badge badge ;
    private int CptTache;
    private int NbTacheMin;

      


public Utilisateur (String pseudo,int NbTacheMin  ){

    this.pseudo= pseudo ; 
    this.CptTache = 0;
    this.badge = Badge.NONE;
    this.NbTacheMin = NbTacheMin;

}

    public void planifier () {}

    public void authentifier (Utilisateur user ) //
    {

    }

 public String  fixerperiode()  //A MODIFIER 
 //DONNE DATEDEBUT ET DATEFIN
 {
    Scanner scanner = new Scanner(System.in);

    System.out.print ( "Veuillez fixer une période pour laquelle vous souhaitez planifier tes taches [exemple : 23mars au 9 AVRIL] : ")  ;

    String periode = scanner.nextLine();


    scanner.close();
    return periode; 

 }
 

 

// METHODE FIXER NOMBRE TACHES 

public void completeTask(Tache task) {
    CptTache++;
    checkBadges(task);
}


private void checkBadges() {
    if (CptTache >= NbTacheMin && badge == Badge.NONE) {
        badge = Badge.GOOD;
        System.out.println("Félicitations ! Vous avez obtenu le badge GOOD.");
    } else if (badge == Badge.GOOD && CptTache >= NbTacheMin * 2) {
        badge = Badge.VERYGOOD;
        System.out.println("Félicitations ! Vous avez obtenu le badge VERYGOOD.");
    } else if (badge == Badge.VERYGOOD && CptTache >= NbTacheMin * 3) {
        badge = Badge.EXCELLENT;
        System.out.println("Félicitations ! Vous avez obtenu le badge EXCELLENT.");
    }
}

}