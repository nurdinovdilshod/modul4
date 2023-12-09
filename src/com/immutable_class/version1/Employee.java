package com.immutable_class.version1;

public final class Employee {
    private final String fullName;
    private final int age;
    private final Address address;

    public Employee(String fullName, int age, Address address) throws CloneNotSupportedException {
        this.fullName = fullName;
        this.age = age;
        this.address = (Address) address.clone();
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
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
