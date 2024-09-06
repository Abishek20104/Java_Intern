import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// E:\catimage.jpg
public class usertablemain {
	public static String Name,DOB,Email,Mobile,Address,Password,ValidPassword = null;
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
		  System.out.println("Enter your password");
		  Password=sc.nextLine();
		  sc.close();
		  
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
		  
		  usertable ut= new usertable();
		  ut.setName(Name);
		  ut.setAddress(Address);
		  ut.setDOB(DOB);
		  ut.setEmail(Email);
		  ut.setMobile(Mobile);
		  ut.setPassword(ValidPassword);  
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
	
}
