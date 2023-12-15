
/* Name: Khursheed Alam Khan		Assignment 3: File Handling: Account Management System
 * Roll# 20i-0496
 * Section: SE-Q
 */

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main 
{
	public static File f1 = new File("D:\\accountInfoCA.txt");
	public static File f2 = new File("D:\\customerInfo.txt");
	public static File f3 = new File("D:\\printStatementInfo.txt");
	public static File f4 = new File("D:\\depositInfo.txt");
	public static File f5 = new File("D:\\withdrawInfo.txt");
	public static File f6 = new File("D:\\balanceInfo.txt");
	
	public static File f7 = new File("D:\\accountInfoSA.txt");


	
	public static StringTokenizer str;
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("|            Welcome to Khursheed's Account Management System           |");
		System.out.println("|                                                                       |");
		System.out.println("|                                                                       |");
		System.out.println("|            Account Number ===> Must be a number (not a string)        |");
		System.out.println("|            CNIC ===> Must be a number (not a string)                  |");
		System.out.println("|            Balance ===> Must also be a number (not a string)          |");
		System.out.println("|                                                                       |");
		System.out.println("|                                                                       |");
		System.out.println("|      Everything else (including date and phone number) is String      |");
		System.out.println("|                                                                       |");
		System.out.println("|                 NOTE: Files Are Saved in local disk D                 |");
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println("");
		
		
		
		
		Scanner keyboard = new Scanner(System.in);
		
		// create array of accounts
		
		BankAccount accounts [] = new BankAccount[10];
		int numAccounts = 0;
		
		int choice;
		
		
		do
		{
			choice = menu(keyboard);
			System.out.println();
			
			if(choice == 1)
			{
				accounts[numAccounts++] = createAccount(accounts,keyboard);
				
			}
			
			else if(choice == 2)
			{
				accounts[numAccounts++] = deleteAccount(accounts, numAccounts, keyboard);
			}		
			
			else if(choice == 3)
			{
				doDeposit(accounts, numAccounts, keyboard);
			}
			
			else if(choice == 4)
			{
				doWithdraw(accounts, numAccounts, keyboard);
			}
			
			else if(choice == 5)
			{
				applyInterest(accounts, numAccounts, keyboard);
			}
			
			else if(choice == 6)
			{
				doZakatDeduction(accounts,numAccounts,keyboard);
			}
			
			else if(choice == 7)
			{
				doPrintStatement(accounts,numAccounts,keyboard);
			}
			
			else if(choice == 8)
			{
				doDisplayAllDeductions(accounts, numAccounts, keyboard);
			}
			
			else if(choice == 9)
			{
				doDisplayAllAccount(accounts, numAccounts, keyboard);
			}
			
			else if(choice == 10)
			{
				doCheckBalance(accounts, numAccounts, keyboard);
			}
					
			else if(choice == 11)
			{
				doTransferAmount(accounts, numAccounts, keyboard);
			}
			
			else if(choice == 12)
			{
				System.out.println("	File Handling Category Entered !!!");
				System.out.println();
				System.out.println("	Select the following options: ");
				System.out.println();
				System.out.println("    1.Read created files");
				System.out.println("    2.Delete created files");
				System.out.println("    3.Save files");
				System.out.println("    4.Load files");
				choice = keyboard.nextInt();
				if(choice == 1)
				{
					System.out.println("	1.Read accountInfoCA File");
					System.out.println("	2.Read customerInfo File");
					System.out.println("	3.Read printStatement File");
					System.out.println("	4.Read Deposit File");
					System.out.println("	5.Read Withdraw File");
					System.out.println("	6.Read balance File");
					System.out.println("	7.Read accountInfoSA File");

					
					choice = keyboard.nextInt();
					if(choice == 1)
					{
						if(f1.exists())
						{	
							readAccountInfo(accounts);
						}
						else if(!(f1.exists()))
						{
							System.out.println("no file exists !!!");
						}
					}
					
					else if(choice == 2)
					{
						if(f2.exists())
						{	
							readCustomerInfo(accounts);
						}
						else if(!(f2.exists()))
						{
							System.out.println("no file exists !!!");
						}
					}
					
					else if(choice == 3)
					{
						if(f3.exists())
						{	
							readPrintInfo(accounts);
						}
						else if(!(f3.exists()))
						{
							System.out.println("no file exists !!!");
						}
					}
					
					else if(choice == 4)
					{
						if(f4.exists())
						{	
							readDepostInfo(accounts);
						}
						else if(!(f4.exists()))
						{
							System.out.println("no file exists !!!");
						}
					}
					
					else if(choice == 5)
					{
						if(f5.exists())
						{	
							readWithdrawalInfo(accounts);
						}
						else if(!(f5.exists()))
						{
							System.out.println("no file exists !!!");
						}
					}
					
					else if(choice == 6)
					{
						if(f6.exists())
						{	
							readBalanceInfo(accounts);
						}
						else if(!(f6.exists()))
						{
							System.out.println("no file exists !!!");
						}
					}
					
					else if(choice == 7)
					{
						if(f7.exists())
						{	
							readAccountInfoSA(accounts);
						}
						else if(!(f7.exists()))
						{
							System.out.println("no file exists !!!");
						}
					}
					
					
			
				}
		
			
			
				else if(choice == 2)
				{
					System.out.println("	1.Delete accountInfoCA File");
					System.out.println("	2.Delete customerInfo File");
					System.out.println("	3.Delete printStatement File");
					System.out.println("	4.Delete deposit File");
					System.out.println("	5.Delete withdraw File");
					System.out.println("	6.Delete balance File");
					System.out.println("	7.Delete accountInfoSA File");


					choice = keyboard.nextInt();
					if(choice ==1)
					{
						if(f1.delete())
						{
							System.out.println(f1.getName()+(" file successfully deleted "));
							
						}
						
						else
						{
							System.out.println("No file exists !!!");
						}
					}
					
					else if(choice ==2)
					{
						if(f2.delete())
						{
							System.out.println(f2.getName()+(" file successfully deleted "));
							
						}
						
						else
						{
							System.out.println("No file exists !!!");
						}
					}
					
					else if(choice ==3)
					{
						if(f3.delete())
						{
							System.out.println(f3.getName()+(" file successfully deleted "));
							
						}
						
						else
						{
							System.out.println("No file exists !!!");
						}
					}
					
					else if(choice ==4)
					{
						if(f4.delete())
						{
							System.out.println(f4.getName()+(" file successfully deleted "));
							
						}
						
						else
						{
							System.out.println("No file exists !!!");
						}
					}
					
					else if(choice ==5)
					{
						if(f5.delete())
						{
							System.out.println(f5.getName()+(" file successfully deleted "));
							
						}
						
						else
						{
							System.out.println("No file exists !!!");
						}
					}
					
					else if(choice ==6)
					{
						if(f6.delete())
						{
							System.out.println(f6.getName()+(" file successfully deleted "));
							
						}
						
						else
						{
							System.out.println("No file exists !!!");
						}
					}
					
					else if(choice ==7)
					{
						if(f7.delete())
						{
							System.out.println(f7.getName()+(" file successfully deleted "));
							
						}
						
						else
						{
							System.out.println("No file exists !!!");
						}
					}
					
							
					
				}
				
				else if(choice == 3)
				{
					System.out.println("	1.Save accountInfoCA File");
					System.out.println("	2.Save customerInfo File");
					System.out.println("	3.Save printStatement File");
					System.out.println("	4.Save depositInfo File");
					System.out.println("	5.Save withdrawInfo File");
					System.out.println("	6.Save balanceInfo File");
					System.out.println("	7.Save accountInfoSA File");

					choice = keyboard.nextInt();
					if(choice ==1)
					{
						
							doUpdateAccountInfoCA(accounts, numAccounts, keyboard);
						
					
					}
					
					else if(choice==2)
					{
						doUpdateCustomerInfo(accounts, numAccounts, keyboard);
					}
					
					else if(choice==3)
					{
						doUpdatePrintInfo(accounts, numAccounts, keyboard);
					}
					
					else if(choice==4)
					{
						doUpdateDepositInfo(accounts, numAccounts, keyboard);
					}
					
					else if(choice==5)
					{
						doUpdateWithdrawalInfo(accounts, numAccounts, keyboard);
					}
					
					else if(choice==6)
					{
						doUpdateBalanceInfo(accounts, numAccounts, keyboard);
					}
					
					else if(choice==7)
					{
						doUpdateAccountInfoSA(accounts, numAccounts, keyboard);
					}

				}
				
				//Load
				else if(choice == 4)
				{
					System.out.println("	1.Load accountInfoCA File");
					System.out.println("");
					System.out.println("	2.Load accountInfoSA File");
					choice = keyboard.nextInt();
					if(choice ==1)
					{
						accounts[numAccounts++] =loadCheckingAccount(accounts,keyboard);
	
					}
					
					else if(choice==2)
					{
						accounts[numAccounts++] =loadSavingAccount(accounts,keyboard);
					}
			
				}
			}
			
			
			else if(choice == 13)
			{
				System.out.println("	Program Exited !!!");
				break;
			}
			
			System.out.println();
		}while(choice !=13);
			
		System.out.println("");
		System.out.println("	Thank you for using Khursheed's Simple Java Based File Handling system for Account Management System.");
	}
	
	
				
	
	
	
									// GENERAL FUNCTIONS
	
	
	
	// Function # 1: Account choice
	public static int accountMenu(Scanner keyboard)
	{
		
		System.out.println("");
		System.out.println("	----Select Account type----");
		System.out.println("	 1. Checking Account");
		System.out.println("	 2. Savings Account");
		System.out.println("");
		
		
		int choice;
		System.out.println("");
		do
		{
			System.out.println("	Enter choice");
			choice = keyboard.nextInt();
			
		}while(choice < 1 || choice > 2);
		
		return choice;
	}
	
	
	
	
	// Function # 2: Searching for an account
	public static int searchAccount(BankAccount accounts [], int count, int accountNumber)
	{
		for(int i =0; i<count;i++)
		{
			
			 if(accounts[i]==null)
			{
				
				
			}
			 
			else if(accounts[i].getAccountNumber() == accountNumber)
			{
					return i;
			}
		}
		return -1;
	}
	
	
	
	
	
	//	Function # 3: Perform deposit on a selected account
	
	public static void doDeposit(BankAccount accounts [], int count, Scanner keyboard)
	{
		int choice = accountMenu(keyboard);
		
		if(choice == 1)//checking account
		{
			int accountNumber;
			System.out.println("	Enter Account Number: ");
			accountNumber = keyboard.nextInt();
			keyboard.nextLine();
			
			int index = searchAccount(accounts, count, accountNumber);
			
			if(index<0)
			{
				
			}
			
			else if(index>=0)
			{
				if(accounts[index] instanceof CheckingAccount)
				{		//date
						System.out.println("	Enter date of deposit transaction (dd/mm/yy): ");
						String d_date = keyboard.nextLine();
						accounts[index].customer.setDepositDate(d_date);
				
						// amount
						System.out.println("	Please enter amount to deposit: ");
						double amount = keyboard.nextDouble();
				
						accounts[index].deposit(amount);
				}
			}
			
			
		}
		
		
		else 
		{
			int accountNumber;
			System.out.println("	Enter Account Number: ");
			accountNumber = keyboard.nextInt();
			keyboard.nextLine();
			
			int index = searchAccount(accounts, count, accountNumber);
			
			if(index<0)
			{
				
			}
			
			else if(index>=0)
			{	
				if(accounts[index] instanceof SavingsAccount)
				{
					//date
					System.out.println("	Enter date of deposit transaction (dd/mm/yy): ");
					String d_date = keyboard.nextLine();
					
					// amount
					System.out.println("	Please enter amount to deposit: ");
					double amount = keyboard.nextDouble();
					
					accounts[index].deposit(amount);
					accounts[index].customer.setDepositDate(d_date);
				}
			
			}
			
		}
	}
	
	
	
	
	
	// Function # 4: Perform withdraw on a selected account
	public static void doWithdraw(BankAccount accounts[], int count, Scanner keyboard)
	{
				int choice = accountMenu(keyboard);
				
				if(choice == 1)//checking account
				{
					int accountNumber;
					System.out.println("	Enter Account Number: ");
					accountNumber = keyboard.nextInt();
					keyboard.nextLine();
					
					int index = searchAccount(accounts, count, accountNumber);
					
					if(index<0)
					{
						
					}
					
					else if(index>=0)
					{
						if(accounts[index] instanceof CheckingAccount)
							{
								//date
								System.out.println("	Enter date of withdrawl transaction (dd/mm/yy): ");
								String w_date = keyboard.nextLine();
								// amount
								System.out.println("	Please enter withdraw amount: ");
								double amount = keyboard.nextDouble();
						
								accounts[index].withdraw(amount);
								accounts[index].customer.setWithdrawlDate(w_date);
							}
						}
					
				}
				
				
				else 
				{
					int accountNumber;
					System.out.println("	Enter Account Number: ");
					accountNumber = keyboard.nextInt();
					keyboard.nextLine();
					
					int index = searchAccount(accounts, count, accountNumber);
					
					if(index<0)
					{
						
					}
					
					else if(index>=0)
					{	
						if(accounts[index] instanceof SavingsAccount)
						{
							//date
							System.out.println("	Enter date of withdrawl transaction (dd/mm/yy): ");
							String w_date = keyboard.nextLine();
							
							// amount
							System.out.println("	Please enter withdraw amount: ");
							double amount = keyboard.nextDouble();
							
							accounts[index].withdraw(amount);
							accounts[index].customer.setWithdrawlDate(w_date);
						}
					}
					
					
				}
				
				
		}
	
	
	
	
	
	
	// Function # 5: Apply interest to savings account
	public static void applyInterest(BankAccount accounts[], int count, Scanner keyboard)
	{
				//get account number
				System.out.println("	Please enter Savings account number");
				int accountNumber = keyboard.nextInt();
				
				// search for the account
				int index = searchAccount(accounts, count, accountNumber);
				
				if(index<0) 
				{
					
				}
				
				else if(index>=0) 
				{
					
					// must be instance of savings account
					if(accounts[index] instanceof SavingsAccount)
					{
						((SavingsAccount)accounts[index]).applyInterest();
						System.out.println("	Interest rate successfully applied !!!");
					}
				}
				
				
			
	}
	
	
	
	
	
	// Function # 6: Create a new Account
	public static BankAccount createAccount(BankAccount accounts [], Scanner keyboard)
	{
		BankAccount account = null;
		int choice = accountMenu(keyboard);
		
		
		int accountNumber;
		System.out.println("	Enter Account Type: ");
		keyboard.nextLine();
		String accountType = keyboard.nextLine();
		
		System.out.println("	Enter Account Number: ");
		accountNumber = keyboard.nextInt();
		keyboard.nextLine();
		findAccountNumberUniqueOrNot(accounts, accountNumber,keyboard);
		if(findAccountNumberUniqueOrNot(accounts, accountNumber,keyboard)==true)
		{
			System.out.println("Press any key to return back to main menu...");
			String in = keyboard.nextLine();
		}
		else {
				System.out.println("	Enter Customer Name: ");
				String name = keyboard.nextLine();
		
		
				System.out.println("	Enter Customer CNIC: ");
				int cnic = keyboard.nextInt();
		
				findCNICUniqueOrNot(accounts, cnic, choice, keyboard);
				if(findCNICUniqueOrNot(accounts,cnic, choice, keyboard)==true)
				{
					System.out.println("Press any key to return back to main menu...");
					String in = keyboard.nextLine();
				}
				else {
				keyboard.nextLine();
				System.out.println("	Enter Customer Address: ");
				String address = keyboard.nextLine();
		
				System.out.println("	Enter Customer Phone number: ");
				String number = keyboard.nextLine();
		
				System.out.println("	Enter date of account creation (dd/mm/yy) ");
				String date = keyboard.nextLine();
				
				System.out.println("	Enter starting balance ");
				double balance = keyboard.nextDouble();
				
				if(choice == 1) //checking account creation
				{
					account = new CheckingAccount(accountType, accountNumber, name, cnic, address, number, date, 10,balance);
					System.out.println("	Checkings account created successfully !!!");
				}
		
				else //savings account creation
					{
					
					account = new SavingsAccount(accountType, accountNumber, name, cnic, address, number, date, 500,balance);
					System.out.println("	Savings account created successfully !!!");
			
			
					}
				}
		}
				return account;
	}
	
	
	
	
			// Function # 7: Deleting an account
			public static BankAccount deleteAccount(BankAccount accounts [], int accountNumber, Scanner keyboard)
			{
					System.out.println("");
					System.out.println("	Deleting Account !!!");
					System.out.println("");
					System.out.println("	Enter Account Number: ");
					accountNumber = keyboard.nextInt();
						
					for(int i=0;i<accounts.length;i++)
					{
						if(accounts[i]==null)
						{
							
						}
						
						else if(accounts[i].getAccountNumber()==accountNumber)
						{
							accounts[i]=null;
							System.out.println("	Account with the ID "+accountNumber+" has been Deleted !!!");
						}
					}
					System.out.println("");
					return null;
				
			}
		
	
		
		
		
	// Function # 8: Display menu options to user
	public static int menu(Scanner keyboard)
	{
		
		System.out.println("");
		System.out.println("	----Bank Account menu----");	// menu to display options and get user's selection
		System.out.println("	1.  Create new Account");
		System.out.println("	2.  Delete an Account");
		System.out.println("	3.  Deposit Funds");
		System.out.println("	4.  Withdraw Funds");
		System.out.println("	5.  Apply interest");
		System.out.println("	6.  Zakat deduction");
		System.out.println("	7.  Print Statement");
		System.out.println("	8.  Display All Deductions");
		System.out.println("	9.  Display All Account details");
		System.out.println("	10. Check Balance");
		System.out.println("	11. Transfer Amount");
		System.out.println("	12. File Handling Options");
		System.out.println("	13. Quit");
		System.out.println("");
		
		
		int choice;
		System.out.println("");
		
		do 
		{
			System.out.println("	Enter choice: ");
			choice = keyboard.nextInt();
			
		}while(choice < 1 || choice > 13);
	
		return choice;
	}
	
	
	
	
	///Function # 9: Display all account details
	public static void doDisplayAllAccount(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
	{
		
			System.out.println("	Displaying All Existing Accounts !!!");
			System.out.println("");
			
			int index = searchAllAccount(accounts);
			
			if(index<0)
			{
				System.out.println("	No accounts Exist");
			}
			
			else 
			{
				System.out.println("");
			}
		
	}
	
	
	
	
	// Function # 10: Search for all accounts 
		public static int searchAllAccount(BankAccount accounts [])
		{
				for(int i =0; i<accounts.length;i++)
				{
					
					 if(accounts[i]==null)
					{
						
						
					}
					 
					else if(accounts[i]!=null)
					{	
						System.out.println("");
						System.out.println("	Account type: "+accounts[i].getAccountType());
						System.out.println("	Customer name: "+accounts[i].customer.getName());
						System.out.println("	Customer address: "+accounts[i].customer.getAddress());
						System.out.println("	Customer phone: "+accounts[i].customer.getNumber());
						System.out.println("	Account ID: "+accounts[i].getAccountNumber());
						System.out.println("	Account creation date: "+accounts[i].customer.getDate());
						System.out.println("	Account Balance: "+accounts[i].getBalance());
						System.out.println("");	
						
					
						
					}
					 
				}
				
				return 0;
			}
	
	
	
	
	// Function # 11: Print statement
	public static void doPrintStatement(BankAccount accounts [], int count, Scanner keyboard)
	{
		int choice = accountMenu(keyboard);
		
		if(choice == 1)//checking account
		{
			System.out.println("	Checking Account Entered !!!");
			int accountNumber;
			System.out.println("	Enter Account Number: ");
			accountNumber = keyboard.nextInt();
			
			int index = searchAccount(accounts, count, accountNumber);
			
			if(index<0)
			{
				
			}
			
			else if(index>=0)
			{
				if(accounts[index] instanceof CheckingAccount)
				accounts[index].printStatement();
			}
			
		}
		
		else //savings account 
		{
			System.out.println("	Savings Account Entered !!!");
			int accountNumber;
			System.out.println("	Enter Account Number: ");
			accountNumber = keyboard.nextInt();
			
			int index = searchAccount(accounts, count, accountNumber);
			
			if(index<0)
			{
				
			}
			
			else if(index>=0)
			{	
				if(accounts[index] instanceof SavingsAccount)
				{
					accounts[index].printStatement();
				}
			}
			
			
			
		}
			
	}
	
	
	
	// Function # 12: Display all deductions
	public static void doDisplayAllDeductions(BankAccount accounts [], int count, Scanner keyboard)
	{
		int choice = accountMenu(keyboard);
		
		if(choice == 1)//checking account
		{
			System.out.println("	Checking Account Entered !!!");
			int accountNumber;
			System.out.println("	Enter Account Number: ");
			accountNumber = keyboard.nextInt();
			
			int index = searchAccount(accounts, count, accountNumber);
			
			if (index<0)
			{
				
			}
			
			else if(index>=0)
			{
				if(accounts[index] instanceof CheckingAccount)
				accounts[index].displayAllDeductions();
			}
			
			
		}
		
		else //savings account 
		{
			System.out.println("	Savings Account Entered !!!");
			int accountNumber;
			System.out.println("	Enter Account Number: ");
			accountNumber = keyboard.nextInt();
			
			int index = searchAccount(accounts, count, accountNumber);
			
			if(index<0)
			{
				
			}
			
			else if(index>=0)
			{	
				if(accounts[index] instanceof SavingsAccount)
				{
					accounts[index].displayAllDeductions();
				}
			}
		
			
			
		}
			
	}
	
	
	
	
	// Function # 13: Calculate Zakat
	public static void doZakatDeduction(BankAccount accounts [], int count, Scanner keyboard)
	{
		
			//savings account 
			int accountNumber;
			System.out.println("	Enter Savings Account Number: ");
			accountNumber = keyboard.nextInt();
			keyboard.nextLine();
			
			int index = searchAccount(accounts, count, accountNumber);
			
			if (index<0)
			{
				
			}
			
			else if(index>=0)
			{	
				if(accounts[index] instanceof SavingsAccount)
				{
					System.out.println("	Enter date of zakat deduction transaction");
					String z_date = keyboard.nextLine();
					
					accounts[index].Zakat();
					accounts[index].customer.setZakatDate(z_date);
				}
			}
					
	}

	
	
	
	
		// Function # 14: Transfer Amount
		public static void doTransferAmount(BankAccount accounts [], int count, Scanner keyboard)
		{
			
			int choice = transferAmountAccountMenu(keyboard);
			
			if(choice == 1)//checking account to checking account
			{
				int accountNumber;
				System.out.println("	Enter Sender's Account Number: ");
				accountNumber = keyboard.nextInt();
				
				
				int index = searchAccount(accounts, count, accountNumber);
				
				if(index<0)
				{
					
				}
				
				else if(index>=0)
				{
					// Receiver's account ID
					System.out.println("	Enter Reciever's Account number: ");
					int accountNumber2 = keyboard.nextInt();
					while(accountNumber2 == accountNumber)
					{
						System.out.println("	Sender's and Receiver's Account Numbers can not be same.... Please re-enter receiver's account number: ");
						accountNumber2 = keyboard.nextInt();
					}
					keyboard.nextLine();
					int index2 = searchAccount(accounts, count, accountNumber2);
					
					if(index2<0)
					{
						
					}
					
					else if(index2>=0)
					{
						//date
						System.out.println("	Enter date of transaction for transfer of amount (dd/mm/yy): ");
						String t_date = keyboard.nextLine();
						// amount
						System.out.println("	Please enter amount to transfer: ");
						double amount = keyboard.nextDouble();
						
						accounts[index].transferAmount(accountNumber, amount);
						double total_balance=accounts[index2].getBalance()+amount;
						accounts[index2].setBalance(total_balance);
						accounts[index].customer.setTransferDate(t_date);
					}
				}
				
			}
			
			
			else if(choice == 2)//checking account to Savings account
			{
				int accountNumber;
				System.out.println("	Enter Sender's Account Number: ");
				accountNumber = keyboard.nextInt();
				
				
				int index = searchAccount(accounts, count, accountNumber);
				
				if(index<0)
				{
					
				}
				
				else if(index>=0)
				{
					// Receiver's account ID
					System.out.println("	Enter Reciever's Account number: ");
					int accountNumber2 = keyboard.nextInt();
					
					
					while(accountNumber2 == accountNumber)
					{
						System.out.println("	Sender's and Receiver's Account Numbers can not be same.... Please re-enter receiver's account number: ");
						accountNumber2 = keyboard.nextInt();
					}
					keyboard.nextLine();
					
					int index2 = searchAccount(accounts, count, accountNumber2);
					
					if(index2<0)
					{
						
					}
					
					else if(index2>=0)
					{
						if(accounts[index2] instanceof SavingsAccount)
						{
							//date
							System.out.println("	Enter date of transaction for transfer of amount (dd/mm/yy): ");
							String t_date = keyboard.nextLine();
							// amount
							System.out.println("	Please enter amount to transfer: ");
							double amount = keyboard.nextDouble();
							
							accounts[index].transferAmount(accountNumber, amount);
							double total_balance=accounts[index2].getBalance()+amount;
							accounts[index2].setBalance(total_balance);
							accounts[index].customer.setTransferDate(t_date);
						}
					}
				}
				
			}
			
			
			else if(choice == 3)//Savings account to Savings account
			{
				int accountNumber;
				System.out.println("	Enter Sender's Account Number: ");
				accountNumber = keyboard.nextInt();
				
				
				int index = searchAccount(accounts, count, accountNumber);
				
				if(index<0)
				{
					
				}
				
				else if(index>=0)
				{
					if(accounts[index] instanceof SavingsAccount)
					{	// Receiver's account ID
						System.out.println("	Enter Reciever's Account number: ");
						int accountNumber2 = keyboard.nextInt();
						
					
						while(accountNumber2 == accountNumber)
						{
							System.out.println("	Sender's and Receiver's Account Numbers can not be same.... Please re-enter receiver's account number: ");
							accountNumber2 = keyboard.nextInt();
						}
						keyboard.nextLine();
						
						int index2 = searchAccount(accounts, count, accountNumber2);
					
						if(index2<0)
						{
							
						}
					
						else if(index2>=0)
						{
							if(accounts[index2] instanceof SavingsAccount)
							{
								//date
								System.out.println("	Enter date of transaction for transfer of amount (dd/mm/yy): ");
								String t_date = keyboard.nextLine();
								// amount
								System.out.println("	Please enter amount to transfer: ");
								double amount = keyboard.nextDouble();
							
								accounts[index].transferAmount(accountNumber, amount);
								double total_balance=accounts[index2].getBalance()+amount;
								accounts[index2].setBalance(total_balance);
								accounts[index].customer.setTransferDate(t_date);
							}
						}
				
					}
					
				
				
				}
			
						
			}
			
			
			else if(choice == 4)//Savings account to Checking Account
			{
				int accountNumber;
				System.out.println("	Enter Sender's Account Number: ");
				accountNumber = keyboard.nextInt();
				
				
				int index = searchAccount(accounts, count, accountNumber);
				
				if(index<0)
				{
					
				}
				
				else if(index>=0)
				{
					if(accounts[index] instanceof SavingsAccount)
					{	// Receiver's account ID
						System.out.println("	Enter Reciever's Account number: ");
						int accountNumber2 = keyboard.nextInt();
						
					
						while(accountNumber2 == accountNumber)
						{
							System.out.println("	Sender's and Receiver's Account Numbers can not be same.... Please re-enter receiver's account number: ");
							accountNumber2 = keyboard.nextInt();
						}
						keyboard.nextLine();
						
						int index2 = searchAccount(accounts, count, accountNumber2);
					
						if(index2<0)
						{
							
						}
					
						else if(index2>=0)
						{
							
							//date
							System.out.println("	Enter date of transaction for transfer of amount (dd/mm/yy): ");
							String t_date = keyboard.nextLine();
							// amount
							System.out.println("	Please enter amount to transfer: ");
							double amount = keyboard.nextDouble();
							
							accounts[index].transferAmount(accountNumber, amount);
							double total_balance=accounts[index2].getBalance()+amount;
							accounts[index2].setBalance(total_balance);
							accounts[index].customer.setTransferDate(t_date);
						}
				
					}
					
				
				
				}
			
						
			}
			
			
		}
		
		
		
		// Function # 15: Menu for transfer of amount between various account types
		public static int transferAmountAccountMenu(Scanner keyboard)
		{
			System.out.println("");
			System.out.println("	----Select Account type to transfer to and from---- ");
			System.out.println("	1. Checking Account to Checking Account				");
			System.out.println("	2. Checking Account to Savings Account				");
			System.out.println("	3. Savings Account to Savings Account				");
			System.out.println("	4. Savings Account to Checking Account				");
			System.out.println("");
			
			System.out.println("");
			int choice;
			do
			{
				System.out.println("	Enter choice");
				choice = keyboard.nextInt();
				
			}while(choice < 1 || choice > 4);
			
			return choice;
		}
		
		// Function # 16: Searching for existing account while creating new account
		public static boolean findAccountNumberUniqueOrNot(BankAccount accounts [], int accountNumber, Scanner keyboard)
		{
			for(int i =0; i<accounts.length;i++)
			{
				
				 if(accounts[i]==null)
				{
					
				}
				 
				else if(accounts[i].getAccountNumber() == accountNumber)
				{
						
							System.out.println("	Account number already exists.... Please re-enter new account number");
							return true;				
						
				}
			
			
			}
			return false;
		}
		
		// Function # 17: Checking Balance of a specific account by its account number
				public static void doCheckBalance(BankAccount accounts [], int count, Scanner keyboard)
				{
					int choice = accountMenu(keyboard);
					
					if(choice == 1)//checking account
					{
						System.out.println("	Checking Account Entered !!!");
						int accountNumber;
						System.out.println("	Enter Account Number: ");
						accountNumber = keyboard.nextInt();
						
						int index = searchAccount(accounts, count, accountNumber);
						
						if (index<0)
						{
							
						}
						
						else if(index>=0)
						{
							if(accounts[index] instanceof CheckingAccount)
							accounts[index].checkBalance();
						}
						
						
					}
					
					else //savings account 
					{
						System.out.println("	Savings Account Entered !!!");
						int accountNumber;
						System.out.println("	Enter Account Number: ");
						accountNumber = keyboard.nextInt();
						
						int index = searchAccount(accounts, count, accountNumber);
						
						if(index<0)
						{
							
						}
						
						else if(index>=0)
						{	
							if(accounts[index] instanceof SavingsAccount)
							{
								accounts[index].checkBalance();
							}
						}
					
						
						
					}
				}
				
				
				// Function # 18: Searching for existing account while creating new account
				public static boolean findCNICUniqueOrNot(BankAccount accounts [], int cnic, int choice, Scanner keyboard)
				{
					for(int i =0; i<accounts.length;i++)
					{
						
						 if(accounts[i]==null)
						{
							
						}
						 
						 else if(accounts[i]!=null)
						 {
							 	if(choice==2)
							 	{		 
							 		if(accounts[i] instanceof SavingsAccount)
								 {	
							 			if(accounts[i].customer.getCNIC()==cnic)
							 			{	
							 				
							 					System.out.println("	Account with entered CNIC already exists.... Please re-enter new CNIC");
							 					return true;					
							 				
								
							 			}
								 }
							 	}
							 	else if(choice ==1)
							 	{
							 		if(accounts[i] instanceof CheckingAccount)
							 		{
							 			if(accounts[i].customer.getCNIC()==cnic)
							 			{	
							 				
							 					System.out.println("	Account with entered CNIC already exists.... Please re-enter new CNIC");
							 					return true;
							 					
								
							 			}
							 		}
							 	}
					
						 	}
						}
						
					
					return false;
				}
				
				
				
											// FILE HANDLING FUNCTIONS 
				
				
				///Function # 1: Update account details CA Major class
				public static void doUpdateAccountInfoCA(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
				{
					
						System.out.println("	Updating Checking Account !!!");
						System.out.println("");
						
						int index = updateDetailsAccountInfoCA(accounts);
						
						if(index<0)
						{
							System.out.println("	No accounts Exist");
						}
						
						else 
						{
							System.out.println("");
						}
					
				}
				
				// Function # 2: Update account details CA minor class
				
				public static int updateDetailsAccountInfoCA(BankAccount accounts []) throws IOException, FileNotFoundException 
				{
					FileWriter writer = new FileWriter(f1);
					
					BufferedWriter br = new BufferedWriter(writer);
					PrintWriter pr = new PrintWriter(br);
					
						
					
						for(int i =0; i<accounts.length;i++)
						{
							
							 if(accounts[i]==null)
							{
								
								
							}
							 
							else if(accounts[i]!=null)
							{	
								if(accounts[i] instanceof CheckingAccount)
								{	
								pr.println(accounts[i].getAccountType());
								pr.println(accounts[i].getAccountNumber());
								pr.println(accounts[i].customer.getName());
								pr.println(accounts[i].customer.getCNIC());
								pr.println(accounts[i].customer.getAddress());
								pr.println(accounts[i].customer.getNumber());
								pr.println(accounts[i].customer.getDate());
								pr.println(accounts[i].getBalance());
							
								}
								
							}
							 
						}
						br.close();
						pr.close();
						writer.close();
						System.out.println(" Information Updated !!!");
						return 0;
					}
				
				///Function # 3: Update customer details Major class
				public static void doUpdateCustomerInfo(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
				{
					
						System.out.println("	Updating Customer Info !!!");
						System.out.println("");
						
						int index = updateDetailsCustomerInfo(accounts);
						
						if(index<0)
						{
							System.out.println("	No accounts Exist");
						}
						
						else 
						{
							System.out.println("");
						}
					
				}
				
				// Function # 4: Update customer details minor class
				
				public static int updateDetailsCustomerInfo(BankAccount accounts []) throws IOException, FileNotFoundException 
				{
					FileWriter writer = new FileWriter(f2);
					
					BufferedWriter br = new BufferedWriter(writer);
					
						
					
						for(int i =0; i<accounts.length;i++)
						{
							
							 if(accounts[i]==null)
							{
								
								
							}
							 
							else if(accounts[i]!=null)
							{	
								
								br.append(" Customer name: "+accounts[i].customer.getName());
								br.append(" | Customer CNIC: "+accounts[i].customer.getCNIC());
								br.append(" | Customer address: "+accounts[i].customer.getAddress());
								br.append(" | Customer phone: "+accounts[i].customer.getNumber());
								br.newLine();
								
							}
							 
						}
						br.close();
						System.out.println(" Information Updated !!!");
						return 0;
					}
				
				
				///Function # 5: Update print statement details Major class
				public static void doUpdatePrintInfo(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
				{
					
						System.out.println("	Updating printStatement Info !!!");
						System.out.println("");
						
						int index = updateDetailsPrintInfo(accounts);
						
						if(index<0)
						{
							System.out.println("	No accounts Exist");
						}
						
						else 
						{
							System.out.println("");
						}
					
				}
				
				// Function # 6: Update print statement details minor class
				
				public static int updateDetailsPrintInfo(BankAccount accounts []) throws IOException, FileNotFoundException 
				{
					FileWriter writer = new FileWriter(f3,true);
					
					BufferedWriter br = new BufferedWriter(writer);
					
						
					
						for(int i =0; i<accounts.length;i++)
						{
							
							 if(accounts[i]==null)
							{
								
								
							}
							 
							else if(accounts[i]!=null)
							{	
								
								br.write("Bank Account ID: "+accounts[i].getAccountNumber());
								br.write("|Customer Name: "+accounts[i].customer.getName());
								br.write("|Customer CNIC: "+accounts[i].customer.getCNIC());
								br.write("|Total Deposits: RS "+(int) accounts[i].getTotal_deposits()+" -- Recent Transaction: "+accounts[i].customer.getDepositDate());
								br.write("|Total Withdrawn: RS "+(int) accounts[i].getTotal_withdrawn()+" -- Recent Transaction: "+accounts[i].customer.getWithdrawlDate());
								br.write("|Total Transfer: RS "+(int) accounts[i].getTotal_Transfer()+" -- Recent Transaction: "+accounts[i].customer.getTransferDate());
								if(accounts[i] instanceof SavingsAccount)
								{
									br.write("|Total Zakat Deduction: RS "+accounts[i].getTotal_Zakat()+" -- Recent Transaction: "+accounts[i].customer.getZakatDate());
								}
								else if(accounts[i] instanceof CheckingAccount)
								{
									br.write("|Total Fee Deduction: RS "+accounts[i].getTotal_Fee()+" -- Recent Transaction Withdrawl: "+accounts[i].customer.getWithdrawlDate()+" -- Recent Transaction Depost:  "+accounts[i].customer.getDepositDate());
								}
								br.newLine();
								
								
							}
							 
						}
						br.close();
						
						System.out.println(" Information Updated !!!");
						return 0;
					}
			
				
				// Read Function for Account Info
				public static void readAccountInfo(BankAccount accounts []) throws IOException
				{
					Scanner s = new Scanner(f1);
					while(s.hasNextLine())
					{
						String line = s.nextLine();
						System.out.println(line);
					}
					s.close();
				}
				
				
				// Read Function for Account Info
				public static void readAccountInfoSA(BankAccount accounts []) throws IOException
				{
					Scanner s = new Scanner(f7);
					while(s.hasNextLine())
					{
						String line = s.nextLine();
						System.out.println(line);
					}
					s.close();
				}
				
				
				// Read Function for customer Info
				public static void readCustomerInfo(BankAccount accounts []) throws IOException
				{
					Scanner s = new Scanner(f2);
					while(s.hasNextLine())
					{
						String line = s.nextLine();
						System.out.println(line);
					}
					s.close();
				}
				
				// Read Function for printStatement Info
				public static void readPrintInfo(BankAccount accounts []) throws IOException
				{
					Scanner s = new Scanner(f3);
					while(s.hasNextLine())
					{
						String line = s.nextLine();
						System.out.println(line);
					}
					s.close();
				}
				
				// Read Function for Deposit Info
				public static void readDepostInfo(BankAccount accounts []) throws IOException
				{
					Scanner s = new Scanner(f4);
					while(s.hasNextLine())
					{
						String line = s.nextLine();
						System.out.println(line);
					}
					s.close();
				}
				
				// Read Function for Withdrawal Info
				public static void readWithdrawalInfo(BankAccount accounts []) throws IOException
				{
					Scanner s = new Scanner(f5);
					while(s.hasNextLine())
					{
						String line = s.nextLine();
						System.out.println(line);
					}
					s.close();
				}
				
				
				
				
				///Function # 7: Update deposit details Major class
				public static void doUpdateDepositInfo(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
				{
					
						System.out.println("	Updating Deposit Info !!!");
						System.out.println("");
						
						int index = updateDetailsDepositInfo(accounts);
						
						if(index<0)
						{
							System.out.println("	No accounts Exist");
						}
						
						else 
						{
							System.out.println("");
						}
					
				}
				
				// Function # 8: Update deposit details minor class
				
				public static int updateDetailsDepositInfo(BankAccount accounts []) throws IOException, FileNotFoundException 
				{
					
					FileWriter fr = new FileWriter(f4,true);
					BufferedWriter br = new BufferedWriter(fr);
					
						
					
						for(int i =0; i<accounts.length;i++)
						{
							
							 if(accounts[i]==null)
							{
								
								
							}
							 
							else if(accounts[i]!=null)
							{	
								
								br.write("Bank Account ID: "+accounts[i].getAccountNumber());
								br.write("|Customer CNIC: "+accounts[i].customer.getCNIC());
								br.write("|Total Deposits: RS "+(int) accounts[i].getTotal_deposits()+" -- Recent Transaction: "+accounts[i].customer.getDepositDate());
								br.newLine();
								
								
							}
							 
						}
						br.close();
						
						System.out.println(" Information Updated !!!");
						return 0;
					}
				
				
				///Function # 9: Update Withdraw details Major class
				public static void doUpdateWithdrawalInfo(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
				{
					
						System.out.println("	Updating Deposit Info !!!");
						System.out.println("");
						
						int index = updateDetailsWithdrawalInfo(accounts);
						
						if(index<0)
						{
							System.out.println("	No accounts Exist");
						}
						
						else 
						{
							System.out.println("");
						}
					
				}
				
				// Function # 10: Update Withdraw details minor class
				
				public static int updateDetailsWithdrawalInfo(BankAccount accounts []) throws IOException, FileNotFoundException 
				{
					
					FileWriter fr = new FileWriter(f5,true);
					BufferedWriter br = new BufferedWriter(fr);
					
						
					
						for(int i =0; i<accounts.length;i++)
						{
							
							 if(accounts[i]==null)
							{
								
								
							}
							 
							else if(accounts[i]!=null)
							{	
								
								br.write("Bank Account ID: "+accounts[i].getAccountNumber());
								br.write("|Customer CNIC: "+accounts[i].customer.getCNIC());
								br.write("|Total Withdrawal: RS "+(int) accounts[i].getTotal_withdrawn()+" -- Recent Transaction: "+accounts[i].customer.getWithdrawlDate());
								br.newLine();
								
								
							}
							 
						}
						br.close();
						
						System.out.println(" Information Updated !!!");
						return 0;
					}
				
				
				
				///Function # 11: Update balance details Major class
				public static void doUpdateBalanceInfo(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
				{
					
						System.out.println("	Updating Balance Info !!!");
						System.out.println("");
						
						int index = updateDetailsBalanceInfo(accounts);
						
						if(index<0)
						{
							System.out.println("	No accounts Exist");
						}
						
						else 
						{
							System.out.println("");
						}
					
				}
				
				// Function # 12: Update Balance details minor class
				
				public static int updateDetailsBalanceInfo(BankAccount accounts []) throws IOException, FileNotFoundException 
				{
					
					FileWriter fr = new FileWriter(f6,true);
					BufferedWriter br = new BufferedWriter(fr);
					
						
					
						for(int i =0; i<accounts.length;i++)
						{
							
							 if(accounts[i]==null)
							{
								
								
							}
							 
							else if(accounts[i]!=null)
							{	
								
								br.write("Bank Account ID: "+accounts[i].getAccountNumber());
								br.write("|Customer CNIC: "+accounts[i].customer.getCNIC());
								br.write("|Total Balance: RS "+(int) accounts[i].getBalance());
								br.newLine();
								
								
							}
							 
						}
						br.close();
						
						System.out.println(" Information Updated !!!");
						return 0;
					}
				
				// Read Function for Balance Info
				public static void readBalanceInfo(BankAccount accounts []) throws IOException
				{
					Scanner s = new Scanner(f6);
					while(s.hasNextLine())
					{
						String line = s.nextLine();
						System.out.println(line);
					}
					s.close();
				}
				
				
				// Load function account CA
				public static BankAccount loadCheckingAccount(BankAccount [] accounts, Scanner keyboard) throws FileNotFoundException
				{

					BankAccount account = null;
				    Scanner input = new Scanner(f1);
				   
				   
				    while(input.hasNext())
				    {
				    	
				        	String acc =input.next();
				        	int num = input.nextInt();
				        	String name = input.next();
				        	int cnic = input.nextInt();
				        	String address = input.next();
				        	String phone = input.next();
				        	String date = input.next();
				        	double balance = input.nextDouble();
				        	account = new CheckingAccount(acc, num, name, cnic, address, phone, date, 10, balance);

				        	
				    }
				    input.close();
				    
					return account;

				    
				   }
				// Load Function account SA
				public static BankAccount loadSavingAccount(BankAccount [] accounts, Scanner keyboard) throws FileNotFoundException
				{

					BankAccount account = null;
				    Scanner input = new Scanner(f7);
				   
				   
				    while(input.hasNext())
				    {
				    	
				        	String acc =input.next();
				        	int num = input.nextInt();
				        	String name = input.next();
				        	int cnic = input.nextInt();
				        	String address = input.next();
				        	String phone = input.next();
				        	String date = input.next();
				        	double balance = input.nextDouble();
				        	account = new SavingsAccount(acc, num, name, cnic, address, phone, date, 500, balance);

				        	
				    }
				    input.close();
					return account;

				    
				   }
				
				
				///Function # 12: Update account details SA Major class
				public static void doUpdateAccountInfoSA(BankAccount accounts [], int count, Scanner keyboard) throws FileNotFoundException, IOException
				{
					
						System.out.println("	Updating Savings Account !!!");
						System.out.println("");
						
						int index = updateDetailsAccountInfoSA(accounts);
						
						if(index<0)
						{
							System.out.println("	No accounts Exist");
						}
						
						else 
						{
							System.out.println("");
						}
					
				}
				
				// Function # 13: Update account details SA minor class
				
				public static int updateDetailsAccountInfoSA(BankAccount accounts []) throws IOException, FileNotFoundException 
				{
					FileWriter writer = new FileWriter(f7);
					
					BufferedWriter br = new BufferedWriter(writer);
					PrintWriter pr = new PrintWriter(br);
					
						
					
						for(int i =0; i<accounts.length;i++)
						{
							
							 if(accounts[i]==null)
							{
								
								
							}
							 
							else if(accounts[i]!=null)
							{	
								if(accounts[i] instanceof SavingsAccount)
								{		
									pr.println(accounts[i].getAccountType());
									pr.println(accounts[i].getAccountNumber());
									pr.println(accounts[i].customer.getName());
									pr.println(accounts[i].customer.getCNIC());
									pr.println(accounts[i].customer.getAddress());
									pr.println(accounts[i].customer.getNumber());
									pr.println(accounts[i].customer.getDate());
									pr.println(accounts[i].getBalance());
							
								}
							} 
						}
						br.close();
						pr.close();
						writer.close();
						System.out.println(" Information Updated !!!");
						return 0;
					}
				
				
						
					
		}
				



