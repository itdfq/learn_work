package com.itdfq.send.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.net.Socket;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author GocChin
 * @Date 2021/8/4 16:46
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */

public class Test {
    public static void main(String[] args) {
        Optional<Student> student1 = Optional.empty();
        Optional<Student> student = Optional.of(new Student("小红", 12, "2021-8-4"));
        Optional<Student> student2 = Optional.ofNullable(null);
        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);

        System.out.println("---------获取Optional值-----------");
        Student student3 = student1.orElse(new Student("小dsa", 14, "202dsd4"));
        System.out.println(student3);

        System.out.println("-----------------转换类----------------------");
        // 原来value的类型是UserInfo，经过map转换为Optional<String>
        Optional<String> username = student.map(Student::getName);
        Socket socket = new Socket();
        //入参也是Optional时，经过map转化后会形成Optional<Optional<String>>嵌套结构，但flatMap可以把这种嵌套结构打平
        Optional<Optional<String>> unFlatMap = student.map(user -> Optional.of(user.getName()));
        System.out.println("unFlatMap:" + unFlatMap);
        Optional<String> s = student.flatMap(user -> Optional.of(user.getName()));
        System.out.println(s);
    }
}

@Slf4j
class Test1 {
    public static void main(String[] args) {
        Optional<Student> userInfoEmptyOpt = Optional.empty();
        Optional<Student> userInfoOpt = Optional.of(new Student("阿飞", 15, "2021-3-12"));

        // filter传入一个lambda，lambda返回值为boolean；true:不做任何改变，false:返回一个空的optional；
        Optional<Student> userInfo = userInfoOpt.filter(user -> "2021-3-12".equals(user.getTime()));
        log.info("userInfo:{}", userInfo.get());

        // isPresent就是判断value是不是null；我们在调用get之前，一定要先调用isPresent，因为直接如果value是null，直接调用get会报异常；
        if (userInfoEmptyOpt.isPresent()) {
            Student value = userInfoEmptyOpt.get();
            log.info("optional value:{}", value);
        } else {
            log.info("optional value==null");
        }

        // ifPresent传入一段lambda，当value!=null时，执行里面的逻辑；当当value==null时，啥都不干；
        userInfoOpt.ifPresent(value -> log.info("optional value:{}", value));

    }
}
@Slf4j
class OptionDemo {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class Employee {
        private Long id;
        private String name;
        private Boolean leader;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class Leader {
        private Long employeeId;
        private BigDecimal bonus;
    }

    public static Optional<Employee> getEmployeeById(Long id) {
        //return Optional.of(new Employee(1L, "大老板", Boolean.TRUE));
        return Optional.of(new Employee(1L, "大老板", Boolean.FALSE));
    }

    public static Optional<Leader> getLeaderByEmployeeId(Long employeeId) {
        //return employeeId == 1L ? Optional.of(new Leader(1L, BigDecimal.valueOf(1000000000))) : Optional.empty();
        return employeeId == 1L ? Optional.of(new Leader(1L, null)) : Optional.empty();
    }

    /**
     * 找到ID为1的员工，如果有奖金就打印出来，没有就打印没有奖金；
     */
    public static void main(String[] args) {
        Optional<Leader> leader = Optional.ofNullable(getEmployeeById(1L).filter(Employee::getLeader).map(Employee::getId).flatMap(OptionDemo::getLeaderByEmployeeId).orElse(null));
        if (leader.isPresent()) {
            Optional.of(leader.map(Leader::getBonus).map(bonus -> String.format("员工ID为1的leader奖金为：%s", bonus)).orElse("员工ID为1的leader也没有奖金")).ifPresent(System.out::println);
        } else {
            log.info("员工为【{}】的leader未找到，他可能只是一个基层员工，不配拥有奖金", Objects.requireNonNull(getLeaderByEmployeeId(1L).orElse(null)).getEmployeeId());
        }
    }


}

