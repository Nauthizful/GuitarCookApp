package views;

import constructeur.Save;
import controller.Generateurs;
import models.CarteJTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import constructeur.Cartes;




public class FenetrePrincipale
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField tfCouleur;
  private JTextField tfAccords;
  private JTextField tfTempo;
  private JComboBox<String> cbCarte;
  private JCheckBox chbCarte;
  private JSpinner spinMin;
  private JSpinner spinMax;
  private static CarteJTableModel carteJTableModel = new CarteJTableModel();
  private JTable jtable = new JTable(carteJTableModel);
  private JScrollPane jscrollpane = new JScrollPane(jtable);
  
  public static ArrayList<Cartes> liste = new ArrayList<Cartes>();
  


  public FenetrePrincipale()
  {
    setResizable(false);
    setBackground(Color.WHITE);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 900, 450);
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    File dir = new File("C:\\Users\\Public\\Documents\\GuitarCookApp");
    dir.mkdirs();
    remplissageTableau();
    jtable.addMouseListener(new MouseListener()
    {
      public void mousePressed(MouseEvent arg0) {}
      public void mouseClicked(MouseEvent e) {}
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) {}
    });
    JPanel panel = new JPanel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setBounds(0, 0, 894, 45);
    contentPane.add(panel);
    
    JLabel lblGuitarCookApp = new JLabel("GUITAR COOK APP");
    lblGuitarCookApp.setFont(new Font("Impact", 0, 22));
    panel.add(lblGuitarCookApp);
    
    JLabel lblCarte = new JLabel("Carte :");
    lblCarte.setBounds(10, 53, 62, 14);
    contentPane.add(lblCarte);
    
    cbCarte = new JComboBox<String>();
    cbCarte.setBackground(Color.WHITE);
    cbCarte.setToolTipText("test");
    cbCarte.setMaximumRowCount(500);
    cbCarte.setBounds(59, 50, 199, 20);
    contentPane.add(cbCarte);
    
    chbCarte = new JCheckBox("Carte aléatoire");
    chbCarte.setBackground(Color.WHITE);
    chbCarte.setBounds(6, 74, 153, 23);
    contentPane.add(chbCarte);
    
    JLabel lblCouleur = new JLabel("Couleur :");
    lblCouleur.setBounds(268, 53, 73, 14);
    contentPane.add(lblCouleur);
    
    tfCouleur = new JTextField();
    tfCouleur.setBackground(Color.WHITE);
    tfCouleur.setEditable(false);
    tfCouleur.setBounds(319, 50, 97, 20);
    contentPane.add(tfCouleur);
    tfCouleur.setColumns(10);
    
    JLabel lblAccords = new JLabel("Accords :");
    lblAccords.setBounds(465, 56, 73, 14);
    contentPane.add(lblAccords);
    
    tfAccords = new JTextField();
    tfAccords.setEditable(false);
    tfAccords.setColumns(10);
    tfAccords.setBackground(Color.WHITE);
    tfAccords.setBounds(521, 53, 86, 20);
    contentPane.add(tfAccords);
    
    JLabel lblTempo = new JLabel("Tempo :");
    lblTempo.setBounds(638, 56, 62, 14);
    contentPane.add(lblTempo);
    
    tfTempo = new JTextField();
    tfTempo.setEditable(false);
    tfTempo.setColumns(10);
    tfTempo.setBackground(Color.WHITE);
    tfTempo.setBounds(687, 56, 86, 20);
    contentPane.add(tfTempo);
    
    JLabel lblTempoMin = new JLabel("Tempo Min :");
    lblTempoMin.setBounds(768, 83, 86, 14);
    contentPane.add(lblTempoMin);
    
    spinMin = new JSpinner();
    spinMin.setModel(new SpinnerNumberModel(70, 70, 250, 1));
    spinMin.setBounds(719, 80, 46, 20);
    contentPane.add(spinMin);
    
    JLabel lblTempoMax = new JLabel("Tempo Max :");
    lblTempoMax.setBounds(638, 83, 86, 14);
    contentPane.add(lblTempoMax);
    
    spinMax = new JSpinner();
    spinMax.setModel(new SpinnerNumberModel(250, 70, 250, 1));
    spinMax.setBounds(838, 80, 46, 20);
    contentPane.add(spinMax);
    
    JButton btnEnregistrer = new JButton("Enregistrer");
    btnEnregistrer.setEnabled(false);
    btnEnregistrer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        enregistrer();
      }
    });
    btnEnregistrer.setBounds(366, 122, 112, 23);
    contentPane.add(btnEnregistrer);
    
    JButton btnGenerer = new JButton("Générer");
    btnGenerer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        generer();
        btnEnregistrer.setEnabled(true);
      }
    });
    btnGenerer.setBounds(100, 122, 112, 23);
    contentPane.add(btnGenerer);
    
    jscrollpane.setBounds(0, 172, 894, 249);
    contentPane.add(jscrollpane);
    
    JButton btnSupprimer = new JButton("Supprimer");
    btnSupprimer.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
          supprimer();
        }
      });
    btnSupprimer.setBounds(612, 122, 112, 23);
    contentPane.add(btnSupprimer);
  }
  
  public void generer() {
    if (chbCarte.isSelected()) {
      cbCarte.setSelectedIndex(Generateurs.randCarte(liste.size()));
    }
    int test = cbCarte.getSelectedIndex();
    tfCouleur.setText(Generateurs.randCouleur());
    tfAccords.setText(Generateurs.randAccords(((Cartes)liste.get(test)).getNbAccords()));
    int tempoMin = Integer.parseInt(spinMin.getValue().toString());
    int tempoMax = Integer.parseInt(spinMax.getValue().toString());
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
    Cartes kumoi = new Cartes("Kumoï", 34, 5);
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
    List<Save> lesSaves = new ArrayList<Save>();
    File rep = new File("C:\\Users\\Public\\Documents\\GuitarCookApp");
    File[] fichierstxt = rep.listFiles(new FilenameFilter() {
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
  //TODO : Choix de fichier par selection dans le tableau
  public void supprimer() {
	  int ligne = jtable.getSelectedRow();
	  if(ligne == -1) {
		  JOptionPane.showMessageDialog(this, "Vous devez selectionner une ligne du tableau", "Supprimer", 1);
	  }else {
		  File fichier = new File("C:\\Users\\Public\\Documents\\GuitarCookApp\\" + jtable.getValueAt(ligne, 0) + ".txt");
		  if(JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir supprimer \"" + jtable.getValueAt(ligne, 0) + "\" ? Pas d'annulation possible", "Supprimer", 0, 3) == 0) {
			  fichier.delete();
			  remplissageTableau();
		  }
	  }
  }
}
