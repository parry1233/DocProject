package docProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client extends Thread
{
	String ipString;
	int portString;
	private Patient patient;
	private Doctor doctor;
	private boolean check_if_opened=false;
	private String stateString="unfinished";
	
	private boolean check=false;
	
	public Client(String ip,int port)
	{
		ipString=ip;
		portString=port;
	}
	
	public void setDocPat(Doctor d,Patient p)
	{
		this.doctor=d;
		this.patient=p;
	}
	public Patient getPatient()
	{
		return this.patient;
	}
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	
	public boolean getCheck()
	{
		return this.check;
	}
	
	public void run() 
	{
		setState("unfinished");
		connect(ipString, portString);
	}
	
	public void connect(String ip,int port)
	{	
		InetSocketAddress inetSocketAddress=new InetSocketAddress(ip,port);
		try
		{
			Socket s=new Socket();
			s.connect(inetSocketAddress);
			this.receive(s);
			
			/*try
			{
				this.wait();
				this.receive(s);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		} 
		catch (ConnectException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void receive(Socket s)
	{
		try
		{	
			DataInputStream input=new DataInputStream(s.getInputStream());;
			while(true)
			{
				String string=input.readUTF();
				System.out.println("[Client("+s.toString()+")] "+string);
				if(string.equals("no"))
				{
					//this.check=false;
					if(!check_if_opened)
					{
						waitMessage();
						setState("finished");
					}
					this.check_if_opened=true;
				}
				else if(string.equals("yes"))
				{
					//this.check=true;
					if(!check_if_opened)
					{
						openViewer();
						//setState("finished");
					}
					this.check_if_opened=true;
				}
				
				DataOutputStream output=new DataOutputStream(s.getOutputStream());
				output.writeUTF(stateString);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void setState(String s)
	{
		this.stateString=s;
	}
	
	public void openViewer() 
	{
		try
		{
			Reverse_Viewer viewer=new Reverse_Viewer();
			viewer.set_default(doctor,patient);
			viewer.setVisible(true);
			
			viewer.addWindowListener(new WindowAdapter() {

	            @Override
	            public void windowClosing(WindowEvent e) {
	            	setState("finished");
	            	System.out.println("set finished");
	            	System.out.println("closing...");
	            }

	            @Override
	            public void windowClosed(WindowEvent e) {
	            	setState("finished");
	            	System.out.println("set finished");
	            	System.out.println("closed");
	            }

	        });
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	public void waitMessage()
	{
		JOptionPane.showMessageDialog(null, "已有用戶在使用，請稍後重試", "Sorry", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args)
	{
		while(true)//infinite loop
		{
			Scanner scanner=new Scanner(System.in);
			System.out.print("ip:");
			String ip=scanner.nextLine();
			System.out.print("port:");
			int port=scanner.nextInt();
			new Client(ip,port).start();//new a client thread and start it
		}
	}
	
	
}
