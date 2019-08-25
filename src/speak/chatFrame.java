package speak;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import speak.friendMesFrame.sendListener;

import java.io.*;
import java.awt.image.*;
import java.util.*;
public class chatFrame{
	  Client client;
	  JFrame f;
	  friendFrame e;
	  TextArea talkText,myTalkText;
	  JScrollPane s,ms;
	  JButton button;
	  String username;
	  String name;
	  String friendName;
  	  public chatFrame(String username,String name,Client client,String friendName)
	  {
  		this.friendName=friendName;
  		this.client=client;
  		this.e=e;
  		this.username=username;
  		this.name=name;
  		talkText=new TextArea(10,50);
  		talkText.setEditable(false);//只能写
  		talkText.setBackground(Color.WHITE);
  		talkText.setFont(new Font("黑体",Font.BOLD,18));
        talkText.setForeground(Color.BLUE);
        
  		myTalkText=new TextArea(5,50);
  		myTalkText.setFont(new Font("黑体",Font.BOLD,18));
  		myTalkText.setForeground(Color.BLUE);
  		
  		s=new JScrollPane(talkText);
  		ms=new JScrollPane(myTalkText);
  		
  		f=new JFrame("和 "+name+" 聊天中");
        button = new JButton("发送");
        button.addActionListener(new enSendListener());
        f.setLayout(new BorderLayout(10,5));
		 f.add(s,BorderLayout.NORTH);
		 f.add(ms);
		 f.add(button,BorderLayout.SOUTH);
		 f.pack();
		 f.setLocation(500, 200);
	  }
	  public void frame()
	  {
		 f.setVisible(true);
	  }
	  class enSendListener implements ActionListener
	  {
	      public void actionPerformed(ActionEvent e)
	    	{
	      	    String mes =myTalkText.getText();
	      	    talkText.append("我: "+ mes+'\n');
	      	    client.sendMes(mes+"<>"+username);
	    	}
	  }
      
}
