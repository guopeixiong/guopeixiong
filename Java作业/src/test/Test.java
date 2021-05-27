package test;

abstract class Employee{
    private String name;
    private int birthMonth;
    public final int prize = 250;

    public Employee(String name,int birthMonth){
        this.name = name;
        this.birthMonth = birthMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public abstract double getSalary(int month);

}

class SalariedEmployee extends Employee{
    private int monthlySalary;

    public SalariedEmployee(String name,int birthMonth,int monthlySalary){
        super(name,birthMonth);
        this.monthlySalary = monthlySalary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double getSalary(int month) {
        if (this.getBirthMonth() == month){
            return this.getMonthlySalary() + prize;
        }
        return this.getMonthlySalary();
    }

}

class HourlyEmployee extends Employee{
    private int hours;
    private int hourlySalary;
    public final int hour = 160;

    public HourlyEmployee(String name,int birthMonth,int hours,int hourlySalary){
        super(name,birthMonth);
        this.hourlySalary = hourlySalary;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double getSalary(int month) {
        if (this.getHours() > hour){
            if (this.getBirthMonth() == month){
                return hourlySalary * hour + (hours-hour)*hourlySalary *1.5 + prize;
            }
            return hourlySalary * hour + (hours-hour) * hourlySalary * 1.5;
        }else{
            if (this.getBirthMonth() == month){
                return hours * hourlySalary + prize;
            }else{
                return hours * hourlySalary;
            }
        }
    }

}

class SalesEmployee extends Employee{
    private int sales;
    private double comm;

    public SalesEmployee(String name, int birthMonth, int sales, double comm){
        super(name,birthMonth);
        this.sales = sales;
        this.comm = comm;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    @Override
    public double getSalary(int month) {
        if (this.getBirthMonth() == month){
            return comm * sales + prize;
        }else{
            return comm * sales;
        }
    }
}

class PaySalary{
    public int month;
    public static double totalSqlqry = 0;

    public PaySalary(int monmth){
        this.month = monmth;
    }

    public void calcEmployeeSalary(Employee e){
        totalSqlqry += e.getSalary(this.month);
    }

}

public class Test {
    public static void main(String[] args) {
        SalariedEmployee zhangsan = new SalariedEmployee("张三",2,5000);
        HourlyEmployee lisi = new HourlyEmployee("李四",2,170,50);
        SalesEmployee wangwu = new SalesEmployee("王五",2,10000,0.5);
        PaySalary pay = new PaySalary(2);
        pay.calcEmployeeSalary(zhangsan);
        pay.calcEmployeeSalary(lisi);
        pay.calcEmployeeSalary(wangwu);
        System.out.println("总工资:"+PaySalary.totalSqlqry);
    }
}
