package components;

// 1.1.1 Creation of the client class
public class Client {
	
	private String name;
	private String last_name;
	private static int count = 0; 
	private int client_number;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getClient_number() {
		return client_number;
	}

	public void setClient_number(int client_number) {
		this.client_number = client_number;
	}

	
	public Client(String name, String last_name ) {
		this.name = name;
		this.last_name = last_name;
		this.client_number = ++count;
	}
	
	@Override
	public String toString() {
		return client_number + " " + this.name + " " + this.last_name;
	}
	
}
