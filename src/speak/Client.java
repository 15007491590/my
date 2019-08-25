package speak;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.sql.ResultSet;
import java.awt.image.*;
import java.util.*;
import java.net.*;
public class Client {
	
     private static final int SERVER_PORT = 30000;
     public  Socket socket;
     private PrintStream ps;
     private BufferedReader brServer;
     private BufferedReader keyIn;
     String username;
     //String name;
     public void init(String username)
     {
    	 
    	 this.username=username;
    	 try
    	 {
    		 
    		 socket =new Socket("192.168.137.1",SERVER_PORT);
    		 //192.168.137.1
    		 /*
    		 Server.clients.put(socket,username);
    		 Server.clients.put(new Socket("127.0.0.1",SERVER_PORT),username+"123");
    		 System.out.println(Server.clients.valueSet());
    		 */
    		 
    		 ps=new PrintStream(socket.getOutputStream());
    		 ps.println(username+"><");
    		 
    		 brServer =new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		 
    		 //keyIn =new BufferedReader(new InputStreamReader(System.in));
    		 
    	 }
    	 catch (UnknownHostException e)
    	 {
    		 System.out.println("找不到服务器");
    	 }
    	 catch (IOException e)
    	 {
    		 System.out.println("网络异常");
    	 }
    	 catch (Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 new ClientThread(brServer).start();
    	 
     }
     public void sendMes(String mes)
     {
    	
    	 ps.println(mes);
    	// System.out.println(mes);
     }
     
}
class ClientThread extends Thread
{
	BufferedReader br =null;
	public ClientThread(BufferedReader br)
	{
		this.br=br;
	}
	public void run()
	{
		try
		{
			String line = null;
			while((line = br.readLine())!=null)
			{
				System.out.println(line);
				String msg=line.split("<>")[0];
		    	String user=line.split("<>")[1];
		    	System.out.println(msg+"  "+user);
		    	for(friendMesFrame k:friendFrame.friendSet)
		    	{
		    		if(k.username.equals(user))
		    		{
		    			k.send.doClick();
		    			
		    			k.c.talkText.append("他说："+msg+'\n');
		    			break;
		    			//192.168.137.1
		    		}
		    	}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(br!=null)
				{
					br.close();
				}
				
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

