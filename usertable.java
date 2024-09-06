import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class usertable {
	private static String Name,DOB,Email,Mobile,Address,Password;
	
	public void setName(String newName) {
	    this.Name = newName;}
	public void setDOB(String date) {
	    this.DOB = date;}
	public void setEmail(String mailaddr) {
	    this.Email = mailaddr;}
	public void setMobile(String num) {
	    this.Mobile = num;}
	public void setAddress(String addr) {
	    this.Address = addr;}
	public void setPassword(String Pass) {
	    this.Password = Pass;}
	
	public String getName() {
	    return Name;
	  }
	public String getDOB() {
	    return DOB;
	  }
	public String getEmail() {
	    return Email;
	  }
	public String getMobile() {
	    return Mobile;
	  }
	public String getAddress() {
	    return Address;
	  }
	public String getPassword() {
	    return Password;
	  }
	
	 void insertintousertable() throws Exception{
		
		  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		  String mysqlUrl = "jdbc:mysql://localhost/intern";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "admin");
	      System.out.println("Connection established......");
	      PreparedStatement pstmt = con.prepareStatement("INSERT INTO usertable VALUES(?,?,?,?,?,?)");
	      pstmt.setString(1,getName());
	      pstmt.setDate(2,java.sql.Date.valueOf(getDOB()));
	      pstmt.setString(3,getEmail());
	      pstmt.setString(4,getMobile());
	      pstmt.setString(5,getAddress());
	      pstmt.setString(6,getPassword());
	      pstmt.execute();
	      System.out.println("Record inserted succesfully......");  
	      Statement st=con.createStatement();
	      ResultSet rs=st.executeQuery("select * from usertable;");
	      while(rs.next()) 
	      System.out.println(rs.getString(1)+" "+rs.getDate(2)+" "+rs.getString(3)+" "+ rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
	      con.close(); 
	}
	 public static boolean loginuser(String pass, String num)throws Exception{
		 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 String mysqlUrl = "jdbc:mysql://localhost/intern";
	     Connection con = DriverManager.getConnection(mysqlUrl, "root", "admin");
	     PreparedStatement pst = con.prepareStatement("select * from usertable where Mobile_number = ? AND Password = ?");
	     pst.setString(1,num);
	     pst.setString(2,pass);
	     ResultSet rst=pst.executeQuery();
	     if(rst.next()) {
	    	 con.close();
	    	 return true; }
	     else {
	    	 con.close();
	    	 return false;
	}
	     }
	
	
}