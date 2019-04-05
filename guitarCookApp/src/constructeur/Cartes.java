package constructeur;

public class Cartes {
  private String nom;
  private int page;
  private int nbAccords;
  
  public Cartes(String nom, int page, int nbAccords) {
    this.nom = nom;
    this.page = page;
    this.nbAccords = nbAccords;
  }
  
  public String getNom() {
    return nom;
  }
  
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public int getPage() {
    return page;
  }
  
  public void setPage(int page) {
    this.page = page;
  }
  
  public int getNbAccords() {
    return nbAccords;
  }
  
  public void setNbAccords(int nbAccords) {
    this.nbAccords = nbAccords;
  }
  
  public String toString() {
    return "Carte : " + nom + "(p." + page + ") avec " + nbAccords + " accords";
  }
}
