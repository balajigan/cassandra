
package com.batria;

import java.lang.Runnable;
import java.lang.Thread;
import java.lang.Exception;
import com.batria.Connection;
import com.datastax.driver.core.Session;

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
		try{
		Thread.sleep(10000);
		}
		catch(Exception ex)
		{
		}
		Connection conn = new Connection();
		Session session = conn.getSession();
		
		for(int loopCount = 0; loopCount < count ; loopCount++)
		{
			initialValue = initialValue+1;
			System.out.println("Current Value = " + initialValue);
			try
			{
				//Thread.sleep(1000);
				GenerateOrder generateOrder = new GenerateOrder();
				String jsonOrderString = generateOrder.getOrderJsonString(initialValue);
				session.execute("INSERT INTO test.orders json " + "'"+jsonOrderString + "'");
				System.out.println(jsonOrderString);	
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}

		}
	}
}
