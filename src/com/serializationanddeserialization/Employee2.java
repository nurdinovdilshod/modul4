package com.serializationanddeserialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee2 implements Externalizable {

    private String fullName;
    private String phoneNumber;
    private String age;

    public Employee2() {
    }

    public Employee2(String fullName, String phoneNumber, String age) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.fullName.substring(0, 5));
        objectOutput.writeObject(this.phoneNumber.substring(6));
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.fullName = (String) objectInput.readObject();
        this.phoneNumber = (String) objectInput.readObject();
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
