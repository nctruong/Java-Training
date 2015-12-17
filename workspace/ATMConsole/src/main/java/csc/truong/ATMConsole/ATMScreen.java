package csc.truong.ATMConsole;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMScreen extends ATM {
	private Scanner input;

	public ATMScreen() throws IOException {
		// TODO Auto-generated constructor stub
		input = new Scanner(System.in);
	}

	public Map<String, String> requestLoginInfo() {
		
		Map<String, String> loginInfo = new HashMap<String, String>();
		System.out.println(getMessage().get("login"));
		
		System.out.println(getMessage().get("username"));
		loginInfo.put("username", input.nextLine());

		System.out.println(getMessage().get("pin"));
		loginInfo.put("pin", String.valueOf(input.nextInt()));
		input.nextLine();
		return loginInfo;
	}

	public Customer getLoginInfo(Customer customer) {
		return customer;
	}

	public void showMenuAction() {
		System.out.println("----------- Main Menu ------------");
		for (String menu : menu) {
			System.out.println(menu);
		}
	}

	public int getActionMenu() {
		System.out.println("Your choice: ");
		int action = input.nextInt();
		while (true) {
			if (action >= 1 && action <= menu.size()) {
				break;
			} else {
				System.out.println("Please choose exactly the action number in the menu above !");
				System.out.println("Your choice: ");
				action = input.nextInt();
			}
		}
		return action;
	}

	public boolean verifyStatusAccount(Customer cus) throws IOException, ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		cus = getCustomerByName(cus.getName());
		Date todayDate = dateFormatter.parse(dateFormatter.format(new Date() ));
		Date toDate = dateFormatter.parse(cus.getValidTo());
		if (cus.getActivated() == 1) {
			return true;
		} else {
			System.out.println("Your account was blocked !");
			return false;
		}

		if((toDate.compareTo(todayDate)) == 1){
			System.out.println("Account expired.");
		}
	}

	public void getCustomerInfo(String username, int pin) {

	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	// Transaction
	public boolean withDrawal(String name) throws IOException, ParseException {
		System.out.println("The money you want to withdrawl: ");
		int money = input.nextInt();
		float bigestAmount = this.getCustomerByName(name).getAmount() - this.getSmallestAmount();
		if (bigestAmount < money) {
			System.out.println("The money must be lower than " + bigestAmount);
		} else {
		
			if(this.getTrans().withDrawal(name, money)){
				System.out.println("Transaction was done successfully.");
			}
		}
		return true;
	}

	public boolean deposit(String name) throws IOException, ParseException {
		System.out.println("The money you want to deposit: ");
		int money = input.nextInt();
		if(this.getTrans().deposit(name, money)){
			System.out.println("Transaction was done successfully.");
		}
		return true;
	}

	public boolean transfer(String cus1) throws IOException, ParseException {
		
		String cus2;
		System.out.println("Please fill Username which you want to transfer the money.");
		System.out.println("Username: ");
		cus2 = input.next();	

		while (this.getCustomerByName(cus2) == null) {
			System.out.println("Not Found ! Please fill exactly Username which you want to transfer the money.");
			System.out.println("Username: ");
			cus2 = input.next();		
		} ;
			
		System.out.println("Money: ");
		int money = input.nextInt();
		
		float bigestAmount = this.getCustomerByName(cus1).getAmount() - this.getSmallestAmount();
		if (bigestAmount <= money) {
			System.out.println("The money must be lower than " + bigestAmount);
		} else {					
			if(this.getTrans().transfer(money, cus1, cus2)){
				System.out.println("Transaction was done successfully.");
			}
		}
		return true;
	}

	public boolean changePin(String name) throws IOException, ParseException {
		System.out.println("Please fill the new Pin Code: ");
		int newPin = input.nextInt();
		if(this.getTrans().changePin(name, newPin)){
			System.out.println("Pin was changed successfully.");
		}
		return true;
	}

	public void inquiryCurrentAccountInfo(String name) throws IOException, ParseException {
		Customer customer = this.getCustomerByName(name);
		float amountVailable = customer.getAmount() - this.getSmallestAmount();
		System.out.println("** ATM Console - Your account Information **");
		System.out.println("- Username          : " + customer.getName());
		System.out.println("- Activated         : " + customer.getActivated());
		System.out.println("- Amount            : " + customer.getAmount());
		System.out.println("- Amount available  : " + amountVailable);
		System.out.println("- To                : " + customer.getValidTo());
	}

	public void exit() {
		System.out.println("Enter to exit !");
		this.getInput().next();
		System.exit(0);	 
	}

}
