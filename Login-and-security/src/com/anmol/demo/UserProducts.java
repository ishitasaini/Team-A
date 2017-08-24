package com.anmol.demo;

public class UserProducts {
	String[] electronics={"mobile", "camera"};
	String[] appliances={"refrigerator", "microwave"};
	String[] clothing = {"shirts", "pants"};
	String[][] allProducts = {electronics, appliances, clothing};
	String[] userProducts = new String[6];
	public String[] getUserProducts() {
		return userProducts;
	}
	public void setUserProducts(String[] userProducts) {
		this.userProducts = userProducts;
	}
	
}
