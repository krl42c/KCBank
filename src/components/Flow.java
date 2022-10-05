package components;

import java.util.Date;

public abstract class Flow {
	
	private String comment;
	private int id;
	private double amount;
	private int target_account_no;
	private boolean effect;
	private Date flow_date;
	
	public Flow(String comment, int id, double amount, int target_account_no, boolean effect, Date flow_date) {
		super();
		this.comment = comment;
		this.id = id;
		this.amount = amount;
		this.target_account_no = target_account_no;
		this.effect = effect;
		this.flow_date = flow_date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTarget_account_no() {
		return target_account_no;
	}

	public void setTarget_account_no(int target_account_no) {
		this.target_account_no = target_account_no;
	}

	public boolean isEffect() {
		return effect;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	public Date getFlow_date() {
		return flow_date;
	}

	public void setFlow_date(Date flow_date) {
		this.flow_date = flow_date;
	}
	
	
}
