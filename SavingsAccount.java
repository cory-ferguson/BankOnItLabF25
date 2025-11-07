import java.util.*;

public class SavingsAccount extends CheckingAccount{
	Scanner input = new Scanner(System.in);
	private double interestRate = .05;

	public static void main(String[] args){
		new SavingsAccount();
	}//end main
	
	public void calcInterest(){
		double calcInt = interestRate * balance;
		double newBalance = calcInt + balance;
		setBalance(newBalance); //unsure if I need this
		getBalanceString();
	}//end calcInterest
	
	public void setInterestRate(){
		this.interestRate = interestRate;
	}//end setInterestRate
	
	public double getInterestRate(){
		return this.interestRate;
	}//end getInterestRate

}//end class def
