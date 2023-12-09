package com.immutable_class.version2;

public final class Employee {
    private final String fullName;
    private final int age;
    private final Address address;

    public Employee(String fullName, int age, Address address){
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
