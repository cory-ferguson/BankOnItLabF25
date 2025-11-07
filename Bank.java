import java.io.*;
import java.util.*;

public class Bank implements HasMenu {
	Scanner input = new Scanner(System.in);
	private Admin admin = new Admin();
	//private ArrayList<String> customers = new ArrayList<String>();
	CustomerList customers = new CustomerList(); //I hope this is right

	public Bank(){
		loadSampleCustomers(); //testing purposes
		saveCustomers(); //testing purposes
		//loadCustomers();
		start();
		//saveCustomers();
	}//end constructor
	
	public static void main(String[] args){
		new Bank();
	}//end main
	
	public void loadSampleCustomers(){
		System.out.println("LoadSampleCustomers()"); //testing purposes
		customers.add(new Customer("Alice", "1111"));
		customers.add(new Customer("Bob", "2222"));
		customers.add(new Customer ("Cindy", "3333"));
	}//end loadSampleCustomers
	
	public void loadCustomers(){
		System.out.println("loadCustomers()"); //testing purposes
		
		//this is when I actually have the Customers.dat file...
		try {
			FileInputStream fIn = new FileInputStream("Customers.dat");
			ObjectInputStream obIn = new ObjectInputStream(fIn);
			customers = (CustomerList)obIn.readObject();
			obIn.close();
			fIn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}//end try	

	}//end loadCustomers

	public void saveCustomers(){
		System.out.println("saveCustomers()"); //testing purposes

		try {
                        FileOutputStream fo = new FileOutputStream("Customers.dat");
                        ObjectOutputStream obOut = new ObjectOutputStream(fo);
                        obOut.writeObject(customers);
                        obOut.close();
                        fo.close();
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }//end try
              
	}//end saveCustomers

	public void fullCustomerReport(){
		/*
		for (int i=0; i < this.size(); i++) {
			System.out.println(customer.getName);
		}//end for
		*/
		//this doesn't work either - I know I have to iterate throught this, but I don't know exactly how to and google is not helping
	}//end fullCustomerReport
	

	public void addUser(){
		Customer c = new Customer();
		System.out.println("New Username: ");
		String response = input.nextLine();
		c.userName = response; 
		System.out.println("New PIN: ");
		String responsePIN = input.nextLine();
		c.PIN = responsePIN;
	}//end addUser
	
	public void applyInterest(){
		System.out.println("Applying interest");
		admin.calcInterest(); //not sure how to actually call calcInterest from Admin since admin doesn't actually have a calcInterest function but thats from SavingAccount
	}//end applyInterest
	
	public void loginAsCustomer(){
		/*
		System.out.print("User name: ");
                String response = input.nextLine()

                System.out.print("PIN: ");
                String responsePIN = input.nextLine();
                
		String searchCustomer = response + responsePIN //not sure if adding two strings here will work

		Customer currentCustomer = null;
		for (Customer in cusomter {
			if(!customers.contains(searchCustomer)) {
				System.out.println("Customer doesn't exist.");
			} else {
				c.start();
			}
		}//end for
		*/

		//I need to check for customer within the CustomerList and I really don't know how to do that
		//The main problem right now is actually iterating through the customerList

	}//end loginAsCustomer
	
	public String menu(){
		System.out.println("Bank Menu");
		System.out.println("0) Exit System");
		System.out.println("1) Login as Admin");
		System.out.println("2) Login as Customer");
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
				startAdmin();
			} else if (response.equals("2")){
				loginAsCustomer();
			} else {
				System.out.println("Invalid input.");
			}//end if
		}//end while
	}//end start
	
	public void startAdmin(){
		boolean keepGoing = true;
		
		if (admin.login()){
			while(keepGoing){
				String response = admin.menu(); 
				if (response.equals("0")){
					keepGoing = false;
				} else if (response.equals("1")){
					this.fullCustomerReport();
				} else if (response.equals("2")){
					this.addUser();
				} else if (response.equals("3")){
					this.applyInterest();
				} else {
					System.out.println("Invalid input.");
				}//end if
			}//end while

		}//end if
	}//end startAdmin

}//end class def

//This is the CustomerList class
class CustomerList extends ArrayList<Customer> {}
