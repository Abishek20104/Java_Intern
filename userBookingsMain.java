import java.util.Scanner;
public class userBookingsMain {
	public static String pickup,drop,vehicle_type;
	public static double km,fare;
	public static boolean status;
	public static void senddata() throws Exception{
		  Scanner sc= new Scanner(System.in);
		  System.out.println("Enter the Pickup location point: ");
		  pickup=sc.nextLine();
		  System.out.println("Enter the Drop location point");
		  drop=sc.nextLine();
		  System.out.println("Enter the number that corresponds to your type of the vehicle 1.Bike 2.Car 3.Auto");
		  vehicle_type=sc.nextLine();
		  System.out.println("Enter the Estimated Distance in KM");
		  km=sc.nextDouble();
		  status=false;
		  sc.close();
		  
		  switch(vehicle_type){
		  case "1":
			  vehicle_type="Bike";
			  break;
		  case "2":
			  vehicle_type="Car";
			  break;
		  case "3":
			  vehicle_type="Auto";
			  break;
		  }
		  
		  
		  userBookings ub= new userBookings();
		  ub.setpickup(pickup);
		  ub.setdrop(drop);
		  ub.setfare(calculatefare(km,vehicle_type));
		  ub.setvehicle_type(vehicle_type); 
		  ub.setkm(km);
	}
	
	public static double calculatefare(double km,String type) {
		double fare = 0;
		switch (type){
			case "Bike":
				fare = km*10;
			case "Car":
				fare = km*20;
			case "Auto":
				fare = km*15;
		}
		return fare;
	}		
	
}
