import java.util.*;

public class Admin extends User {
	Scanner input = new Scanner(System.in);
	public Admin(){
		this.userName = "admin";
		this.PIN = "0000";
	}//end constructor

	public static void main(String[] args){
		Admin a = new Admin();
		a.login();
	}//end main

	public String menu(){
		System.out.println("Admin Menu");
		System.out.println("");
		System.out.println("0) quit");
		System.out.println("1) Full customer report");
		System.out.println("2) Add user");
		System.out.println("3) Appy interest to savings account");
		String response = input.nextLine();
		return response; 
	}//end menu
	
	public String getReport(){
		//bank.fullCustomerReport();
		//return bank.fullCustomerReport();
		return "";
	}//end getReport
	
	public void start(){
		//leave this blank
	}//end start

}//end class def
