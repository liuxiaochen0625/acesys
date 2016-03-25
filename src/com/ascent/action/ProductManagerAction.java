package com.ascent.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.ascent.po.Product;
import com.ascent.po.Usr;
import com.ascent.util.AddExcelProduct;
import com.ascent.util.PageBean;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class ProductManagerAction extends BaseAction {
	//Product 属性字段 及setter、getter方法
	private String pid;
	private String productId;  
	private String catalogno;
	private String cas;
	private String productname;
	private String structure;
	private String mdlnumber;
	private String formula;
	private String mw;
	private String price1;
	private String price2;
	private String stock;
	private String realstock;
	private String newproduct;
	private String category;
	private String note;
	private String delFlag;
	
//	上传文件属性字段  用File类型封装
	private File upload;
	//struts2中要求定义文件字段+FileName和 +ContentType的两个字段来封装文件名和文件类型
	private String uploadFileName;
	private String uploadContentType;
	//选择文件的自己物理路径
	private String filepath;
	//保存路径属性，该属性的值可以通过配置文件来设置，从而动态注入
	private String savePath;
	
	//处理结果展示字段
	private String tip;
	
//	查询页数
	private String jumpPage;
//	页面展现用户列表的 处理结果集合
	private ArrayList dataList;
	
	//查询字段
	private String searchName;
	//查询值
	private String searchValue;
	
	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public ArrayList getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList dataList) {
		this.dataList = dataList;
	}

	public String getJumpPage() {
		return jumpPage;
	}

	public void setJumpPage(String jumpPage) {
		this.jumpPage = jumpPage;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@SuppressWarnings("deprecation")
	public String getSavePath() throws Exception{
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getCas() {
		return cas;
	}
	public void setCas(String cas) {
		this.cas = cas;
	}
	public String getCatalogno() {
		return catalogno;
	}
	public void setCatalogno(String catalogno) {
		this.catalogno = catalogno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getMdlnumber() {
		return mdlnumber;
	}
	public void setMdlnumber(String mdlnumber) {
		this.mdlnumber = mdlnumber;
	}
	public String getMw() {
		return mw;
	}
	public void setMw(String mw) {
		this.mw = mw;
	}
	public String getNewproduct() {
		return newproduct;
	}
	public void setNewproduct(String newproduct) {
		this.newproduct = newproduct;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getPrice2() {
		return price2;
	}
	public void setPrice2(String price2) {
		this.price2 = price2;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getRealstock() {
		return realstock;
	}
	public void setRealstock(String realstock) {
		this.realstock = realstock;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	
	@SuppressWarnings("unchecked")
	public String saveOne()throws Exception{
		
		if(productService.findByProductId(this.getProductId())!=null){
			this.setTip(this.getText("productM_tip.id.used"));//商品编号被占用，请重新添加商品
			return INPUT;
		}else{
			if(this.getUpload()!=null){
					if(this.getUploadContentType().equals("application/vnd.ms-excel")){
						this.setTip(this.getText("productM_tip.upload.file.type"));//此处只允许上传图片类型文件，请返回重新选择
						return INPUT;
					}
					//保存图片名称到数据库字段structure
					this.setStructure(getUploadFileName());
					//以服务器的文件保存地址和原文件的名  建立上传文件输出流
					FileOutputStream fos = new FileOutputStream(this.getSavePath()+"\\"+this.getUploadFileName());
					
					//以上传文件建立一个文件上传流
					FileInputStream fis = new FileInputStream(this.getUpload());
					
					//将上传文件的内容写入服务器
					byte [] buffer = new byte[1024];
					int len=0;
					while((len=fis.read(buffer))>0){
						fos.write(buffer, 0, len);
					}
			}
			System.out.println("结束上传单个文件-----------------------");
			Product product = new Product();
			product.setCas(this.getCas());
			product.setCategoryno(this.getCatalogno());
			product.setCategory(this.getCategory());
			product.setDelsoft("0");
			product.setFormula(this.getFormula());
			product.setMdlint(this.getMdlnumber());
			product.setWeight(this.getMw());
			product.setIsnewproduct(this.getNewproduct());
			product.setPrice1(Float.parseFloat(this.getPrice1()));
			product.setPrice2(Float.parseFloat(this.getPrice2()));
			product.setProductnumber(this.getProductId());
			product.setProductname(this.getProductname());
			product.setRealstock(this.getRealstock());
			product.setStock(this.getStock());
			product.setImagepath((this.getStructure()));
			productService.saveProduct(product);
			this.pageReturn();
			return "saveOnesuccess";
			
			
			
		}
		
	}
//	返回分页数目的结果集合
	public PageBean listData(String number){	//  返回一个封装数据库查询数据的页面对象
		PageBean page = new PageBean(productService.getTotalRows());
		
		int pageNum = Integer.parseInt(number);
		String sql = "from Product p where p.delsoft='0'  order by p.id ";
		ArrayList data = productService.getData(sql,page.rowsPage*(pageNum-1), page.rowsPage);
		page.currentPage = pageNum;
		page.data = data;
		
		return page;
	}
	//管理员展现商品列表（分页）
	@SuppressWarnings("unchecked")
	public String pageShow()throws Exception{
		
		this.pageReturn();
		return "adminproductsshow";
	}
	//删除商品
	@SuppressWarnings("unchecked")
	public String delete()throws Exception{
		Product product =productService.findByPid(this.getPid());
		//设置删除标志1
		product.setDelsoft("1");
		productService.updateProduct(product);
		//下面为查询分页信息到产品展现页面
		
		this.pageReturn();
		return "adminproductsshow";
	}
	//根据pid查询产品到修改页面
	@SuppressWarnings("unchecked")
	public String find_update()throws Exception{
		Product product =productService.findByPid(this.getPid());
		ActionContext.getContext().getSession().put("pid_product",product);
		return "updateProduct";
	}
	@SuppressWarnings("unchecked")
	public String update()throws Exception{
		//System.out.println(this.getClass().getName()+this.getPid());
		//取得该product产品
		Product product =productService.findByPid(this.getPid());
		//System.out.println(this.getClass().getName()+product.getId());
		//如果修改操作修改图片进行if操作，否则不进入
		if(this.getUploadFileName()!=null){
			if(this.getUploadContentType().equals("application/vnd.ms-excel")){
				this.setTip(this.getText("productM_tip.upload.file.type"));//此处只允许上传图片类型文件，请返回重新选择
				return INPUT;
			}
			
			//保存图片名称到数据库字段structure
			this.setStructure(getUploadFileName());
			//以服务器的文件保存地址和原文件的名  建立上传文件输出流
			FileOutputStream fos = new FileOutputStream(this.getSavePath()+"\\"+this.getUploadFileName());
			
			//以上传文件建立一个文件上传流
			FileInputStream fis = new FileInputStream(this.getUpload());
			
			//将上传文件的内容写入服务器
			byte [] buffer = new byte[1024];
			int len=0;
			while((len=fis.read(buffer))>0){
				fos.write(buffer, 0, len);
			}
			product.setImagepath((this.getStructure()));
		}
		product.setCas(this.getCas());
		product.setCategoryno((this.getCatalogno()));
		product.setCategory(this.getCategory());
		product.setFormula(this.getFormula());
		product.setMdlint(this.getMdlnumber());
		product.setWeight((this.getMw()));
		product.setIsnewproduct(this.getNewproduct());
		product.setPrice1(Float.parseFloat(this.getPrice1()));
		product.setPrice2(Float.parseFloat(this.getPrice2()));
		product.setProductnumber(this.getProductId());
		product.setProductname(this.getProductname());
		product.setRealstock(this.getRealstock());
		product.setStock(this.getStock());
		product.setNote(this.getNote());
		System.out.println(this.getClass().getName()+product.getId());
		productService.updateProduct(product);
		this.pageReturn();
		return "adminproductsshow";
	}
	
	public String excelAdd()throws Exception{
		if(!this.getUploadContentType().equals("application/vnd.ms-excel")){
			this.setTip(this.getText("productM_tip.upload.file.type.excel"));//此处只允许上传excel类型文件，请返回重新选择
			return INPUT;
		}
		
		ArrayList arrayList = AddExcelProduct.addTextFile(this.getFilepath());
		productService.saveExcelProduct(arrayList);
		
		this.pageReturn();
		return "adminproductsshow";
	}
	
	
//	管理员展现商品列表（分页）
	@SuppressWarnings("unchecked")
	public String guestPageShow()throws Exception{
		
		this.pageReturn();
		return "guestproductsshow";
	}
	
	//根据选择字段查询商品
	@SuppressWarnings("unchecked")
	public String search()throws Exception{
		List search_product_list = productService.findBySearchProperty(this.getSearchName(), this.getSearchValue());
		ActionContext.getContext().getSession().put("search_product_list",search_product_list);
		return "searchproductshow";
	}
	
	//根据uid返回分配用户权限的商品
	@SuppressWarnings("unchecked")
	public String userProducts()throws Exception{
		Usr u =(Usr)ActionContext.getContext().getSession().get("usr");
		List userProductList = productService.findByUid(u.getId());
		ActionContext.getContext().getSession().put("userproductslist", userProductList);
		return "userproducts";
	}
	
	//进行分页返回信息方法 每个需要返回分页结果的方法都需要调用它

	@SuppressWarnings("unchecked")
	private void pageReturn(){
		String jump_page = this.getJumpPage();
		if(jump_page==null){
			jump_page="1";
		}
		PageBean page = this.listData(jump_page);
		ActionContext.getContext().getSession().put("product_page_list",page);
		this.setDataList(page.getData());
	}
	
	@SuppressWarnings("unchecked")
	public String newProducts()throws Exception{
		List newProductsList = productService.findNewProducts();
		ActionContext.getContext().getSession().put("newproductslist", newProductsList);
		return "index";
	}
	
	public String productDetail() throws Exception{
		Product detailProduct = productService.findByPid(this.getPid());
		List productdetailList = new ArrayList();
		productdetailList.add(detailProduct);
		ActionContext.getContext().getSession().put("detailproduct", productdetailList);
		return "productdetail";
	}
}
