
/* Name: Khursheed Alam Khan		Assignment 3: File Handling: Account Management System
 * Roll# 20i-0496
 * Section: SE-Q
 */
import java.io.*;
public class Customers implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// name
	protected String name;
	
	// address
	protected String address;
	
	// phone number
	protected String number;
	
	// creation date
	protected String date;
	
	// withdrawal date
	protected String withdrawl_Date;
	
	// deposit date
	protected String deposit_Date;
		
	// Zakat deduction date
	protected String zakat_Date;
	
	// Transfer Amount date
	protected String transfer_Date;
	
	// CNIC
	protected int cnic;
	
	// default constructor
	public Customers()
	{
		
	}
	
	public Customers(String name, String address, String number, String date, int cnic)
	{
		this.name=name;
		this.address=address;
		this.number=number;
		this.date = date;
		this.cnic=cnic;
	}
	
	//getters
	
	
	public String getName()
	{
		return this.name;
		
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public String getNumber()
	{
		return this.number;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public String getWithdrawlDate()
	{
		return this.withdrawl_Date;
	}
	
	public String getDepositDate()
	{
		return this.deposit_Date;
	}
	
	public String getZakatDate()
	{
		return this.zakat_Date;
	}
	
	public String getTransferDate()
	{
		return this.transfer_Date;
	}
	
	public int getCNIC()
	{
		return this.cnic;
	}
	//setters
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	
	public void setNumber(String number)
	{
		this.number=number;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setWithdrawlDate(String withdrawl_Date)
	{
		this.withdrawl_Date=withdrawl_Date;
	}
	
	public void setDepositDate(String deposit_Date)
	{
		this.deposit_Date=deposit_Date;
	}
	
	public void setZakatDate(String zakat_Date)
	{
		this.zakat_Date = zakat_Date;
	}
	
	public void setTransferDate(String transfer_Date)
	{
		this.transfer_Date = transfer_Date;
	}
	
	public void setCNIC(int cnic)
	{
		this.cnic=cnic;
	}
}
