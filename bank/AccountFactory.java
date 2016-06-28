package unifi.ingsw.bank;

import java.util.ArrayList;
import java.util.List;

public class AccountFactory {

	public static Account create(AccountType accountType, IdentityRegistry identity) throws AccountCreationException {
		Account account = create(accountType, identity, new ArrayList<AbstractObserver>());
		if (account == null) {
			throw new AccountCreationException();
		} else {
			return account;
		}
	}

	public static Account create(AccountType accountType, IdentityRegistry identity, List<AbstractObserver> observers) {

		try {
			System.out.println("A new account is being created...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("An error occures.");
			e.printStackTrace();
		}

		switch (accountType) {

		case YOUNG:
			System.out.println("You created a young account.");
			return new YoungAccount(observers, identity, 0, false, false, 0);
		case GENERAL:
			System.out.println("You created a young account.");
			return new GeneralAccount(observers, identity, 0, false, false, 3);
		default:
			// this is the wrong case
			return null;
		}

	}
}
