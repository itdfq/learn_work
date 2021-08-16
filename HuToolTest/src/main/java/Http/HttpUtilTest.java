package Http;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 13:13
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class HttpUtilTest {
    public static void main(String[] args) {
        String url="http://qa.wxb.com.cn:8000/v7/calypso/wx/auth/regCaptcha";
        //GET请求
//        String content = HttpUtil.get(url);
        //Post
        Map<String,Object> map = new HashMap<>();
        map.put("mobile","19999999999");
        String content=HttpUtil.post(url,map);
        System.out.println(content);
    }
}
