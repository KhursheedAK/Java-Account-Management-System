
/* Name: Khursheed Alam Khan		Assignment 3: File Handling: Account Management System
 * Roll# 20i-0496
 * Section: SE-Q
 */
import java.io.*;
public abstract class BankAccount implements Serializable 
{
		// default transaction fee
		protected static double fee = 10.0;
		
		// default trxCount
		protected int trxCount=0;
		
		// total deposits
		protected double total_deposits;
		
		// total withdrawn
		protected double total_withdrawn;
		
		// total fee deducted
		protected double total_fee;
		
		// total amount transfer
		protected double total_Transfer;
		
		// extra withdraw amount if amount exceeds balance
		protected double extraAmount=0;
	
		// total fee deducted
		private double total_Zakat;
	
	/* Customer class association
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Customers customer = new Customers();
	
	// account type
	protected String accountType;
	
	
	// account number
	protected int accountNumber;
	
	
	// balance
	protected double balance;
	
	
	// date
	protected int month;
	
	// default constructor
	public BankAccount()
	{
		
	}
	

	public BankAccount(String accountType, int accountNumber, String name, int cnic, String address, String number, String date)
	{
		this.accountType=accountType;
		this.accountNumber=accountNumber;
		customer.setName(name);
		customer.setCNIC(cnic);
		customer.setAddress(address);
		customer.setNumber(number);
		customer.setDate(date);
		balance=-0;

	}

	
	// getter method
	public double getBalance()
	{
		return this.balance;
	}
	
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	
	
	public String getAccountType()
	{
		return this.accountType;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	
	public double getTotal_Zakat() {
		return total_Zakat;
	}

	public void setTotal_Zakat(double total_Zakat) {
		this.total_Zakat = total_Zakat;
	}
	
	
	public int setAccountNumber(int accountNumber)
	{
		return this.accountNumber;
	}
	
	public String setAccountType(String accountType)
	{
		return this.accountType;
	}
	
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	
	public double getTotal_deposits() {
		return total_deposits;
	}

	public void setTotal_deposits(double total_deposits) {
		this.total_deposits = total_deposits;
	}

	public double getTotal_withdrawn() {
		return total_withdrawn;
	}

	public void setTotal_withdrawn(double total_withdrawn) {
		this.total_withdrawn = total_withdrawn;
	}

	public double getTotal_Fee() {
		return total_fee;
	}

	public void setTotal_Fee(double total_fee) {
		this.total_fee = total_fee;
	}

	public double getTotal_Transfer() {
		return total_Transfer;
	}

	public void setTotal_Transfer(double total_Transfer) {
		this.total_Transfer = total_Transfer;
	}
	
	
	public double getExtraAmount() {
		return extraAmount;
	}

	public void setExtraAmount(double extraAmount) {
		this.extraAmount = extraAmount;
	}
	/* Function to deposit funds
	 * Amount needs to be > 0
	 * 
	 */
	public abstract void deposit(double amount);
	
	
	/* Function to withdraw funds
	 * Withdraw must be > 0
	 * withdraw must be <= balance
	 */
	
	public abstract void withdraw(double amount);
	
	
	/* Function to check balance
	 * 
	 */
	
	public abstract void checkBalance();
	
	/* Function to printStatement
	 * 
	 */
	
	public abstract int printStatement();
	
	/* Function to calculate Zakat
	 * 
	 */
	
	public abstract void Zakat();
	
	/* Function to transfer amount 
	 * 
	 */
	
	public abstract boolean transferAmount(int accountNumber, double amount);
	
	/* Function to display all deductions
	 * 
	 */
	
	public abstract void displayAllDeductions();
	
	/* Function to calculate number of transaction
	 * 
	 */
	
	public abstract int countTrx();
	
}
