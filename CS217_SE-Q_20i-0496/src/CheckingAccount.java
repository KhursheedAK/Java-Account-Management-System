import java.util.Scanner;
import java.io.*;
/* Name: Khursheed Alam Khan		Assignment 3: File Handling: Account Management System
 * Roll# 20i-0496
 * Section: SE-Q
 */

public class CheckingAccount extends BankAccount implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	transient Scanner cin = new Scanner(System.in);
	
	private double balance;
	
	// default transaction fee
	private static double fee = 10.0;
	
	// default trxCount
	private int trxCount = 0;
	
	// total deposits
	private double total_deposits;
	
	// total withdrawn
	private double total_withdrawn;
	
	// total fee deducted
	private double total_fee;
	
	// total amount transfer
	private double total_Transfer;
	
	// extra withdraw amount if amount exceeds balance
	private double extraAmount=0;
	
	// default constructor
	
	public CheckingAccount()
	{
		super();
	}
	
	/*
	 * Parameter constructor initialize CheckingAccount
	 * with a custom account number 
	 * and a transaction fee of RS 10
	 */
	
	public CheckingAccount(String accountType, int accountNumber, String name, int cnic, String address, String number, String date, double fee, double balance)
	{
		super(accountType, accountNumber, name, cnic, address, number, date);
		CheckingAccount.fee=fee;
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
	
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/* Function to deposit funds
	 * Amount needs to be > 0
	 * 
	 */
	public void deposit(double amount)
	{
				System.out.println("");
				// check amount
				if(amount > 0 && (trxCount<2))
				{
					// check sufficient balance
					
						System.out.println("	Amount deposited = RS "+amount);
						balance = balance + amount;
						total_deposits = total_deposits + amount;
						System.out.println("	Balance = RS "+balance);
						trxCount++;
						System.out.println("	Your Transaction count = "+trxCount);
					
				}
				
				else if(amount > 0 && (trxCount>=2))
				{
					System.out.println("	Transaction count greater than 2 ");
					System.out.println("	You will be charged RS 10 fee for every transcation until next month");
					// check sufficient balance
					if((fee) <=balance)
					{
						System.out.println("	Amount deposited = RS "+amount);
						balance = balance + amount;
						balance = balance - fee;
						total_deposits = total_deposits + amount;
						total_fee = total_fee + fee;
						System.out.println("	Balance after deducting fee = RS "+balance);
						trxCount++;
						System.out.println("	Your Transaction count = "+trxCount);
					}
					
					else
					{
						System.out.println("	Negative amount cannot be deposited");
					}
				}
				
				else
				{
					System.out.println("	Negative amount cannot be deposited");
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
		if(amount >= 0 && (trxCount<2))
		{
			// check sufficient balance
			if(amount <= balance)
			{
				System.out.println("	Amount withdrawn = RS "+amount);
				balance = balance - amount;
				total_withdrawn = total_withdrawn + amount;
				System.out.println("	Balance = RS "+balance);
				trxCount++;
				System.out.println("	Your Transaction count = "+trxCount);
			}
			
			else if(amount > balance)
			{
				
				System.out.println("    Your amount exceeds your bank balance...");
				System.out.println("    You can withdraw up to a total limit of RS 5000 only...");
				System.out.println("    Enter your new amount to withdraw: ");
				
				double newAmount = cin.nextDouble();
				if(newAmount<=5000.0)
					{
						extraAmount = extraAmount + newAmount;
						if(extraAmount<=5000.0)
						{
							balance = balance - newAmount;
							total_withdrawn = total_withdrawn + newAmount;
							trxCount++;
							System.out.println("    Withdraw Successfull");
							System.out.println("    Your Transaction count = "+trxCount);
							System.out.println("    Extra Amount withdrawn so far is: RS "+this.extraAmount);
						
						}	
					
				
						else if(extraAmount>5000.0)
						{
							System.out.println("	You have exceeded max limit of withdrawal...");
							System.out.println("	Failed to withdraw !!!");
						}
				
					}
				
				else if(newAmount>5000.0)
				{
					System.out.println("    New amount exceeds the max withrdrawl limit of Rs 5000...");
					System.out.println("    Failed to withdraw !!!");
				}
			
			}
		}
		
		else if(amount > 0 && (trxCount>=2))
		{
			System.out.println("	Transaction count greater than 2 ");
			System.out.println("	You will be charged RS 10 fee for every transcation until next month");
			// check sufficient balance
			if((amount+fee) <=balance)
			{
				System.out.println("	Amount withdrawn = RS "+amount);
				balance = balance - amount;
				balance = balance - fee;
				total_withdrawn = total_withdrawn + amount;
				total_fee = total_fee + fee;
				System.out.println("	Balance after deducting fee = RS "+balance);
				trxCount++;
				System.out.println("	Your Transaction count = "+trxCount);
			}
			
			else if(amount> balance)
			{
				
				System.out.println("    Your amount exceeds your bank balance...");
				System.out.println("    You can withdraw up to RS 5000 only...");
				System.out.println("    Enter your new amount to withdraw: ");
				
				double newAmount = cin.nextDouble();
				if(newAmount<=5000.0)
				{
					extraAmount = extraAmount + newAmount;
					if(extraAmount<=5000.0)
					{
						balance = balance - newAmount;
						total_withdrawn = total_withdrawn + newAmount;
						trxCount++;
						System.out.println("    Withdraw Successfull");
						System.out.println("    Your Transaction count = "+trxCount);
						System.out.println("    Extra Amount withdrawn so far is: RS "+this.extraAmount);
					
					}	
				
					else if(extraAmount>5000.0)
					{
						System.out.println("    You have exceeded max limit of withdrawal...");
						System.out.println("    Failed to withdraw !!!");
					}
			
				}
				
				else if(newAmount>5000.0)
				{
					System.out.println("    New amount exceeds the max withrdrawl limit of Rs 5000...");
					System.out.println("    Failed to withdraw !!!");
				}
			
			}
		}
		
		else
		{
			System.out.println("	Negative amount cannot be withdrawn");
		}
		System.out.println("");
	}
	
	
	/* Function to Check Balance
	 * 
	 */
	public void checkBalance()
	{
		System.out.println();
		
		System.out.println("	Account Balance Details !!!" );
	    System.out.println("");
		System.out.println("	Account Type: "+super.getAccountType());
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
		System.out.println("	Total Deposits: RS "+this.total_deposits+"	        	Recent Transaction date: "+this.customer.getDepositDate());
		System.out.println("	Total Withdrawn: RS "+this.total_withdrawn+"			Recent Transaction date: "+this.customer.getWithdrawlDate());
		System.out.println("	Total Amount transfer: RS "+this.total_Transfer+"		Recent Transaction date for transfer: "+this.customer.getTransferDate());
		System.out.println("");
		return 0;
	}
	
	/* Function to calculate Zakat
	 * 
	 */
	
	public void Zakat()
	{
		
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
		
		else if(amount <=balance && countTrx()<2)
		{
			System.out.println("	Transferring Amount !!!");
			balance = balance - amount;
			total_Transfer = total_Transfer + amount;
			System.out.println("	Transfer successfull");
			return true;
		}
		else if( amount <= balance && countTrx()>=2)
		{
			System.out.println("	Transferring Amount !!!");
			balance = balance - (amount + (amount * fee));
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
		System.out.println("	Total Withdrawn: RS "+total_withdrawn+"			Recent Transaction date: "+customer.getWithdrawlDate());
		System.out.println("	Total Amount transfer: RS "+total_Transfer+"		Recent Transaction date for transfer: "+customer.getTransferDate());
		System.out.println("	Total transaction deductions: RS "+total_fee+"	 	Recent Withdraw Transaction date: "+customer.getWithdrawlDate()+"	 	Rrecent Deposit Transaction date: "+customer.getDepositDate());
		System.out.println("");
	}
	
	/* Function to calculate number of transaction
	 * 
	 */
	
	public int countTrx()
	{
		trxCount = 0;
		
		trxCount = trxCount + 1;
	
		return trxCount;
	}
	
	
}
