package com.batria;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.log4j.Logger;

public class Connection
{
        private static Logger logger = Logger.getLogger("Connection");	
	public static Cluster cluster;
	public static Session session;
	private String ipAddress = "127.0.0.1";
	public Connection()
	{
	}
	public Connection(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}
	public Session getSession()
	{
		if(session == null)
		{
			try
			{
			cluster = Cluster.builder().addContactPoint(ipAddress).withPort(9042).build();
			session = cluster.connect();
			//System.out.println("getSession method is called");
			logger.info("getSession method is called");
			}
			catch(Exception ex)
			{
				logger.error("Issues in opening connection with Cassandra");
				ex.printStackTrace();
			}
		}									
		return session;
	}
	public void close()
	{
		cluster.close();
		logger.info("cluster is closed");
	}
}
