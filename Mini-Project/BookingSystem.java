import java.util.Scanner;

/*
 * Class BookingSystem helps the Admin to inclucde details about screens
 * Helps the user to buy the tickets 
 */
public class BookingSystem {
    static Scanner scanner = new Scanner(System.in);
    static int totalNoOfScreen = 10;
    static int isOpen = 0;
    static int activeNoOfScreen;
    static int[] cost = new int[totalNoOfScreen];
    static int[] seats = new int[totalNoOfScreen];
    static int[] seatsBooked = new int[totalNoOfScreen];
    static String[] movies = new String[totalNoOfScreen];

    /**
     * Method getInfo will print the tickets booked in that particular screen
     * And also print the balance tickets in that particular screen
     */ 
    public static void getInfo(int screenNumber) {
	System.out.println("In Screen " + screenNumber + " "
			        + seatsBooked[screenNumber - 1] + " Tickets Are Booked");
	System.out.println("Balance " + 
			        ((seats[screenNumber - 1]) - (seatsBooked[screenNumber - 1])));
    }
    
    /**
     * Method login takes the admin to his page 
     * where he can ADD SCREENS, add seats, add ticket price and updte changes in future
     */  
    public static void login() {
	int isLogout = 1;
	int screenForUpdate;
	int action;
	final int a = 1;
	final int b = 2;
	final int c = 3;
	final int d = 4;
	final int e = 5;
	final int f = 6;
    	// while condition run until admin select LOGOUT option
	while (isLogout != 0) {
	    System.out.print("Enter '1' For Adding Screens '2' For Adding Extra Seats"
			         + " '3' For Updateing Movie '4' For Updateing The Price"
				 + " '5' To See How Many Tickets are Booked '6' For Logout : ");
	    action = scanner.nextInt();
	    
	    switch (action) {
	    /**
	     * In this case getting the detail about the active screen 
	     * like what movie is streaming in that screen how many numbers of seats are there in that screen 
               and what is price for ticket 
             */
	                 
	    case a:
	        System.out.print("Enter the Number of Screens you need to add :");
		activeNoOfScreen = scanner.nextInt();                                                            //active number of screens 

                // Running a for loop for getting infromation about each screen from the admin
		for (int screenNumber = 0; screenNumber < activeNoOfScreen; screenNumber++) {
		    System.out.print("How Many Seats are there in Screen "
				          + (screenNumber + 1 ) +" : ");
		    seats[screenNumber] = scanner.nextInt();
		    scanner.nextLine();                                                                           //here i am getting the string to avoid skipping
		    System.out.print("What Movie is Streaming in Screen "
				          + (screenNumber + 1) + " : ");
		    movies[screenNumber] = scanner.nextLine();
		    System.out.print("What is The Cost of The Ticket For Screen "
			                  + (screenNumber + 1) + " : ");
		    cost[screenNumber] = scanner.nextInt();		    
		}
		isOpen = 1; 
		break;
            
            /**
             * This case is updates the number of seats in particular screen 
             * By getting screen number from the admin
             */
	    case b:
		int extraSeats;
		System.out.print("Enter Screen Number For What You Need To Add Extra Seats : ");
		screenForUpdate = scanner.nextInt();
		System.out.print("Enter The Number Seats You Need To Add : ");
		extraSeats = scanner.nextInt();
		seats[screenForUpdate-1] = seats[screenForUpdate-1] + extraSeats; 
		break;
	    
	    /** 
	     * This case will update the movie in that particular screen
             * By getting the movie name from the admin
             */
	    case c:
		System.out.print("Enter The Screen Number For What You Need To UPDATE MOVIE : ");
		screenForUpdate = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter The Movie Name : ");
		movies[screenForUpdate-1] = scanner.nextLine();
		break;

	    
	    /**
             * This case is update the ticket price for particular screen
             * By getting the  from the admin
             */
	    case d:
		System.out.print("Enter Screen Number To Update Price : ");
		screenForUpdate = scanner.nextInt();
		System.out.print("Enter the New Price : ");
		cost[screenForUpdate-1] = scanner.nextInt();		
		break;

	    /** 
             * This case is shows the number of tickets booked in particular screen
             * By getting the screen number from the admin
	     */	

	    case e:
		System.out.print("Enter Screen Number To get number Tickets are Booked :");
		getInfo(scanner.nextInt());                                                            //calling the getInfo to get the Booked tickets and balance tickets details
		break;

	    /** 
             * This is case log out the admin 
             */
	    case f:
		isLogout = 0;
		break;

	    default:
		System.out.println("You Entered Wrong Number ");		 
	    }
        }  		     		
    }  
    
