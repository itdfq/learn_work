package CSV;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;

import java.util.List;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:58
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        CsvReader reader = CsvUtil.getReader();
        CsvData data = reader.read(FileUtil.file("test.csv")) ;
        List<CsvRow> rows = data.getRows();
        for (CsvRow csvRow : rows) {
            Console.log(csvRow.getRawList());
        }
    }
}
