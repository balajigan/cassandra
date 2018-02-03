package com.batria;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.log4j.Logger;

import com.datastax.driver.core.ConsistencyLevel; 
import com.datastax.driver.core.QueryOptions; 


public class Connection
{
        private static Logger logger = Logger.getLogger("Connection");	
	public static Cluster cluster;
	public static Session session;
	private String ipAddress = "10.1.1.16";
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
			//cluster = Cluster.builder().addContactPoint(ipAddress).withPort(9042).build();
			QueryOptions qo = new QueryOptions();
			qo.setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM);
			cluster= Cluster.builder().addContactPoint(ipAddress).withPort(9042).withQueryOptions(qo).build();

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
