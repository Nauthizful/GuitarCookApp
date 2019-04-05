package constructeur;

public class Save {
  private String nom;
  private String carte;
  private String couleur;
  private String accords;
  private String tempo;
  
  public Save(String nom, String carte, String couleur, String accords, String tempo) {
    this.nom = nom;
    this.carte = carte;
    this.couleur = couleur;
    this.accords = accords;
    this.tempo = tempo;
  }
  
  public String getNom() {
    return nom;
  }
  
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public String getCarte() {
    return carte;
  }
  
  public void setCarte(String carte) {
    this.carte = carte;
  }
  
  public String getCouleur() {
    return couleur;
  }
  
  public void setCouleur(String couleur) {
    this.couleur = couleur;
  }
  
  public String getAccords() {
    return accords;
  }
  
  public void setAccords(String accords) {
    this.accords = accords;
  }
  
  public String getTempo() {
    return tempo;
  }
  
  public void setTempo(String tempo) {
    this.tempo = tempo;
  }
  
  public String toString()
  {
    return "Save [nom=" + nom + ", carte=" + carte + ", couleur=" + couleur + ", accords=" + accords + ", tempo=" + tempo + "]";
  }
}
