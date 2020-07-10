package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetTime_handler extends DefaultHandler
{
	private boolean doc_check=false;
	private boolean id_check=false;
	private boolean check1=false;
	private boolean check2=false;
	private boolean check3=false;
	private boolean check4=false;
	private boolean check5=false;
	private boolean check6=false;
	private boolean check7=false;
	private String cuurrentTag;
	
	private String id_string;
	private String[] doc_time=new String[7];
	
	public GetTime_handler(String id)
	{
		super();
		id_string=id;
	}
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		if(name.equals("Doctor"))
		{
			doc_check=true;
			cuurrentTag="Doctor";
			if(attributes.getValue("id").equals(id_string))
			{
				id_check=true;
			}
		}
		else if(doc_check&&name.equals("password"))
		{
			cuurrentTag="password";
		}
		else if(doc_check&&name.equals("Fname"))
		{
			cuurrentTag="Fname";
		}else if(doc_check&&name.equals("Lname"))
		{
			cuurrentTag="Lname";
		}
		else if(doc_check&&name.equals("Department"))
		{
			cuurrentTag="Department";
		}
		else if(doc_check&&name.equals("PhoneNumber"))
		{
			cuurrentTag="PhoneNumber";
		}
		else if(doc_check&&name.equals("OfficeTime"))
		{
			if(attributes.getValue("day").equals("1"))
			{
				check1=true;
			}
			else if(attributes.getValue("day").equals("2"))
			{
				check2=true;
			}
			else if(attributes.getValue("day").equals("3"))
			{
				check3=true;
			}
			else if(attributes.getValue("day").equals("4"))
			{
				check4=true;
			}
			else if(attributes.getValue("day").equals("5"))
			{
				check5=true;
			}
			else if(attributes.getValue("day").equals("6"))
			{
				check6=true;
			}
			else if(attributes.getValue("day").equals("7"))
			{
				check7=true;
			}
			cuurrentTag="OfficeTime";
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		//TODO Auto-generated method stub
		if(id_check)
		{
			if(cuurrentTag.equals("OfficeTime")&&check1)
			{
				doc_time[0]=new String(ch, start, length);
			}
			else if(cuurrentTag.equals("OfficeTime")&&check2)
			{
				doc_time[1]=new String(ch, start, length);
			}
			else if(cuurrentTag.equals("OfficeTime")&&check3)
			{
				doc_time[2]=new String(ch, start, length);
			}
			else if(cuurrentTag.equals("OfficeTime")&&check4)
			{
				doc_time[3]=new String(ch, start, length);
			}
			else if(cuurrentTag.equals("OfficeTime")&&check5)
			{
				doc_time[4]=new String(ch, start, length);
			}
			else if(cuurrentTag.equals("OfficeTime")&&check6)
			{
				doc_time[5]=new String(ch, start, length);
			}
			else if(cuurrentTag.equals("OfficeTime")&&check7)
			{
				doc_time[6]=new String(ch, start, length);
			}
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Doctor"))
		{
			doc_check=false;
			id_check=false;
		}
		if(name.equals("OfficeTime"))
		{
			check1=false;
			check2=false;
			check3=false;
			check4=false;
			check5=false;
			check6=false;
			check7=false;
		}
		cuurrentTag=null;
	}
	
	public String[] dataReturn()
	{
		return doc_time;
	}
}
