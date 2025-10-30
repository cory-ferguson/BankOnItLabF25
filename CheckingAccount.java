import java.util.*;

public class CheckingAccount implements HasMenu {
	Scanner input = new Scanner(System.in);
	protected double balance = 0;

	public CheckingAccount(){
	       	this.balance = 0;
	}//end constructor
	
	public CheckingAccount(double balance){
		this.balance = balance;
		start();
	}//end constructor

	public static void main(String[] args){
		new CheckingAccount();
	}//end main
	
	public String menu(){
		System.out.println("");
		System.out.println("Account Menu");
		System.out.println("");
		System.out.println("0) quit");
		System.out.println("1) check balance");
		System.out.println("2) make deposit");
		System.out.println("3) make a withdrawal");
		System.out.print("Please enter 0-3: ");
		String response = input.nextLine();
		return response;
	}//end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String response = menu();
			if (response.equals("0")){
				keepGoing = false;
			} else if (response.equals("1")){
				checkBalance();
			} else if (response.equals("2")){
				makeDeposit();
			} else if (response.equals("3")){
				makeWithdrawal();
			} else {
				System.out.print("Invalid input");
			}//end if
		}//end while
	}//end start
	
	public double getBalance(){
		return this.balance;
	}//end getBalance
	
	public String getBalanceString(){
		String output = String.valueOf(balance);
		System.out.print("$" + output);
		return "";
	}//end getBalanceString
	
	public void setBalance(double balance){
		this.balance = balance;
	}//end setBalance
	
	public void checkBalance(){
		System.out.println("Checking balance...");
		System.out.println("Current balance: ");
		getBalanceString();
		System.out.println("");
	}//end checkBalance
	
	private double getDouble(String response){
		double converted;
		try{
			converted = Double.parseDouble(response);
			return converted;
		} catch (NumberFormatException e){
			System.out.println("Invalid input.");
			System.out.println("");
			return 0;
		}//end try
	}//end getDouble
	
	public void makeDeposit(){
		System.out.println("Making a deposit...");
		System.out.print("How much to deposit? ");
		String response = input.nextLine();
		double convResponse = getDouble(response);
		double newBalance = convResponse + balance;
		setBalance(newBalance); 
		System.out.print("New balance: ");
		getBalanceString();
		System.out.println("");
	}//end makeDeposit
	
	public void makeWithdrawal(){
		System.out.println("Making a withdrawal...");
		System.out.print("How much to withdrawal? ");
		String response = input.nextLine();
		double convResponse = getDouble(response);
		double newBalance = balance - convResponse; 
		setBalance(newBalance); 
		System.out.println("New balance: ");
		getBalanceString();
		System.out.println("");
	}//end makeWithdrawal
	
}//end class def
