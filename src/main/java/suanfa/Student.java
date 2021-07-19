package suanfa;

import java.io.Serializable;

/**
 * @Author GocChin
 * @Date 2021/7/16 10:32
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -8913229041802904861L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
