package main;

import java.util.ArrayList;
import java.util.List;

import components.Client;

// 1.1.2 Creation of main class for tests
public class Main {
	public static void main(String args[]) {
		var list = createTable(6);
		displayTable(list);
	}
	
	public static List<Client> createTable(int total) {
		var client_list = new ArrayList<Client>();
		
		String name = "name";
		String last_name = "lastname";
		
		for(int i = 0; i < total; i++) {
			client_list.add(new Client(name+i,last_name+i));
		}
		
		return client_list;
	}
	
	public static void displayTable(List<Client> list) {
		for(var elem : list) {
			System.out.println(elem.toString());
		}
	}
}