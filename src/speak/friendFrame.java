package speak;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import speak.apply.enApplyListener;
import java.io.*;
import java.sql.ResultSet;
import java.awt.image.*;
import java.util.*;
import java.awt.event.*;

public class friendFrame {
	Client client ;
	imgBank bank;
	static HashSet <friendMesFrame>friendSet=new HashSet<>();
	myMesFrame m;
    //friend  mes 
    String[] a= new String[3];
    String username;
    public friendFrame(Client client,String username)
    {
    	this.username=username;
    	this.client=client;
    	//bank=new imgBank();
    	//bank.initBank();
    }
	public void frame()
			throws Exception
	{
		JFrame f=new JFrame("测试");
		String sql=new String();
		
		JPanel space=new JPanel();
		//设置背景颜色
	    //space.setOpaque(true);
		//space.setBackground(Color.WHITE);
		space.setPreferredSize(new Dimension(30,30));
		JLabel list =new JLabel("好友列表");
		space.add(list);
		list.setForeground(Color.GREEN);
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
		sql="select name,username,password,img from users where username='"+username+"';";
		ResultSet ts = getSql.research(sql);
		if(ts.next())
		{
			myMesFrame fmsg=new myMesFrame(ts.getString(4),ImageIO.read(new File(ts.getString(4))),ts.getString(1),ts.getString(2),ts.getString(3));
		    ver.add(fmsg.frame());
		}
	    ver.add(space);
	    
	    sql="select name,username,img from users;";
	    ResultSet rs = getSql.research(sql);  
	    // ResultSet rss=getSql.stmt.getResultSet();
	    rs.last();
	    int t=rs.getRow();
	    rs.first();
        for(int i=0;i<t;i++)
        {
        	if(!username.equals(rs.getString(2)))
        	{
        		friendMesFrame fmsg1=new friendMesFrame(ImageIO.read(new File(rs.getString(3))),rs.getString(1),rs.getString(2),client);
        		ver.add(fmsg1.frame());
        		friendSet.add(fmsg1);
        	}
    		rs.next();
        }
	    f.add(s);
	    f.setBounds(900,50,250,500);
	    f.setVisible(true);
	    
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
	imgBank bank;

	BufferedImage img;
	public JPanel j;
	public String name;
	public String username;
	private String password;
	public JButton msg;
	public JLabel jname;
	public static int WIDTH = 40;
	
	public JPanel minj;
	public JFrame myMsgFrame;
	public JButton save,changePassword;
	
	public JLabel jl1 = new JLabel();
	public JLabel jl2 = new JLabel();
	
	public JTextField jt2 =new JTextField(20);
	
	JLabel lab;
	String picPath;
	ImageIcon icon;
    JButton imgChange;
	
	public myMesFrame(String imgi,BufferedImage img,String name,String username,String password)
	{
		
		this.img=img;
		this.name=name;
		this.username=username;
		this.password=password;
		bank=new imgBank(this);
    	bank.initBank();
    	bank.path=picPath;
		myMsgFrame = new JFrame();
		
        picPath = imgi;
        
	    icon = new ImageIcon(picPath);
	    
	    lab = new JLabel();
		lab.setIcon(icon);
		//myCanvas img=new myCanvas();
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,0,0,null);
		//g.drawImage
	}
	public JPanel frame()
	{
		j=new JPanel();
		
		minj=new JPanel();
		minj.setLayout(new BorderLayout(0,0));
		//minj.setOpaque(true);
		//minj.setBackground(Color.YELLOW);
		
		msg=new JButton("个人信息");
		msg.setPreferredSize(new Dimension(30,20));
		jname =new JLabel(name);
		BorderLayout bo= new BorderLayout(0,0);
	    j.setLayout(bo);
	    this.setPreferredSize(new Dimension(WIDTH,WIDTH));
	    j.add(this,bo.WEST);
	    
	    msg.setOpaque(true);
		msg.setBackground(Color.YELLOW);
	    
	    msg.addActionListener(new msgListener());
	    
	    minj.add(jname,BorderLayout.NORTH);
	    minj.add(msg,BorderLayout.SOUTH);
	    
	    j.add(this,bo.WEST);
	    j.add(minj);
	    this.repaint();
	    
	    this.changeFrame();
	    j.setPreferredSize(new Dimension(100,WIDTH));
	    
	    return j;
	}
	public void changeFrame()
	{
	    
	    imgChange=new JButton("更换头像");
		
		save =new JButton ("保存");
		save.addActionListener(new saveListener());
	    changePassword =new JButton ("修改密码");
	    changePassword.addActionListener(new changeListener());
	    myMsgFrame.setLayout(new BorderLayout(0,0));
	    JPanel p1,p2,p3;
	    p1=new JPanel();
	    p2=new JPanel();
	    p3=new JPanel();
	    p1.add(jl1);p1.add(lab);p1.add(imgChange);
	    imgChange.addActionListener(new imgChangeListener());
	    p2.add(jl2);p2.add(jt2);
	    //p2.add(jl1);
	    p3.add(save);p3.add(changePassword);
	    
	    jl1.setText("头像");
	    
	    jl2.setText("名称");
	    jt2.setText(name);
	    
	    myMsgFrame.add(p1,BorderLayout.NORTH);
	    myMsgFrame.add(p2,BorderLayout.CENTER);
	    myMsgFrame.add(p3,BorderLayout.SOUTH);
	    this.repaint();
	    myMsgFrame.setLocation(500,250);
	    myMsgFrame.pack();
	 
	}
	class msgListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
    	{
      	    myMsgFrame.setVisible(true);
    	}
	}
	class imgChangeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
    	{
      	    bank.visible();
      	    //picPath=bank.path;
      	    //icon = new ImageIcon(picPath);
      	    //lab.setIcon(icon);
      	    //System.out.println(picPath);
    	}
	}
	class changeListener implements ActionListener
	{
		JTextField t1;
		JTextField t2;
		JTextField t3;
		JButton b;
		JLabel k;
		public void actionPerformed(ActionEvent e)
    	{
			
      	    JFrame tt=new JFrame();
      	    
      	    Box box= Box.createVerticalBox();
      	    JPanel p1=new JPanel();
      	    JPanel p2=new JPanel();
      	    JPanel p3=new JPanel();
      	    JPanel p4=new JPanel();
      	    b=new JButton("确定修改");
      	    b.addActionListener(new enChangeListener());
      	    
      	    JLabel l1=new JLabel("原密码");
      	    JLabel l2=new JLabel("新密码");
          	JLabel l3=new JLabel("确认新密码");
          	k=new JLabel();
          	
          	t1=new JTextField(20);
          	t2=new JTextField(20);
          	t3=new JTextField(20);
          	
          	p1.add(l1);p1.add(t1);
          	p2.add(l2);p2.add(t2);
          	p3.add(l3);p3.add(t3);
          	p4.add(b);p4.add(k);
          	
          	box.add(p1);
          	box.add(p2);
          	box.add(p3);
          	box.add(p4);
          	
          	
          	tt.add(box);
          	tt.pack();
          	tt.setLocation(480,240);
          	tt.setVisible(true);
    	}
		class enChangeListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
	    	{
				try
				{
					String sql;
		      	    sql="select password from users where username ='"+username+"';";
		      	    ResultSet re=getSql.research(sql);
		      	    if(re.next())
		      	    {
		      	    	if(t1.getText().equals(re.getString(1)))
		      	    	{
		      	    		if(!t2.getText().equals("")&&t2.getText().equals(t3.getText()))
		      	    		{
		      	    			sql="update users set password='"+t2.getText()+ "' where username ='"+username+"';";
		      	    		    getSql.update(sql);
		      	    		    k.setText("修改成功");
		      	    		    password=t2.getText();
		      	    		}
		      	    		else
		      	    		{
		      	    			k.setText("新密码有误");
		      	    		}
		      	    	}
		      	    	else
		      	    	{
		      	    		k.setText("原密码不正确");
		      	    	}
		      	    }
		            
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
	      	    
	    	}
		}
	}
	
	
	
	class saveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
    	{
			String s1= jt2.getText();
			String sql="update users "
    				+ "set name ='"+s1+"' "+","+"img ='"+picPath+"' "
    				+ "where username='"+username+"';";
			try
    		{
    			if(getSql.update(sql)!=0)
        		{
    				img= ImageIO.read(new File(picPath));
    				myMesFrame.this.repaint();//内部类调用外部类的方法
    				name=s1;
    				myMsgFrame.setVisible(false);
    				bank.f.setVisible(false);
    				jname.setText(name);
    				/*
    				JFrame kk =new JFrame();
    				jname.setText(name);
        			JLabel b=new JLabel("修改成功!");
        			kk.setLocation(520,250);
        			kk.add(b);
        			kk.pack();
        			kk.setVisible(true);*/
        			
        		}
    			else
    			{
    				System.out.println("error");
    			}
    		}
			catch (Exception ex)
			{
				
				ex.printStackTrace();
			}
    	}
	}
}
class friendMesFrame extends Canvas
{
	Client client;
	
