package mybatis_Generator;

import org.mybatis.generator.api.ShellRunner;

/**
 * @Author GocChin
 * @Date 2021/7/19 13:19
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  使用mybatis+Generator 自动生产代码
 */
public class Start {
    public static void main(String[] args) {
        String config = Start.class.getClassLoader()
                .getResource("generatorConfig.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
        System.out.println("执行完毕");
    }
}
