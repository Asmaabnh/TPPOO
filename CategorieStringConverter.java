import javafx.util.StringConverter;

public class CategorieStringConverter extends StringConverter<Categorie> {
    @Override
    public String toString(Categorie categorie) {
        return categorie.getNom(); // Renvoie le nom de la catégorie
    }

    @Override
    public Categorie fromString(String nom) {
        // Conversion inverse n'est pas nécessaire pour l'affichage uniquement
        return null;
    }
}