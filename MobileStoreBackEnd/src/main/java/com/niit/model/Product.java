package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table
public class Product {
	@Id
	@GeneratedValue
public int productId;
public String productName;
@ManyToOne
private Category category;
public int productCost;
public int productStock;
public String productDesc;
@Transient
private MultipartFile img;


public MultipartFile getImg() {
	return img;
}
public void setImg(MultipartFile img) {
	this.img = img;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public int getProductCost() {
	return productCost;
}
public void setProductCost(int productCost) {
	this.productCost = productCost;
}
public int getProductStock() {
	return productStock;
}
public void setProductStock(int productStock) {
	this.productStock = productStock;
}
public String getProductDesc() {
	return productDesc;
}
public void setProductDesc(String productDesc) {
	this.productDesc = productDesc;
}

}
