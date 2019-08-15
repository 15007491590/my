package speak;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import java.util.*;
public class friendFrame {
	myMesFrame m;
    //friend  mes  
    String[] a= new String[3];
	public void frame()
			throws Exception
	{
		JFrame f=new JFrame("测试");
		//Container p = f.getContentPane(); 
		//BorderLayout bo= new BorderLayout(30,5);
	    //p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
	    Box ver= Box.createVerticalBox();
		JScrollPane s =new JScrollPane(ver);
		
		//s.setHorizontalScrollBarPolicy(   
                //JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		//s.setLayout(new BoxLayout(s,BoxLayout.Y_AXIS));
		//Container p1 = s.getContentPane();
		//s.setLayout(bo);
		//s(new BoxLayout(s,BoxLayout.Y_AXIS));
		
		friendMesFrame fmsg=new friendMesFrame(ImageIO.read(new File("ico/1.gif")),"123");
	    ver.add(fmsg.frame());
	    
	    for(int i=0;i<50;i++)
		{
			friendMesFrame fmsg1=new friendMesFrame(ImageIO.read(new File("ico/1.gif")),"123");
		    ver.add(fmsg1.frame());
		    
		}
	    f.add(s);
	    f.setBounds(20,30,100,300);
	    f.setVisible(true);
	    
	}
	public static void main(String[] args)
	throws Exception
    {
		friendFrame f = new friendFrame();
		f.frame();
	    /*JFrame f=new JFrame();
	    BorderLayout bo= new BorderLayout(30,5);
	    f.setLayout(new BorderLayout(30,5));
	    
	    myCanvas c=new myCanvas();
	    JPanel j =new JPanel();
	    //Graphics g=new Graphics();
	    
	    c.setPreferredSize(new Dimension(250,180));
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	    //Graphics g;
	    BufferedImage b = ImageIO.read(new File("ico/1.gif"));
	    c.b=b;
	    c.repaint();
	    
	    j.add(c);
	    
	    f.add(j,new BorderLayout(0,0).SOUTH);*/
	    
    }
}
class myCanvas extends Canvas
{
	//private static final long serialVersionUID = 1L; 序列化
	public BufferedImage b;
	public void paint(Graphics g)
	{
		g.drawImage(b,0,0,null);
		
	}
}
class myMesFrame extends Canvas
{
	//private static final long serialVersionUID = 1L;   序列化
	public HashMap<BufferedImage,String> b=new HashMap<BufferedImage,String>();
	public String name;
	public myMesFrame(BufferedImage b,String name)
	{
		this.b=b;
		this.name=name;
		myCanvas img=new myCanvas();
	}
	public void paint(Graphics g)
	{
		g.drawImage(b,0,0,null);
	}
}
class friendMesFrame extends Canvas
{
	public BufferedImage img;
	public String name;
	public JPanel j;
	public static int WIDTH = 40;
	public friendMesFrame(BufferedImage img,String name)
	{
		this.img=img;
		this.name=name;	
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,0,0,null);
	}
	public JPanel frame()
	{
		j=new JPanel();
	    BorderLayout bo= new BorderLayout(0,0);
	    this.setPreferredSize(new Dimension(WIDTH,WIDTH));
	    j.add(this);
	    this.repaint();
	    
	    
		return j;
	}
}
