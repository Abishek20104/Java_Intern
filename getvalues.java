import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// E:\catimage.jpg
public class getvalues {
	public static String Name,DOB,Email,Mobile,Address,LicenseNo,LicenseExp,Type,TypeofVehicle,Password,Path,ValidPassword = null;
	public void senddata() throws Exception{
		  Scanner sc= new Scanner(System.in);
		  System.out.println("Enter your Name");
		  Name=sc.nextLine();
		  System.out.println("Enter your DOB in (YYYY-MM-DD) format");
		  DOB=sc.nextLine();
		  System.out.println("Enter your Email");
		  Email=sc.nextLine();
		  System.out.println("Enter your Mobile Number");
		  String Num=sc.nextLine();
		  System.out.println("Enter your Address");
		  Address=sc.nextLine();
		  System.out.println("Enter your License No");
		  LicenseNo=sc.nextLine();
		  System.out.println("Enter the Date of Expiry of the license in (YYYY-MM-DD) format");
		  LicenseExp=sc.nextLine();
		  System.out.println("Enter the directory path of photocopy of the license");
		  Path=sc.nextLine();
		  System.out.println("Enter the number that corresponds to your type of the vehicle 1.Bike 2.Car 3.Auto");
		  Type=sc.nextLine();
		  System.out.println("Enter your password");
		  Password=sc.nextLine();
		  sc.close();
		  
		  switch(Type){
		  case "1":
			  TypeofVehicle="Bike";
			  break;
		  case "2":
			  TypeofVehicle="Car";
			  break;
		  case "3":
			  TypeofVehicle="Auto";
			  break;
		  }
		  
		  boolean validpass= isValidPassword(Password);
		  if(validpass) {
			  ValidPassword= Password;
		  }
		  else {
			  throw new Exception("Enter the Valid Password It contains at least 8 characters and at most 20 characters.\r\n"
				  		+ "Should contain at least one digit.\r\n"
				  		+ "Should contain at least one upper case alphabet.\r\n"
				  		+ "Should contain at least one lower case alphabet.\r\n"
				  		+ "Should contain at least one special character which includes ! @ # $ % & * ( ) - + = ^ .\r\n"
				  		+ "Should doesn’t contain any white space.");
		  }
		  
		  boolean validnum= isValidNumber(Num);
		  if(validnum) {
			  Mobile=Num;
		  }
		  else {
			  throw new Exception("The mobile number should contains only 10 digits");
		  }
		   
		  boolean flag = isValidFile(Path);
		  if(flag){}
		  else { 
			  throw new Exception("Upload the correct file format");
		  }
		  
		  Sampleapp app= new Sampleapp();
		  app.setName(Name);
		  app.setAddress(Address);
		  app.setDOB(DOB);
		  app.setEmail(Email);
		  app.setLicenseExp(LicenseExp);
		  app.setLicenseNo(LicenseNo);
		  app.setMobile(Mobile);
		  app.setPassword(ValidPassword);
		  app.setPath(Path);
		  app.setTypeofVehicle(TypeofVehicle);
		  
	}
	
	public static boolean isValidPassword(String password)
  {
      String regex = "^(?=.*[0-9])"
                     + "(?=.*[a-z])(?=.*[A-Z])"
                     + "(?=.*[@#$%^&+=])"
                     + "(?=\\S+$).{8,20}$";
      Pattern p = Pattern.compile(regex);
      if (password == null) {
          return false;
      }
      Matcher m = p.matcher(password);
      return m.matches();
  }
	
	public static boolean isValidNumber(String Num)
  {
      String regex = "^[0-9]{10}$";
      Pattern p = Pattern.compile(regex);
      if (Num == null) {
          return false;
      }
      Matcher m = p.matcher(Num);
      return m.matches();
  }
	
	public static boolean isValidFile(String S) {
		if(S.toLowerCase().endsWith(".jpg") || S.toLowerCase().endsWith(".jpeg") || S.toLowerCase().endsWith(".png") || S.toLowerCase().endsWith(".pdf")) 
			return true;
		else
			return false;
	}
	
}
