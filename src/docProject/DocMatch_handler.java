package docProject;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DocMatch_handler extends DefaultHandler
{
	private boolean doc_check=false;
	
	private ArrayList<String> patSSN=new ArrayList<>();
	private ArrayList<String> diagnosis=new ArrayList<>();
	private ArrayList<String> resultBy=new ArrayList<>();
	private ArrayList<String> result=new ArrayList<>();
	private ArrayList<String> note=new ArrayList<>();
	private ArrayList<ArrayList<String>> match_infos=new ArrayList<>();
	
	private String currentTag=null;
	private String docID_string=null;
	
	public DocMatch_handler(String docID)
	{
		super();
		docID_string=docID;
	}
	
	@Override
	public void startElement(String uri,String lname,String name,Attributes attributes) throws SAXException
	{
		if(name.equals("Match"))
		{
			currentTag="Match";
			if(attributes.getValue("dID").equals(docID_string))
			{
				doc_check=true;
				patSSN.add(attributes.getValue("pSSN"));
			}
		}
		else if(name.equals("Diagnosis"))
		{
			currentTag="Diagnosis";
		}
		else if(name.equals("Result")&&doc_check)
		{
			currentTag="Result";
			resultBy.add(attributes.getValue("by"));
		}
		else if(name.equals("Note"))
		{
			currentTag="Note";
		}
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException
	{
		if(currentTag.equals("Diagnosis")&&doc_check)
		{
			diagnosis.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Result")&&doc_check)
		{
			result.add(new String(ch, start, length));
		}
		else if(currentTag.equals("Note")&&doc_check)
		{
			note.add(new String(ch, start, length));
		}
	}
	
	@Override
	public void endElement(String uri,String lname,String name) throws SAXException
	{
		//TODO Auto-generated method stub
		if (name.equals("Match"))
		{
			doc_check=false;
			currentTag=null;
		}
	}
	
	public ArrayList<ArrayList<String>> matchesBack()
	{
		match_infos.add(patSSN);
		match_infos.add(diagnosis);
		match_infos.add(resultBy);
		match_infos.add(result);
		match_infos.add(note);
		
		return match_infos;
	}
	
}
