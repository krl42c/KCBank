package components;

import java.util.Date;

public class Credit extends Flow {

	public Credit(String comment, int id, double amount, int target_account_no, boolean effect, Date flow_date) {
		super(comment, id, amount, target_account_no, effect, flow_date);
	}
	
}
