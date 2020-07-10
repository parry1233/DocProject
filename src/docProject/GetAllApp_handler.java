package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetAllApp_handler extends DefaultHandler
{
	private boolean app_check=false;
	private String cuurrentTag;
	private ArrayList<ArrayList<String>> allApp_details= new ArrayList<>();
	private ArrayList<String> allApp_docID=new ArrayList<>();
	private ArrayList<String> allApp_patID=new ArrayList<>();
	private ArrayList<String> allApp_day=new ArrayList<>();
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		if(name.equals("Appointment"))
		{
			app_check=true;
			cuurrentTag="Appointment";
			allApp_day.add(attributes.getValue("Day"));
		}
		else if(app_check&&name.equals("Doc"))
		{
			cuurrentTag="Doc";
		}
		else if(app_check&&name.equals("Pat"))
		{
			cuurrentTag="Pat";
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		//TODO Auto-generated method stub
		if(cuurrentTag.equals("Doc"))
		{
			allApp_docID.add(new String(ch, start, length));
		}
		else if (cuurrentTag.equals("Pat"))
		{
			allApp_patID.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Appointment"))
		{
			app_check=false;
		}
		cuurrentTag=null;
	}
	
	public ArrayList<ArrayList<String>> Read()
	{
		allApp_details.add(allApp_docID);//0
		allApp_details.add(allApp_patID);//1
		allApp_details.add(allApp_day);//2
		
		return allApp_details;
	}
}
