package docProject;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Login_handler extends DefaultHandler
{ 
	private boolean id_check=false;
	private boolean into_pw_check=false;
	private boolean all_pass=false;
	
	private ArrayList<String> doc_info=new ArrayList<>();
	
	private String currentTag=null;
	private String id_string=null;
	private String pw_string=null;
	
	public Login_handler(String id,String pw)
	{
		super();
		id_string=id;
		pw_string=pw;
	}
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Doctor"))
		{
			currentTag="Doctor";
			if(attributes.getValue("id").equals(id_string))
			{
				id_check=true;
				doc_info.add(attributes.getValue("id"));
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
		else if(name.equals("Department"))
		{
			currentTag="Department";
		}
		else if(name.equals("PhoneNumber"))
		{
			currentTag="PhoneNumber";
		}
		else if(name.equals("OfficeTime"))
		{
			currentTag="OfficeTime";
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
				doc_info.add(s);
			}
		}
		
		else if(currentTag.equals("Fname")&&all_pass)
		{
			doc_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Lname")&&all_pass)
		{
			doc_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Department")&&all_pass)
		{
			doc_info.add(new String(ch, start, length));
		}
		else if(currentTag.equals("PhoneNumber")&&all_pass)
		{
			doc_info.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Doctor"))
		{
			id_check=false;
			into_pw_check=false;
			all_pass=false;
			currentTag=null;
		}
	}
	
	public ArrayList<String> CheckLogin()
	{
		return doc_info;
	}
}
