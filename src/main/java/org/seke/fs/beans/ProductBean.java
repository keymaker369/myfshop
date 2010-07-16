package org.seke.fs.beans;

import org.seke.fs.Product;

/**
 * Created by IntelliJ IDEA. User: user Date: Jul 14, 2010 Time: 4:27:04 PM To
 * change this template use File | Settings | File Templates.
 */
public class ProductBean implements Product {

	private int id;
	private String title;
	private int amountInStock;
	private double price;

	public ProductBean() {
	}

	public ProductBean(int id, String title, int amountInStock, double price) {
		this.id = id;
		this.title = title;
		this.amountInStock = amountInStock;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmountInStock() {
		return amountInStock;
	}

	public void setAmountInStock(int amountInStock) {
		this.amountInStock = amountInStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
