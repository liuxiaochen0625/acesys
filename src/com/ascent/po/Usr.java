package com.ascent.po;
public class Usr implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String fullname;
	private String title;
	private String companyname;
	private String companyaddress;
	private String city;
	private String job;
	private String tel;
	private String email;
	private String country;
	private String zip;
	private String superuser;
	private String delsoft;
	private String note;

	// Constructors

	/** default constructor */
	public Usr() {
	}

	/** full constructor */
	public Usr(String username, String password, String fullname, String title,
			String companyname, String companyaddress, String city, String job,
			String tel, String email, String country, String zip,
			String superuser, String delsoft, String note) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.title = title;
		this.companyname = companyname;
		this.companyaddress = companyaddress;
		this.city = city;
		this.job = job;
		this.tel = tel;
		this.email = email;
		this.country = country;
		this.zip = zip;
		this.superuser = superuser;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyaddress() {
		return this.companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSuperuser() {
		return this.superuser;
	}

	public void setSuperuser(String superuser) {
		this.superuser = superuser;
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