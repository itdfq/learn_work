package Mail;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailUtil;

import java.io.File;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:39
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class MailTest {
    public static void main(String[] args) {
        //发送普通邮件
        MailUtil.sendText("909256107@qq.com","title test","测试");
        //发送附件
        String s = MailUtil.sendText("909256107@qq.com", "title test", "测试", FileUtil.file("users.csv"));
        System.out.println(s);
    }
}
