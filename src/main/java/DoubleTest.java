/**
 * @Author: QianMo
 * @Date: 2021/10/29 13:21
 * @Description:
 */
public class DoubleTest {
    public static void main(String[] args) {
        double a = 120.345234;
        double b = 120.345234;
        System.out.println(a == b); //true
//        System.out.println(a.equals(b));

        Double a1 = Double.valueOf("0.0");
        Double b1 = Double.valueOf("-0.0");
        System.out.println(a1.equals(b1)); //false

    }
}
