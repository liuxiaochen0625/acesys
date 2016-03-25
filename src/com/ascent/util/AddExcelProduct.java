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
//	将Excel中的药品信息放到一个ArrayList中
	@SuppressWarnings({ "unused", "unchecked" })
	public static   ArrayList addTextFile(String excelTextFilePath){
		
		ArrayList arrayList_TextFile=new ArrayList();//用于存放xls文件的数据
		InputStream inputstream_File=null;
		Workbook wb=null;
		Sheet[] sheet=null;
		Cell cell=null;
		String str=null;
		
		try {
			String temp = new String (excelTextFilePath.getBytes("iso8859-1"),"gb2312");//将路径转变编码
			inputstream_File = new FileInputStream(temp);//得到输入流
			wb=Workbook.getWorkbook(inputstream_File);//得到Workbook
			//File file=new File(excelTextFilePath);
			//wb=Workbook.getWorkbook(file);
			
			
			sheet=wb.getSheets();//得到所有页的列表
			
			for(int i=0;i<sheet.length;i++){//for(1)
				ArrayList arrayList_Sheet=new ArrayList();//每个Sheet的内容
				
				for(int j=1;j<sheet[i].getRows();j++){//for(2),将每个Sheet的内容组成一个arrayList_Sheet
					
					ArrayList arrayList_Row=new ArrayList();//arrayList_Row用来存放行记录
					
					for(int k=0;k<sheet[i].getColumns();k++){//for(3),将每行的内容组成一个arrayList_Row
						cell=sheet[i].getCell(k,j);//注意：API规定column在前，Row在后
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
