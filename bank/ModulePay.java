package unifi.ingsw.bank;

public class ModulePay implements PaymentStrategy {


	public boolean evaluate(Account account, int amount) {

		System.out.println("this is a module payment for an amount of :" + amount);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			System.out.println("An error occured!");
			return false;
		}

		account.checkDecrement(amount);
		account.setState(account.isNegative, account.isOver);
		if (account.checkObservers()) {
			account.decrement(amount);
			return true;
		}

		else {
			System.out.println("The operation can't be completed.");
			return false;
		}

	}


}
