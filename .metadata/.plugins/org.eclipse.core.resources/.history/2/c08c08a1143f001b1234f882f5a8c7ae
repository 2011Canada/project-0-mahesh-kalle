package com.revature.bank.models;

public class Account {

	private int accountId;
	
	private String tansactionType;
	
	private float amount;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTansactionType() {
		return tansactionType;
	}

	public void setTansactionType(String tansactionType) {
		this.tansactionType = tansactionType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", tansactionType=" + tansactionType + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((tansactionType == null) ? 0 : tansactionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (tansactionType == null) {
			if (other.tansactionType != null)
				return false;
		} else if (!tansactionType.equals(other.tansactionType))
			return false;
		return true;
	}
	
}
