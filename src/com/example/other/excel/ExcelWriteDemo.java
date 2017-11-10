package com.example.other.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by lenovo on 2017/7/24.
 */
public class ExcelWriteDemo {
    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\lenovo\\Desktop\\工作\\ExcelTest2.xlsx");
        FileInputStream fis=new FileInputStream(file );
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);

        try {
            //新增加行
            XSSFRow row0=sheet.createRow(0);
            row0.createCell(0).setCellValue(01);
            row0.createCell(3).setCellValue(03);
            //修改已有的行
            XSSFRow row1=sheet.getRow(1);
            Cell cell02=row1.getCell(2);
            String cellString=PoiUtil.getCellString(cell02);
            System.out.println("第2行第3列数据为:"+cellString);

            Cell cell=row1.createCell(1,CellType.STRING);
            cell.setCellValue("5555555");
        }catch (Exception e){
            e.printStackTrace();
        }
        fis.close();
        FileOutputStream  fos=new FileOutputStream(file);
        fos.flush();
        wb.write(fos);
        fos.close();
        wb.close();
        System.out.println("数据成功写入");

    }
}
