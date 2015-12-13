/**
 * 
 */
package nctruong.atm;

/**
 * @author truong
 *
 */
public class ATM {

	/**
	 * 
	 */

	private Customer customer;
	private int state;
	private final int SERVING_STATE = 0;
	
	public ATM() {
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		
	}
	
	public Customer getCustomer(){
		return customer;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getSERVING_STATE() {
		return SERVING_STATE;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	
}
