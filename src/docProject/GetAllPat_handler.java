package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetAllPat_handler extends DefaultHandler
{
	ArrayList<String> ssn=new ArrayList<>();
	ArrayList<String> pw=new ArrayList<>();
	ArrayList<String> fname=new ArrayList<>();
	ArrayList<String> lname=new ArrayList<>();
	ArrayList<String> address=new ArrayList<>();
	ArrayList<String> number=new ArrayList<>();
	ArrayList<String> height=new ArrayList<>();
	ArrayList<String> weight=new ArrayList<>();
	ArrayList<String> blood=new ArrayList<>();
	ArrayList<String> birth=new ArrayList<>();
	ArrayList<String> info=new ArrayList<>();
	
	private ArrayList<ArrayList<String>> allpats= new ArrayList<>();
	
	private String currentTag=null;
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Patient"))
		{
			currentTag="Patient";
			ssn.add(attributes.getValue("SSN"));
		}
		else if(name.equals("password"))
		{
			currentTag="password";
		}
		else if(name.equals("Fname"))
		{
			currentTag="Fname";
		}
		else if(name.equals("Lname"))
		{
			currentTag="Lname";
		}
		else if(name.equals("Address"))
		{
			currentTag="Address";
		}
		else if(name.equals("PhoneNumber"))
		{
			currentTag="PhoneNumber";
		}
		else if(name.equals("Height"))
		{
			currentTag="Height";
		}
		else if(name.equals("Weight"))
		{
			currentTag="Weight";
		}
		else if(name.equals("Info"))
		{
			currentTag="Info";
			blood.add(attributes.getValue("Blood"));
			birth.add(attributes.getValue("Birth"));
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		//TODO Auto-generated method stub
		if(currentTag.equals("password"))
		{
			pw.add(new String(ch, start, length));
		}
		
		else if(currentTag.equals("Fname"))
		{
			fname.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Lname"))
		{
			lname.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Address"))
		{
			address.add(new String(ch, start, length));
		}
		else if(currentTag.equals("PhoneNumber"))
		{
			number.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Height"))
		{
			height.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Weight"))
		{
			weight.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Info"))
		{
			info.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Patient"))
		{
			currentTag=null;
		}
	}
	
	public ArrayList<ArrayList<String>> Read()
	{
		allpats.add(ssn);
		allpats.add(pw);
		allpats.add(fname);
		allpats.add(lname);
		allpats.add(address);
		allpats.add(number);
		allpats.add(height);
		allpats.add(weight);
		allpats.add(blood);
		allpats.add(birth);
		allpats.add(info);

		return allpats;
	}
}
