package CSV;

import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;

/**
 * @Author: QianMo
 * @Date: 2021/9/14 11:24
 * @Description:  生成测试
 */
public class ProductDemo {
    public static void main(String[] args) {
        //指定路径和编码
        CsvWriter writer = CsvUtil.getWriter("E:\\java-IDEA\\learn\\HuToolTest\\src\\main\\resources\\test.csv", CharsetUtil.CHARSET_UTF_8);
//按行写出
        writer.write(
                new String[] {"a1", "b1", "c1"},
                new String[] {"a2", "b2", "c2"},
                new String[] {"a3", "b3", "c3"}
        );
    }
}
