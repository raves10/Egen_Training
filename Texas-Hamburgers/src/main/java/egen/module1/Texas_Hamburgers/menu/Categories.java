package egen.module1.Texas_Hamburgers.menu;

public abstract class Categories implements Menu{

	public String itemName;
	public String itemPrice;
	public boolean isCombo = false;
	public String comboPrice = "0.0";
	public final String COMBO_PRICE_TAG = "Combo Price $";
	public final String PRICE_TAG = "Price $";
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public boolean isCombo() {
		return isCombo;
	}
	public void setCombo(boolean isCombo) {
		this.isCombo = isCombo;
	}
	public String getComboPrice() {
		return comboPrice;
	}
	public void setComboPrice(String comboPrice) {
		this.comboPrice = comboPrice;
	}

	public abstract void showAlacarteMenu();
	public abstract void showComboMenu();
	
}
