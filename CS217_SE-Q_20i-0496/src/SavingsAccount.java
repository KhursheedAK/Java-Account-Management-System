
/* Name: Khursheed Alam Khan		Assignment 3: File Handling: Account Management System
 * Roll# 20i-0496
 * Section: SE-Q
 */
import java.io.*;
public class SavingsAccount extends BankAccount implements Serializable
{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private double balance;
		// interest rate
		private double interestRate;
	
		// total deposits
		private double total_deposits;
		
		// total withdrawn
		private double total_withdrawn;
		
		// total fee deducted
		private double total_Zakat;
		
		// total amount transfer
		private double total_Transfer;
		
	public SavingsAccount()
	{
		super();
	}
	
	/*
	 * Parameter constructor initialize CheckingAccount
	 * with a custom account number 
	 * and a transaction fee of RS 10
	 */
	
	public SavingsAccount(String accountType, int accountNumber, String name, int cnic, String address, String number, String date, double interestRate, double balance)
	{
		super(accountType, accountNumber, name, cnic, address, number, date);
		this.interestRate=interestRate;
		this.balance=balance;
	
	}
	
	// getter function
	
	public double getInterestRate()
	{
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate)
	{
		this.interestRate=interestRate;
	}
	
	public double calcInterest()
	{
		return balance + interestRate;
	}
	
	public void applyInterest()
	{
		double interest = calcInterest();
		System.out.println("	Interest amount added to balace = RS "+interestRate);
		System.out.println("	Total balance after adding interest: "+interest);
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

	public double getTotal_Zakat() {
		return total_Zakat;
	}

	public void setTotal_Zakat(double total_Zakat) {
		this.total_Zakat = total_Zakat;
	}

	public double getTotal_Transfer() {
		return total_Transfer;
	}

	public void setTotal_Transfer(double total_Transfer) {
		this.total_Transfer = total_Transfer;
	}
	
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	
	
	/* Function to deposit funds
	 * Amount needs to be > 0
	 * 
	 */
	
	public void deposit(double amount)
	{
		System.out.println("");
		// First check amount
		if(amount > 0)
		{
			
			balance = balance + amount;
			System.out.println("	Amount deposited = RS "+amount);
			total_deposits = total_deposits + amount;
			System.out.println("	Balance = RS "+balance);
		}
		
		else
		{
			System.out.println("	A negative amount cannot be deposited");
		}
		System.out.println("");
	}
	
	/*Function to withdraw funds
	 * Withdraw must be > 0
	 * withdraw must be <= balance
	 */
	
	public void withdraw(double amount)
	{
		System.out.println("");
		// Same check
		if(amount > 0)
		{
			// check sufficient balance
			if(amount <= balance)
			{
				System.out.println("	Amount withdrawn = RS "+amount);
				balance = balance - amount;
				total_withdrawn = total_withdrawn + amount;
				System.out.println("	Balance = RS "+balance);
			}
			
		}
		
		else
		{
			System.out.println("	Negative amount cannot be withdrawn");
		}
		System.out.println("");
	}

	
	public  void checkBalance()
	{
		System.out.println();
		
		System.out.println("	Account Balance Details !!!" );
		System.out.println("	Customer Name: "+customer.getName());

		System.out.println("	Account Balance: RS "+balance);
		
		System.out.println();
	}
	
	/* Function to printStatement
	 * 
	 */
	
	public int printStatement()
	{
		System.out.println("");
		System.out.println("	Statement Details !!!");
		System.out.println("	Account Type: "+super.getAccountType());
		System.out.println("	Account Number: "+super.getAccountNumber());
		System.out.println("	Customer Name: "+super.customer.getName());
		System.out.println("	Total Deposits: RS "+total_deposits+"	          Recent Deposit Transaction date: "+customer.getDepositDate());
		System.out.println("	Total Withdrawn: RS "+total_withdrawn+"  	      Recent Withdrawl Transaction date: "+customer.getWithdrawlDate());
		System.out.println("	Total Amount transfer: RS "+total_Transfer+"     Recent Transaction date: "+customer.getTransferDate());
		System.out.println("");
		return 0;
	}
	
	/* Function to calculate Zakat
	 * 
	 */
	
	public void Zakat()
	{
		System.out.println("");
		double zakat=(this.getBalance()*2.5)/100;
		System.out.println("	Calculating Zakat !!!");
		if(this.getBalance()<20000)
		{
			System.out.println("	Zakat collection failed");
			System.out.println("	Balance is less than Rs 20,000");
		}
		else if(this.getBalance()>=20000)
		{
			double total;
			total=balance-zakat;
			this.setBalance(total);
			this.total_Zakat = this.total_Zakat + zakat;
			System.out.println("	Zakat calculation Successful");
			super.setTotal_Zakat(this.total_Zakat);
			
		}
		System.out.println("");
	}
	
	/* Function to transfer amount 
	 * 
	 */
	
	public boolean transferAmount(int accountNumber, double amount)
	{
		System.out.println("");
		if(amount > balance)
		{
			System.out.println("	Transfer Failed !!!");
			System.out.println("	Amount exceeds the maximum balance");
			return false;
		}
		
		else if(amount <=balance)
		{
			System.out.println("	Transferring Amount !!!");
			balance = balance - amount;
			total_Transfer = total_Transfer + amount;
			System.out.println("	Transfer successfull");
			return true;
		}
		System.out.println("");
		return false;
		
	}
	
	/* Function to display all deductions
	 * 
	 */
	
	public void displayAllDeductions()
	{
		System.out.println("");
		System.out.println("	Total Deductions !!!");
		System.out.println("	Account Type: "+super.getAccountType());
		System.out.println("	Account Number: "+super.getAccountNumber());
		System.out.println("	Customer Name: "+super.customer.getName());
		System.out.println("	Total Withdrawn: RS "+total_withdrawn+"  	      Recent Withdrawl Transaction date: "+customer.getWithdrawlDate());
		System.out.println("	Total Amount transfer: RS "+total_Transfer+"     Recent Transaction date: "+customer.getTransferDate());
		System.out.println("	Total Zakat deductions: RS "+total_Zakat+"     Recent Transaction: "+customer.getZakatDate());
		System.out.println("");
	}
	
	
	/* Function to calculate number of transaction
	 * 
	 */
	
	public int countTrx()
	{
		return 0;
	}
	
	
}