package com.ascent.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AddExcelProduct {
//	��Excel�е�ҩƷ��Ϣ�ŵ�һ��ArrayList��
	@SuppressWarnings({ "unused", "unchecked" })
	public static   ArrayList addTextFile(String excelTextFilePath){
		
		ArrayList arrayList_TextFile=new ArrayList();//���ڴ��xls�ļ�������
		InputStream inputstream_File=null;
		Workbook wb=null;
		Sheet[] sheet=null;
		Cell cell=null;
		String str=null;
		
		try {
			String temp = new String (excelTextFilePath.getBytes("iso8859-1"),"gb2312");//��·��ת�����
			inputstream_File = new FileInputStream(temp);//�õ�������
			wb=Workbook.getWorkbook(inputstream_File);//�õ�Workbook
			//File file=new File(excelTextFilePath);
			//wb=Workbook.getWorkbook(file);
			
			
			sheet=wb.getSheets();//�õ�����ҳ���б�
			
			for(int i=0;i<sheet.length;i++){//for(1)
				ArrayList arrayList_Sheet=new ArrayList();//ÿ��Sheet������
				
				for(int j=1;j<sheet[i].getRows();j++){//for(2),��ÿ��Sheet���������һ��arrayList_Sheet
					
					ArrayList arrayList_Row=new ArrayList();//arrayList_Row��������м�¼
					
					for(int k=0;k<sheet[i].getColumns();k++){//for(3),��ÿ�е��������һ��arrayList_Row
						cell=sheet[i].getCell(k,j);//ע�⣺API�涨column��ǰ��Row�ں�
						str=cell.getContents();
						
						//System.out.println(str);
						
						arrayList_Row.add(k,str);
					}//for(3)
					
					System.out.println("--------------------");
					arrayList_Sheet.add(j-1,arrayList_Row);
				}//for(2)
				
				arrayList_TextFile.add(i,arrayList_Sheet);
				
			}//for(1)
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			inputstream_File.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		wb.close();
		return arrayList_TextFile;
	}
}
