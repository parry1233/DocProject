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

public class ToMySQL_Pat
{
	private List<Patient> patList=new ArrayList<>();
	
	private Connection con = null; //Database objects 
	  //連接object 
	  private Statement stat = null; 
	  //執行,傳入之sql為完整字串 
	  private ResultSet rs = null; 
	  //結果集 
	  private PreparedStatement pst = null; 
	  //執行,傳入之sql為預儲之字申,需要傳入變數之位置 
	  //先利用?來做標示 
	  
	  private String dropdbSQL = "DROP TABLE patient "; 
	  
	  private String createdbSQL = "CREATE TABLE patient (" + 
		"    line    INTEGER " + 
	    "  , p_SSN     VARCHAR(20) " + 
	    "  , p_pw  VARCHAR(20)"+
	    "  , p_fname    VARCHAR(20) " +
	    "  , p_lname    VARCHAR(20) " +
	    "  , p_address  VARCHAR(20)"+
	    "  , p_number  VARCHAR(20)"+
	    "  , p_height  VARCHAR(20)"+
	    "  , p_weight  VARCHAR(20)"+
	    "  , p_blood  VARCHAR(20)"+
	    "  , p_birth  VARCHAR(20)"+
	    "  , p_info  VARCHAR(20))"; 
	  
	  private String insertdbSQL = "insert into patient(line,p_SSN,p_pw,p_fname,p_lname,p_address,p_number,p_height,p_weight,p_blood,p_birth,p_info) " + 
	      "select ifNULL(max(line),0)+1,?,?,?,?,?,?,?,?,?,?,? FROM patient"; 
	  
	  private String selectSQL = "select * from patient ";
	  
	  public ToMySQL_Pat()
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
	  public void insertTable(String p_SSN,String p_pw, String p_fname,String p_lname,String p_address,String p_number,String p_height,String p_weight,String p_blood,String p_birth,String p_info) 
	  { 
	    try 
	    { 
	      pst = con.prepareStatement(insertdbSQL); 
	      
	      pst.setString(1, p_SSN);
	      pst.setString(2, p_pw); 
	      pst.setString(3, p_fname); 
	      pst.setString(4, p_lname);
	      pst.setString(5, p_address);
	      pst.setString(6, p_number);
	      pst.setString(7, p_height);
	      pst.setString(8, p_weight);
	      pst.setString(9, p_blood);
	      pst.setString(10, p_birth);
	      pst.setString(11, p_info);
	      
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
	      System.out.println("Line\t\tSSN\t\tPassword\t\tFname\t\tLname\t\tAddress\t\tNumber\t\tHeight\t\tWeight\t\tBlood\t\tBirth\t\tInfomation"); 
	      while(rs.next()) 
	      { 
	        System.out.println(rs.getInt("line")+"\t\t"+rs.getString("p_SSN")+"\t\t"+rs.getString("p_pw")+"\t\t"+rs.getString("p_fname")+"\t\t"+rs.getString("p_lname")+"\t\t"+
	            rs.getString("p_address")+"\t\t"+rs.getString("p_number")+"\t\t"+rs.getString("p_height")+"\t\t"+rs.getString("p_weight")+"\t\t"+
	            rs.getString("p_blood")+"\t\t"+rs.getString("p_birth")+"\t\t"+rs.getString("p_info")); 
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
		List<Patient> list=new ArrayList<>();
		try
		{
			XML_Reader reader=new XML_Reader();
			list=reader.all_PATread();
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
	    ToMySQL_Pat test = new ToMySQL_Pat(); 
	    test.dropTable(); 
	    test.createTable(); 
	    for(Patient p:list)
	    {
	    	test.insertTable(p.getSSN(), p.getPW(),p.getFname(),p.getLname(),p.getAddress(),p.getNumber(),p.getHeight(),p.getWeight(),p.getBlood(),p.getBirth(),p.getInfo());
	    }
	    test.SelectTable(); 
	  
	  } 
}
