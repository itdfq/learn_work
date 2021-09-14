package CSV;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;

import java.util.List;

/**
 * @Author: QianMo
 * @Date: 2021/9/14 12:12
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
         CsvReader reader = CsvUtil.getReader();
    //假设csv文件在classpath目录下
         List<TestBean> result = reader.read(
                ResourceUtil.getUtf8Reader("E:\\java-IDEA\\learn\\HuToolTest\\src\\main\\resources\\test.csv"), TestBean.class);
        System.out.println(result);
    }
}
