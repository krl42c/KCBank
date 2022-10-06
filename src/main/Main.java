package main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import components.Account;
import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfert;

public class Main {
	public static void main(String args[]) {
		var list = createTable(6);
		displayTable(list);
		
		var account_list = loadAccounts(list);
		displayAccounts(account_list);
		
		var htable = createHashTable(account_list);
		displayHashTable(htable);
		
		updateAccountFlows(htable, loadFlow(htable));
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
		Stream.of(list).forEach(System.out::println);
	}

	// 1.2.3 Creation of the tablea account
	public static List<Account> loadAccounts(List<Client> client_list) {
		var account_list = new ArrayList<Account>();
		for(Client client : client_list) {
			// Using the same label as this is just for testing 
			var current_account = new CurrentAccount("CurrentAccount", client);
			//current_account.setBalance(new Flow("Comment",1,0, current_account.getAccount_no(),false, new Date()));
			
			var savings_account = new SavingsAccount("SavingsAccount", client);
			//savings_account.setBalance(0);
			
			account_list.add(current_account);
			account_list.add(savings_account);
		}
		return account_list;
	}

	// 1.2.3 Creation of the tablea account
	public static void displayAccounts(List<Account> account_list) {
		Stream.of(account_list).forEach(System.out::println);
	}
	
	// 1.3.1 Adaptation of the table of accounts
	public static Hashtable<Integer, Account> createHashTable(List<Account> account_list) {
		var htable = new Hashtable<Integer,Account>();
		for(Account account : account_list) {
			htable.put(account.getAccount_no(), account);
		}
		return htable;
	}
	
	// 1.3.1 Adaptation of the table of accounts
	public static void displayHashTable(Hashtable<Integer, Account> htable) {
		List<Account> list = htable.values().stream().sorted(Comparator.comparingDouble(Account::getBalance)).collect(Collectors.toList());
		Stream.of(list).forEach(System.out::println);
	}
	
	// 1.3.4 Creation of the flow array
	public static List<Flow> loadFlow(Hashtable<Integer, Account> htable) {
		var flow_list = new ArrayList<Flow>();
		
		// Get current date + 2 days
		Date date = new Date();
        LocalDateTime local_date = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        local_date.plusDays(2);
        Date final_date = Date.from(local_date.atZone(ZoneId.systemDefault()).toInstant());

        // Debit on account number 1
		var flow1 = new Debit("No", 0, 50.0, htable.get(1).getAccount_no() , false, final_date);
		flow_list.add(flow1);
		
		// Credit on all accounts
		// Retrieve list of accounts from the HashMap
		Collection<Account> account_col =  htable.values();
		List<Account> account_list = new ArrayList(account_col);
		
		for(Account account : account_list) {
			if(account instanceof SavingsAccount)
				flow_list.add(new Credit("No", 0, 100.50, account.getAccount_no(), false, final_date));
			else
				flow_list.add(new Credit("No", 0, 1500.0, account.getAccount_no(), false, final_date));
		}
		
		var transfert = new Transfert("no", 0, 50.0, htable.get(1).getAccount_no(), false, final_date, htable.get(2).getAccount_no());
		flow_list.add(transfert);
		return flow_list;
	}
	
	// 1.3.5 Updating accounts
	public static void updateAccountFlows(Hashtable<Integer,Account> hmap, List<Flow> flow_list) {
		// Update accounts
		flow_list.forEach(f -> {
			hmap.get(f.getTarget_account_no()).setBalance(f);
		});
		
		// List of accounts with negative Flows
		List<Account> negative_accounts = hmap.values()
				.stream()
				.filter(acc -> acc.getBalance() < 0)
				.collect(Collectors.toList());
		
		negative_accounts.stream().forEach((acc) -> {
			System.out.println("Account with id " + acc.getAccount_no() + " has negative balance " + acc.getBalance());
		});
	}
}