package docProject;

public class Diagnosis
{
	private String pSSN;
	private String dID;
	private String diagnosis;
	private String resultBy;
	private String resultDetail;
	private String note;
	
	public Diagnosis()
	{
		
	}
	
	public Diagnosis(String pssn,String d_id,String diag,String by,String detail,String in_note)
	{
		this.pSSN=pssn;
		this.dID=d_id;
		this.diagnosis=diag;
		this.resultBy=by;
		this.resultDetail=detail;
		this.note=in_note;
	}
	
	public void setPSSN(String s)
	{
		this.pSSN=s;
	}
	public String getPSSN()
	{
		return this.pSSN;
	}
	
	public void setdID(String s)
	{
		this.dID=s;
	}
	public String getdID()
	{
		return this.dID;
	}
	
	public void setDiagnosis(String s)
	{
		this.diagnosis=s;
	}
	public String getDiagnosis()
	{
		return this.diagnosis;
	}
	
	public void setR_By(String s)
	{
		this.resultBy=s;
	}
	public String getR_By()
	{
		return this.resultBy;
	}
	
	public void setR_Detail(String s)
	{
		this.resultDetail=s;
	}
	public String getR_Detail()
	{
		return this.resultDetail;
	}
	
	public void setNote(String s)
	{
		this.note=s;
	}
	public String getNote()
	{
		return this.note;
	}
}
