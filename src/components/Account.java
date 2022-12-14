package components;

// 1.2.1 Creation of the account class
public abstract class Account {
	
	protected String label;
	protected double balance;
	protected int account_no;
	
	private static int count = 0;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(Flow flow) {
		if(flow instanceof Credit) {
			balance += flow.getAmount();
		}
		
		if(flow instanceof Debit) {
			balance -= flow.getAmount();
		}
		
		if(flow instanceof Transfert) {
			if(this.account_no == flow.getTarget_account_no()) {
				balance += flow.getAmount();
			}
			
			if(this.account_no == ((Transfert)flow).getAccount_no()) {
				balance -= flow.getAmount();
			}
		}
		this.balance = flow.getAmount();
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	protected Client client;
	
	Account(String label, Client client) {
		this.label = label;
		this.client = client;
		this.account_no = ++count;
	}
	
	@Override
	public String toString() {
		return this.label + " " + this.client.toString() + " " + this.account_no;
	}
}
