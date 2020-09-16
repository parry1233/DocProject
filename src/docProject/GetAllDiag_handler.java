package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetAllDiag_handler extends DefaultHandler
{
	private boolean diag_check=false;
	private String cuurrentTag;
	private ArrayList<ArrayList<String>> allDiag_details= new ArrayList<>();
	private ArrayList<String> allDiag_pSSN=new ArrayList<>();
	private ArrayList<String> allDiag_dID=new ArrayList<>();
	private ArrayList<String> allDiag_Diagnosis=new ArrayList<>();
	private ArrayList<String> allDiag_ResultBy=new ArrayList<>();
	private ArrayList<String> allDiag_ResultDetail=new ArrayList<>();
	private ArrayList<String> allDiag_Note=new ArrayList<>();
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		if(name.equals("Match"))
		{
			diag_check=true;
			cuurrentTag="Match";
			allDiag_pSSN.add(attributes.getValue("pSSN"));
			allDiag_dID.add(attributes.getValue("dID"));
		}
		else if(diag_check&&name.equals("Diagnosis"))
		{
			cuurrentTag="Diagnosis";
		}
		else if(diag_check&&name.equals("Result"))
		{
			cuurrentTag="Result";
			allDiag_ResultBy.add(attributes.getValue("by"));
		}
		else if(diag_check&&name.equals("Note"))
		{
			cuurrentTag="Note";
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		//TODO Auto-generated method stub
		if(cuurrentTag.equals("Diagnosis"))
		{
			allDiag_Diagnosis.add(new String(ch, start, length));
		}
		else if (cuurrentTag.equals("Result"))
		{
			allDiag_ResultDetail.add(new String(ch, start, length));
		}
		else if (cuurrentTag.equals("Note"))
		{
			allDiag_Note.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Match"))
		{
			diag_check=false;
		}
		cuurrentTag=null;
	}
	
	public ArrayList<ArrayList<String>> Read()
	{
		allDiag_details.add(allDiag_pSSN);//0
		allDiag_details.add(allDiag_dID);//1
		allDiag_details.add(allDiag_Diagnosis);//2
		allDiag_details.add(allDiag_ResultBy);//3
		allDiag_details.add(allDiag_ResultDetail);//4
		allDiag_details.add(allDiag_Note);//5
		
		return allDiag_details;
	}
}
