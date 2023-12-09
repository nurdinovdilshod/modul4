package com.immutable_class.version1;

public class EmployeeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Bukhara", "Karoulbazar");
        Employee employee = new Employee("Nuriddinov DIlshod", 22,address);
        System.out.println(employee);
//        address.setRegion("Tashkent");
//        System.out.println(employee);
        employee.getAddress().setRegion("Tashkent");
        System.out.println(employee);
    }
}
