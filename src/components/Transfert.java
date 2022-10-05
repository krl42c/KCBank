package components;

import java.util.Date;

public class Transfert extends Flow {
	
	private int account_no;
	
	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public Transfert(String comment, int id, double amount, int target_account_no, boolean effect, Date flow_date, int account_no) {
		super(comment, id, amount, target_account_no, effect, flow_date);
		this.account_no = account_no;
	}

}
