import views.FenetrePrincipale;
import java.awt.EventQueue;


public class Main
{
  public Main() {}
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          FenetrePrincipale frame = new FenetrePrincipale();
          
          frame.setVisible(true);
          frame.remplissageComboBox();
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
}
