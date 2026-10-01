package org.techbiltz;

public class Transaction {
	private int txId ; 
	private String txDate;
	private float txAmount;
	private boolean txStatus;
	private boolean txArrears;
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public float getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(float txAmount) {
		this.txAmount = txAmount;
	}
	public boolean isTxStatus() {
		return txStatus;
	}
	public void setTxStatus(boolean txStatus) {
		this.txStatus = txStatus;
	}
	public boolean isTxArrears() {
		return txArrears;
	}
	public void setTxArrears(boolean txArrears) {
		this.txArrears = txArrears;
	}
	public Transaction(int txId, String txDate, float txAmount, boolean txStatus, boolean txArrears) {
		
		this.txId = txId;
		this.txDate = txDate;
		this.txAmount = txAmount;
		this.txStatus = txStatus;
		this.txArrears = txArrears;
	}
	@Override
	public String toString() {
		return "Transaction [txId=" + txId + ", txDate=" + txDate + ", txAmount=" + txAmount + ", txStatus=" + txStatus
				+ ", txArrears=" + txArrears + "]";
	}
	
	

}
