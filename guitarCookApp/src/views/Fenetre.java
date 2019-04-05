package views;

import constructeur.Save;
import controller.Generateurs;
import models.CarteJTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;

import constructeur.Cartes;

public class Fenetre extends javax.swing.JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel panelPrincipal;
  private JPanel contentPane;
  private JLabel guitarCookApp;
  private JLabel labelCarte;
  private JComboBox<String> cbCarte;
  private JCheckBox carteRandom;
  private JLabel labelCouleur;
  private JTextField tfCouleur;
  private JLabel labelAccords;
  private JTextField tfAccords;
  private int bpm = 0;
  private JLabel labelTempo;
  private JTextField tfTempo;
  private JButton btnMetronome;
  private JLabel lblMinTempo;
  private JSpinner spinTempoMin = new JSpinner();
  private JSpinner.NumberEditor spinnerEditorMin = new JSpinner.NumberEditor(spinTempoMin);
  private JLabel lblMaxTempo;
  private JSpinner spinTempoMax = new JSpinner();
  private JSpinner.NumberEditor spinnerEditorMax = new JSpinner.NumberEditor(spinTempoMax);
  
  private JButton btnGenerer;
  
  private JButton btnEnregistrer;
  
  private static CarteJTableModel carteJTableModel = new CarteJTableModel();
  private JTable jtable = new JTable(carteJTableModel);
  private JScrollPane jscrollpane = new JScrollPane(jtable);
  
  public static ArrayList<Cartes> liste = new ArrayList();
  
  public Fenetre() {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 1550, 300);
    
    contentPane = new JPanel();
    contentPane.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new java.awt.BorderLayout(0, 0));
    setContentPane(contentPane);
    contentPane.add(getPanelPrincipal(), "First");
    getContentPane().add(jscrollpane, "Center");
    File dir = new File("C:\\Users\\Public\\Documents\\GuitarCookApp");
    dir.mkdirs();
    remplissageTableau();
    jtable.addMouseListener(new java.awt.event.MouseListener()
    {
      public void mousePressed(MouseEvent arg0)
      {
        JTable table = (JTable)arg0.getSource();
        int ligne = table.getSelectedRow();
        if ((arg0.getClickCount() == 2) && (table.getSelectedRow() != -1)) {
          ouvrirFenetreModif(ligne);
        }
      }
      




      public void mouseClicked(MouseEvent e) {}
      



      public void mouseEntered(MouseEvent e) {}
      



      public void mouseExited(MouseEvent e) {}
      



      public void mouseReleased(MouseEvent e) {}
    });
  }
  



  private JPanel getPanelPrincipal()
  {
    if (panelPrincipal == null) {
      panelPrincipal = new JPanel();
      
      panelPrincipal.add(getGuitarCookApp());
      


      panelPrincipal.add(getLabelCarte());
      panelPrincipal.add(getCbCarte());
      panelPrincipal.add(getCarteRandom());
      
      panelPrincipal.add(getLabelCouleur());
      panelPrincipal.add(getTfCouleur());
      
      panelPrincipal.add(getLabelAccords());
      panelPrincipal.add(getTfAccords());
      
      panelPrincipal.add(getLabelTempo());
      panelPrincipal.add(getTfTempo());
      
      panelPrincipal.add(getLblMinTempo());
      panelPrincipal.add(getSpinTempoMin());
      panelPrincipal.add(getLblMaxTempo());
      panelPrincipal.add(getSpinTempoMax());
      
      panelPrincipal.add(getBtnGenerer());
      panelPrincipal.add(getBtnEnregistrer());
    }
    
    return panelPrincipal;
  }
  
  private JLabel getGuitarCookApp() {
    if (guitarCookApp == null) {
      guitarCookApp = new JLabel("GuitarCookApp");
    }
    return guitarCookApp;
  }

  public JLabel getLabelCarte()
  {
    if (labelCarte == null) {
      labelCarte = new JLabel("Carte : ");
    }
    return labelCarte;
  }
  
  public JComboBox<String> getCbCarte() {
    if (cbCarte == null) {
      cbCarte = new JComboBox();
      cbCarte.setFocusable(false);
    }
    return cbCarte;
  }
  
  public JCheckBox getCarteRandom() {
    if (carteRandom == null) {
      carteRandom = new JCheckBox();
      carteRandom.setText("Carte aléatoire");
    }
    return carteRandom;
  }
  
  public JLabel getLabelCouleur() {
    if (labelCouleur == null) {
      labelCouleur = new JLabel("Couleur : ");
    }
    return labelCouleur;
  }
  
  public JTextField getTfCouleur() {
    if (tfCouleur == null) {
      tfCouleur = new JTextField();
      tfCouleur.setColumns(10);
      tfCouleur.setFocusable(false);
    }
    return tfCouleur;
  }
  
  public JLabel getLabelAccords() {
    if (labelAccords == null) {
      labelAccords = new JLabel("Accords : ");
    }
    return labelAccords;
  }
  
  public JTextField getTfAccords() {
    if (tfAccords == null) {
      tfAccords = new JTextField();
      tfAccords.setColumns(10);
      tfAccords.setFocusable(false);
    }
    return tfAccords;
  }
  
  public JLabel getLabelTempo() {
    if (labelTempo == null) {
      labelTempo = new JLabel("Tempo : ");
    }
    return labelTempo;
  }
  
  public JTextField getTfTempo() {
    if (tfTempo == null) {
      tfTempo = new JTextField();
      tfTempo.setColumns(10);
      tfTempo.setFocusable(false);
    }
    return tfTempo;
  }
    
  public JLabel getLblMinTempo() {
    if (lblMinTempo == null) {
      lblMinTempo = new JLabel("Tempo minimum : ");
    }
    return lblMinTempo;
  }
  
  public JSpinner getSpinTempoMin() {
    spinTempoMin.setEditor(spinnerEditorMin);
    spinnerEditorMin.getModel().setMinimum(Integer.valueOf(70));
    spinnerEditorMin.getModel().setMaximum(Integer.valueOf(250));
    spinnerEditorMin.getModel().setValue(Integer.valueOf(70));
    return spinTempoMin;
  }
  
  public JLabel getLblMaxTempo() {
    if (lblMaxTempo == null) {
      lblMaxTempo = new JLabel("Tempo maximum : ");
    }
    return lblMaxTempo;
  }
  
  public JSpinner getSpinTempoMax() {
    spinTempoMax.setEditor(spinnerEditorMax);
    spinnerEditorMax.getModel().setMinimum(Integer.valueOf(70));
    spinnerEditorMax.getModel().setMaximum(Integer.valueOf(250));
    spinnerEditorMax.getModel().setValue(Integer.valueOf(250));
    
    spinTempoMax.addChangeListener(new javax.swing.event.ChangeListener()
    {
      public void stateChanged(ChangeEvent e) {}

    });
    return spinTempoMax;
  }
  
  public JButton getBtnGenerer() {
    if (btnGenerer == null) {
      btnGenerer = new JButton("Générer");
      btnGenerer.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          generer();
        }
      });
    }
    
    return btnGenerer;
  }
  
  public JButton getBtnEnregistrer() {
    if (btnEnregistrer == null) {
      btnEnregistrer = new JButton("Enregistrer");
      btnEnregistrer.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          enregistrer();
        }
      });
    }
    
    return btnEnregistrer;
  }
  
  public void generer() {
    if (carteRandom.isSelected()) {
      cbCarte.setSelectedIndex(Generateurs.randCarte(liste.size()));
    }
    int test = cbCarte.getSelectedIndex();
    tfCouleur.setText(Generateurs.randCouleur());
    tfAccords.setText(Generateurs.randAccords(((Cartes)liste.get(test)).getNbAccords()));
    int tempoMin = Integer.parseInt(spinTempoMin.getValue().toString());
    int tempoMax = Integer.parseInt(spinTempoMax.getValue().toString());
    tfTempo.setText(Generateurs.randTempo(tempoMin, tempoMax));
  }
  
  public void enregistrer() {
    String nom = JOptionPane.showInputDialog(this, "Entrez un nom", "Nom", 3);
    Pattern p = Pattern.compile("^(\\p{Alnum})+$");
    Matcher m = p.matcher(nom);
    while ((nom.isEmpty()) && (!m.find())) {
      nom = JOptionPane.showInputDialog(this, "Vous devez entrer un nom", "Nom", 2);
    }
    int index = cbCarte.getSelectedIndex();
    String carte = ((Cartes)liste.get(index)).getNom();
    try {
      FileWriter fw = new FileWriter("C:\\Users\\Public\\Documents\\GuitarCookApp\\" + nom + ".txt");
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(carte + " - " + tfCouleur.getText() + " - " + tfAccords.getText() + " - " + tfTempo.getText());
      bw.close();
      JOptionPane.showMessageDialog(this, "Enregistrement réussi. Un fichier texte à  été créé dans vos documents.", "Enregistrement", 1);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "Vous ne pouvez pas utiliser de caractères spéciaux", "Nom", 2);
      enregistrer();
    }
    remplissageTableau();
  }
  
  public void remplissageComboBox() {
    Cartes pentatonique = new Cartes("Pentatoniques", 26, 5);
    liste.add(pentatonique);
    Cartes ecclesiastiques = new Cartes("Ecclésiastiques", 27, 7);
    liste.add(ecclesiastiques);
    Cartes harmonique = new Cartes("Harmonique", 28, 7);
    liste.add(harmonique);
    Cartes melodique = new Cartes("Mélodique", 29, 7);
    liste.add(melodique);
    Cartes hirajoshi = new Cartes("Hirajoshi", 33, 5);
    liste.add(hirajoshi);
    Cartes kumoi = new Cartes("Kumoi", 34, 5);
    liste.add(kumoi);
    Cartes locrien = new Cartes("Pentatonique locrien", 35, 5);
    liste.add(locrien);
    Cartes locrien9 = new Cartes("Pentatonique locrien #9", 36, 5);
    liste.add(locrien9);
    Cartes pelog = new Cartes("Pelog", 37, 5);
    liste.add(pelog);
    Cartes scriabine = new Cartes("Scriabine", 38, 5);
    liste.add(scriabine);
    Cartes promethee = new Cartes("Prométhée", 39, 6);
    liste.add(promethee);
    Cartes piongio = new Cartes("Piongio", 40, 6);
    liste.add(piongio);
    Cartes raganone = new Cartes("Rafa None", 41, 7);
    liste.add(raganone);
    Cartes peiraiotikos = new Cartes("Peiraiotikos", 42, 7);
    liste.add(peiraiotikos);
    Cartes melasuryakanta = new Cartes("Mela Suryakanta", 43, 7);
    liste.add(melasuryakanta);
    Cartes ragaambika = new Cartes("Raga Ambika", 44, 7);
    liste.add(ragaambika);
    Cartes ragaganavaridhi = new Cartes("Raga ganavaridhi", 45, 7);
    liste.add(ragaganavaridhi);
    Cartes ragaganasamavarali = new Cartes("Raga ganasamavarali", 46, 7);
    liste.add(ragaganasamavarali);
    Cartes melanavanitam = new Cartes("Mela navanitam", 47, 7);
    liste.add(melanavanitam);
    
    for (int i = 0; i != liste.size(); i++) {
      cbCarte.addItem(((Cartes)liste.get(i)).getNom() + " (p." + ((Cartes)liste.get(i)).getPage() + ")");
    }
  }
  
  public void remplissageTableau() {
    List<Save> lesSaves = new ArrayList();
    File rep = new File("C:\\Users\\Public\\Documents\\GuitarCookApp");
    File[] fichierstxt = rep.listFiles(new java.io.FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
      }
    });
    for (int i = 0; i < fichierstxt.length; i++) {
      try {
        FileReader fr = new FileReader(fichierstxt[i]);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
          String[] parts = line.split("-");
          String nom = fichierstxt[i].getName().substring(0, fichierstxt[i].getName().length() - 4);
          lesSaves.add(new Save(nom, parts[0], parts[1], parts[2], parts[3]));
        }
        br.close();
      }
      catch (IOException localIOException) {}
    }
    
    if (lesSaves.size() > 0)
    {
      carteJTableModel.loadData(lesSaves);
    } else {
      lesSaves.add(new Save("Aucun jeu n'a été trouvé", "", "", "", ""));
      carteJTableModel.loadData(lesSaves);
    }
  }
  
  public void ouvrirFenetreModif(int ligne) {
    String nom = carteJTableModel.getValueAt(ligne, 0).toString();
    String carte = carteJTableModel.getValueAt(ligne, 1).toString();
    String couleur = carteJTableModel.getValueAt(ligne, 2).toString();
    String accords = carteJTableModel.getValueAt(ligne, 3).toString();
    String tempo = carteJTableModel.getValueAt(ligne, 4).toString();
    System.out.println(nom);
    System.out.println(carte);
    System.out.println(couleur);
    System.out.println(accords);
    System.out.println(tempo);
  }
}
