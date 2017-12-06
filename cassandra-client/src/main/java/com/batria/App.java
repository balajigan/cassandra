package com.batria;


import com.datastax.driver.core.Session;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import com.google.gson.Gson;
import com.batria.Connection;
import org.json.JSONObject;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
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
      try{
        conn = new Connection();
	session = conn.getSession();

//	JSONObject jsonObj = new JSONObject();

	ResultSet rs = session.execute("SELECT JSON * FROM test.orders");
	Row row = rs.one();
	String jsonString = row.getString(0);

	System.out.println(jsonString);
       }
      catch(Exception ex)
      {
	      System.out.println("Exception !!!");
      }
      finally
      {
	      conn.close();
      }
    }
}
