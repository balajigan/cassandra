package com.batria;


import com.datastax.driver.core.Session;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import com.google.gson.Gson;
import com.batria.Connection;
import org.json.JSONObject;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import com.batria.PopulateData;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	Connection conn = null;
	Session session = null;
	int numberOfRowsPerThread = 200000;
	int numberOfThreads = 3;
      try{
        conn = new Connection();
	session = conn.getSession();

	for(int threadCount = 0; threadCount < numberOfThreads; threadCount++)
	{
		String threadName = "Thread"+Integer.toString(threadCount);
		Thread thread1 = new Thread(new PopulateData(numberOfRowsPerThread*threadCount ,5), threadName);
		thread1.start();
	}

//	JSONObject jsonObj = new JSONObject();
//        jsonObj.put("ordr_id","1234");
//	jsonObj.put("mrkt", "test_marker$$$$$$$$$$$$$$$$$$$$$$");
//	session.execute("INSERT INTO test.orders JSON " +  "'" + jsonObj.toString() + "'");
//	ResultSet rs = session.execute("SELECT JSON * FROM test.orders");
//	Row row = rs.one();
//	String jsonString = row.getString(0);

//	System.out.println(jsonString);
	System.out.println("Exit from main");
       }
      catch(Exception ex)
      {
	      System.out.println("Exception !!!");
	      ex.printStackTrace();
      }
      finally
      {
	      conn.close();
      }
    }
}
