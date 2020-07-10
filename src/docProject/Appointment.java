package docProject;

public class Appointment
{
	private String docID;
	private String patID;
	private String day;
	
	public Appointment()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Appointment(String id_doc,String id_pat,String dayon)
	{
		this.docID=id_doc;
		this.patID=id_pat;
		this.day=dayon;
	}
	
	public String getDocID()
	{
		return this.docID;
	}
	
	public void setDocID(String s)
	{
		this.docID=s;
	}
	
	public String getPAtID()
	{
		return this.patID;
	}
	
	public void setPatID(String s)
	{
		this.patID=s;
	}
	
	public String getDay()
	{
		return this.day;
	}
	
	public void setDay(String s)
	{
		this.day=s;
	}
}
