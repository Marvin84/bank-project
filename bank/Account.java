package unifi.ingsw.bank;

import java.util.List;

public abstract class Account {

	private List<AbstractObserver> observers;
	protected IdentityRegistry identity;
	protected PaymentStrategy method;
	protected int balance;
	protected boolean isNegative;
	protected boolean isOver;

	public Account(List<AbstractObserver> observers, IdentityRegistry identity, int balance, boolean isNegative, boolean isOver) {
		this.observers = observers;
		this.identity = identity;
		this.balance = balance;
		this.isNegative = isNegative;
		this.isOver = isOver;

	}

	public abstract void checkDecrement(int amound);

	public abstract void setState(boolean isBalanceNegative, boolean isAmountOver);

	public IdentityRegistry getIdentity() {
		return identity;
	}

	public void setIdentity(IdentityRegistry identity) {
		this.identity = identity;
	}

	public int getBalance() {
		return balance;
	}

	public boolean isNegative() {
		return isNegative;
	}

	public boolean isOver() {
		return isOver;
	}

	public void attach(AbstractObserver ob) {
		observers.add(ob);
	}

	public void notifyObservers() {

		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
	}

	public boolean checkObservers() {
		for (int i = 0; i < observers.size(); i++) {
			if (!observers.get(i).isOk) {
				System.out.println(observers.get(i).name + " noticed a problem.");
				return false;
			}
		}
		return true;
	}

	public void increment(int amount) {
		balance += amount;
		if (balance >= 0) {
			isNegative = false;
		}
	}

	public void decrement(int amount) {

		try {
			System.out.println("Processing...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("An error occures");
			e.printStackTrace();
		}
		System.out.println("an amount of " + amount + "$ is being evaluated.");
		balance -= amount;

	}

	public void setPaymentMethod(PaymentStrategy aMethod) {
		method = aMethod;

	}

	public void pay(int amount) {
		method.evaluate(this, amount);
	}

}
