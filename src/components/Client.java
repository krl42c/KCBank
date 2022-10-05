package components;

// 1.1.1 Creation of the client class
public class Client {
	
	private String name;
	private String last_name;
	private static int client_number = 0; 
	
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

	public static int getClient_number() {
		return client_number;
	}

	public static void setClient_number(int client_number) {
		Client.client_number = client_number;
	}

	
	public Client(String name, String last_name ) {
		this.name = name;
		this.last_name = last_name;
		Client.client_number++;
	}
	
	@Override
	public String toString() {
		return Client.client_number + " " + this.name + " " + this.last_name;
	}
	
}
