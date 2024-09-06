import java.util.*;
public class GoRide {
public static void main(String args[])throws Exception{
	int choice;
	Scanner sc1=new Scanner(System.in);
	System.out.println("Enter your choice");
	System.out.println("1.Register as Driver 2.Register as User 3.Login as Driver 4.Login as User");
	choice=sc1.nextInt();
	sc1.nextLine();
	switch(choice){
	case 1:
		getvalues get= new getvalues(); 
		get.senddata();
		Sampleapp app= new Sampleapp();
		app.insertintodrivertable();
		break;
	
	case 2:
		usertablemain utm=new usertablemain();
		utm.senddata();
		usertable ut= new usertable();
		ut.insertintousertable();
		break;
	case 3:
		String phn,ps,vehitype;
		Boolean valid;
		System.out.println("Enter your Mobile Number");
		phn=sc1.nextLine();
		System.out.println("Enter your Passowrd");
		ps=sc1.nextLine();
		System.out.println("Enter the vehicle type");
		vehitype=sc1.nextLine();
		Sampleapp sp=new Sampleapp();
		sp.logindriver(vehitype,phn,ps);
		break;
	case 4:
		Boolean valid1;
		System.out.println("Enter your Mobile Number");
		String phone1= sc1.nextLine();
		System.out.println("Enter your Passoword");
		String pass1=sc1.nextLine();
		usertable ub1=new usertable();
		valid1=ub1.loginuser(pass1,phone1);
		if(valid1) {
			System.out.println("Logged in successfully");
			System.out.println("Enter 1 for new booking: ");
			int yes=sc1.nextInt();
			
			if(yes==1) {
			userBookingsMain ubm=new userBookingsMain();
			ubm.senddata();
			userBookings ub=new userBookings();
			ub.insertintouserbookingstable();
			}
			else {
				System.out.println("Thankyou");
				break;
			}	
		}
		else
			System.out.print("Mobile or Password mismatch");
		break;
	
	default:
		System.out.println("Invalid Choice");
		break;
	
		
		
	}
}
}