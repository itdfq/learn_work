package suanfa;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author GocChin
 * @Date 2021/7/15 9:27
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class MD5 {
    public static String md5(String s ){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(s.getBytes());
            byte[] digest = md5.digest();
            System.out.println(HexBin.encode(digest));
            return HexBin.encode(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 执行一次加密，第二次解密
     * @param inStr
     * @return
     */
    public static String covertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for (int i=0;i<a.length;i++){
            a[i]= (char) (a[i]^'t');
        }
        String s = new String(a);
        return s;
    }

    public static void main(String[] args) {
        String passwd = "dfq1234...";
        String s = md5(passwd);
        System.out.println("解密算法");
        System.out.println(covertMD5(s));
        System.out.println(covertMD5(covertMD5(s)));
        String s1 = md5(passwd);
        System.out.println("s1:"+s1);
    }
}
