package com.concurrency;

import com.java8.example.predicateDemo.Employee;
import com.java8.example.predicateDemo.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-17 9:54
 */
public class LambdaMain {

    private static final List<Employee> employees;

    static {
        employees = Arrays.asList(new Employee("lily", 18, 5000.00f),
                new Employee("lucy", 28, 8000.00f),
                new Employee("tony", 48, 4000.00f),
                new Employee("leo", 33, 7000.00f));
    }

    /**
     * 策略设计模式
     *
     * @param employee 员工集合
     * @param mp       自定义比较接口
     */
    private static void test1(List<Employee> employee, Predicate<Employee> mp) {
        List<Employee> list = new ArrayList<>();
        for (Employee e : employee) {
            if (mp.test(e)) {
                list.add(e);
            }
        }
        System.out.println(list);
    }

    /**
     * 匿名内部类
     *
     * @param employees 员工集合
     */
    private static void test2(List<Employee> employees) {
        List<Employee> list = new ArrayList<>();
        Predicate<Employee> predicate = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 5000;
            }
        };
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                list.add(employee);
            }
        }
        System.out.println(list);
    }

    /**
     * lambda表达式实现
     *
     * @param employees 员工集合
     */
    private static void test3(List<Employee> employees) {
        List<Employee> list = new ArrayList<>();
        Predicate<Employee> predicate = employee -> employee.getSalary() < 5000;
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                list.add(employee);
            }
        }
        System.out.println(list);
    }

    /**
     * 返回员工年龄大于30的员工信息
     * Stream API
     * filter 过滤
     *
     * @param employees 员工集合
     */
    private static void test4(List<Employee> employees) {
        employees.stream().filter(employee -> employee.getAge() > 30).forEach(System.out::println);
    }

    /**
     * 返回员工工资大于7000的员工姓名
     * Stream API
     * map 将一个流中的值转换成一个新的流
     *
     * @param employees 员工集合
     */
    private static void test5(List<Employee> employees) {
        employees.stream()
                .filter(employee -> employee.getSalary() > 7000)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        LambdaMain.test1(employees, new EmployeeAge());
//        LambdaMain.test2(employees);
//        LambdaMain.test3(employees);
//        LambdaMain.test4(employees);
        LambdaMain.test5(employees);
    }

}
