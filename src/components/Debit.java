package components;

import java.util.Date;

public class Debit extends Flow {

	public Debit(String comment, int id, double amount, int target_account_no, boolean effect, Date flow_date) {
		super(comment, id, amount, target_account_no, effect, flow_date);
	}

}
