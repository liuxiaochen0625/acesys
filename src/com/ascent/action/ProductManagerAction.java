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
	//Product �����ֶ� ��setter��getter����
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
	
//	�ϴ��ļ������ֶ�  ��File���ͷ�װ
	private File upload;
	//struts2��Ҫ�����ļ��ֶ�+FileName�� +ContentType�������ֶ�����װ�ļ������ļ�����
	private String uploadFileName;
	private String uploadContentType;
	//ѡ���ļ����Լ�����·��
	private String filepath;
	//����·�����ԣ������Ե�ֵ����ͨ�������ļ������ã��Ӷ���̬ע��
	private String savePath;
	
	//������չʾ�ֶ�
	private String tip;
	
//	��ѯҳ��
	private String jumpPage;
//	ҳ��չ���û��б�� ����������
	private ArrayList dataList;
	
	//��ѯ�ֶ�
	private String searchName;
	//��ѯֵ
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
			this.setTip(this.getText("productM_tip.id.used"));//��Ʒ��ű�ռ�ã������������Ʒ
			return INPUT;
		}else{
			if(this.getUpload()!=null){
					if(this.getUploadContentType().equals("application/vnd.ms-excel")){
						this.setTip(this.getText("productM_tip.upload.file.type"));//�˴�ֻ�����ϴ�ͼƬ�����ļ����뷵������ѡ��
						return INPUT;
					}
					//����ͼƬ���Ƶ����ݿ��ֶ�structure
					this.setStructure(getUploadFileName());
					//�Է��������ļ������ַ��ԭ�ļ�����  �����ϴ��ļ������
					FileOutputStream fos = new FileOutputStream(this.getSavePath()+"\\"+this.getUploadFileName());
					
					//���ϴ��ļ�����һ���ļ��ϴ���
					FileInputStream fis = new FileInputStream(this.getUpload());
					
					//���ϴ��ļ�������д�������
					byte [] buffer = new byte[1024];
					int len=0;
					while((len=fis.read(buffer))>0){
						fos.write(buffer, 0, len);
					}
			}
			System.out.println("�����ϴ������ļ�-----------------------");
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
//	���ط�ҳ��Ŀ�Ľ������
	public PageBean listData(String number){	//  ����һ����װ���ݿ��ѯ���ݵ�ҳ�����
		PageBean page = new PageBean(productService.getTotalRows());
		
		int pageNum = Integer.parseInt(number);
		String sql = "from Product p where p.delsoft='0'  order by p.id ";
		ArrayList data = productService.getData(sql,page.rowsPage*(pageNum-1), page.rowsPage);
		page.currentPage = pageNum;
		page.data = data;
		
		return page;
	}
	//����Աչ����Ʒ�б���ҳ��
	@SuppressWarnings("unchecked")
	public String pageShow()throws Exception{
		
		this.pageReturn();
		return "adminproductsshow";
	}
	//ɾ����Ʒ
	@SuppressWarnings("unchecked")
	public String delete()throws Exception{
		Product product =productService.findByPid(this.getPid());
		//����ɾ����־1
		product.setDelsoft("1");
		productService.updateProduct(product);
		//����Ϊ��ѯ��ҳ��Ϣ����Ʒչ��ҳ��
		
		this.pageReturn();
		return "adminproductsshow";
	}
	//����pid��ѯ��Ʒ���޸�ҳ��
	@SuppressWarnings("unchecked")
	public String find_update()throws Exception{
		Product product =productService.findByPid(this.getPid());
		ActionContext.getContext().getSession().put("pid_product",product);
		return "updateProduct";
	}
	@SuppressWarnings("unchecked")
	public String update()throws Exception{
		//System.out.println(this.getClass().getName()+this.getPid());
		//ȡ�ø�product��Ʒ
		Product product =productService.findByPid(this.getPid());
		//System.out.println(this.getClass().getName()+product.getId());
		//����޸Ĳ����޸�ͼƬ����if���������򲻽���
		if(this.getUploadFileName()!=null){
			if(this.getUploadContentType().equals("application/vnd.ms-excel")){
				this.setTip(this.getText("productM_tip.upload.file.type"));//�˴�ֻ�����ϴ�ͼƬ�����ļ����뷵������ѡ��
				return INPUT;
			}
			
			//����ͼƬ���Ƶ����ݿ��ֶ�structure
			this.setStructure(getUploadFileName());
			//�Է��������ļ������ַ��ԭ�ļ�����  �����ϴ��ļ������
			FileOutputStream fos = new FileOutputStream(this.getSavePath()+"\\"+this.getUploadFileName());
			
			//���ϴ��ļ�����һ���ļ��ϴ���
			FileInputStream fis = new FileInputStream(this.getUpload());
			
			//���ϴ��ļ�������д�������
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
			this.setTip(this.getText("productM_tip.upload.file.type.excel"));//�˴�ֻ�����ϴ�excel�����ļ����뷵������ѡ��
			return INPUT;
		}
		
		ArrayList arrayList = AddExcelProduct.addTextFile(this.getFilepath());
		productService.saveExcelProduct(arrayList);
		
		this.pageReturn();
		return "adminproductsshow";
	}
	
	
//	����Աչ����Ʒ�б���ҳ��
	@SuppressWarnings("unchecked")
	public String guestPageShow()throws Exception{
		
		this.pageReturn();
		return "guestproductsshow";
	}
	
	//����ѡ���ֶβ�ѯ��Ʒ
	@SuppressWarnings("unchecked")
	public String search()throws Exception{
		List search_product_list = productService.findBySearchProperty(this.getSearchName(), this.getSearchValue());
		ActionContext.getContext().getSession().put("search_product_list",search_product_list);
		return "searchproductshow";
	}
	
	//����uid���ط����û�Ȩ�޵���Ʒ
	@SuppressWarnings("unchecked")
	public String userProducts()throws Exception{
		Usr u =(Usr)ActionContext.getContext().getSession().get("usr");
		List userProductList = productService.findByUid(u.getId());
		ActionContext.getContext().getSession().put("userproductslist", userProductList);
		return "userproducts";
	}
	
	//���з�ҳ������Ϣ���� ÿ����Ҫ���ط�ҳ����ķ�������Ҫ������

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
