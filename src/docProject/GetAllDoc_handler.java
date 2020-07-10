package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetAllDoc_handler extends DefaultHandler
{
	private boolean doc_check=false;
	private boolean check1=false;
	private boolean check2=false;
	private boolean check3=false;
	private boolean check4=false;
	private boolean check5=false;
	private boolean check6=false;
	private boolean check7=false;
	private String cuurrentTag;
	
	private ArrayList<ArrayList<String>> allDoc_details= new ArrayList<>();
	private ArrayList<String> allDoc_id=new ArrayList<>();
	private ArrayList<String> allDoc_pw=new ArrayList<>();
	private ArrayList<String> allDoc_fname=new ArrayList<>();
	private ArrayList<String> allDoc_lname=new ArrayList<>();
	private ArrayList<String> allDoc_num=new ArrayList<>();
	private ArrayList<String> allDoc_dep=new ArrayList<>();
	private ArrayList<String> allDoc_time1=new ArrayList<>();
	private ArrayList<String> allDoc_time2=new ArrayList<>();
	private ArrayList<String> allDoc_time3=new ArrayList<>();
	private ArrayList<String> allDoc_time4=new ArrayList<>();
	private ArrayList<String> allDoc_time5=new ArrayList<>();
	private ArrayList<String> allDoc_time6=new ArrayList<>();
	private ArrayList<String> allDoc_time7=new ArrayList<>();
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		if(name.equals("Doctor"))
		{
			doc_check=true;
			cuurrentTag="Doctor";
			allDoc_id.add(attributes.getValue("id"));
		}
		else if(doc_check&&name.equals("password"))
		{
			cuurrentTag="password";
		}
		else if(doc_check&&name.equals("Fname"))
		{
			cuurrentTag="Fname";
		}
		else if(doc_check&&name.equals("Lname"))
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
		if(cuurrentTag.equals("password"))
		{
			allDoc_pw.add(new String(ch, start, length));
		}
		else if (cuurrentTag.equals("Fname"))
		{
			allDoc_fname.add(new String(ch, start, length));
		}
		else if (cuurrentTag.equals("Lname"))
		{
			allDoc_lname.add(new String(ch, start, length));
		}
		else if (cuurrentTag.equals("Department"))
		{
			allDoc_dep.add(new String(ch, start, length));
		}
		else if (cuurrentTag.equals("PhoneNumber"))
		{
			allDoc_num.add(new String(ch, start, length));
		}
		
		else if(cuurrentTag.equals("OfficeTime")&&check1)
		{
			allDoc_time1.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("OfficeTime")&&check2)
		{
			allDoc_time2.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("OfficeTime")&&check3)
		{
			allDoc_time3.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("OfficeTime")&&check4)
		{
			allDoc_time4.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("OfficeTime")&&check5)
		{
			allDoc_time5.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("OfficeTime")&&check6)
		{
			allDoc_time6.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("OfficeTime")&&check7)
		{
			allDoc_time7.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Doctor"))
		{
			doc_check=false;
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
	
	public ArrayList<ArrayList<String>> Read()
	{
		allDoc_details.add(allDoc_id);//0
		allDoc_details.add(allDoc_pw);//1
		allDoc_details.add(allDoc_fname);//2
		allDoc_details.add(allDoc_lname);//3
		allDoc_details.add(allDoc_dep);//4
		allDoc_details.add(allDoc_num);//5
		allDoc_details.add(allDoc_time1);//6
		allDoc_details.add(allDoc_time2);//7
		allDoc_details.add(allDoc_time3);//8
		allDoc_details.add(allDoc_time4);//9
		allDoc_details.add(allDoc_time5);//10
		allDoc_details.add(allDoc_time6);//11
		allDoc_details.add(allDoc_time7);//12
		
		return allDoc_details;
	}
}
