package models;

import constructeur.Save;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;











public class CarteJTableModel
  extends AbstractTableModel
{
  private static final long serialVersionUID = 1L;
  private String[] nomColonnes;
  private Vector<String[]> lignes;
  
  public CarteJTableModel()
  {
    nomColonnes = 
      new String[] {
      "Nom", 
      "Carte", 
      "Couleur", 
      "Accords", 
      "Tempo" };
    

    lignes = new Vector();
  }
  




  public int getColumnCount()
  {
    return nomColonnes.length;
  }
  




  public int getRowCount()
  {
    return lignes.size();
  }
  






  public Object getValueAt(int rowIndex, int columnIndex)
  {
    return ((String[])lignes.get(rowIndex))[columnIndex];
  }
  





  public String getColumnName(int column)
  {
    return nomColonnes[column];
  }
  





  public void loadData(List<Save> lesSaves)
  {
    lignes = new Vector();
    for (Save uneSave : lesSaves)
    {

      lignes.add(new String[] { uneSave.getNom(), uneSave.getCarte(), uneSave.getCouleur(), uneSave.getAccords(), uneSave.getTempo() });
    }
    fireTableChanged(null);
  }
}
