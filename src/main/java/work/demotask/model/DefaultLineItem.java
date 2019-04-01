package work.demotask.model;

public class DefaultLineItem implements LineItem {
	
	public DefaultLineItem(StoreItem storeItem, int quantity) {
		this.storeItem = storeItem;
		this.quantity = quantity;
	}

	private StoreItem storeItem;
	
	private int quantity;

	@Override
	public String getName() {
		return storeItem.getName();
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public double getTotal() {
		return storeItem.getPrice()*quantity;
	}

	@Override
	public void incrementQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	@Override
	public String toString() {
		return new StringBuilder(getName()).append(" : ").append(getQuantity()).toString();
	}
}
