import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Form extends WindowAdapter implements ActionListener
{
  Frame f;
  Label l1, l2;
  TextField t1, t2;
  Button b;
  public Form ()
  {
    f = new Frame ("Form");
    l1 = new Label ("Email:");
    l2 = new Label ("Password:");
    t1 = new TextField (50);
    t2 = new TextField (50);
    b = new Button ("Insert");
    l1.setBounds (65, 125, 60, 20);
    t1.setBounds (145, 125, 130, 20);
    l2.setBounds (60, 160, 80, 20);
    t2.setBounds (145, 160, 130, 20);
    b.setBounds (130, 200, 100, 20);
    t1.setFont (new Font ("Arial", Font.BOLD, 14));
    t2.setFont (new Font ("Arial", Font.BOLD, 14));
    l1.setFont (new Font ("Arial", Font.BOLD, 14));
    l2.setFont (new Font ("Arial", Font.BOLD, 14));
    b.setFont (new Font ("Arial", Font.BOLD, 14));
    b.addActionListener (this);
    b.setBackground (Color.LIGHT_GRAY);
    t1.setBackground (Color.LIGHT_GRAY);
    t2.setBackground (Color.LIGHT_GRAY);
    f.add (l1);
    f.add (l2);
    f.add (t1);
    f.add (t2);
    f.add (b);
    f.addWindowListener (this);
    f.setBackground (Color.PINK);
    f.setSize (360, 400);
    f.setLayout (null);
    f.setVisible (true);
  }
  public void windowClosing (WindowEvent ev)
  {
    f.dispose ();
  }
  public static void main (String args[]) throws Exception
  {
    new Form ();
  }
  public void actionPerformed (ActionEvent e)
  {
    String Email = t1.getText ();
    String Password = t2.getText ();

    try
    {

      Class.forName ("com.mysql.cj.jdbc.Driver");

      String DB_URL = "jdbc:mysql://localhost:3306/arpitdb";
      String USER = "root";
      String PASS = "arpit@8839";

      Connection conn = DriverManager.getConnection (DB_URL, USER, PASS);
      String q = "insert into Resister(Email ,Password ) values (? ,?)";

      PreparedStatement pstmt = conn.prepareStatement (q);
      pstmt.setString (1, Email);
      pstmt.setString (2, Password);

      pstmt.executeUpdate ();

      System.out.println ("inserted...");
    } catch (Exception ew)
    {
      ew.printStackTrace ();
    }

  }

}
