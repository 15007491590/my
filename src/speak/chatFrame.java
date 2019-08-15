package speak;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import java.util.*;
public class chatFrame {
	  JFrame f;
	  TextArea talkText,myTalkText;
	  JScrollPane s,ms;
	  JButton button;
  	  public chatFrame()
	  {
  		talkText=new TextArea(10,50);
  		myTalkText=new TextArea(5,50);
  		s=new JScrollPane(talkText);
  		ms=new JScrollPane(myTalkText);
  		f=new JFrame("ÁÄÌì");
        button = new JButton("·¢ËÍ");
	  }
	  public void frame()
	  {
		 f.setLayout(new BorderLayout(10,5));
		 f.add(s,BorderLayout.NORTH);
		 f.add(ms);
		 f.add(button,BorderLayout.SOUTH);
		 f.pack();
		 f.setVisible(true);
	  }
      public static void main(String[] args)
      {
    	  chatFrame c =new chatFrame();
    	  c.frame();
      }
}
