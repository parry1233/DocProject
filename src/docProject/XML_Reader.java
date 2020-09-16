package docProject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.helpers.DefaultHandler;


public class XML_Reader
{
	public XML_Reader() throws XMLStreamException, IOException
	{
		DefaultHandler handler=new DefaultHandler();
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Doctors.xml", handler);
		}
		catch(FileNotFoundException e)
		{
			//initialize Doctors.xml first
			writeDoc_first_time();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Patients.xml", handler);
		}
		catch(FileNotFoundException e)
		{
			//initialize  Patients.xml first
			writePat_first_time();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Matches.xml", handler);
		}
		catch(FileNotFoundException e)
		{
			//initialize  Matches.xml first
			writeMat_first_time();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Appointments.xml", handler);
		}
		catch(FileNotFoundException e)
		{
			//initialize  Matches.xml first
			writeAppoint_first_time();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<Doctor> all_DOCread()
	{
		List<Doctor> doclist=new ArrayList<>();
		GetAllDoc_handler handler=new GetAllDoc_handler();
		Doctor d=new Doctor();
		
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Doctors.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<handler.Read().get(0).size();i++)
    	{
    		d=new Doctor(handler.Read().get(0).get(i),handler.Read().get(1).get(i),handler.Read().get(2).get(i),handler.Read().get(3).get(i),handler.Read().get(4).get(i),handler.Read().get(5).get(i),handler.Read().get(6).get(i),handler.Read().get(7).get(i),handler.Read().get(8).get(i),handler.Read().get(9).get(i),handler.Read().get(10).get(i),handler.Read().get(11).get(i),handler.Read().get(12).get(i));
    		doclist.add(d);
    	}
    	
        return doclist;
	}
	
	public List<Patient> all_PATread()
    {
		List<Patient> patList=new ArrayList<>();
		GetAllPat_handler handler=new GetAllPat_handler();
    	Patient p=new Patient();
    	try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Patients.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<handler.Read().get(0).size();i++)
    	{
    		p=new Patient(handler.Read().get(0).get(i),handler.Read().get(1).get(i),handler.Read().get(2).get(i),handler.Read().get(3).get(i),handler.Read().get(4).get(i),handler.Read().get(5).get(i),handler.Read().get(6).get(i),handler.Read().get(7).get(i),handler.Read().get(8).get(i),handler.Read().get(9).get(i),handler.Read().get(10).get(i));
    		patList.add(p);
    	}
    	
