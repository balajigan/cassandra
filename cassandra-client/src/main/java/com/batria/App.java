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

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = Logger.getLogger("App");

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

	PatternLayout layout = new PatternLayout();
	String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
	layout.setConversionPattern(conversionPattern);

	        // creates console appender
	ConsoleAppender consoleAppender = new ConsoleAppender();
	consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();
	
	FileAppender fileAppender = new FileAppender();
	fileAppender.setFile("client.log");
	fileAppender.setLayout(layout);
	fileAppender.activateOptions();

	Logger rootLogger = Logger.getRootLogger();
	rootLogger.setLevel(Level.INFO);
//	rootLogger.addAppender(consoleAppender);
	rootLogger.addAppender(fileAppender);
	logger.info("For testing the logger");

	Connection conn = null;
	Session session = null;
	int numberOfRowsPerThread = 2; //00000;
	int numberOfThreads = 1;
      try{
        conn = new Connection();
	session = conn.getSession();

	for(int threadCount = 0; threadCount < numberOfThreads; threadCount++)
	{
		String threadName = "Thread"+Integer.toString(threadCount);
		Thread thread1 = new Thread(new PopulateData(numberOfRowsPerThread*threadCount ,numberOfRowsPerThread), threadName);
		thread1.start();
	}

	System.out.println("Exit from main");
       }
      catch(Exception ex)
      {
	      System.out.println("Exception !!!");
	      ex.printStackTrace();
      }
      finally
      {
	    //  conn.close();
      }
    }
}
