package com.kainos.ea.model;

import com.kainos.ea.employee_stuff.BadNumber;
import com.kainos.ea.employee_stuff.SalaryTooLowException;

import java.util.Objects;

public class Employee {
    public static final int min_salary = 7_000_00;
    private int id;
    protected String name;
    private int salary;
    private String bankNo;
    private String NIN;
    private String phoneNumber;
    private String countryCode;
    public Employee(){

    }

    public Employee(int id, String name, int salary, String bankNo, String NIN, String phoneNumber, String countryCode) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bankNo = bankNo;
        this.NIN = NIN;
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
    }
    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getNIN() {
        return NIN;
    }

    public void setNIN(String NIN) {
        this.NIN = NIN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public int getID() {
        return id;
    }

    public boolean setID(short thisNumber) {
        if (thisNumber > 0) {
            id = thisNumber;
            return true;
        } else {
            return false;
        }
    }

    public boolean setID(String thisNumber) {
        try{
            short s = Short.parseShort(thisNumber);
            return setID(s);
        } catch(NumberFormatException e){
            throw new BadNumber(e.getMessage());
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String thisName) {
        if (!thisName.isEmpty()) {
            name = thisName;
            return true;
        } else {
            return false;
        }
    }
    public double calcPay(){
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public String toString() {
        return "Employee: " +
                "EmployeeID = " + getID() +
                ", Name = '" + getName() + '\'' +
                ", Salary = " + getSalary() +
                ", BankNo = '" + getBankNo() + '\'' +
                ", NIN = '" + getNIN() + '\'' +
                ", Phone Number = '" + getPhoneNumber() + '\'' +
                ", Country Code = '" + getCountryCode() + '\'';
    }

    public float calcPay(Employee payee) {
        return 0;
    }

//    @Override
//    public int compareTo(Employee x){
////        return Float.compare(this.getSalary(), x.getSalary());
//        return  this.getName().split(" ")[1].compareTo(x.getName().split(" ")[1]);
//    }
}
