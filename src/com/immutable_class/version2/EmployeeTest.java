package com.immutable_class.version2;

public class EmployeeTest {
    public static void main(String[] args) {
        Address address = new Address("Bukhara", "Karoulbazar");
        Employee employee = new Employee("Nuriddinov DIlshod", 22,address);
        System.out.println(employee);
        System.out.println(employee);
        System.out.println(employee);
    }
}
