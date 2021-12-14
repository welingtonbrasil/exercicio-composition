package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem o: orderItem) {
			sum += o.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\n");
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append(client);
		sb.append("\n\nOrder items:\n");
		for(OrderItem o: orderItem) {			
			sb.append(o+"\n");
		}
		sb.append("\nTotal price: $");
		sb.append(String.format("%.2f",total()));
		return sb.toString();
	}
}
