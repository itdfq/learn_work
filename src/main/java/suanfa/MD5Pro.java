package suanfa;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author GocChin
 * @Date 2021/7/15 9:46
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 盐值加密  ：原理是通过生成随机数与MD5生成字符串进行组合
 */
public class MD5Pro {
    public static String generate(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }
    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new HexBin().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleFormatter.format(new Date());
        System.out.println(format);
        String salt = format;
        String s = new String(String.valueOf(System.currentTimeMillis()));
        return md5Hex(password + salt).equals(new String(cs1));
    }

    public static void main(String[] args) {
        String ss = MD5Pro.generate("123456");
        System.out.println(MD5Pro.generate("123456"));
        System.out.println("是否是同一字符串："+MD5Pro.verify("123456",ss));
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleFormatter.format(new Date());

    }

}
