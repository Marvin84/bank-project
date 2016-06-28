package unifi.ingsw.bank;

public class PaymentTest {

	private Account account;

	public PaymentTest(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	public void test(int amount){
		
		try {
			System.out.println("The next payment test is in execution.");
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			System.out.println("An error occurs...");
			e1.printStackTrace();
		}
		System.out.println(account.identity.getName() + " " + account.identity.getSurname() + " " + "is filling out a payment form");
		try {
			System.out.println("Please wait!");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("An error occurs...");
			e.printStackTrace();
		}
		 
		account.pay(amount);
		System.out.println("The new balance is " + account.getBalance());
		
	}

}
