import java.util.ArrayList;

import java.util.List;



public class Projet {
    private String nom ; 
    private String description ; 
    private List<String> taches = new ArrayList<>();



    public Projet( String nom, String description ,  List<String> taches  ) {
        this.nom = nom ; 
        this.description = description ; 
        this.taches = taches;  //It is initialized here : create an empty list 
    }

    public void addtache(String str) {
        taches.add(str);
    }  


   

   

}
