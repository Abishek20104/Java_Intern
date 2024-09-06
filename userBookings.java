import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class userBookings {
	private static String pickup,drop,vehicle_type;
	private static double estimated_KM,fare;
	
	public void setpickup(String pickaddr) {
	    this.pickup = pickaddr;}
	public void setdrop(String dropaddr) {
	    this.drop = dropaddr;}
	public void setvehicle_type(String type) {
	    this.vehicle_type = type;}
	public void setkm(double km) {
	    this.estimated_KM = km;}
	public void setfare(double fare) {
	    this.fare = fare;}

	public String getpickup() {
	    return pickup;
	  }
	public String getdrop() {
	    return drop;
	  }
	public String getvehicle_type() {
	    return vehicle_type;
	  }
	public double getkm() {
	    return estimated_KM;
	  }
	public double getfare() {
	    return fare;
	}
	 void insertintouserbookingstable() throws Exception{
		
		  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		  String mysqlUrl = "jdbc:mysql://localhost/intern";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "admin");
	      System.out.println("Connection established......");
	      System.out.println(getpickup());
	      PreparedStatement pstmt = con.prepareStatement("INSERT INTO userbookings (pickup_point,drop_point,vehicle_type,Estimated_KM,Calculated_fare,booking_status) VALUES(?,?,?,?,?,?)");
	      pstmt.setString(1,getpickup());
	      pstmt.setString(2,getdrop());
	      pstmt.setString(3,getvehicle_type());
	      pstmt.setDouble(4,getkm());
	      pstmt.setDouble(5,getfare());
	      pstmt.setBoolean(6,false);
	      pstmt.execute();
	      System.out.println("Your Fare" + getfare());
	      System.out.println("Record inserted succesfully......");  
	      con.close();
	}
}