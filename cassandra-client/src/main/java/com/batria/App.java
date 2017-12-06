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
//	{"ordr_id": "1234", "mrkt": "MX", "mtrl": [{"MTRL_ID": "6565", "MTRL_ORDR_QTY": "2", "ORDR_MTRL_UOM_CDV": "each"}, {"MTRL_ID": "6565", "MTRL_ORDR_QTY": "45", "ORDR_MTRL_UOM_CDV": "case"}], "ordr_dc": "DC1", "ordr_dt": "2017-12-05T08:12:13", "ordr_src": "MC1", "ordr_sts": "CRTD", "sold_to_cust_id": "2324"}

	JSONObject jsonObj = new JSONObject();
        jsonObj.put("ordr_id","1234");
	jsonObj.put("mrkt", "test_marker$$$$$$$$$$$$$$$$$$$$$$");
	session.execute("INSERT INTO test.orders JSON " +  "'" + jsonObj.toString() + "'");
	ResultSet rs = session.execute("SELECT JSON * FROM test.orders");
	Row row = rs.one();
	String jsonString = row.getString(0);

	System.out.println(jsonString);
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
