package com.xb.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

//import org.apache.poi.hssf.util.CellRangeAddress;

/** 
 * 导出Excel公共方法 
 * @version 1.0 
 *  
 * @author wangcp 
 * 
 */  
public class ExportExcelMax {  
	public  HSSFWorkbook workbook ;  
    //显示的导出表的标题  
    private String title;  
    //导出表的列名  
    private String[] rowName ;  
      
    private List<Object[]>  dataList = new ArrayList<Object[]>();  
      
    HttpServletResponse  response;  
      
    //构造方法，传入要导出的数据  
    public ExportExcelMax( HSSFWorkbook workbook ,String title,String[] rowName,List<Object[]>  dataList, HttpServletResponse response){  
        this.dataList = dataList;  
        this.rowName = rowName;  
        this.title = title;  
        this.response = response;
        this.workbook=workbook;
    }  
              
    /* 
     * 导出数据 
     * */  
    public void export( int a ) throws Exception{ 
        try{  
           
          // 创建工作簿对象  03版excel
            HSSFSheet sheet = workbook.createSheet("当前为第"+a+"页");                 // 创建工作表  
              
            // 产生表格标题行  
            HSSFRow rowm = sheet.createRow(0);  
            HSSFCell cellTiltle = rowm.createCell(0);  
              
            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】  
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);//获取列头样式对象  
            HSSFCellStyle style = this.getStyle(workbook);                  //单元格样式对象  
            //合并单元格
            sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0, 1,0, (rowName.length-1)));    
            cellTiltle.setCellStyle(columnTopStyle);  
            cellTiltle.setCellValue(title);  
              
            // 定义所需列数  
            int columnNum = rowName.length;  
            HSSFRow rowRowName = sheet.createRow(2);                // 在索引2的位置创建行(最顶端的行开始的第二行)  
              
            // 将列头设置到sheet的单元格中  
            for(int n=0;n<columnNum;n++){  
                HSSFCell  cellRowName = rowRowName.createCell(n);               //创建列头对应个数的单元格  
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型  
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);  
                cellRowName.setCellValue(text);                                 //设置列头单元格的值  
                cellRowName.setCellStyle(columnTopStyle);                       //设置列头单元格样式  
            }  
              
            //将查询出的数据设置到sheet对应的单元格中  
            for(int i=0;i<dataList.size();i++){  
                  
                Object[] obj = dataList.get(i);//遍历每个对象  
                HSSFRow row = sheet.createRow(i+3);//创建所需的行数  
                  
                for(int j=0; j<obj.length; j++){  
                    HSSFCell  cell = null;   //设置单元格的数据类型  
//                    if(j == 0){  
//                        cell = row.createCell(j,HSSFCell.CELL_TYPE_NUMERIC);  
//                        cell.setCellValue(i+1);   
//                    }else{  
                        cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);  
                        if(!"".equals(obj[j]) && obj[j] != null){  
                            cell.setCellValue(obj[j].toString());                       //设置单元格的值  
                        } else {
                        	cell.setCellValue(""); 
                        }  
//                    }  
                    cell.setCellStyle(style);                                   //设置单元格样式  
                }  
            }  
            //让列宽随着导出的列长自动适应  
            for (int colNum = 0; colNum < columnNum; colNum++) {  
                int columnWidth = sheet.getColumnWidth(colNum) / 256;  
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {  
                    HSSFRow currentRow;  
                    //当前行未被使用过  
                    if (sheet.getRow(rowNum) == null) {  
                        currentRow = sheet.createRow(rowNum);  
                    } else {  
                        currentRow = sheet.getRow(rowNum);  
                    }  
                    if (currentRow.getCell(colNum) != null) {  
                        HSSFCell currentCell = currentRow.getCell(colNum);  
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {  
                        	int length = 0;
                        	if (null != currentCell.getStringCellValue() && !"".equals(currentCell.getStringCellValue())) {
                        		length = currentCell.getStringCellValue().getBytes().length;  
                        	}
                            
                            if (columnWidth < length) {  
                                columnWidth = length;  
                            }  
                        }  
                    }  
                }  
                if(colNum == 0){  
                    sheet.setColumnWidth(colNum, (columnWidth-2) * 256);  
                }else{  
                    sheet.setColumnWidth(colNum, (columnWidth+4) * 256);  
                }  
            }  
              
            //responseDown(workbook);  
  
        }catch(Exception e){  
            e.printStackTrace();  
        } 

       System.out.println(a);
          
    }

	private    void responseDown(HSSFWorkbook workbook) {
		if(workbook !=null){  
		    try  
		    {  
		        String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";  
		        String headStr = "attachment; filename=\"" + fileName + "\"";  
		        response.setContentType("APPLICATION/OCTET-STREAM");  
		        response.setHeader("Content-Disposition", headStr);  
		        OutputStream out = response.getOutputStream();  
		        
		        
		       // FileOutputStream out = new FileOutputStream(E://学生表.xls);
		        workbook.write(out);
		        //workbook.write(out);  
		    }  
		    catch (IOException e)  
		    {  
		        e.printStackTrace();  
		    }  
		}
	}  
    
    
    
    
      
    /*  
     * 列头单元格样式 
     */      
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {  
          
          // 设置字体  
          HSSFFont font = workbook.createFont();  
          //设置字体大小  
          font.setFontHeightInPoints((short)11);  
          //字体加粗  
          font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
          //设置字体名字   
          font.setFontName("Courier New");  
          //设置样式;   
          HSSFCellStyle style = workbook.createCellStyle();  
          //设置底边框;   
          style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
          //设置底边框颜色;    
          style.setBottomBorderColor(HSSFColor.BLACK.index);  
          //设置左边框;     
          style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
          //设置左边框颜色;   
          style.setLeftBorderColor(HSSFColor.BLACK.index);  
          //设置右边框;   
          style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
          //设置右边框颜色;   
          style.setRightBorderColor(HSSFColor.BLACK.index);  
          //设置顶边框;   
          style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
          //设置顶边框颜色;    
          style.setTopBorderColor(HSSFColor.BLACK.index);  
          //在样式用应用设置的字体;    
          style.setFont(font);  
          //设置自动换行;   
          style.setWrapText(false);  
          //设置水平对齐的样式为居中对齐;    
          style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
          //设置垂直对齐的样式为居中对齐;   
          style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
            
          return style;  
            
    }  
      
    /*   
     * 列数据信息单元格样式 
     */    
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {  
          // 设置字体  
          HSSFFont font = workbook.createFont();  
          //设置字体大小  
          //font.setFontHeightInPoints((short)10);  
          //字体加粗  
          //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
          //设置字体名字   
          font.setFontName("Courier New");  
          //设置样式;   
          HSSFCellStyle style = workbook.createCellStyle();  
          //设置底边框;   
          style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
          //设置底边框颜色;    
          style.setBottomBorderColor(HSSFColor.BLACK.index);  
          //设置左边框;     
          style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
          //设置左边框颜色;   
          style.setLeftBorderColor(HSSFColor.BLACK.index);  
          //设置右边框;   
          style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
          //设置右边框颜色;   
          style.setRightBorderColor(HSSFColor.BLACK.index);  
          //设置顶边框;   
          style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
          //设置顶边框颜色;    
          style.setTopBorderColor(HSSFColor.BLACK.index);  
          //在样式用应用设置的字体;    
          style.setFont(font);  
          //设置自动换行;   
          style.setWrapText(false);  
          //设置水平对齐的样式为居中对齐;    
          style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
          //设置垂直对齐的样式为居中对齐;   
          style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
           
          return style;  
      
    }  
  //判断从Excel文件中解析出来数据的格式   
    public static String getCellValue(HSSFCell cell){   
        String value = null;   
        //简单的查检列类型   
        switch(cell.getCellType())   
        {   
            case HSSFCell.CELL_TYPE_STRING://字符串   
                value = cell.getRichStringCellValue().getString();   
                break;   
            case HSSFCell.CELL_TYPE_NUMERIC://数字   
                long dd = (long)cell.getNumericCellValue();   
                value = dd+"";   
                break;   
            case HSSFCell.CELL_TYPE_BLANK:   
                value = "";   
                break;      
            case HSSFCell.CELL_TYPE_FORMULA:   
                value = String.valueOf(cell.getCellFormula());   
                break;   
            case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值   
                value = String.valueOf(cell.getBooleanCellValue());   
                break;   
            case HSSFCell.CELL_TYPE_ERROR:   
                value = String.valueOf(cell.getErrorCellValue());   
                break;   
            default:   
                break;   
        }   
         return value;   
     } 
  
    	
     
    
    		
    		
    		
}  
