import com.alibaba.fastjson.JSON;

/**
 * @Author GocChin
 * @Date 2021/7/27 13:39
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        String s = "1,2,3,4";
        String[] split = s.split(",");
        StringBuilder privilegess = new StringBuilder(",");
        for (String ss : split){
            privilegess.append(ss).append(",");
        }
        System.out.println(JSON.toJSONString(privilegess.toString()));
    }


}
