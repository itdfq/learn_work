package Test;


import Test.entity.Student;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 15:04
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: list测试
 */
public class ListTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        List<Student> list1 = new ArrayQueue<>(30);

        Student student = new Student().setName("123").setAge(12).setAddress("dfgarterg");
        Student student1 = new Student().setName("345").setAge(23).setAddress("gdgagsdg");
        list.add(student);
        list.add(student1);
        System.out.println(list);

    }
}
