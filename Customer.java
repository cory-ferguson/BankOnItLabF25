import java.util.*;

public class Customer extends User {
	Scanner input = new Scanner(System.in);
	private CheckingAccount checking = new CheckingAccount();
	private SavingsAccount savings = new SavingsAccount();

	public static void main(String[] args){
		new Customer();
	}//end main
	
	public Customer(){
		this.userName = userName;
		this.PIN = PIN;

		if(login()){
			start();
		} else {
			System.out.println("Invalid username or PIN.");
		}//end if

	}//end constructor
	
	public Customer(String userName, String PIN){
		this.userName = userName;
		this.PIN = PIN;
	}//end constructor
	
	public void start(){
		//login(userName, PIN);
		boolean keepGoing = true;
		while(keepGoing){
			String response = menu();
			if (response.equals("0")){
				keepGoing = false;
			} else if (response.equals("1")){
				checking.start();
				//System.out.println("chose 1");
			} else if (response.equals("2")){
				savings.start();
				//System.out.println("chose 2");
			} else if (response.equals("3")){
				changePIN();
			} else {
				System.out.print("Invalid input");
			}//end if
		}//end while
	}//end start
	
	public String menu(){
		System.out.println("");
		System.out.println("Customer Menu");
		System.out.println("");
		System.out.println("0) quit");
		System.out.println("1) Manage Checking Account");
		System.out.println("2) Manage Savings Account");
		System.out.println("3) Change PIN");
		System.out.println("Please enter 0-3");
		String response = input.nextLine();
		return response;
	}//end menu
	
	public void changePIN(){
		System.out.print("New PIN: ");
		String response = input.nextLine();
		setPIN(response);
	}//end changePIN
	
	public String getReport(){
		System.out.print("Checking Account Balance: ");
		checking.getBalanceString();
		System.out.print("");
		System.out.print("Savings Account Balance: ");
		savings.getBalanceString();
		System.out.println("");
		return "";
	}//end getReport

}//end class def
