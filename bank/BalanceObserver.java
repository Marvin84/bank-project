package unifi.ingsw.bank;

public class BalanceObserver extends AbstractObserver {

	public BalanceObserver(Account anAccount) {

		subject = anAccount;
		name = "Balance Observer";
		isOk = true;
		subject.attach(this);

	}

	public void update() {
		if (subject.isNegative()) {
			isOk = false;
			//System.out.println("negative balance!");
		}

		else {
			isOk = true;
		}

	}

}
