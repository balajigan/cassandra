
package com.batria;

import java.lang.Runnable;
import java.lang.Thread;
import java.lang.Exception;

public class PopulateData implements Runnable
{
	int initialValue=0;
	int count=0;
	public PopulateData()
	{

	}
	public PopulateData(int initialValue, int count)
	{
		this.initialValue = initialValue;
		this.count = count;
	}

	public void run()
	{	
		for(int loopCount = 0; loopCount < count ; loopCount++)
		{
			initialValue = initialValue+1;
			System.out.println("Current Value = " + initialValue);
			try
			{
				//Thread.sleep(1000);	
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}

		}
	}
}
