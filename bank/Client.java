package unifi.ingsw.bank;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static unifi.ingsw.bank.AccountType.*;

public class Client {

	public static void main(String[] args) throws AccountCreationException {

		IdentityRegistry ir1 = new IdentityRegistry("Tom", "Mitchell", 64);
		IdentityRegistry ir2 = new IdentityRegistry("Ada", "Lovelace", 22);

		//System.out.println("The case of wrong input for an account name:");
		//Account aGeneralNullAccount = AccountFactory.create(WRONG, ir1);
		System.out.println("Starting to create 2 accounts...");
		Account aGeneralAccount = AccountFactory.create(GENERAL, ir1);

		new BalanceObserver(aGeneralAccount);
		new LimitObserver(aGeneralAccount);
		// starts the limit test
		int amount = 800;
		ObserversTest ot1 = new ObserversTest(aGeneralAccount);
		ot1.test(amount);
		// starts a bill payment test
		aGeneralAccount.increment(amount);
		aGeneralAccount.setPaymentMethod(new BillPay());
		PaymentTest pt1 = new PaymentTest(aGeneralAccount);
		int paymentAmount = 100;
		pt1.test(paymentAmount);
		Account aYoungAccount = AccountFactory.create(YOUNG, ir2);
		new BalanceObserver(aYoungAccount);
		new LimitObserver(aYoungAccount);
		// starts the limit test
		amount = 600;
		ObserversTest ot2 = new ObserversTest(aYoungAccount);
		ot2.test(amount);
		ot2.test(10);
		// starts a module payment test
		aYoungAccount.increment(amount * 2);
		aYoungAccount.setPaymentMethod(new ModulePay());
		PaymentTest pt2 = new PaymentTest(aYoungAccount);
		paymentAmount = 100;
		pt2.test(paymentAmount);

	}
}
