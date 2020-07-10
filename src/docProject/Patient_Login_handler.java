package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Patient_Login_handler extends DefaultHandler
{
	private String id_string;
	private String currentTag;
	private boolean id_check;
	
	private ArrayList<String> pat_info=new ArrayList<>();
	
	public Patient_Login_handler(String id_to_check)
	{
		super();
		id_string=id_to_check;
	}
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Patient"))
		{
			currentTag="Patient";
			if(attributes.getValue("SSN").equals(id_string))
			{
				id_check=true;
				pat_info.add(attributes.getValue("SSN"));
			}
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
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		//TODO Auto-generated method stub
		if(currentTag.equals("Address")&&id_check)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("PhoneNumber")&&id_check)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Height")&&id_check)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if (currentTag.equals("Weight")&&id_check)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if (currentTag.equals("Info")&&id_check)
		{
			pat_info.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Patient"))
		{
			id_check=false;
		}
		currentTag=null;
	}
	
	public ArrayList<String> pat_infoReturn()
	{
		return pat_info;
	}
}
