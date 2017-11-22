package com.java8.example.predicateDemo;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-17 10:02
 */
public class EmployeeAge implements Predicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 30;
    }
}
