package docProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

public class MySQL_Test
{
	public static void main(String[] args)
	{
		List<Doctor> doclist=new ArrayList<>();
		List<Patient> patlist=new ArrayList<>();
		List<Diagnosis> diaglist=new ArrayList<>();
		List<Appointment> applist=new ArrayList<>();
		try
		{
			XML_Reader reader=new XML_Reader();
			doclist=reader.all_DOCread();
			patlist=reader.all_PATread();
			diaglist=reader.allDIAGread();
			applist=reader.allAPPread();
		} 
		catch (XMLStreamException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    //doctor XML to database 
	    ToMySQL doc = new ToMySQL(); 
	    doc.dropTable(); 
	    doc.createTable(); 
	    for(Doctor d:doclist)
	    {
	    	doc.insertTable(d.getID(), d.getPW(), d.getFName(), d.getLName(), d.getDep(), d.getPhone(), d.getOFTime().get(0), d.getOFTime().get(1), d.getOFTime().get(2), d.getOFTime().get(3), d.getOFTime().get(4), d.getOFTime().get(5), d.getOFTime().get(6));
	    }
	    doc.SelectTable(); 
	    
	    //patient XML to database
	    ToMySQL_Pat pat = new ToMySQL_Pat(); 
	    pat.dropTable(); 
	    pat.createTable(); 
	    for(Patient p:patlist)
	    {
	    	pat.insertTable(p.getSSN(), p.getPW(),p.getFname(),p.getLname(),p.getAddress(),p.getNumber(),p.getHeight(),p.getWeight(),p.getBlood(),p.getBirth(),p.getInfo());
	    }
	    pat.SelectTable();
	    
	    //diagnosis XML to database
	    ToMySQL_Diag diag = new ToMySQL_Diag(); 
	    diag.dropTable(); 
	    diag.createTable(); 
	    for(Diagnosis d:diaglist)
	    {
	    	diag.insertTable(d.getPSSN(), d.getdID(), d.getDiagnosis(), d.getR_By(), d.getR_Detail(), d.getNote());
	    } 
	    diag.SelectTable(); 
	    
	    //Appointment XML to database
	    ToMySQL_Apoint app = new ToMySQL_Apoint(); 
	    app.dropTable(); 
	    app.createTable(); 
	    for(Appointment a:applist)
	    {
	    	app.insertTable(a.getPAtID(),a.getDocID(),a.getDay());
	    } 
	    app.SelectTable(); 
	}
}
