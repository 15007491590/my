package speak;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class loginFrame 
{
	JTextField t1,t2;
	JFrame lf;
	JLabel tip;
    friendFrame f;
    public void frame()
    {
    	tip=new JLabel();
        lf=new JFrame("登陆");
    	BorderLayout b=new BorderLayout(30,5);
    	BorderLayout c=new BorderLayout(30,5);
    	lf.setLayout(b);
    	JPanel p1=new JPanel();
    	JLabel l1=new JLabel("用户");
    	
    	JPanel pTol =new JPanel();
    	pTol.setLayout(c);
    	t1=new JTextField(15);
    	p1.add(l1);
    	p1.add(t1);
    	
    	JPanel p2=new JPanel();
    	JLabel l2=new JLabel("密码");
    	t2=new JTextField(15);
    	p2.add(l2);
    	p2.add(t2);
    	
    	JPanel p3=new JPanel();
    	JButton button1=new JButton("登陆"); 
    	button1.addActionListener(new LoginListener());
    	
    	JButton button2=new JButton("注册"); 
    	button2.addActionListener(new ApplyListener());
    	
        p3.add(button1);
        p3.add(button2);
        
    	pTol.add(p1,b.NORTH);
    	pTol.add(p2,b.CENTER);
    	pTol.add(p3,b.SOUTH);
    	
    	lf.add(pTol,b.NORTH);
    	lf.add(tip,b.SOUTH);
    	
    	lf.setLocation(550, 250);
    	
    	lf.pack();
    	lf.setVisible(true);
    	
    }
    class LoginListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		
    		String s1= t1.getText();
    		String s2= t2.getText();
    		String sql =new String();
    		sql="select name,password "
    				+ "from users "
    				+ "where username='"+s1+"';";
    				
    		try
    		{
    			
    			ResultSet res=getSql.research(sql);
    			if(res.next()&&res.getString(2).equals(s2))
    			{
    				System.out.println("成功登陆");
            		lf.setVisible(false);
            		Client client = new Client();
            		client.init(t1.getText());
            			
             		f = new friendFrame(client,t1.getText());
            		f.frame();
    				
        			
        		}
    			else
    			{
    				System.out.println("登陆失败");
    				tip.setText("                用户或密码有误!");
    				lf.pack();
    			}
    		}
    		catch (Exception ex)
    		{
    			
    		}
    		
    	}
    }
    class ApplyListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		apply a=new apply();
    		a.frame();
    		
    	}
    }
    public static void main(String[] args)
    		throws Exception
    {
    	//JFrame j=new JFrame();
    	getSql.init();
    	loginFrame a=new loginFrame();
    	a.frame();
    	//JDialog d1=new JDialog(j,"123",false);
    	//j.setVisible(true);
    	//d1.setVisible(true);
    	//t.setVisible(true);
    }
}
class apply
{
	JTextField t1,t2,t3,t4;
	JFrame lf;
	JLabel tip;
	public void frame()
    {
		lf=new JFrame("注册");
    	//BorderLayout b=new BorderLayout(30,5);
    	FlowLayout f=new FlowLayout();
    	lf.setLayout(f);
    	JPanel p1=new JPanel();
    	JLabel l1=new JLabel("名称");
    	t1=new JTextField(15);
    	p1.add(l1);
    	p1.add(t1);

    	JPanel p2=new JPanel();
    	JLabel l2=new JLabel("新用户");
    	t2=new JTextField(15);
    	p2.add(l2);
    	p2.add(t2);
    	
    	JPanel p3=new JPanel();
    	JLabel l3=new JLabel("设置密码");
    	t3=new JTextField(15);
    	p3.add(l3);
    	p3.add(t3);
    	
    	JPanel p4=new JPanel();
    	JLabel l4=new JLabel("确定密码");
    	t4=new JTextField(15);
    	p4.add(l4);
    	p4.add(t4);
    	
    	JPanel p5=new JPanel();
    	JButton button1=new JButton("确定注册"); 
        p5.add(button1);
        button1.addActionListener(new enApplyListener());
    	
    	p2.add(l2);
    	p2.add(t2);
    	
    	tip=new JLabel();
    	
    	lf.add(p1);
    	lf.add(p2);
    	lf.add(p3);
    	lf.add(p4);
    	lf.add(p5);
    	//lf.setLocation(550, 250);
    	lf.add(tip);
    	lf.setBounds(500,200,280,240);
    	//lf.pack();
    	lf.setVisible(true);
    }
	class enApplyListener implements ActionListener
	    //throws Exception
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		try
    		{	
    			if(!t2.getText().equals(""))
    			{
    				String sql="select username "+ "from users where username='"+t2.getText()+"';";
        			if(getSql.search(sql)==0)//可以注册
        			{
        				System.out.println("注册成功");//ico/1.gif
        				tip.setText("注册成功!");
        				sql="insert into users "
        						+ "values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+"ico/1.gif"+"');";
        				System.out.println(sql);
        				getSql.search(sql);
        				System.out.println(sql);
        			}
        			else
        			{
        				
        				tip.setText("该用户已存在");
        				
        				//lf.setVisible(true);

        			}
    			}
    			else
    			{
    				tip.setText("用户不许为空");
    			}
    			
    		}
    		catch (Exception ex)
    		{
    		    ex.printStackTrace();
    		}
    		
    	}
    }
}
class getSql
{
    public static Connection conn;
    public static Statement stmt;
    public static PreparedStatement pstmt; 
	public static void init()
	throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1305458550");
	   stmt = conn.createStatement();
	}
	public static int  search(String s)
			throws Exception
	{
		boolean has = stmt.execute(s);
		if(has)
		{
			ResultSet rs=stmt.getResultSet();
			//rs.getRow();
			rs.last();
			if(rs.getRow()!=0)
			{
				return rs.getRow();
			}
		}
		return 0;
	}
	public static int  update(String s)
			throws Exception
	{
		int has = stmt.executeUpdate(s);
		
		if(has>0)
		{
			return has;
		}
		
		return 0;
	}
	public static ResultSet research(String s)
			throws Exception
	{
		boolean has = stmt.execute(s);
		if(has)
		{
			ResultSet rs=stmt.getResultSet();
			//rs.getRow();
			return rs;
		}
		return null;
	}
}
