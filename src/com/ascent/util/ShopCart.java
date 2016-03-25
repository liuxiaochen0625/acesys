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
	 * ���hashmap���Ƿ����˸�pid��Ӧ�Ķ��󷽷�
	 * @param pid
	 * @return true����   false����
	 */
	public boolean checkPid(String pid){
		if(hashMap.containsKey(pid)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �����淽������false��������product
	 * @param pid
	 * @param product
	 */
	public void addProduct(String pid,Product product){
		hashMap.put(pid, product);
	}
	
	/**
	 * ����idɾ��hashmap�е�product
	 * @param pid
	 */
	public void delProduct(String pid){
		hashMap.remove(pid);
	}
	
	/**
	 * �޸�hashmap��pid��Ӧproduct������quantity
	 * @param pid
	 * @param quantity
	 */
	public void updateQuantity(String pid,String quantity){
		hashMap.get(pid).setQuantity(quantity);
	}
	
	/**
	 * ������ﳵ
	 */
	public void emptyCart(){
		this.getHashMap().clear();
	}
}
