package com.ksr.eb.entity;

public class Domestic extends Connection{

	public Domestic(int currentReading,int previousReading,float[] slabs) {
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		int units=previousReading-currentReading;
		float bill=0;
		if(units<=50)
		{
			bill=units*slabs[0];
		}
		else if(units>50 && units<=100)
		{
			bill=50*slabs[0] + (units-50)*slabs[1];
		}
		else
		{
			bill=50*slabs[0] + 50*slabs[1] + (units-100)*slabs[2];
		}
		return bill;
	}
	
}
