package com.other.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.*;

/**
 * Excel读写
 * 文件：C:\Users\lenovo\Desktop\ExcelTest.xlsx
 */
public class ExcelDemo {
    public static void main(String[] args) throws Exception {
        String input="C:\\Users\\lenovo\\Desktop\\ExcelTest.xlsx";
//                 writeExcel(input,2007);           //xlsx格式用2007,xls格式用2003
        readExcel(input,2007);

    }


    public static  void readExcel(String file,int edition) throws Exception {//读取2003和2007版本的Excel
        try {
            //创建文件流
            FileInputStream fis=new FileInputStream(new File(file));
            //通过接口实例化Workbook工作簿
            Workbook workbook=PoiUtil.getWorkbook(fis,edition);
            //通过接口获得默认的第一个sheet的页面
            Sheet sheet = workbook.getSheetAt(0);
            //获取sheet页的第一行
            Row row1 = sheet.getRow(0);

            //从第二行开始读，遍历到最后一行
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);//得到每一行
                for (int j = 0; j < row.getLastCellNum(); j++) {//得到每一行的每一列
                    Cell cell = row.getCell(j);
                    // 根据excel中单元格的属性，来用不同的格式取得有效值
                    String cellValue = PoiUtil.getCellString(cell);
                    System.out.println("单元格内容为:"+cellValue);
                }
            }
            fis.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeExcel(String file,int edition) throws Exception{

        FileInputStream fis=new FileInputStream(new File(file));
        Workbook workbook=PoiUtil.getWorkbook(fis,edition);
        Sheet sheet=workbook.getSheetAt(0);

        try {
            //获取第一行
            Row row0=sheet.getRow(0);
            //在第一行第一列写入数据,类型为string
            Cell cell0=row0.createCell(0, CellType.STRING);
            cell0.setCellValue("Order");
            //在第二行开始写入数据
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Cell cell=row.createCell(0, CellType.STRING);
                cell.setCellValue( String.valueOf(i+1) );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        fis.close();
        //刷新流的缓存区,将数据写入excel
        FileOutputStream fos=new FileOutputStream(file);
        fos.flush();
        workbook.write(fos);
        //关闭文件流
        fos.close();
        workbook.close();

    }

}