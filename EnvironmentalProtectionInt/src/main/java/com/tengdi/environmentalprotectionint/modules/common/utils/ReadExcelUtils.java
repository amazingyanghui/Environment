package com.tengdi.environmentalprotectionint.modules.common.utils;

import com.tengdi.core.utils.ArithUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 读取EXCEL内容类
 */
public class ReadExcelUtils {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Workbook wb;
    private Sheet sheet;
    private Row row;

    public ReadExcelUtils(InputStream is,String ext){
        try {
            if ("xls".equals(ext)) {
                wb = new HSSFWorkbook(is);
            } else if ("xlsx".equals(ext)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        }
    }

    public ReadExcelUtils(String filepath) {
        if (filepath == null) {
            return;
        }
        String ext = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filepath);
            if (".xls".equals(ext)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        }
    }


    /**
     * 读取Excel表格表头的内容
     *
     * @return String 表头内容的数组
     */
    public String[] readExcelTitle() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();

        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            // title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = row.getCell(i).getStringCellValue();
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     *
     * @return Map 包含单元格数据内容的Map对象
     */
    public Map<Integer, Map<Integer, Object>> readExcelContent(int sheetNo) throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        Map<Integer, Map<Integer, Object>> content = new HashMap<Integer, Map<Integer, Object>>();

        sheet = wb.getSheetAt(sheetNo);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();

        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer, Object> cellValue = new HashMap<Integer, Object>();
            while (j < colNum) {
                Object obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);
                j++;
            }
            content.put(i, cellValue);
        }
        return content;
    }

    /**
     * 根据Cell类型设置数据
     *
     * @param cell
     * @return Object
     */
    private Object getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {

            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
                case Cell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式
                        // data格式是带时分秒的：2013-7-10 0:00:00
                        // cellvalue = cell.getDateCellValue().toLocaleString();


                        // data格式是不带带时分秒的：2013-7-10
                        Date date = cell.getDateCellValue();
                        cellvalue = date;
                    } else {
                        // 如果是纯数字
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:// 默认的Cell值
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
		/* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
			/* 获取一个字符 */
            String temp = value.substring(i, i + 1);
			/* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
				/* 中文字符长度为2 */
                valueLength += 2;
            } else {
				/* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    public static void main(String args[]) throws Exception {
        ReadExcelUtils utils = new ReadExcelUtils("E://test.xlsx");
        Map<Integer,Map<Integer,Object>> tes = utils.readExcelContent(0);
        int length = utils.length("fsdfsd中国人民/的/你")/2;
        DecimalFormat df = new DecimalFormat("#");
        Double test = ArithUtil.mul(String.valueOf(length),"0.26");
        System.out.println(df.format(test));
    }

    /**
     * 得到Excel内容
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public static List<String[]> getExcel(String filePath) throws Exception {
        // 创建对Excel工作簿文件的引用
        boolean isExcel2003 = filePath.toLowerCase().endsWith("xls") ? true : false;
        Workbook workbook = null;
        if (isExcel2003) {
            workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
        } else {
            workbook = new XSSFWorkbook(new FileInputStream(new File(filePath)));
        }
        // 在Excel文档中，第一张工作表的缺省索引是0
        // 其语句为：
        // HSSFSheet sheet = wookbook.getSheetAt(0);
        Sheet sheet = workbook.getSheetAt(0);
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        //时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 遍历行
        List<String[]> list_excel = new ArrayList<String[]>();
        for (int i = 1; i <= rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                // 获取到Excel文件中的所有的列
                int cells = row.getPhysicalNumberOfCells();
                String value = "";
                // 遍历列
                for (int j = 0; j <= cells; j++) {
                    // 获取到列的值
                    Cell cell = row.getCell(j);
                    if (cell != null & StringUtils.isNotEmpty(String.valueOf(cell).trim())) {
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC://数字型
                                if(HSSFDateUtil.isCellDateFormatted(cell)){
                                    value += sdf.format(cell.getDateCellValue())+",";//日期型
                                }else {
                                    String newValue= String.valueOf(cell.getNumericCellValue());
                                    newValue=newValue.substring(newValue.lastIndexOf(".")+1,newValue.length());
                                    if(newValue.equals("0")){
                                        value += (int)cell.getNumericCellValue() + ",";//数字型int
                                    }else {
                                        value += cell.getNumericCellValue() + ",";//数字型double

                                    }
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                value += cell.getStringCellValue() + ",";//文本类型
                                break;
                            case Cell.CELL_TYPE_FORMULA://公式
                                try {
                                    value += String.valueOf(cell.getStringCellValue())+",";
                                } catch (IllegalStateException e) {
                                    value += String.valueOf(cell.getNumericCellValue())+",";
                                }
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                value += cell.getStringCellValue()+",";
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                value += cell.getBooleanCellValue()+",";
                                break;
                            default:
                                value += "0";
                                break;
                        }
                    }
                }
                String[] val = value.split(",");
                list_excel.add(val);
            }
        }
        return list_excel;
    }
}