        return patList;
    }
	
	public List<Appointment> allAPPread()
	{
		List<Appointment> appList=new ArrayList<>();
		GetAllApp_handler handler=new GetAllApp_handler();
    	Appointment a=new Appointment();
    	try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Appointments.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(handler.Read().get(0).size()==0)
    	{
    		return null;
    	}
    	else 
    	{
    		for(int i=0;i<handler.Read().get(0).size();i++)
        	{
        		a=new Appointment(handler.Read().get(0).get(i),handler.Read().get(1).get(i),handler.Read().get(2).get(i));
        		appList.add(a);
        	}
        	
            return appList;
		}
	}
	
	public List<Diagnosis> allDIAGread()
	{
		List<Diagnosis> diagList=new ArrayList<>();
		GetAllDiag_handler handler=new GetAllDiag_handler();
    	Diagnosis d=new Diagnosis();
    	try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Matches.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i=0;i<handler.Read().get(0).size();i++)
    	{
    		d=new Diagnosis(handler.Read().get(0).get(i),handler.Read().get(1).get(i),handler.Read().get(2).get(i),handler.Read().get(3).get(i),handler.Read().get(4).get(i),handler.Read().get(5).get(i));
    		diagList.add(d);
    	}
    	return diagList;
	} 
	
	public void write_NewDiagnosis(List<Diagnosis>list) throws XMLStreamException, IOException
	{
		try 
		{
			DefaultHandler handler=new DefaultHandler();
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Matches.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeStartElement("Matches");
		
		for(Diagnosis d:list)
		{
			xmlStreamWriter.writeStartElement("Match");
			xmlStreamWriter.writeAttribute("pSSN",d.getPSSN());
			xmlStreamWriter.writeAttribute("dID",d.getdID());
			xmlStreamWriter.writeStartElement("Diagnosis");
			xmlStreamWriter.writeCharacters(d.getDiagnosis());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Result");
			xmlStreamWriter.writeAttribute("by",d.getR_By());
			xmlStreamWriter.writeCharacters(d.getR_Detail());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Note");
			xmlStreamWriter.writeCharacters(d.getNote());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeEndElement();
		}
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Matches.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public void writeAppoint_first_time() throws XMLStreamException, IOException
	{
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		
		xmlStreamWriter.writeStartElement("Appointments");
		xmlStreamWriter.writeEndElement();
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Appointments.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public void write_NewApp(List<Appointment> list) throws XMLStreamException, IOException
	{
		try 
		{
			DefaultHandler handler=new DefaultHandler();
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Appointments.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeStartElement("Appointments");
		for(int i=0;i<list.size();i++)
		{
			xmlStreamWriter.writeStartElement("Appointment");
			xmlStreamWriter.writeAttribute("Day",list.get(i).getDay());
			xmlStreamWriter.writeStartElement("Doc");
			xmlStreamWriter.writeCharacters(list.get(i).getDocID());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Pat");
			xmlStreamWriter.writeCharacters(list.get(i).getPAtID());
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeEndElement();
		}
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Appointments.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public void write_NewDoc(List<Doctor>list) throws XMLStreamException, IOException
	{
		try 
		{
			DefaultHandler handler=new DefaultHandler();
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Doctors.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeStartElement("Doctors");
		
		for(int i=0;i<list.size();i++)
		{
			xmlStreamWriter.writeStartElement("Doctor");
			xmlStreamWriter.writeAttribute("id",list.get(i).getID());
			xmlStreamWriter.writeStartElement("password");
			xmlStreamWriter.writeCharacters(list.get(i).getPW());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Fname");
			xmlStreamWriter.writeCharacters(list.get(i).getFName());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Lname");
			xmlStreamWriter.writeCharacters(list.get(i).getLName());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Department");
			xmlStreamWriter.writeCharacters(list.get(i).getDep());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("PhoneNumber");
			xmlStreamWriter.writeCharacters(list.get(i).getPhone());
			xmlStreamWriter.writeEndElement();
			for(int a=1;a<=7;a++)
			{
				xmlStreamWriter.writeStartElement("OfficeTime");
				xmlStreamWriter.writeAttribute("day",String.valueOf(a));
				xmlStreamWriter.writeCharacters(list.get(i).getOFTime().get(a-1));
				xmlStreamWriter.writeEndElement();
			}
			xmlStreamWriter.writeEndElement();
		}
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Doctors.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public void write_NewPat(List<Patient> list) throws XMLStreamException, IOException
	{
		try 
		{
			DefaultHandler handler=new DefaultHandler();
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Patients.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeStartElement("Patients");
		for(int i=0;i<list.size();i++)
		{
			xmlStreamWriter.writeStartElement("Patient");
			xmlStreamWriter.writeAttribute("SSN",list.get(i).getSSN());
			xmlStreamWriter.writeStartElement("password");
			xmlStreamWriter.writeCharacters(list.get(i).getPW());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Fname");
			xmlStreamWriter.writeCharacters(list.get(i).getFname());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Lname");
			xmlStreamWriter.writeCharacters(list.get(i).getLname());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Address");
			xmlStreamWriter.writeCharacters(list.get(i).getAddress());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("PhoneNumber");
			xmlStreamWriter.writeCharacters(list.get(i).getNumber());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Height");
			xmlStreamWriter.writeCharacters(list.get(i).getHeight());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Weight");
			xmlStreamWriter.writeCharacters(list.get(i).getWeight());
			xmlStreamWriter.writeEndElement();
			xmlStreamWriter.writeStartElement("Info");
			xmlStreamWriter.writeAttribute("Blood",list.get(i).getBlood());
			xmlStreamWriter.writeAttribute("Birth",list.get(i).getBirth());
			xmlStreamWriter.writeCharacters(list.get(i).getInfo());
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeEndElement();
		}
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Patients.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public void writeDoc_first_time() throws XMLStreamException, IOException
	{
		//Initialize xml file
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		
		xmlStreamWriter.writeStartElement("Doctors");

		xmlStreamWriter.writeStartElement("Doctor");
		xmlStreamWriter.writeAttribute("id", "5404");
		
			xmlStreamWriter.writeStartElement("password");		
			xmlStreamWriter.writeCharacters("5404");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Fname");		
			xmlStreamWriter.writeCharacters("Yucheng");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Lname");		
			xmlStreamWriter.writeCharacters("Lin");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Department");		
			xmlStreamWriter.writeCharacters("administrator");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("PhoneNumber");		
			xmlStreamWriter.writeCharacters("5404-1234");
			xmlStreamWriter.writeEndElement();
			
			for(int i=1;i<=7;i++)
			{
				xmlStreamWriter.writeStartElement("OfficeTime");
				xmlStreamWriter.writeAttribute("day", String.valueOf(i));
				String available="T";
				xmlStreamWriter.writeCharacters(available+available+available);
				xmlStreamWriter.writeEndElement();
			}
			xmlStreamWriter.writeEndElement();

		xmlStreamWriter.writeStartElement("Doctor");
		xmlStreamWriter.writeAttribute("id", "parry1233");
			
			xmlStreamWriter.writeStartElement("password");		
			xmlStreamWriter.writeCharacters("parry1233");
			xmlStreamWriter.writeEndElement();
		
			xmlStreamWriter.writeStartElement("Fname");		
			xmlStreamWriter.writeCharacters("Parry");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Lname");		
			xmlStreamWriter.writeCharacters("Chung");
			xmlStreamWriter.writeEndElement();
		
			xmlStreamWriter.writeStartElement("Department");		
			xmlStreamWriter.writeCharacters("administrator");
			xmlStreamWriter.writeEndElement();
		
			xmlStreamWriter.writeStartElement("PhoneNumber");		
			xmlStreamWriter.writeCharacters("0975925288");
			xmlStreamWriter.writeEndElement();
		
			for(int i=1;i<=7;i++)
			{
				xmlStreamWriter.writeStartElement("OfficeTime");
				xmlStreamWriter.writeAttribute("day", String.valueOf(i));
				String available="T";
				xmlStreamWriter.writeCharacters(available+available+available);
				xmlStreamWriter.writeEndElement();
			}
			xmlStreamWriter.writeEndElement();
		
		xmlStreamWriter.writeEndElement();
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Doctors.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public void writePat_first_time() throws XMLStreamException, IOException
	{
		//Initialize xml file
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		
		xmlStreamWriter.writeStartElement("Patients");

		xmlStreamWriter.writeStartElement("Patient");
		xmlStreamWriter.writeAttribute("SSN", "A220345698");
		
			xmlStreamWriter.writeStartElement("password");		
			xmlStreamWriter.writeCharacters("19990212");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Fname");		
			xmlStreamWriter.writeCharacters("Alice");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Lname");		
			xmlStreamWriter.writeCharacters("Yang");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Address");		
			xmlStreamWriter.writeCharacters("新北市新店區");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("PhoneNumber");		
			xmlStreamWriter.writeCharacters("0975537900");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Height");		
			xmlStreamWriter.writeCharacters("157.9");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Weight");		
			xmlStreamWriter.writeCharacters("40");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Info");
			xmlStreamWriter.writeAttribute("Blood", "B");
			xmlStreamWriter.writeAttribute("Birth", "19990212");
			xmlStreamWriter.writeCharacters("MIS senior student");
			xmlStreamWriter.writeEndElement();
			
		xmlStreamWriter.writeEndElement();
			
		xmlStreamWriter.writeStartElement("Patient");
		xmlStreamWriter.writeAttribute("SSN", "A123456789");
		
			xmlStreamWriter.writeStartElement("password");		
			xmlStreamWriter.writeCharacters("0000");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Fname");		
			xmlStreamWriter.writeCharacters("Brian");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Lname");		
			xmlStreamWriter.writeCharacters("Wang");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Address");		
			xmlStreamWriter.writeCharacters("台南市北區");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("PhoneNumber");		
			xmlStreamWriter.writeCharacters("0975903269");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Height");		
			xmlStreamWriter.writeCharacters("175");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Weight");		
			xmlStreamWriter.writeCharacters("62");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Info");
			xmlStreamWriter.writeAttribute("Blood", "O");
			xmlStreamWriter.writeAttribute("Birth", "19990710");
			xmlStreamWriter.writeCharacters("Patient default");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeEndElement();
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Patients.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}

	public void writeMat_first_time() throws XMLStreamException, IOException
	{
		//Initialize xml file
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		
		xmlStreamWriter.writeStartElement("Matches");

		xmlStreamWriter.writeStartElement("Match");
		xmlStreamWriter.writeAttribute("dID", "parry1233");
		xmlStreamWriter.writeAttribute("pSSN", "A220345698");
		
			xmlStreamWriter.writeStartElement("Diagnosis");		
			xmlStreamWriter.writeCharacters("headache");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Result");
			xmlStreamWriter.writeAttribute("by", "Medicine");
			xmlStreamWriter.writeCharacters("marijuana");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Note");		
			xmlStreamWriter.writeCharacters("Eat medicine");
			xmlStreamWriter.writeEndElement();
			
		xmlStreamWriter.writeEndElement();
		
		xmlStreamWriter.writeStartElement("Match");
		xmlStreamWriter.writeAttribute("dID", "parry1233");
		xmlStreamWriter.writeAttribute("pSSN", "A123456789");
		
			xmlStreamWriter.writeStartElement("Diagnosis");		
			xmlStreamWriter.writeCharacters("Knee Injury");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Result");
			xmlStreamWriter.writeAttribute("by", "Rehabilitation");
			xmlStreamWriter.writeCharacters("electrotherapy");
			xmlStreamWriter.writeEndElement();
			
			xmlStreamWriter.writeStartElement("Note");		
			xmlStreamWriter.writeCharacters("Rest more");
			xmlStreamWriter.writeEndElement();
			
		xmlStreamWriter.writeEndElement();
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Matches.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public ArrayList<ArrayList<String>> matches_check(String docID)
	{
		ArrayList<ArrayList<String>> matches_info=new ArrayList<>();
		DocMatch_handler handler=new DocMatch_handler(docID);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Matches.xml", handler);
			matches_info = handler.matchesBack();
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(matches_info.size()>1)
		{
			
			return matches_info;
		}
		else 
		{
			return null;
		}
	}
	
	public ArrayList<String> DocViewPat_info(String patSSN)
	{
		ArrayList<String> pat_info=new ArrayList<>();
		Patient_Login_handler handler=new Patient_Login_handler(patSSN);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Patients.xml", handler);
			pat_info = handler.pat_infoReturn();
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pat_info;
	}
	
	public ArrayList<String> Login_Pat_check(String ssn,String pw)
	{
		ArrayList<String> pat_info=new ArrayList<>();
		Login_pat_handler handler=new Login_pat_handler(ssn, pw);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Patients.xml", handler);
			pat_info = handler.CheckLogin();
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(pat_info.size()>=2&&pat_info.get(0).equals(ssn)&&pat_info.get(1).equals(pw))
		{
			
			return pat_info;
		}
		else 
		{
			return null;
		}
	}
	
	public ArrayList<String> LoginCheck(String id,String pw)
	{
		ArrayList<String> doc_info=new ArrayList<>();
		Login_handler handler=new Login_handler(id, pw);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Doctors.xml", handler);
			doc_info = handler.CheckLogin();
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(doc_info.size()>=2&&doc_info.get(0).equals(id)&&doc_info.get(1).equals(pw))
		{
			
			return doc_info;
		}
		else 
		{
			return null;
		}
	}
	
	public String[] getTime(String id)
	{
		GetTime_handler handler=new GetTime_handler(id);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Doctors.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return handler.dataReturn();
	}
	
	public void Edit_time(String[] s,String id) throws XMLStreamException, IOException
	{
		Change_OFT_handler handler = new Change_OFT_handler(s,id);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Doctors.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeStartElement("Doctors");
		
		for(int i=0;i<handler.dataReturn().get(0).size();i++)
		{
			xmlStreamWriter.writeStartElement("Doctor");
				xmlStreamWriter.writeAttribute("id", handler.dataReturn().get(0).get(i));
				xmlStreamWriter.writeStartElement("password");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(1).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Fname");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(2).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Lname");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(3).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Department");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(4).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("PhoneNumber");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(5).get(i));
				xmlStreamWriter.writeEndElement();
				for(int a=1;a<=7;a++)
				{
					xmlStreamWriter.writeStartElement("OfficeTime");
					xmlStreamWriter.writeAttribute("day", String.valueOf(a));
					xmlStreamWriter.writeCharacters(handler.dataReturn().get(a+5).get(i));
					xmlStreamWriter.writeEndElement();
				}
				
			xmlStreamWriter.writeEndElement();
		}
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Doctors.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}
	
	public void Doc_edit_Pat(String ssn,String address,String pNumber,String height,String weight,String note) throws XMLStreamException, IOException
	{
		Doc_editPat_handler handler=new Doc_editPat_handler(ssn,address,pNumber,height,weight,note);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Patients.xml", handler);
			handler.addAll();
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeStartElement("Patients");
		
		for(int i=0;i<handler.dataReturn().get(0).size();i++)
		{
			xmlStreamWriter.writeStartElement("Patient");
				xmlStreamWriter.writeAttribute("SSN", handler.dataReturn().get(0).get(i));
				xmlStreamWriter.writeStartElement("password");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(1).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Fname");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(2).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Lname");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(3).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Address");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(4).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("PhoneNumber");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(5).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Height");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(6).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Weight");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(7).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Info");
				xmlStreamWriter.writeAttribute("Birth", handler.dataReturn().get(8).get(i));
				xmlStreamWriter.writeAttribute("Blood", handler.dataReturn().get(9).get(i));
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(10).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeEndElement();
		}		
		xmlStreamWriter.writeEndElement();
			
		xmlStreamWriter.writeEndDocument();
			
		xmlStreamWriter.close();
			
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Patients.xml",false);
			
		out.write(xmlstring);
		out.close();
			
		stringWriter.close();
	}
	
	public void Edit(String id,String pw,String fname,String lname,String department,String phonenumber) throws XMLStreamException, IOException
	{
		Rewrite_handler handler=new Rewrite_handler(id,pw,fname,lname,department,phonenumber);
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser saxParser=factory.newSAXParser();
			saxParser.parse("Doctors.xml", handler);
		}
		catch(Exception e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringWriter stringWriter=new StringWriter();
		XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xmlStreamWriter.writeStartDocument();
		xmlStreamWriter.writeStartElement("Doctors");
		
		for(int i=0;i<handler.dataReturn().get(0).size();i++)
		{
			xmlStreamWriter.writeStartElement("Doctor");
				xmlStreamWriter.writeAttribute("id", handler.dataReturn().get(0).get(i));
				xmlStreamWriter.writeStartElement("password");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(1).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Fname");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(2).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Lname");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(3).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("Department");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(4).get(i));
				xmlStreamWriter.writeEndElement();
				xmlStreamWriter.writeStartElement("PhoneNumber");
				xmlStreamWriter.writeCharacters(handler.dataReturn().get(5).get(i));
				xmlStreamWriter.writeEndElement();
				for(int a=1;a<=7;a++)
				{
					xmlStreamWriter.writeStartElement("OfficeTime");
					xmlStreamWriter.writeAttribute("day", String.valueOf(a));
					xmlStreamWriter.writeCharacters(handler.dataReturn().get(a+5).get(i));
					xmlStreamWriter.writeEndElement();
				}
				
			xmlStreamWriter.writeEndElement();
		}
		
		xmlStreamWriter.writeEndDocument();
		
		xmlStreamWriter.close();
		
		String xmlstring=stringWriter.getBuffer().toString();
		FileWriter out=new FileWriter("Doctors.xml",false);
		
		out.write(xmlstring);
		out.close();
		
		stringWriter.close();
	}

}
