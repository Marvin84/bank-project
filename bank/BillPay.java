package unifi.ingsw.bank;

public class BillPay implements PaymentStrategy {


	public boolean evaluate(Account account, int amount) {
		
		int cost = 10;
		System.out.println("this is a bill payment for an amount of :" + amount + ", and it has a cost of: " + cost);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			System.out.println("An error occured!");
			return false;
		}

		account.checkDecrement(amount);
		account.setState(account.isNegative, account.isOver);
		if (account.checkObservers()) {
			account.decrement(amount + cost);
			return true;
		}

		else {

			System.out.println("The operation can't be completed.");
			return false;
		}

	}


}
