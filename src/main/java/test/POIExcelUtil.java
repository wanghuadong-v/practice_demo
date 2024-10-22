package test;

import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class POIExcelUtil {
    private static final Logger logger = LoggerFactory.getLogger("POIExcelUtil.class");
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    /**
     * 读入excel文件，解析后返回
     * @param file
     * @throws IOException
     */
    public static List<String[]> readExcel(MultipartFile file) throws IOException {
        //检查文件
        checkFile(file);
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        if(workbook != null){
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum  = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum;rowNum <= lastRowNum;rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getLastCellNum();//为空列获取
//                    int lastCellNum = row.getPhysicalNumberOfCells();//为空列不获取
//                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    String[] cells = new String[row.getLastCellNum()];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
        }
        return list;
    }
    // 提取固定列的内容
    public static List<String[]> readExcel(String filePath, List<Integer> columnInfos) throws IOException {
        List<String[]> result = readExcel(filePath);
        List<String[]> filterResult = new ArrayList<String[]>();

        for(String[] item : result) {
            System.out.println("item =" + JSON.toJSONString(item));
            String[] cols = new String[columnInfos.size()];
            for (int i =0;i<columnInfos.size();i++) {
                System.out.println("columnInfos.size() =" + columnInfos.size()+", " +i + ", item.size()="+item.length);
                cols[i] = item[columnInfos.get(i)];
            }
            filterResult.add(cols);
        }
        return filterResult;
    }

    /**
     *
     * @param filePath
     * @param startRow 从第几行开始(下标)
     * @param columnInfos 提取哪些列数据
     * @return
     * @throws IOException
     */
    public static List<String[]> readExcel(String filePath, int startRow, List<Integer> columnInfos) throws IOException {
        List<String[]> result = readExcel(filePath);
        List<String[]> filterResult = new ArrayList<String[]>();
        int rows = result.size();
        if (startRow > rows-1) {
            //有异常了
            return null;
        }
        for (int rowIndex = startRow; rowIndex < result.size(); rowIndex++) {
            String[] item = result.get(rowIndex);
            String[] cols = new String[columnInfos.size()];
            for (int i =0;i<columnInfos.size();i++) {
                cols[i] = item[columnInfos.get(i)];
            }
            filterResult.add(cols);
        }
        return filterResult;
    }

    public static List<String[]> readExcel(String filePath) throws IOException {
        //检查文件
        checkFile(filePath);
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(filePath);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        if(workbook != null){
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum  = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum;rowNum <= lastRowNum;rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getLastCellNum();//为空列获取
//                    int lastCellNum = row.getPhysicalNumberOfCells();//为空列不获取
//                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    String[] cells = new String[row.getLastCellNum()];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
        }
        return list;
    }
    /**
     * 导出excel
     * @param dataList  数据集
     * @param sheetName 文本薄名称
     * @param titleArr  表头数组
     * @return 导出行数
     */
    public static int writeExcel0(List<Map<String, String>> dataList, String excelPath, String sheetName, String... titleArr)
            throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet0 = workbook.createSheet(sheetName);

        // 设置表头
        XSSFRow row0 = sheet0.createRow(0);
        for (int i = 0; i < titleArr.length; i++) {
            XSSFCell cell = row0.createCell(i);
            cell.setCellValue(titleArr[i]);
        }

        int rowN = 1;
        for (Map<String, String> map : dataList) {
            XSSFRow row = sheet0.createRow(rowN++);
            int colN = -1;
            while (colN++ < titleArr.length - 1) {
                XSSFCell cell = row.createCell(colN);
                cell.setCellValue(map.get(getTitle(row0, colN)));// 根据列索引获取列名，再获取内容
            }
        }

        workbook.write(new FileOutputStream(excelPath));// 覆盖
        workbook.close();

        return dataList.size();
    }
    public static int write2File(List<String[]> dataList, String excelPath, String sheetName, String... titleArr)
            throws Exception {
        List<Map<String, String>> newList = new ArrayList<>();
        dataList.forEach(e -> {
            Map<String, String> map = new HashMap<>();
            int i = 0;
            for (String str: e) {
                map.put(titleArr[i++], str);
            }
            newList.add(map);
        });
        return writeExcel0(newList, excelPath, sheetName, titleArr);
    }
    /**
     * 返回表头名称
     *
     * @param titleRow 表头行
     * @param colN     列索引
     * @return
     */
    private static String getTitle(XSSFRow titleRow, int colN) {
        return titleRow.getCell(colN).getStringCellValue();
    }
    public static void checkFile(MultipartFile file) throws IOException{
        //判断文件是否存在
        if(null == file){
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith(xls) && !fileName.endsWith(xlsx)){
            throw new IOException(fileName + "不是excel文件");
        }
    }
    public static void checkFile(String filePath) throws IOException{
        //判断文件是否存在
        if(null == filePath){
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = filePath;
        //判断文件是否是excel文件
        if(!fileName.endsWith(xls) && !fileName.endsWith(xlsx)){
            throw new IOException(fileName + "不是excel文件");
        }
    }
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith(xls)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(xlsx)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return workbook;
    }
    public static Workbook getWorkBook(String filePath) {
        //获得文件名
        String fileName = filePath;
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = new FileInputStream(filePath);
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith(xls)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(xlsx)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return workbook;
    }
    /**
     * 根据cell值类型获取值
     * 注：无论文本列是何种类型，都转为String
     *
     * @param cell 文本列
     */
    protected static String getCellValue(Cell cell) {
        if(cell == null) {
            return "";
        }
        CellType type = cell.getCellType();
        if (type == CellType.BLANK) {
            return "";
        } else if (type == CellType.NUMERIC) {// 数字、时间
            return cell.getNumericCellValue() + "";
        } else if (type == CellType.BOOLEAN) {
            return cell.getBooleanCellValue() + "";
        } else if (type == CellType.STRING) {
            return cell.getStringCellValue().trim();
        } else if (type == CellType.ERROR) {
            return String.valueOf(cell.getErrorCellValue());
        } else {
            return "";
        }
    }
    public static void main(String[] args) throws Exception {



    }

}
