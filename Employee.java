//Author: Keith Kirtfield
//This class Stores the employees in an array
public class Employee {
//    Vars
    char status;
    String name;
    double wage, hours;
//    Constructors
    public Employee(char aStatus, String aName, double aWage, double aHours){
        status = aStatus;
        name = aName;
        wage = aWage;
        hours = aHours;
    }
    public Employee(){

    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    public char getStatus() {
        return status;
    }
}
