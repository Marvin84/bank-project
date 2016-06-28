package unifi.ingsw.bank;
import java.util.List;

public class GeneralAccount extends Account {

	private int cost;


	public GeneralAccount(List<AbstractObserver> observers,
			IdentityRegistry identity, int balance, boolean isNegative,
			boolean isOver, int cost) {
		super(observers, identity, balance, isNegative, isOver);
		this.cost = cost;
	}

	public void setState(boolean isBalanceNegative, boolean isAmountOver) {
		isNegative = isBalanceNegative;
		isOver = isAmountOver;
		notifyObservers();

	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void checkDecrement(int amount){
		if (balance < -50){
			isNegative = true;			
		}
		if(amount >750){
			isOver = true;
		}
	}

}
