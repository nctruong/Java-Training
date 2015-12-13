/**
 * 
 */
package nctruong.atm.transaction;

import nctruong.atm.ATM;
import nctruong.atm.Balances;
import nctruong.atm.Message;
import nctruong.atm.Session;

/**
 * @author truong
 *
 */
public class Transaction {

	/**
	 * 
	 */
	protected ATM atm;
	protected Session session;
	protected String username;
	protected int pin;
	protected Message message;
	protected Balances balances;
	protected int state;
	
	private final int INVALID_PIN_STATE = 0;
	private final int COMPLETING_TRANSACTION_STATE = 0;
	private final int ASKING_ANOTHER_STATE = 0;
	
	public Transaction(ATM atm, Session session,String username, String pin ) {
		// TODO Auto-generated constructor stub
	}
	
	public Transaction makeTransaction(ATM atm, Session session, String username, int pin){
		
	}
	
	public boolean performTransaction(){
		
	}
	
	public boolean performGetValidPin(){
		
	}
	
	public Message returnMessage(){}
	
	public completeTransaction(){}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Balances getBalances() {
		return balances;
	}

	public void setBalances(Balances balances) {
		this.balances = balances;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getINVALID_PIN_STATE() {
		return INVALID_PIN_STATE;
	}

	public int getCOMPLETING_TRANSACTION_STATE() {
		return COMPLETING_TRANSACTION_STATE;
	}

	public int getASKING_ANOTHER_STATE() {
		return ASKING_ANOTHER_STATE;
	} // 
	
	
	
	
}
