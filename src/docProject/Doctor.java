package docProject;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Doctor
{
	private String id;
	private String pw;
	private String fname;
	private String lname;
	private String department;
	private String phone;
	private ArrayList<String> Office_time=new ArrayList<>();
	private int server_port;
	
	public Doctor()
	{
		
	}
	
	public Doctor(String id,String pw,String fname,String lname,String department,String phone,String day1,String day2,String day3,String day4,String day5,String day6,String day7)
	{
		this.id=id;
		this.pw=pw;
		this.fname=fname;
		this.lname=lname;
		this.department=department;
		this.phone=phone;
		this.Office_time.add(day1);//index=0
		this.Office_time.add(day2);//1
		this.Office_time.add(day3);//2
		this.Office_time.add(day4);//3
		this.Office_time.add(day5);//4
		this.Office_time.add(day6);//5
		this.Office_time.add(day7);//6
	}
	
	//@return the id
    public String getID() 
    {
        return id;
    }
    //@param id the id to set
    public void setID(String id)
    {
        this.id = id;
    }
    
    //@return the pw
    public String getPW() 
    {
        return pw;
    }
    //@param pw the pw to set
    public void setPW(String pw)
    {
        this.pw = pw;
    }
    
    //@return the name
    public String getFName() 
    {
        return fname;
    }
    //@param name the name to set
    public void setFName(String fname)
    {
        this.fname = fname;
    }
    
  //@return the name
    public String getLName() 
    {
        return lname;
    }
    //@param name the name to set
    public void setLName(String lname)
    {
        this.lname = lname;
    }
    
    //@return the department
    public String getDep() 
    {
        return department;
    }
    //@param department the department to set
    public void setDep(String dep)
    {
        this.department = dep;
    }
    
    //@return the name
    public String getPhone() 
    {
        return phone;
    }
    //@param name the name to set
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public ArrayList<String> getOFTime() 
    {
        return Office_time;
    }
    public void setOFTime(ArrayList<String> oftime)
    {
        this.Office_time = oftime;
    }
    
    public void setServerSocket()
    {
    	this.server_port=5000+(int)(Math.random()*1001);
    }
    public int getServerPort()
    {
    	return this.server_port;
    }
}
