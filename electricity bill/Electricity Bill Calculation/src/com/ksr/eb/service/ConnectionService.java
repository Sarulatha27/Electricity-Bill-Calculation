package com.ksr.eb.service;
import com.ksr.eb.entity.Commercial;
import com.ksr.eb.entity.Domestic;
import com.ksr.eb.exception.InvalidConnectionException;
import com.ksr.eb.exception.InvalidReadingException;
public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		if(currentReading<previousReading || previousReading<0)
		{
			throw new InvalidReadingException();
		}
		if(type.equals("Domestic") || type.equals("Commercial"))
		{ }
		else
		{
			throw new InvalidConnectionException();
		}
		return true;
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		boolean b=true;
		float bill=0;
		try { 
			b=validate(currentReading,previousReading,type);
			if(b==true)
			{
				if(type.equals("Domestic"))
				{
					float []slabs=new float[3];
					slabs[0]=2.3f;
					slabs[1]=4.2f;
					slabs[2]=5.5f;
					Domestic d= new Domestic(currentReading,previousReading,slabs);
					bill =d.computeBill();
				}
				else if(type.equals("Commercial"))
				{
					float []slabs=new float[3];
					slabs[0]=5.2f;
					slabs[1]=6.8f;
					slabs[2]=8.3f;
					Commercial d= new Commercial(currentReading,previousReading,slabs);
					bill =d.computeBill();
				}
					
			}
		}
		catch(InvalidReadingException e) {
			return -1;
		}
		catch(InvalidConnectionException e) {
			return -2;
		}
		return bill;
	}
	public String generateBill(int currentReading, int previousReading, String type)
	{
		String result="";
		float bill=calculateBillAmt(currentReading,previousReading,type);
		if(bill==-1)
		{
			result="Incorrect Reading";
		}
		else if(bill==-2)
		{
			result="Invalid ConnectionType";
		}
		else
		{
			result="Amount to be paid:"+bill;
		}
		return result;
	}
}
