package model.entities;

import model.exceptions.domainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		super();
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit (Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {
		if(amount > balance) {
			throw new domainException("Saldo insuficiente.");
		}
		
		if(amount < 5.0) {
			throw new domainException("Valor mínimo permitido: R$5.00");
		}
		
		if (amount < withdrawLimit) {
		balance -= amount;
		}
		else {
			throw new domainException ("Limite de saque excedido");
		}
	}
	
}
