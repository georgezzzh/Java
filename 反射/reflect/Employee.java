package reflect;

public class Employee {
    private String name;
    private int salary;
    private int day;
    private int month;
    private int year;

    public Employee(String name, int salary, int day, int month, int year) {
        this.name = name;
        this.salary = salary;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
