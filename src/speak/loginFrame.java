package speak;
import java.awt.*;
public class loginFrame {
    public void frame()
    {
    	Frame lf=new Frame("登陆");
    	BorderLayout b=new BorderLayout(30,5);
    	lf.setLayout(b);
    	Panel p1=new Panel();
    	Label l1=new Label("用户");
    	TextField t1=new TextField(20);
    	p1.add(l1);
    	p1.add(t1);
    	
    	Panel p2=new Panel();
    	Label l2=new Label("密码");
    	TextField t2=new TextField(20);
    	p2.add(l2);
    	p2.add(t2);
    	
    	Panel p3=new Panel();
    	Button button1=new Button("登陆"); 
    	Button button2=new Button("注册"); 
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
    	Frame lf=new Frame("注册");
    	BorderLayout b=new BorderLayout(30,5);
    	FlowLayout f=new FlowLayout();
    	lf.setLayout(f);
    	Panel p1=new Panel();
    	Label l1=new Label("名称");
    	TextField t1=new TextField(20);
    	p1.add(l1);
    	p1.add(t1);
    	
    	Panel p2=new Panel();
    	Label l2=new Label("新用户");
    	TextField t2=new TextField(20);
    	p2.add(l2);
    	p2.add(t2);
    	
    	Panel p3=new Panel();
    	Label l3=new Label("设置密码");
    	TextField t3=new TextField(20);
    	p3.add(l3);
    	p3.add(t3);
    	
    	Panel p4=new Panel();
    	Label l4=new Label("确定密码");
    	TextField t4=new TextField(20);
    	p4.add(l4);
    	p4.add(t4);
    	
    	Panel p5=new Panel();
    	Button button1=new Button("确定注册"); 
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
class apply
{
	public void frame()
    {
		Frame lf=new Frame("注册");
    	BorderLayout b=new BorderLayout(30,5);
    	FlowLayout f=new FlowLayout();
    	lf.setLayout(f);
    	Panel p1=new Panel();
    	Label l1=new Label("名称");
    	TextField t1=new TextField(20);
    	p1.add(l1);
    	p1.add(t1);
    	
    	Panel p2=new Panel();
    	Label l2=new Label("新用户");
    	TextField t2=new TextField(20);
    	p2.add(l2);
    	p2.add(t2);
    	
    	Panel p3=new Panel();
    	Label l3=new Label("设置密码");
    	TextField t3=new TextField(20);
    	p3.add(l3);
    	p3.add(t3);
    	
    	Panel p4=new Panel();
    	Label l4=new Label("确定密码");
    	TextField t4=new TextField(20);
    	p4.add(l4);
    	p4.add(t4);
    	
    	Panel p5=new Panel();
    	Button button1=new Button("确定注册"); 
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
