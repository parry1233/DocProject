package docProject;

public class Patient
{
	private String p_SSN;
	private String p_pw;
	private String p_fname;
	private String p_lname;
	private String p_address;
	private String p_number;
	private String p_height;
	private String p_weight;
	private String p_blood;
	private String p_birth;
	private String p_info;
	
	public Patient()
	{
		
	}
	
	public Patient(String SSN,String pw,String fname,String lname,String address,String number,String height,String weight,String blood,String birth,String info)
	{
		this.p_SSN=SSN;
		this.p_pw=pw;
		this.p_fname=fname;
		this.p_lname=lname;
		this.p_address=address;
		this.p_number=number;
		this.p_height=height;
		this.p_weight=weight;
		this.p_blood=blood;
		this.p_birth=birth;
		this.p_info=info;
	}
	
	public String getSSN()
	{
		return p_SSN;
	}
	
	public void setSSN(String ssn)
	{
		this.p_SSN=ssn;
	}
	public String getPW()
	{
		return p_pw;
	}
	
	public void setPW(String pw)
	{
		this.p_pw=pw;
	}
	public String getFname()
	{
		return p_fname;
	}
	
	public void setFname(String fname)
	{
		this.p_fname=fname;
	}
	public String getLname()
	{
		return p_lname;
	}
	
	public void setLname(String lname)
	{
		this.p_lname=lname;
	}
	public String getAddress()
	{
		return p_address;
	}
	
	public void setAddress(String address)
	{
		this.p_address=address;
	}
	public String getNumber()
	{
		return p_number;
	}
	
	public void setNumber(String number)
	{
		this.p_number=number;
	}
	public String getHeight()
	{
		return p_height;
	}
	
	public void setHeight(String height)
	{
		this.p_height=height;
	}
	public String getWeight()
	{
		return p_weight;
	}
	
	public void setWeight(String weight)
	{
		this.p_weight=weight;
	}
	public String getBlood()
	{
		return p_blood;
	}
	
	public void setBlood(String blood)
	{
		this.p_blood=blood;
	}
	public String getBirth()
	{
		return p_birth;
	}
	
	public void setBirth(String birth)
	{
		this.p_birth=birth;
	}
	public String getInfo()
	{
		return p_info;
	}
	
	public void setInfo(String info)
	{
		this.p_info=info;
	}
}
