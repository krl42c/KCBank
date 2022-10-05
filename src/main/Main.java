package main;

import java.util.ArrayList;
import java.util.List;

import components.Account;
import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;

public class Main {
	public static void main(String args[]) {
		var list = createTable(6);
		//displayTable(list);
		
		var account_list = loadAccounts(list);
		displayAccounts(account_list);
		
	}
	
	// 1.1.2 Creation of main class for tests
	public static List<Client> createTable(int total) {
		var client_list = new ArrayList<Client>();
		
		String name = "name";
		String last_name = "lastname";
		
		for(int i = 0; i < total; i++) {
			client_list.add(new Client(name+i,last_name+i));
		}
		
		return client_list;
	}
	
	// 1.1.2 Creation of main class for tests
	public static void displayTable(List<Client> list) {
		for(var elem : list) {
			System.out.println(elem.toString());
		}
	}

	// 1.2.3 Creation of the tablea account
	public static List<Account> loadAccounts(List<Client> client_list) {
		var account_list = new ArrayList<Account>();
		
		for(Client client : client_list) {
			// Using the same label as this is just for testing 
			var current_account = new CurrentAccount("CurrentAccount", client);
			current_account.setBalance(0);
			
			var savings_account = new SavingsAccount("SavingsAccount", client);
			savings_account.setBalance(0);
			
			account_list.add(current_account);
			account_list.add(savings_account);
		}
		return account_list;
	}

	// 1.2.3 Creation of the tablea account
	public static void displayAccounts(List<Account> account_list) {
		for(Account account : account_list) {
			System.out.println(account.toString());
		}
	}
}