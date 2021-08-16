package Http;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.net.HttpCookie;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 13:30
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class HttpRequestTest {
    public static void main(String[] args) {
        String url = "http://qa.wxb.com.cn:8000/v7/inn/order/work?time=1";
        Map map = new HashMap<>();
//链式构建请求
//        String result2 = HttpRequest.get(url)
//                .header("Mall-Token", "zqxxsqdxbxjf61dd1cq664cipl77uyjj")//头信息，多个头信息多次调用此方法即可
//                .form(null)//表单内容
//                .timeout(20000)//超时，毫秒
//                .execute().body();
//        Console.log(result2);
        HttpResponse execute = HttpRequest.get(url)
                .header("Mall-Token", "zqxxsqdxbxjf61dd1cq664cipl77uyjj")//头信息，多个头信息多次调用此方法即可
                .form(null)//表单内容
                .timeout(20000)//超时，毫秒
                .execute();
        /**
         * 配置代理
         */

        String result2 = HttpRequest.post(url)
                .setHttpProxy("127.0.0.1", 9080)
                .body(JSONUtil.toJsonStr(map))
                .execute().body();

    }
}
