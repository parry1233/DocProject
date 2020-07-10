package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Doc_editPat_handler extends DefaultHandler
{
	private boolean pat_check=false;
	private String cuurrentTag;
	
	private String ssn_string;
	private String address_string;
	private String pnumber_string;
	private String height_string;
	private String weight_string;
	private String note_string;
	
	private ArrayList<ArrayList<String>> allPat_details= new ArrayList<>();
	private ArrayList<String> allPat_SSN=new ArrayList<>();
	private ArrayList<String> allPat_password=new ArrayList<>();
	private ArrayList<String> allPat_fname=new ArrayList<>();
	private ArrayList<String> allPat_lname=new ArrayList<>();
	private ArrayList<String> allPat_address=new ArrayList<>();
	private ArrayList<String> allPat_pnumber=new ArrayList<>();
	private ArrayList<String> allPat_height=new ArrayList<>();
	private ArrayList<String> allPat_weight=new ArrayList<>();
	private ArrayList<String> allPat_info_birth=new ArrayList<>();
	private ArrayList<String> allPat_info_blood=new ArrayList<>();
	private ArrayList<String> allPat_info=new ArrayList<>();
	
	public Doc_editPat_handler(String ssn,String address,String pnumber,String height,String weight,String note)
	{
		super();
		ssn_string=ssn;
		address_string=address;
		pnumber_string=pnumber;
		height_string=height;
		weight_string=weight;
		note_string=note;
	}
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		if(name.equals("Patient"))
		{
			pat_check=true;
			cuurrentTag="Patient";
			allPat_SSN.add(attributes.getValue("SSN"));
		}
		else if(pat_check&&name.equals("password"))
		{
			cuurrentTag="password";
		}
		else if(pat_check&&name.equals("Fname"))
		{
			cuurrentTag="Fname";
		}
		else if(pat_check&&name.equals("Lname"))
		{
			cuurrentTag="Lname";
		}
		else if(pat_check&&name.equals("Address"))
		{
			cuurrentTag="Address";
		}
		else if(pat_check&&name.equals("PhoneNumber"))
		{
			cuurrentTag="PhoneNumber";
		}
		else if(pat_check&&name.equals("Height"))
		{
			cuurrentTag="Height";
		}
		else if (pat_check&&name.equals("Weight"))
		{
			cuurrentTag="Weight";
		}
		else if (pat_check&&name.equals("Info"))
		{
			cuurrentTag="Info";
			allPat_info_birth.add(attributes.getValue("Birth"));
			allPat_info_blood.add(attributes.getValue("Blood"));
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		if(cuurrentTag.equals("password"))
		{
			allPat_password.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("Fname"))
		{
			allPat_fname.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("Lname"))
		{
			allPat_lname.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("Address"))
		{
			allPat_address.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("PhoneNumber"))
		{
			allPat_pnumber.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("Height"))
		{
			allPat_height.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("Weight"))
		{
			allPat_weight.add(new String(ch, start, length));
		}
		else if(cuurrentTag.equals("Info"))
		{
			allPat_info.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		if (name.equals("Patient"))
		{
			pat_check=false;
		}
		cuurrentTag=null;
	}
	
	public void addAll()
	{
		int gotcha=0;
		for(int i=0;i<allPat_SSN.size();i++)
		{
			if(ssn_string.equals(allPat_SSN.get(i)))
			{
				gotcha=i;
			}
		}
		
		allPat_address.set(gotcha, address_string);
		allPat_pnumber.set(gotcha, pnumber_string);
		allPat_height.set(gotcha, height_string);
		allPat_weight.set(gotcha, weight_string);
		allPat_info.set(gotcha, note_string);

		allPat_details.add(allPat_SSN);
		allPat_details.add(allPat_password);
		allPat_details.add(allPat_fname);
		allPat_details.add(allPat_lname);
		allPat_details.add(allPat_address);
		allPat_details.add(allPat_pnumber);
		allPat_details.add(allPat_height);
		allPat_details.add(allPat_weight);
		allPat_details.add(allPat_info_birth);
		allPat_details.add(allPat_info_blood);
		allPat_details.add(allPat_info);
	}
	public ArrayList<ArrayList<String>> dataReturn()
	{	
		return allPat_details;
	}
}
