package docProject;

import javax.xml.stream.XMLStreamException; 
import java.io.IOException;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToMySQL_Diag
{
	//private List<Diagnosis> diagnosis = new ArrayList<>();
		private Connection con = null; //Database objects 
		  //連接object 
		  private Statement stat = null; 
		  //執行,傳入之sql為完整字串 
		  private ResultSet rs = null; 
		  //結果集 
		  private PreparedStatement pst = null; 
		  //執行,傳入之sql為預儲之字申,需要傳入變數之位置 
		  //先利用?來做標示 
		  
		  private String dropdbSQL = "DROP TABLE Diagnosis "; 
		  
		  private String createdbSQL = "CREATE TABLE Diagnosis  (" + 
		    "   line       INTEGER"+
		    "  , p_SSN   VARCHAR(20) "+
		    "  , d_ID   VARCHAR(20) " + 
		    "  , Diagnosis   VARCHAR(40)"+
		    "  , resultB    VARCHAR(40)"+
		    "  , resultD    VARCHAR(40)"+
		    "  , Note       VARCHAR(40))";
		  
		  private String insertdbSQL = "insert into Diagnosis(line,p_SSN,d_ID,Diagnosis,resultB,resultD,Note) " + 
		      "select ifNULL(max(line),0)+1,?,?,?,?,?,? FROM Diagnosis"; 
		 
		  private String selectSQL = "select * from Diagnosis "; 
		  
		  public ToMySQL_Diag()
		  {
			  try { 
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
			    catch(SQLException x) { 
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
		  public void insertTable( String pssn,String iddoc,String diagnosis ,String resb, String resd, String note) 
		  { 
		    try 
		    { 
		      pst = con.prepareStatement(insertdbSQL); 
		      
		      pst.setString(1, pssn );
		      pst.setString(2, iddoc );
		      pst.setString(3, diagnosis );
		      pst.setString(4, resb );
		      pst.setString(5, resd );
		      pst.setString(6, note );
		      
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
		      System.out.println("Line\t\tPatient SSN\t\tDoctor ID\t\tDiagnosis\t\tResult By\t\tResult Detail\t\tNote"); 
		      while(rs.next()) 
		      { 
		        System.out.println(rs.getInt("line")+"\t"+ 
		            "\t"+rs.getString("p_SSN")+"\t\t"+rs.getString("d_ID")+"\t\t"+rs.getString("Diagnosis")+"\t\t"+rs.getString("resultB")+"\t\t"+
		            rs.getString("resultD")+"\t\t"+rs.getString("Note")); 
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
			  List<Diagnosis> list=new ArrayList<>();
				try
				{
					XML_Reader reader=new XML_Reader();
					list=reader.allDIAGread();
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
			  
				ToMySQL_Diag test = new ToMySQL_Diag(); 
			    test.dropTable(); 
			    test.createTable(); 
			    for(Diagnosis d:list)
			    {
			    	test.insertTable(d.getPSSN(), d.getdID(), d.getDiagnosis(), d.getR_By(), d.getR_Detail(), d.getNote());
			    } 
			    test.SelectTable(); 
			
		  
		  } 
}
