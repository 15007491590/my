package speak;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.sql.ResultSet;
import java.awt.image.*;
import java.util.*;
import java.net.*;

public class Server {
      private static final int SERVER_PORT=30000;
      public static CrazyitMap<String,PrintStream> clients=new CrazyitMap<>();
      public void init()
      {
    	  try
    	  {
    		  ServerSocket ss = new ServerSocket(SERVER_PORT);		  
    		  while(true)
    		  {
    			  System.out.println("等待练连接");
    			  Socket socket=ss.accept() ;
    			  new ServerThread(socket).start();
    			  //System.out.println(Server.clients.valueSet());
    		  }
    	  }
    	  catch (IOException ex)
    	  {
    		  System.out.println("服务器启动失败");
    	  }
      }
      public static void main(String[] args)
      {
    	  
    	  Server server =new Server();
    	  server.init();
      }
      
}
class ServerThread extends Thread
{
	private Socket socket;
	BufferedReader br=null;
	PrintStream ps=null;
	public ServerThread(Socket socket)
	{
		this.socket=socket;
		
	}
	public void run()
	{
		try
		{
		    br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    
		    ps=new PrintStream(socket.getOutputStream());
		    String line =null;
		    //Socket mid;
		    //PrintStream midps;
		    while((line=br.readLine())!=null)
		    {
		    	if(line.endsWith("><"))//用户
		    	{
		    		String username =line.substring(0,line.length()-2);
		    		Server.clients.put(username, ps);
		    	}
		    	else
		    	{
		    		String msg=line.split("<>")[0];
			    	String user=line.split("<>")[1];
			    	//System.out.println(Server.clients.valueSet());
			    	if(Server.clients.map.get(user)!=null)
			    	{
			    		Server.clients.map.get(user).println(msg+"<>" + Server.clients.getKeyByValue(ps));
			    	}
			    	/*if(mid!=null)
			    	{
			    		midps =new PrintStream(mid.getOutputStream());
				    	
				    	String friendUsername=Server.clients.getValue(socket);
				    	
				        midps.println(msg+"<>"+friendUsername);
			    	}*/
		    	}
		    	
		    }
		}
		catch (Exception ex)
		{
			JFrame tt = new JFrame("bug");
			tt.setVisible(true);
		}
	}
}
class CrazyitMap<K,V>
{
	public Map<K,V> map=Collections.synchronizedMap(new HashMap<K,V>());
	public synchronized void removeByValue(Object value)
	{
		for(Object key : map.keySet())
		{
			if(map.get(key)==value)
			{
				map.remove(key);
				break;
			}
		}
	}
	public synchronized Set<V> valueSet()
	{
		Set<V> result = new HashSet<V>();
		map.forEach((key,value)->result.add(value));
		return result;
	}
	public synchronized K getKeyByValue(V val)
	{
		for(K key : map.keySet())
		{
			if(map.get(key)==val||map.get(key).equals(val))
			{
				return key;
			}
		}
		return null;
	}
	public synchronized V put(K key, V value)
	{
		System.out.println("tip");
		for(V val : valueSet())
		{
			if(val.equals(value)&&val.hashCode()==value.hashCode())
			{
				JFrame tt = new JFrame("重复bug");
				tt.setVisible(true);
			}
		}
		return map.put(key, value);
	}
}
