package com.ascent.po;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private String productnumber;
	private String productname;
	private String categoryno;
	private String category;
	private String imagepath;
	private String isnewproduct;
	private float price1;
	private float price2;
	private String realstock;
	private String stock;
	private String cas;
	private String mdlint;
	private String formula;
	private String weight;
	private String delsoft;
	private String note;
	private String quantity;
	
	// Constructors

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String productnumber, String productname, String categoryno,
			String category, String imagepath, String isnewproduct,
			float price1, float price2, String realstock, String stock,
			String cas, String mdlint, String formula, String weight,
			String delsoft, String note) {
		this.productnumber = productnumber;
		this.productname = productname;
		this.categoryno = categoryno;
		this.category = category;
		this.imagepath = imagepath;
		this.isnewproduct = isnewproduct;
		this.price1 = price1;
		this.price2 = price2;
		this.realstock = realstock;
		this.stock = stock;
		this.cas = cas;
		this.mdlint = mdlint;
		this.formula = formula;
		this.weight = weight;
		this.delsoft = delsoft;
		this.note = note;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductnumber() {
		return this.productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCategoryno() {
		return this.categoryno;
	}

	public void setCategoryno(String categoryno) {
		this.categoryno = categoryno;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getIsnewproduct() {
		return this.isnewproduct;
	}

	public void setIsnewproduct(String isnewproduct) {
		this.isnewproduct = isnewproduct;
	}

	public float getPrice1() {
		return this.price1;
	}

	public void setPrice1(float price1) {
		this.price1 = price1;
	}

	public float getPrice2() {
		return this.price2;
	}

	public void setPrice2(float price2) {
		this.price2 = price2;
	}

	public String getRealstock() {
		return this.realstock;
	}

	public void setRealstock(String realstock) {
		this.realstock = realstock;
	}

	public String getStock() {
		return this.stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getCas() {
		return this.cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public String getMdlint() {
		return this.mdlint;
	}

	public void setMdlint(String mdlint) {
		this.mdlint = mdlint;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDelsoft() {
		return this.delsoft;
	}

	public void setDelsoft(String delsoft) {
		this.delsoft = delsoft;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}