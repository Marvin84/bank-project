package unifi.ingsw.bank;

public interface PaymentStrategy {
	
	public boolean evaluate (Account account, int amount);

}
