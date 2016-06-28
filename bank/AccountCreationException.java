package unifi.ingsw.bank;

public class AccountCreationException extends Exception {


	private static final long serialVersionUID = 1L;

		public AccountCreationException() {
			super("You didn't create any account");
		}
	}