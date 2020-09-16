package docProject;

import java.io.IOException;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

public class ToMySQL
{
	private List<Doctor> docList=new ArrayList<>();
	
	private Connection con = null; //Database objects 
	  //連接object 
	  private Statement stat = null; 
	  //執行,傳入之sql為完整字串 
	  private ResultSet rs = null; 
	  //結果集 
	  private PreparedStatement pst = null; 
	  //執行,傳入之sql為預儲之字申,需要傳入變數之位置 
	  //先利用?來做標示 
	  
	  private String dropdbSQL = "DROP TABLE doctor "; 
	  
	  private String createdbSQL = "CREATE TABLE doctor (" + 
		"    line    INTEGER " + 
	    "  , d_ID     VARCHAR(20) " + 
	    "  , d_password  VARCHAR(20)"+
	    "  , d_fname    VARCHAR(20) " +
	    "  , d_lname    VARCHAR(20) " +
	    "  , d_department  VARCHAR(20)"+
	    "  , d_phone  VARCHAR(20)"+
	    "  , d_OFTime1  VARCHAR(20)"+
	    "  , d_OFTime2  VARCHAR(20)"+
	    "  , d_OFTime3  VARCHAR(20)"+
	    "  , d_OFTime4  VARCHAR(20)"+
	    "  , d_OFTime5  VARCHAR(20)"+
	    "  , d_OFTime6  VARCHAR(20)"+
	    "  , d_OFTime7 VARCHAR(20))"; 
	  
	  private String insertdbSQL = "insert into doctor(line,d_ID,d_password,d_fname,d_lname,d_department,d_phone,d_OFTime1,d_OFTime2,d_OFTime3,d_OFTime4,d_OFTime5,d_OFTime6,d_OFTime7) " + 
	      "select ifNULL(max(line),0)+1,?,?,?,?,?,?,?,?,?,?,?,?,? FROM doctor"; 
	  
	  private String selectSQL = "select * from doctor ";
	  
	  public ToMySQL()
	  {
		  try
		  { 
		      Class.forName("com.mysql.cj.jdbc.Driver"); 
		      //註冊driver 
		      con = DriverManager.getConnection( 
		      "jdbc:mysql://127.0.0.1:3306/doctor?serverTimezone=CST&useUnicode=true&characterEncoding=Big5", 
		      "parry1233","parry1233"); 
		      //取得connection

		//jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=Big5
		//localhost是主機名,test是database名
		//useUnicode=true&characterEncoding=Big5使用的編碼 
		      
		    } 
		  	catch(ClassNotFoundException e) 
		    { 
		      System.out.println("DriverClassNotFound :"+e.toString()); 
		    }//有可能會產生sqlexception 
		    catch(SQLException x) 
	  		{ 
		      System.out.println("Exception :"+x.toString()); 
		    } 
	  	}
	  
	  //建立table的方式 
	  //可以看看Statement的使用方式 
	  public void createTable() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      stat.executeUpdate(createdbSQL); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("CreateDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  //新增資料 
	  //可以看看PrepareStatement的使用方式 
	  public void insertTable(String id,String pw, String fname,String lname,String dep,String phone,String oft1,String oft2,String oft3,String oft4,String oft5,String oft6,String oft7) 
	  { 
	    try 
	    { 
	      pst = con.prepareStatement(insertdbSQL); 
	      
	      pst.setString(1, id);
	      pst.setString(2, pw); 
	      pst.setString(3, fname); 
	      pst.setString(4, lname);
	      pst.setString(5, dep);
	      pst.setString(6, phone);
	      pst.setString(7, oft1);
	      pst.setString(8, oft2);
	      pst.setString(9, oft3);
	      pst.setString(10, oft4);
	      pst.setString(11, oft5);
	      pst.setString(12, oft6);
	      pst.setString(13, oft7);
	      
	      pst.executeUpdate(); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("InsertDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  //刪除Table, 
	  //跟建立table很像 
	  public void dropTable() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      stat.executeUpdate(dropdbSQL); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  //查詢資料 
	  //可以看看回傳結果集及取得資料方式 
	  public void SelectTable() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      rs = stat.executeQuery(selectSQL); 
	      System.out.println("Line\t\td_ID\t\td_Password\td_Fname\td_Lname\td_Department\td_Phone\td_Monday\td_Tuesday\td_Wednesday\td_Thursday\td_Friday\td_Saturday\td_Sunday"); 
	      while(rs.next()) 
	      { 
	        System.out.println(rs.getInt("line")+"\t\t"+rs.getString("d_ID")+"\t\t"+rs.getString("d_password")+"\t\t"+rs.getString("d_fname")+"\t\t"+rs.getString("d_lname")+"\t\t"+
	            rs.getString("d_department")+"\t\t"+rs.getString("d_phone")+"\t\t"+rs.getString("d_OFTime1")+"\t\t"+rs.getString("d_OFTime2")+rs.getString("d_OFTime3")+"\t\t"+
	            rs.getString("d_OFTime4")+"\t\t"+rs.getString("d_OFTime5")+"\t\t"+rs.getString("d_OFTIme6")+"\t\t"+rs.getString("d_OFTIme7")); 
	      } 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  //完整使用完資料庫後,記得要關閉所有Object 
	  //否則在等待Timeout時,可能會有Connection poor的狀況 
	  private void Close() 
	  { 
	    try 
	    { 
	      if(rs!=null) 
	      { 
	        rs.close(); 
	        rs = null; 
	      } 
	      if(stat!=null) 
	      { 
	        stat.close(); 
	        stat = null; 
	      } 
	      if(pst!=null) 
	      { 
	        pst.close(); 
	        pst = null; 
	      } 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("Close Exception :" + e.toString()); 
	    } 
	  }
	  
	  public static void main(String[] args) 
	  { 
		List<Doctor> list=new ArrayList<>();
		try
		{
			XML_Reader reader=new XML_Reader();
			list=reader.all_DOCread();
		} 
		catch (XMLStreamException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    //測看看是否正常 
	    ToMySQL test = new ToMySQL(); 
	    test.dropTable(); 
	    test.createTable(); 
	    for(Doctor d:list)
	    {
	    	test.insertTable(d.getID(), d.getPW(), d.getFName(), d.getLName(), d.getDep(), d.getPhone(), d.getOFTime().get(0), d.getOFTime().get(1), d.getOFTime().get(2), d.getOFTime().get(3), d.getOFTime().get(4), d.getOFTime().get(5), d.getOFTime().get(6));
	    }
	    test.SelectTable(); 
	  
	  } 
}
