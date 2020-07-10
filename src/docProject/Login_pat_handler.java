package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Login_pat_handler extends DefaultHandler
{
	private boolean id_check=false;
	private boolean into_pw_check=false;
	private boolean all_pass=false;
	
	private String blood;
	private String birth;
	
	private ArrayList<String> pat_info=new ArrayList<>();
	
	private String currentTag=null;
	private String id_string=null;
	private String pw_string=null;
	
	public Login_pat_handler(String ssn,String pw)
	{
		super();
		id_string=ssn;
		pw_string=pw;
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
			if(id_check)
			{
				into_pw_check=true;
			}
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
		else if(name.equals("Info")&&id_check)
		{
			currentTag="Info";
			blood=attributes.getValue("Blood");
			birth=attributes.getValue("Birth");
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		//TODO Auto-generated method stub
		if(currentTag.equals("password")&&into_pw_check)
		{
			String s=new String(ch, start, length);
			if(s.equals(pw_string))
			{
				all_pass=true;
				pat_info.add(s);
			}
		}
		
		else if(currentTag.equals("Fname")&&all_pass)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Lname")&&all_pass)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Address")&&all_pass)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("PhoneNumber")&&all_pass)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Height")&&all_pass)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Weight")&&all_pass)
		{
			pat_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Info")&&all_pass)
		{
			pat_info.add(blood);
			pat_info.add(birth);
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
			into_pw_check=false;
			all_pass=false;
			currentTag=null;
		}
	}
	
	public ArrayList<String> CheckLogin()
	{
		return pat_info;
	}
}
