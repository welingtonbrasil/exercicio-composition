package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");;
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.nextLine());
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int qtdOrder = sc.nextInt();
		
		Calendar cal = Calendar.getInstance();
		Date dataAtual = Date.from(Instant.now());
		dataAtual = cal.getTime();
		//System.out.println(dataAtual);
		
		Order order = new Order(dataAtual,OrderStatus.valueOf(status),new Client(name,email,date));
		
		for (int i = 1; i <= qtdOrder; i++) {
			System.out.println("Enter #"+ i +" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
		}
		
		System.out.println(order);
		
		
		
		sc.close();

	}

}
