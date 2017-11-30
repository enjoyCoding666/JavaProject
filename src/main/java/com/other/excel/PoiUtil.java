package com.other.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Util�ṩ�����о�̬�������صĶ�����Workbook�����һ������������������
 * @author learnhow
 *
 */
public class PoiUtil {
    public static final int Excel2003 = 2003;
    public static final int Excel2007 = 2007;

    /**
     * ���ݰ汾�ţ���ȡExcel poi����
     *
     * @param edition
     * @param in
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook( InputStream in,int edition) throws IOException {
        Workbook workbook;
        if (edition == Excel2003) {
           workbook= new HSSFWorkbook(in);
        } else if (edition == Excel2007) {
            workbook= new XSSFWorkbook(in);
        }else {
            workbook=null;
        }
        return workbook;
    }

    /**
     * ��ȡ��Ԫ���Stringֵ
     * �ı���ֱ�ӻ�ȡ,��ֵ�͵�һ����double���ͣ����ں�����Ҫ�ֿ�����
     * @param cell

     * @return
     */
    public static String getCellString(Cell cell) {
        String cellValue="";
        switch (cell.getCellTypeEnum()) {
            case STRING:
                cellValue=cell.getStringCellValue();
                if (cellValue.trim().isEmpty()) {
                    cellValue = "";
                }
                break;
            case NUMERIC:
                if( DateUtil.isCellDateFormatted(cell)) {
                    Date date=cell.getDateCellValue();
                    cellValue=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(date);
                }else {
                    BigDecimal bigDecimal=new BigDecimal(cell.getNumericCellValue());
                    cellValue=bigDecimal.toString();
                }
                break;
            case FORMULA:
                cellValue = new BigDecimal(cell.getNumericCellValue()).toPlainString();
                break;
            case BLANK:
                cellValue = "";
                break;
            default:
                break;
        }
        return  cellValue.trim();
    }





    /**
     * ��ָ��excel��������ж�ȡ����
     *
     * @param workbook
     * @param startRow
     * @param startCol
     * @param indexSheet
     * @return
     */
    public static List<List<String>> getExcelString(Workbook workbook, int startRow, int startCol, int indexSheet) {
        List<List<String>> stringTable = new ArrayList<List<String>>();
        // ��ȡָ�������
        Sheet sheet = workbook.getSheetAt(indexSheet);
        // ��ȡ�������
        int rowNum = sheet.getLastRowNum();
        for (int i = startRow; i <= rowNum; i++) {
            List<String> oneRow = new ArrayList<String>();
            Row row = sheet.getRow(i);
            // ���ݵ�ǰָ���������������������
            int colNum = row.getLastCellNum();
            for (int j = startCol; j <= colNum; j++) {
                // ȷ����ǰ��Ԫ��
                Cell cell = row.getCell(j);
                String cellValue = null;
                if (cell != null) {
                    // ��֤ÿһ����Ԫ�������
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            // ����з��ص����������ǿ�ѧ��������˲���ֱ��ת�����ַ�����ʽ
                            cellValue = new BigDecimal(cell.getNumericCellValue()).toPlainString();
                            break;
                        case Cell.CELL_TYPE_STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            cellValue = new BigDecimal(cell.getNumericCellValue()).toPlainString();
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            cellValue = "";
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            cellValue = Boolean.toString(cell.getBooleanCellValue());
                            break;
                        case Cell.CELL_TYPE_ERROR:
                            cellValue = "ERROR";
                            break;
                        default:
                            cellValue = "UNDEFINE";
                    }
                } else {
                    cellValue = "";
                }
                // ����һ������
                oneRow.add(cellValue);
            }
            stringTable.add(oneRow);
        }
        return stringTable;
    }

    /**
     * ���ݸ���������ֱ������workbook
     *
     * @param workbook
     * @param sheetName
     * @param data
     * @return
     */
    public static Workbook createExcel(Workbook workbook, String sheetName, List<List<String>> data) {
        Sheet sheet = workbook.createSheet(sheetName);
        for (int i = 0; i < data.size(); i++) {
            List<String> oneRow = data.get(i);
            Row row = sheet.createRow(i);
            for (int j = 0; j < oneRow.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(oneRow.get(j));
            }
        }
        return workbook;
    }

    /**
     * ��ָ����sheet���в������ݣ�����ķ������ṩһ��valueMap��int[]��2ά���������Ҫ������������꣬��0��ʼ
     *
     * @param workbook
     * @param sheetIndex
     * @param valueMap
     * @return
     */
    public static Workbook insertExcel(Workbook workbook, int sheetIndex, Map<int[], String> valueMap) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Iterator<Map.Entry<int[], String>> it = valueMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<int[], String> cellEntry = it.next();
            int x = cellEntry.getKey()[0];
            int y = cellEntry.getKey()[1];
            String value = cellEntry.getValue();
            Row row = sheet.getRow(y);
            Cell cell = row.getCell(x);
            cell.setCellValue(value);
        }
        return workbook;
    }

    /**
     * ����ָ���е��и�
     *
     * @param workbook
     * @param  rowHight
     * @param sheetIndex
     * @param rowIndex
     * @return
     */
    public static Workbook setRowHeight(Workbook workbook, int rowHight, int sheetIndex, int rowIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        row.setHeight((short) rowHight);
        return workbook;
    }

    /**
     * �����п�
     *
     * @param workbook
     * @param columnWidth
     * @param sheetIndex
     * @param columnIndex
     * @return
     */
    public static Workbook setColumnWidth(Workbook workbook, int columnWidth, int sheetIndex, int columnIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        sheet.setColumnWidth(columnIndex, columnWidth);
        return workbook;
    }

    /**
     * ɾ��ָ����
     *
     * @param workbook
     * @param sheetIndex
     * @param rowIndex
     * @return
     */
    public static Workbook removeRow(Workbook workbook, int sheetIndex, int rowIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        int lastRowNum = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex < lastRowNum) {
            sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
        }
        if (rowIndex == lastRowNum) {
            sheet.removeRow(sheet.getRow(rowIndex));
        }
        return workbook;
    }

    /**
     * ��ָ��λ�ò���հ���
     *
     * @param workbook
     * @param sheetIndex
     * @param rowIndex
     * @return
     */
    public static Workbook insertBlankRow(Workbook workbook, int sheetIndex, int rowIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        int lastRowNum = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex <= lastRowNum) {
            sheet.shiftRows(rowIndex, lastRowNum, 1);
            // �����һ�е�Row����
            Row preRow = sheet.getRow(rowIndex - 1);
            short rowNum = preRow.getLastCellNum();
            Row curRow = sheet.createRow(rowIndex);
            // �����ɵ�Row��������һ������ͬ����Cell
            for (short i = preRow.getFirstCellNum(); i < rowNum; i++) {
                Cell cell = preRow.getCell(i);
                CellStyle style = cell.getCellStyle();
                curRow.createCell(i).setCellStyle(style);
            }
            return workbook;
        }
        return null;
    }

    /**
     * ����sheet(0)��Ϊģ���ؽ�workbook
     *
     * @param workbook
     * @param sheetNum
     * @param sheetNames
     * @return
     */
    public static Workbook rebuildWorkbook(Workbook workbook, int sheetNum, String... sheetNames) {
        if(sheetNames.length == sheetNum){
            for (int i = 0; i < sheetNum; i++) {
                workbook.cloneSheet(0);
                // ���ɺ���Ĺ�����ָ������
                workbook.setSheetName(i + 1, sheetNames[i]);
            }
            // ɾ����һ�Ź�����
            workbook.removeSheetAt(0);
            return workbook;
        }
        return null;
    }
}