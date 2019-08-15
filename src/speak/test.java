package speak;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class test extends JDialog
{
   public static void main(String[] args)
   {
	   Frame f = new Frame("≤‚ ‘");
	   
	   Panel p=new Panel();
	   TextField h=new TextField();
	   BorderLayout b=new BorderLayout(300,50);
	   p.setLayout(b);
	   p.add(h,b.CENTER);
	   f.add(p);
	   f.pack();
	   f.setVisible(true);
   }
}
