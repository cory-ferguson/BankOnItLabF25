# BankOnItLabF25

# UML In the Assignment

Milestone one:
Set up git account
Create HasMenu interface
Get basic functionality of CheckingAccount class working

# HasMenu
interface HasMenu
	public
		string menu()
		void start()

# CheckingAccount
class CheckingAccount implements HasMenu
	private
		double balance
		
	public
		CheckingAccount()
		CheckingAccount(double balance)
		
		void main()
			create an instance of the class (?) 

		string menu() //from HasMenu
			print 0) quit
			print 1) check balance
			print 2) make deposit
			print 3) make a withdrawal

			create a string for response 
			print "Please enter 0-3: "
			put user input into response
		    return response 
			
		void start() //from HasMenu
			bool keepGoing set to true
			while keepGoing
				call menu()
					if response = 0
						quit program //should go back to Customer Menu
						set keepGoing false
					else if response = 1
						call checkBalance()
					else if response = 2
						call makeDeposit() 
					else if response = 3
						call makeWithdrawal()d
					else
						print "invalid input" 

		double getBalance()
			return this.balance

		string getBalanceString()
			//formats the balance nicely
			print "$" balance

		void setBalance(balance)
			this.balance = balance

		void checkBalance()
			print "checking balance"
			print current balance
		
		private double getDouble()
			create a string	for input
			create a double called converted
			try 
				converted = Double.parseDouble(input)
				return converted
			catch (NumberFormatException e)
				print "Invalid input"
				return 0
					

		void makeDeposit()
			print "Making a deposit..."
			create a string called response
			print "How much to deposit? " 
			put input into response
			call getDouble(response) //converts to a double
			add the response to balance
			print "New balance: " balance

		void makeWithdrawal()
			print "Making a withdrawal..."
			create a string for response
			print "How much to withdraw? " 
			put user input into response
			call getDouble(response) //converts to a double
			subtract response from balance
			print "New balance: " balance


Milestone two:
Finish working on CheckingAccount if necessary
Implement and test SavingsAccount
Start working on User class

# SavingsAccount

class SavingsAccount extends Checking Account

    private 
        double interestRate

    public
        main()
            new SavingsAccount() // ? I think??

        calcInterest()
            double calcInt = (interestRate * balance);
            newBalance = calcInt + balance;
            //setBalance(newBalance); //unsure if I need this 
        
        void setInterestRate()
            this.interestRate = interestRate;

        double getInterestRate()
            return this.iterestRate;

# User 

abstract class User implements HasMenu, Serializable

    private
        string userName
        string PIN

    public
        boolean login()
            //tests for proper username and pin
            if userName = "Alice" and PIN = 0000 //Alice and 0000 for testing purposes
                print Login Successful
                return true
            else
                return false            

        boolean login(userName, PIN)
            //this will probably test wether or not the username and PIN were valid
            if userName = Alice && PIN = 0000 //Again, Alice and 0000 for testing purposes
                return true
            else
                return false

        void setUserName(userName)
            this.userName = userName

        string getUserName()
            return this.userName

        void setPIN(PIN)
            this.PIN = PIN

        string getPIN()
            return this.PIN

        abstract string getReport()

# Customer 

class Customer extends User
    
    private 
        CheckingAccount checking
        SavingsAccount savings

    public 
        void main()
            new Customer()

        Customer()
            create a bool keepGoing set to true
            while(keepGoing)
                prompt for username
                add input into string response
                prompt for pin
                add input into string responsePIN
                if (login())
                    call start()
                else
                    print Invalid username or PIN
                

        Customer(userName, PIN)
            this.userName = userName
            this.PIN = PIN

        void start()
            create a boolean keepGoing set to true
            while keepGoing
                String response = menu()
                if response = 0
                    keepGoing false
                else if response = 1
                    open checking account class
                else if response = 2
                    open savings account class
                else if resposne = 3
                    call changePin()
                else
                    print invalid input

        string menu()
            print 0) quit
            print 1) Manage Checking Account
            print 2) Manage Savings Account
            print 3) Change PIN
            create a string for response
            put input into response
            return response        

        void changePIN()
            print New PIN: 
            create a string for response
            put input into response
            call setPIN(response)
            //maybe check to make sure pin is a number but i dont want to worry about that rn
            //i could convert it to an int and then back into a string maybe just to check
            //also would have to make sure its 4 digits ...
       
        string getReport()
            print Checking Account Balance: 
            call getBalanceString() from CheckingAccount class?
            print Savings Account Balance: 
            call getBalanceString() from SavingsAccount class?
