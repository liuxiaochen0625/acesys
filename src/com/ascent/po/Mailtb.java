package com.ascent.po;

/**
 * Mailtb entity. @author MyEclipse Persistence Tools
 */

public class Mailtb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String fromaddress;
	private String frompassword;
	private String toaddress;

	// Constructors

	/** default constructor */
	public Mailtb() {
	}

	/** full constructor */
	public Mailtb(String fromaddress, String frompassword, String toaddress) {
		this.fromaddress = fromaddress;
		this.frompassword = frompassword;
		this.toaddress = toaddress;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromaddress() {
		return this.fromaddress;
	}

	public void setFromaddress(String fromaddress) {
		this.fromaddress = fromaddress;
	}

	public String getFrompassword() {
		return this.frompassword;
	}

	public void setFrompassword(String frompassword) {
		this.frompassword = frompassword;
	}

	public String getToaddress() {
		return this.toaddress;
	}

	public void setToaddress(String toaddress) {
		this.toaddress = toaddress;
	}

}