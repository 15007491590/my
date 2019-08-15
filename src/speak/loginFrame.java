package speak;
import java.awt.*;
import javax.swing.*;
public class loginFrame {
    public void frame()
    {
    	JFrame lf=new JFrame("登陆");
    	BorderLayout b=new BorderLayout(30,5);
    	lf.setLayout(b);
    	JPanel p1=new JPanel();
    	JLabel l1=new JLabel("用户");
    	JTextField t1=new JTextField(15);
    	p1.add(l1);
    	p1.add(t1);
    	
    	JPanel p2=new JPanel();
    	JLabel l2=new JLabel("密码");
    	JTextField t2=new JTextField(15);
    	p2.add(l2);
    	p2.add(t2);
    	
    	JPanel p3=new JPanel();
    	JButton button1=new JButton("登陆"); 
    	JButton button2=new JButton("注册"); 
        p3.add(button1);
        p3.add(button2);
    	
    	p2.add(l2);
    	p2.add(t2);
    	
    	lf.add(p1,b.NORTH);
    	lf.add(p2,b.CENTER);
    	lf.add(p3,b.SOUTH);
    	
    	lf.pack();
    	lf.setVisible(true);
    }
    public static void main(String[] args)
    {
    	loginFrame a=new loginFrame();
    	a.frame();
    }
}
class apply
{
	public void frame()
    {
		JFrame lf=new JFrame("注册");
    	BorderLayout b=new BorderLayout(30,5);
    	FlowLayout f=new FlowLayout();
    	lf.setLayout(f);
    	JPanel p1=new JPanel();
    	JLabel l1=new JLabel("名称");
    	JTextField t1=new JTextField(15);
    	p1.add(l1);
    	p1.add(t1);
    	
    	JPanel p2=new JPanel();
    	JLabel l2=new JLabel("新用户");
    	JTextField t2=new JTextField(15);
    	p2.add(l2);
    	p2.add(t2);
    	
    	JPanel p3=new JPanel();
    	JLabel l3=new JLabel("设置密码");
    	JTextField t3=new JTextField(15);
    	p3.add(l3);
    	p3.add(t3);
    	
    	JPanel p4=new JPanel();
    	JLabel l4=new JLabel("确定密码");
    	JTextField t4=new JTextField(15);
    	p4.add(l4);
    	p4.add(t4);
    	
    	JPanel p5=new JPanel();
    	JButton button1=new JButton("确定注册"); 
        p5.add(button1);
    	
    	p2.add(l2);
    	p2.add(t2);
    	
    	
    	lf.add(p1);
    	lf.add(p2);
    	lf.add(p3);
    	lf.add(p4);
    	lf.add(p5);
    	
    	lf.setBounds(30,30,280,240);
    	//lf.pack();
    	lf.setVisible(true);
    }
}
