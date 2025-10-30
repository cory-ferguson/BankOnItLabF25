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
		this.PIN = PIN;
	}//end setPIN
	
	public String getPIN(){
		return this.PIN;
	}//end getPIN
	
	public abstract String getReport();

}//end class def	
