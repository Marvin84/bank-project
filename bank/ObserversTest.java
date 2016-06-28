package unifi.ingsw.bank;

public class ObserversTest {

	private Account anAccount;

	public ObserversTest(Account anAccount) {
		this.setAnAccount(anAccount);
	}

	public Account getAnAccount() {
		return anAccount;
	}

	public void setAnAccount(Account anAccount) {
		this.anAccount = anAccount;
	}

	public void test(int amount) {

		try {

			System.out.println("The next observers test is in execution.");
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			System.out.println("An error occurs...");
			e1.printStackTrace();
		}
		System.out.println(anAccount.identity.getName() + " " + anAccount.identity.getSurname() + " " + "is trying to take " + amount);
		try {
			System.out.println("Please wait!");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("An error occurs...");
			e.printStackTrace();
		}
		anAccount.checkDecrement(amount);
		anAccount.setState(anAccount.isNegative, anAccount.isOver);
		if (anAccount.checkObservers()) {

			anAccount.decrement(amount);
			System.out.println("The new balance is " + anAccount.getBalance());
		}

		else {
			System.out.println("this operation can't be done!");

		}

	}

}
