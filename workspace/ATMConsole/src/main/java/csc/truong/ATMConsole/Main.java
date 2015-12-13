package csc.truong.ATMConsole;

import java.text.DateFormat;
import java.util.List;

import csc.truong.ATMConsole.helper.FileUtil;

public class Main {
	public static DateFormat formatter ; 
	public static final int NO_ACCOUNT_INFO = 5;

	public static void main(String[] args) {
		FileUtil file = new FileUtil();
	    List<Customer> listCustomer;
	    
	    listCustomer = (List<Customer>) file.readFromFile("account.txt");
	    
	    for(Customer cus : listCustomer){
	    	System.out.print(cus.getName() + " - ");
	    	System.out.print(cus.getPin() + " - ");
	    	System.out.print(cus.getActived() + " - ");
	    	System.out.print(cus.getAmount() + " - ");
	    	System.out.println(cus.getValidTo());
	    }
	    
	}

}
