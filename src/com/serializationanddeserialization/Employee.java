package com.serializationanddeserialization;

import java.io.Serializable;

public class Employee implements Serializable {
    private String fullName;
    private transient String phoneNumber;
    private String age;

    public Employee(String fullName, String phoneNumber, String age) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}
