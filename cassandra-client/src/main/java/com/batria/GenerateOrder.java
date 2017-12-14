
package com.batria;
import com.batria.Order;
import com.batria.Order_line_items;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenerateOrder
{
	public GenerateOrder()
	{
	}
	public String getOrderJsonString(int orderId)
	{
		Order order = new Order();
		List<Order_line_items> orderLineItems = new ArrayList<Order_line_items>();

		for(int lineItemCount =0; lineItemCount < 20; lineItemCount ++)
		{
			Order_line_items orderLineItem = new Order_line_items();
			orderLineItem.setOrder_unit("case");
			orderLineItem.setProduct_id("productId"+ Integer.toString(lineItemCount));
			orderLineItem.setOrder_qty(Integer.toString(10*lineItemCount));

			orderLineItems.add(orderLineItem);
		}
		order.setOrder_line_items(orderLineItems);
		order.setOrder_id(Integer.toString(orderId));
		order.setOrder_date("01-Jan-2017");
		order.setOrder_market("Market"+Integer.toString(orderId));
		order.setOrder_dc("OrderDc"+Integer.toString(orderId));
		order.setOrder_source("OrderSource"+Integer.toString(orderId));
		order.setOrder_taken_by("AgentId"+Integer.toString(orderId));
		order.setDelivery_notes("Delivery Note for order Id"+Integer.toString(orderId));

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try
		{
			jsonInString = mapper.writeValueAsString(order);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return jsonInString;
	}

}
