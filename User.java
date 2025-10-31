import java.util.*;
import java.io.*;

abstract class User implements HasMenu, Serializable {
	protected String userName;
	protected String PIN;
	Scanner input = new Scanner(System.in);

	public boolean login(){
		 if(userName.equals("Alice") && PIN.equals("0000")){
                        System.out.println("Login Successful.");
                        return true;
                } else {
                        return false;
                }//end if
	}//end login
	
	public boolean login(String userName, String PIN){
		if(userName.equals("Alice") && PIN.equals("0000")){
			return true;
		} else {
			return false;
		}//end if
	}//end login
	
	public void setUserName(String userName){
		this.userName = userName;
	}//end setUserName
	
	public String getUserName(){
		return this.userName;
	}//end getUserName
	
	public void setPIN(String PIN){
		//checks for four digits
		if (PIN.matches("^\\d{4}$")){
			this.PIN = PIN;
		} else {
			System.out.println("Pin must be four digits, all numberic");
			System.out.println("Setting PIN to 0000");
			this.PIN = "0000";
		}//end if
	}//end setPIN
	
	public String getPIN(){
		return this.PIN;
	}//end getPIN
	
	public abstract String getReport();

}//end class def	