    /** 
     * This method book the tickets and print the screen number to the user
     * By getting the screen selected by the user 
     * And number of ticket asked by the user as a parameter 
     * Then updateing the seats booked for that screen
     */
    public static void bookTickets(int selected, int count) {
	System.out.println("Your Seat Number are ");
	int notBooked = seatsBooked[selected - 1] + 1;
	for (int seatNumber = notBooked ; seatNumber <= (notBooked + count); 
	         seatNumber++) {
	    System.out.println("Screen " + selected + " S" + seatNumber);
	}
	seatsBooked[selected - 1] = seatsBooked[selected - 1] + count;                                                                 // updateting the seats booked for that screen
    }
    
    /** 
     * This method calculate the totatl price amount
     * By getting the price of ticket for the screen selected by the user
     */

    public static int calculateTotalPrice(int selected, int count) {
	return cost[selected-1] * count;		
    }
    
    public static boolean ticketsAvailabilityCheck (int selected, int count) {
	int countAvailable;
	countAvailable = seats[selected - 1] - seatsBooked[selected - 1];
	
	if (count <= countAvailable) {
	    return true;
	} else {
	    return false;
	} 
    }

    public static void userDashboard() {
	int selected;
	int count;
	int totalCost;
	String conformation;

	for (int screenNumber = 0; screenNumber < activeNoOfScreen; screenNumber++) {
	    System.out.println("Movie Streaming On Screen " + (screenNumber + 1) + " is " 
			          + movies[screenNumber] + " Available Tickets " 
				  + (seats[screenNumber] - seatsBooked[screenNumber]));	
	}
	System.out.print("Select The Screen : ");
	selected = scanner.nextInt();
	System.out.print("How Many Tickets You Want : ");
	count = scanner.nextInt();
	
	
	if (0 < selected && selected <= activeNoOfScreen) {
	    if (ticketsAvailabilityCheck(selected, count)) {
	        totalCost = calculateTotalPrice(selected,count);
		scanner.nextLine();
	        System.out.print("The Total Cost is " + totalCost + " Conform by 'yes' : ");
	        conformation = (scanner.nextLine()).toLowerCase(); 
	        if (conformation.equalsIgnoreCase("yes")) {
		    bookTickets(selected,count);
	        } else {
		    System.out.println("Thanks For Comming Let's Do This Next Time,!");
	        }
	    } else {
	        System.out.println("Entered More Number of Tickets Than What I Have");
	    }		
	} else {
	    System.out.println("Please Enter Screen only where the Movies are Streamed "); 
	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	int dashboard;
	int appRunning = 1;
	final int a = 1;
	final int b = 2;
	final int c = 3;
	System.out.print("Welcom To The Booking App....");
	
	while(appRunning != 0) {
	    System.out.print("Press '1' For User Access '2' For Admin Access "
			        + "'3' to Quit The App : ");
	    dashboard = scanner.nextInt();
	    
	    switch (dashboard) {
	    case a:
	        System.out.println("Welcom User...");
		if (isOpen == 1) {
		    userDashboard();
		} else {
		    System.out.println("Sorry !!! No Movies are Streaming In Any Screens");
		}
	        break;
	
	    case b:
		int adminId;
		int adminPassword;
		System.out.print("Enter your admin Id : ");
		adminId = scanner.nextInt();
		System.out.print("Enter your Password : ");
		adminPassword = scanner.nextInt();
	
		if ((adminPassword == 101) && (adminId == 101)) {
	    	    System.out.println("Welcome Admin.. ");
		    login();
	    
		} else {
	    	    System.out.println("Access denied ");
		}
		break;

	    case c:
		System.out.println("Thanks For Comming !!");
		appRunning = 0;
		break;

	    default:
		System.out.println("We have only have selected options");
		break;
	    }
	}
    }
}
	        