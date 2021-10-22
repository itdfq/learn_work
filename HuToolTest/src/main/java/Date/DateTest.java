package Date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @Author: QianMo
 * @Date: 2021/9/17 10:44
 * @Description:
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = DateUtil.date();
        System.out.println(date);
        DateTime dateTime = DateUtil.offsetDay(date, 3);
        System.out.println(dateTime);
    }
}
