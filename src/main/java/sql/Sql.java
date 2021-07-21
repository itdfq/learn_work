package sql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.apache.log4j.Logger;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * @Author GocChin
 * @Date 2021/7/16 15:39
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 插入10W条数据到数据库，测试用时
 */

public class Sql {

    private static Logger logger = Logger.getLogger(Sql.class);
    public static void main(String[] args) {
        String url = "jdbc:mysql://119.3.234.108:3306/test?useSSL=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "root";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO userinfo(uid,uname,uphone,uaddress) VALUES(?,CONCAT('姓名',?),?,?)";
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            Long startTime = System.currentTimeMillis();
            Random rand = new Random();
//            logger.info("开始进行插入");
            System.out.println("开始插入");
            int a, b, c, d;
            for (int i = 1; i <= 100000; i++) {
                pstm.setInt(1, i);
                pstm.setInt(2, i);
                a = rand.nextInt(10);
                b = rand.nextInt(10);
                c = rand.nextInt(10);
                d = rand.nextInt(10);
                pstm.setString(3, "188" + a + "88" + b + c + "66" + d);
                pstm.setString(4, "xxxxxxxxxx_" + "188" + a + "88" + b + c + "66" + d);
                pstm.addBatch();
            }
            pstm.executeBatch();
            Long endTime = System.currentTimeMillis();
            System.out.println("OK,用时：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
