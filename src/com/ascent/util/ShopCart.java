package com.ascent.util;

import java.util.HashMap;

import com.ascent.po.Product;

public class ShopCart {
	private HashMap<String, Product> hashMap;
	
	public HashMap<String, Product> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<String, Product> hashMap) {
		this.hashMap = hashMap;
	}

	@SuppressWarnings("unchecked")
	public ShopCart(){
		hashMap = new HashMap();
	}
	
	/**
	 * 检查hashmap中是否有了该pid对应的对象方法
	 * @param pid
	 * @return true：有   false：无
	 */
	public boolean checkPid(String pid){
		if(hashMap.containsKey(pid)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 在上面方法返回false情况下添加product
	 * @param pid
	 * @param product
	 */
	public void addProduct(String pid,Product product){
		hashMap.put(pid, product);
	}
	
	/**
	 * 根据id删除hashmap中的product
	 * @param pid
	 */
	public void delProduct(String pid){
		hashMap.remove(pid);
	}
	
	/**
	 * 修改hashmap中pid对应product的质量quantity
	 * @param pid
	 * @param quantity
	 */
	public void updateQuantity(String pid,String quantity){
		hashMap.get(pid).setQuantity(quantity);
	}
	
	/**
	 * 清除购物车
	 */
	public void emptyCart(){
		this.getHashMap().clear();
	}
}
