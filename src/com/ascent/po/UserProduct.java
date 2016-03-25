package com.ascent.po;

/**
 * UserProduct entity. @author MyEclipse Persistence Tools
 */

public class UserProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer usrid;
	private Integer productid;

	// Constructors

	/** default constructor */
	public UserProduct() {
	}

	/** full constructor */
	public UserProduct(Integer usrid, Integer productid) {
		this.usrid = usrid;
		this.productid = productid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsrid() {
		return this.usrid;
	}

	public void setUsrid(Integer usrid) {
		this.usrid = usrid;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

}