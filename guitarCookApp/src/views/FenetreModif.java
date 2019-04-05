package views;

import models.CarteJTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;

import constructeur.Cartes;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;




public class FenetreModif
  extends JFrame
{
  private String nom;
  private String carte;
  private String couleur;
  private String accords;
  private String tempo;
  private JPanel panelCo;
  private JPanel contentPane;
  private JLabel lblModifNom;
  private JLabel lblModifCarte;
  private JLabel lblModifCouleur;
  private JLabel lblModifAccords;
  private JLabel lblModifTempo;
  private JTextField inputModifNom;
  private JComboBox<String> inputModifCarte;
  private JComboBox<String> inputModifCouleur;
  private JTextField inputModifAccords;
  private JSpinner inputModifTempo = new JSpinner();
  private JSpinner.NumberEditor spinnerEditor = new JSpinner.NumberEditor(inputModifTempo);
  
  private CarteJTableModel carteJTableModel = new CarteJTableModel();
  private JTable jtable = new JTable(carteJTableModel);
  
  private JButton btnModifier;
  
  private JButton btnAnnuler;
  private ArrayList<String> couleurs = new ArrayList();
  




  public FenetreModif(String nom, String carte, String couleur, String accords, String tempo)
  {
    this.nom = nom;
    this.carte = carte;
    this.couleur = couleur;
    this.accords = accords;
    this.tempo = tempo;
    setBounds(100, 300, 600, 300);
    contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    contentPane.add(getPanelModif());
    remplissageCb();
  }
  


  private JPanel getPanelModif()
  {
    if (panelCo == null)
    {
      panelCo = new JPanel();
      

      panelCo.add(getLblModifNom());
      panelCo.add(getInputModifNom());
      
      panelCo.add(getLblModifCarte());
      panelCo.add(getInputModifCarte());
      
      panelCo.add(getLblModifCouleur());
      panelCo.add(getInputModifCouleur());
      
      panelCo.add(getLblModifAccords());
      panelCo.add(getInputModifAccords());
      
      panelCo.add(getLblModifTempo());
      panelCo.add(getInputModifTempo());
      
      panelCo.add(getBtnModifier());
      panelCo.add(getBtnAnnuler());
    }
    return panelCo;
  }
  


  public JLabel getLblModifNom()
  {
    if (lblModifNom == null)
    {
      lblModifNom = new JLabel(" Nom :");
    }
    return lblModifNom;
  }
  

  public JLabel getLblModifCarte()
  {
    if (lblModifCarte == null)
    {
      lblModifCarte = new JLabel(" Carte :");
    }
    return lblModifCarte;
  }
  

  public JLabel getLblModifCouleur()
  {
    if (lblModifCouleur == null)
    {
      lblModifCouleur = new JLabel(" Couleur :");
    }
    return lblModifCouleur;
  }
  

  public JLabel getLblModifAccords()
  {
    if (lblModifAccords == null)
    {
      lblModifAccords = new JLabel(" Accords :");
    }
    return lblModifAccords;
  }
  
  public JLabel getLblModifTempo()
  {
    if (lblModifTempo == null)
    {
      lblModifTempo = new JLabel(" Tempo :");
    }
    return lblModifTempo;
  }
  



  public JTextField getInputModifNom()
  {
    if (inputModifNom == null)
    {
      inputModifNom = new JTextField(nom);
      inputModifNom.setColumns(10);
      inputModifNom.setFocusable(false);
    }
    return inputModifNom;
  }
  

  public JComboBox<String> getInputModifCarte()
  {
    if (inputModifCarte == null) {
      inputModifCarte = new JComboBox();
    }
    return inputModifCarte;
  }
  

  public JComboBox<String> getInputModifCouleur()
  {
    if (inputModifCouleur == null) {
      inputModifCouleur = new JComboBox();
    }
    return inputModifCarte;
  }
  

  public JTextField getInputModifAccords()
  {
    if (inputModifAccords == null)
    {
      inputModifAccords = new JTextField(accords);
      inputModifAccords.setColumns(10);
      inputModifAccords.setFocusable(false);
    }
    return inputModifAccords;
  }
  

  public JSpinner getInputModifTempo()
  {
    if (inputModifTempo == null)
    {
      inputModifTempo.setEditor(spinnerEditor);
      spinnerEditor.getModel().setMinimum(Integer.valueOf(70));
      spinnerEditor.getModel().setMaximum(Integer.valueOf(250));
      spinnerEditor.getModel().setValue(Integer.valueOf(Integer.parseInt(tempo.toString())));
    }
    return inputModifTempo;
  }
  









  private JButton getBtnModifier()
  {
    if (btnModifier == null)
    {
      btnModifier = new JButton("Modifier");
      btnModifier.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0) {}
      });
    }
    



    return btnModifier;
  }
  




  private JButton getBtnAnnuler()
  {
    if (btnAnnuler == null) {
      btnAnnuler = new JButton("Annuler");
      btnAnnuler.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          int confirm = JOptionPane.showConfirmDialog(panelCo, 
            "Vous allez vraiment quitter cette fenêtre ", 
            "Modifier", 
            2);
          if (confirm == 0) {
            dispose();
          }
        }
      });
    }
    return btnAnnuler;
  }
  
  private void remplissageCb() {
    for (int i = 0; i != Fenetre.liste.size(); i++) {
      inputModifCarte.addItem(((Cartes)Fenetre.liste.get(i)).getNom() + " (p." + ((Cartes)Fenetre.liste.get(i)).getPage() + ")");
    }
    
    couleurs.add("Bleue clair");
    couleurs.add("Bleue");
    couleurs.add("Bleue foncé");
    couleurs.add("Vert clair");
    couleurs.add("Vert");
    couleurs.add("Vert foncé");
    couleurs.add("Rose clair");
    couleurs.add("Rose");
    couleurs.add("Rose");
    couleurs.add("Orange clair");
    couleurs.add("Orange");
    couleurs.add("Orange foncé");
    
    for (int i = 0; i != couleurs.size(); i++) {
      inputModifCouleur.addItem(((String)couleurs.get(i)).toString());
    }
  }
}
