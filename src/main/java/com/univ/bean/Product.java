package com.univ.bean;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Product_Details")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String imgName;
	private String description;
	private String type,img_org;
	private int price,qty;
	
	@Column(name="image_path")
	@Transient
	private MultipartFile image;

	@Column(name="status",columnDefinition = "int default 0")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImg_org() {
		return img_org;
	}

	public void setImg_org(String img_org) {
		this.img_org = img_org;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", imgName=" + imgName + ", description=" + description + ", type=" + type
				+ ", img_org=" + img_org + ", price=" + price + ", qty=" + qty + ", image=" + image + ", status="
				+ status + "]";
	}

	public Product(int id, String imgName, String description, String type, String img_org, int price, int qty,
			MultipartFile image, String status) {
		super();
		this.id = id;
		this.imgName = imgName;
		this.description = description;
		this.type = type;
		this.img_org = img_org;
		this.price = price;
		this.qty = qty;
		this.image = image;
		this.status = status;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
		
		
}
