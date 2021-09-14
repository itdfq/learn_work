package Excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * @Author: QianMo
 * @Date: 2021/9/14 16:37
 * @Description: Excel导入测试
 */
public class ExcelTest {
    public static void main(String[] args) {
        ExcelReader reader =  ExcelUtil.getReader(FileUtil.file("E:\\java-IDEA\\learn\\HuToolTest\\src\\main\\resources\\storeEnter.xlsx"), "sheet1");
        List<List<Object>> read = reader.read();
        System.out.println(JSONUtil.toJsonStr(read));
        List<StoreBase> all = reader.readAll(StoreBase.class);
        System.out.println(JSONUtil.toJsonStr(all));

    }
}
