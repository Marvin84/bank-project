package unifi.ingsw.bank;

public abstract class AbstractObserver {

	protected Account subject;
	protected String name;
	protected boolean isOk;

	public abstract void update();

}
