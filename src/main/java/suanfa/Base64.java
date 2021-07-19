package suanfa;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Author GocChin
 * @Date 2021/7/15 9:18
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Base64 {
    public static void base64(String s){
        try {
            BASE64Encoder encoder = new BASE64Encoder();  //加密
            String encode = encoder.encode(s.getBytes());
            System.out.println("加密的密码："+encode);
            BASE64Decoder base64Decoder = new BASE64Decoder();//解密
            String s1 = new String(base64Decoder.decodeBuffer(encode));
            System.out.println("解密之后的密码："+s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String password = "dfq123456...";
        base64(password);
    }
}