	public BufferedImage img;
	public String name;
	public String username;
	public JPanel j;
	public static int WIDTH = 40;
	public JButton send;
	
	chatFrame c;
	public friendMesFrame(BufferedImage img,String name,String username,Client client)
	{
	    
		this.img=img;
		this.name=name;
		this.username=username;
		this.client=client;
		c=new chatFrame(username,name,client,username);
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,0,0,null);
	}
	
	public JPanel frame()
	{
		j=new JPanel();
	    BorderLayout bo= new BorderLayout(0,0);
	    j.setLayout(bo);
	    this.setPreferredSize(new Dimension(WIDTH,WIDTH));
	    j.add(this,bo.WEST);
	    JPanel min =new JPanel();
	    send=new JButton("send");
	    //send.setPreferredSize(new Dimension(80,20));
	    send.addActionListener(new sendListener());
	    JLabel tip=new JLabel(name);
	    j.add(tip);
	    j.add(send,bo.EAST);
	    this.repaint();
	    
		return j;
	}
	class sendListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
      	    c.frame();
    	}
    }
	
}
class imgBank
{
	JFrame f;
	JPanel p;
	String path;
	
	JLabel lab;
	String picPath;
    Icon icon;
    myMesFrame mf;
    imgBank(myMesFrame mf)
    {
    	this.mf=mf;
    }
	void initBank()
	{
		f=new JFrame("头像选择");
		p=new JPanel();
		for(int i=1;i<=10;i++)
		{
			picPath = "ico/"+i+".gif";
		    
		    icon = new ImageIcon(picPath) ;
		    
		    lab = new JLabel(icon,JLabel.CENTER) ;
		    
		    clickLister cl =new clickLister(picPath);
		    lab.addMouseListener(cl);
		    
		    p.add(lab);
		    
		    f.add(p);
		    f.setBounds(300, 250, 200, 200);
		}
	}
	void visible()
	{
		f.setVisible(true);
	}
	class clickLister extends MouseAdapter
	{
		//int i;
		String picPath;
		clickLister(String picPath)
		{
			this.picPath=picPath;
		}
		public void mouseClicked(MouseEvent e)
    	{
			path=picPath;
			System.out.println(picPath);
			mf.picPath=path;
      	    mf.icon = new ImageIcon(mf.picPath);
      	    mf.lab.setIcon(mf.icon);
    	}
	}
	
}
