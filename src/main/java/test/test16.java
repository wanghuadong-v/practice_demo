package test;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import org.apache.commons.io.FileUtils;
import org.ddr.poi.html.HtmlRenderPolicy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2025/6/9 15:18
 */
public class test16 {
    public static void main(String[] args) throws IOException {
        // 读取HTML文件
        String html = "<h1 style='color:red'>嘿嘿嘿</ah1>";

        // 配置模板引擎
        Configure config = Configure.builder()
                .bind("htmlContent", new HtmlRenderPolicy())
                .build();
        XWPFTemplate template = XWPFTemplate.compile("C:\\Users\\wanghuadong\\Desktop\\20251026\\template.docx", config);

        // 绑定数据
        Map<String, Object> data = new HashMap<>();
        data.put("htmlContent", html);
        template.render(data);

        // 输出文件
        template.write(new FileOutputStream("C:\\Users\\wanghuadong\\Desktop\\20251026\\output.docx"));

    }
}
