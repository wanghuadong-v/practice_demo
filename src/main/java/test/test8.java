package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2024/9/14 8:43
 */
public class test8 {
    public static void main(String[] args) {
        List<String[]> strings = null;
        try {
            strings = POIExcelUtil.readExcel("C:\\Users\\wanghuadong\\Desktop\\poi读取excel测试\\新建 Microsoft Excel 工作表.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String[] string : strings) {
            for (String s : string) {
                System.out.println(s);
            }
        }
    }
}
