 import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*; 
public class Sampleapp {
	private static String Name,DOB,Email,Mobile,Address,LicenseNo,LicenseExp,TypeofVehicle,Password,Path;
	
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
	public void setLicenseNo(String licno) {
	    this.LicenseNo = licno;}
	public void setLicenseExp(String exp) {
	    this.LicenseExp = exp;}
	public void setPath(String path) {
		this.Path=path;}
	public void setTypeofVehicle(String TypeVehi) {
	    this.TypeofVehicle = TypeVehi;}
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
	public String getLicenseNo() {
	    return LicenseNo;
	  }
	public String getLicenseExp() {
	    return LicenseExp;
	  }
	public String getPath() {
	    return Path;
	  }
	public String getTypeofVehicle() {
	    return TypeofVehicle;
	  }
	public String getPassword() {
	    return Password;
	  }
	
	 void insertintodrivertable() throws Exception{
		
		  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		  String mysqlUrl = "jdbc:mysql://localhost/intern";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "admin");
	      System.out.println("Connection established......");
	      InputStream in = new FileInputStream(getPath());
	      PreparedStatement pstmt = con.prepareStatement("INSERT INTO drivertable VALUES(?,?,?,?,?,?,?,?,?,?)");
	      pstmt.setString(1,getName());
	      pstmt.setDate(2,java.sql.Date.valueOf(getDOB()));
	      pstmt.setString(3,getEmail());
	      pstmt.setString(4,getMobile());
	      pstmt.setString(5,getAddress());
	      pstmt.setString(6,getLicenseNo());
	      pstmt.setDate(7,java.sql.Date.valueOf(getLicenseExp()));
	      pstmt.setBinaryStream(8,in,in.available());
	      pstmt.setString(9,getTypeofVehicle());
	      pstmt.setString(10,getPassword());
	      pstmt.execute();
	      in.close();
	      System.out.println("Record inserted succesfully......");  
	      con.close();
	}
	
	 public void logindriver(String type,String num, String pass)throws Exception{
		 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 Scanner sc=new Scanner(System.in);
		 int avail=0;
		 String mysqlUrl = "jdbc:mysql://localhost/intern";
	     Connection con = DriverManager.getConnection(mysqlUrl, "root", "admin");
	     PreparedStatement pst = con.prepareStatement("select * from drivertable where Type_of_Vehicle = ? AND Mobile_Number = ? AND Password = ?");
	     pst.setString(1, type);
	     pst.setString(2, num);
	     pst.setString(3, pass);
	     ResultSet rst=pst.executeQuery();
	     if(rst.next()) {
	 			System.out.println("Logged in successfully");
	 			System.out.println("Checking for the avilable rides: ");
	 			PreparedStatement pstm = con.prepareStatement("select pickup_point,drop_point,Estimated_KM,Calculated_fare,id from userbookings where vehicle_type = ? AND booking_status = 0");
	 			pstm.setString(1, type);
	 			ResultSet rstm=pstm.executeQuery();
	 			while(rstm.next()) {
	 				System.out.println("Pickup point: "+rstm.getString(1)+"\nDrop point: "+rstm.getString(2)+"\nEstimated KM: "+rstm.getDouble(3)+"\nFare: "+rstm.getDouble(4)+"\nBooking Id: "+rstm.getInt(5));
	 				System.out.println("------------***************--------------");
	 				avail=1;
	 			}
	 			if(avail==1) {
	 			System.out.println("Enter the order ID for accepting the ride");
	 			int id=sc.nextInt();
	 			PreparedStatement pm = con.prepareStatement("update userbookings SET booking_status = 1 where id="+id);
	 			pm.execute();
	 			System.out.println("Booking Updated");
	 			} 
	 			else
	 				System.out.println("No Bookings found");
	     }
	     else
	    	 System.out.println("No driver record found");
	     con.close();
	     }  	 
	}