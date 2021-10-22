package snow;

/**
 * @Author: QianMo
 * @Date: 2021/9/24 12:51
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();
        long l = idGenerator.snowflakeId();
        System.out.println(l);
    }
}
