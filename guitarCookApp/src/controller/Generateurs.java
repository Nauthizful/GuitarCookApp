package controller;

import java.util.ArrayList;

public class Generateurs {
  public Generateurs() {}
  
  public static int randCarte(int size) {
    java.util.Random index = new java.util.Random();
    return index.nextInt(size + 1 - 1);
  }
  
  public static String randCouleur() {
    String result = "";
    java.util.Random index = new java.util.Random();
    ArrayList<String> couleurs = new ArrayList();
    ArrayList<String> nuances = new ArrayList();
    
    couleurs.add("Bleue");
    couleurs.add("Vert");
    couleurs.add("Rose");
    couleurs.add("Orange");
    
    nuances.add("clair");
    nuances.add("");
    nuances.add("foncé");
    
    result = (String)couleurs.get(index.nextInt(4)) + " " + (String)nuances.get(index.nextInt(3));
    
    return result;
  }
  
  public static String randTempo(int tempoMin, int tempoMax)
  {
    java.util.Random rand = new java.util.Random();
    int result = tempoMin + 1 + rand.nextInt(tempoMax - (tempoMin + 1));
    String resultat = Integer.toString(result);
    return resultat;
  }
  
  public static String randAccords(int nbAccords) {
    String result = "";
    ArrayList<Integer> tab = new ArrayList();
    int remplissage = 1;
    java.util.Random index = new java.util.Random();
    

    while (remplissage != nbAccords + 2) {
      tab.add(Integer.valueOf(remplissage));
      remplissage++;
    }
    
    for (int i = 0; i != 4; i++) {
      int test = index.nextInt(tab.size() - 1);
      result = result + tab.get(test);
      tab.remove(tab.get(test));
    }
    
    return result;
  }
}
