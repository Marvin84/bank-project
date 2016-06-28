package unifi.ingsw.bank;

public class LimitObserver extends AbstractObserver {

	public LimitObserver(Account anAccount) {

		subject = anAccount;
		name = "Limit Observer";
		isOk = true;
		subject.attach(this);

	}

	public void update() {
		if (subject.isOver()) {
			isOk = false;
			subject.isOver = false;
			//System.out.println("you tried to take more than possible amount");
		}

		else {
			isOk = true;
		}
	}

}
