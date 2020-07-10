package docProject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;


import java.util.List;

public class Server extends Thread
{
	private Socket lastSocket;
	private String last_string="";
	private ServerSocket SS;
	private List<Socket> list=new ArrayList<Socket>();//list to collect clients which connect to this server
	//private List<Socket> temp_list=new ArrayList<Socket>();
	private Doctor doctor;
	private int port;
	
	public Server()
	{
		this.initSS();
	}
	
	public void Set(Doctor d)
	{
		doctor=d;
	}
	
	public Doctor returnDoc()
	{
		return this.doctor;
	}
	public int returnPort()
	{
		return this.port;
	}
	
	public ServerSocket SS()
	{
		return this.SS;
	}
	
	private void initSS()//initialize server socket
	{
		try
		{
			port=5000+(int)(Math.random()*1001);
			SS=new ServerSocket(port);//random server socket port
			//System.out.println("Listening port:"+SS.getLocalPort());
		} 
		catch (Exception e)
		{
			this.initSS();//if exception happen, initialize again
		}
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				list.add(SS.accept());//while server thread run,add the new connected client socket to list
				
				/*if(list.size()>=2)
				{
					for(Socket s:list)
					{
						DataInputStream input=new DataInputStream(s.getInputStream());
						String string=input.readUTF();
						System.out.println("check condition--"+s.toString()+string);
						if(string.equals("finished"))
						{
							lastSocket=s;
							list.remove(s);
							System.out.println("Removed>>"+s.toString());
						}
					}
				}*/
				
				int next_person=0;
				for(Socket s:list)//for loop which do for all socket listed
				{
					String string="";
					try 
					{
						DataOutputStream output=new DataOutputStream(s.getOutputStream());
						if(s.equals(list.get(0)))
						{
							string="yes";
							System.out.println(s.toString()+"//Write input:yes");
						}
						else 
						{
							string="no";
							System.out.println(s.toString()+"//Write input:no");
						}
						output.writeUTF(string);//write output to the client which for loop is pointed to
						next_person++;
					}
					catch (Exception e)
					{
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
				for(Socket s:list)
				{
					DataInputStream input=new DataInputStream(s.getInputStream());
					String string=input.readUTF();
					System.out.println("check condition--"+s.toString()+string);
					if(string.equals("finished"))
					{
						lastSocket=s;
						list.remove(s);
						System.out.println("Removed>>"+s.toString());
					}
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new Server().start();
	}

}
