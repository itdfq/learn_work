package RandomUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: QianMo
 * @Date: 2021/9/24 11:07
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        SnowFlake snowFlake = new SnowFlake(1,1);
        System.out.println(snowFlake.nextId());
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostName());
        System.out.println(System.currentTimeMillis());
    }
}
