package com.ascent.util;

import java.util.Comparator;
/**
 * ������
 * sort��ǩ�Ƚ�����   /anli/tag/tag_sort.jsp��ʹ��
 * 
 * @author LEE
 *
 */
public class MyComparator implements Comparator
{
	//�����ַ����ĳ��ȱȽ�
	public int compare(Object element1, Object element2)
	{
		return element1.toString().length() - element2.toString().length();
	}
}
