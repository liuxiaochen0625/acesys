package com.ascent.util;

import java.util.Comparator;
/**
 * 案例类
 * sort标签比较器类   /anli/tag/tag_sort.jsp中使用
 * 
 * @author LEE
 *
 */
public class MyComparator implements Comparator
{
	//按照字符串的长度比较
	public int compare(Object element1, Object element2)
	{
		return element1.toString().length() - element2.toString().length();
	}
}
