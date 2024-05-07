package com.ksr.eb.entity;
public class Commercial extends Connection{
	public Commercial(int currentReading,int previousReading,float[] slabs) {
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		float BillAmount=0;
		float bill=0;
		float ElectricityDuty=0;
		int units=previousReading-currentReading;
		if(units<=50)
		{
			BillAmount=units*slabs[0];
		}
		else if(units>50 && units<=100)
		{
			BillAmount=50*slabs[0] + (units-50)*slabs[1];
		}
		else
		{
			BillAmount=50*slabs[0] + 50*slabs[1] + (units-100)*slabs[2];
		}
		//
		if(BillAmount<5000)
			{
			ElectricityDuty=(float)(BillAmount* 0.02);
		    bill=BillAmount + ElectricityDuty;
			}
		else if(BillAmount>=5000)
		   {
			ElectricityDuty=(float)(BillAmount* 0.06);
		    bill=BillAmount + ElectricityDuty;
			}
		else
		    {
			ElectricityDuty=(float)(BillAmount* 0.09);
		    bill=BillAmount + ElectricityDuty;
			}
		return bill;
	}
}