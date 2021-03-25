package test2;

public abstract class Employee {
    //员工属性
    private String name;
    private int birthMonth;
    public final int bouns=250;
    //构造方法
    public Employee(String name,int birthMonth){
        this.name=name;
        this.birthMonth=birthMonth;
    }
    //getter,setter方法
    public String getName(){
        return name;
    }
    public int getBirthMonth(){
        return birthMonth;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setBirthMonth(int month){
        this.birthMonth=month;
    }
    //抽象方法查看月份工资,其中参数bouns为生日补贴若满足条件则给予生日补贴
    public abstract double getSalary(int month,int bouns);
}
class SalariedEmployee extends Employee{//固定工资员工类
    //月薪属性和
    private double monthlySalay;
    //构造方法
    public SalariedEmployee(String name,int birthMonth,double monthlySalay){
        super(name,birthMonth);
        this.monthlySalay=monthlySalay;
    }
    //getter,setter方法
    public double getMonthlySalay(){
        return monthlySalay;
    }
    public void setMonthlySalay(double monthlySalay){
        this.monthlySalay=monthlySalay;
    }
    //重写抽象方法
    public double getSalary(int month,int bouns){
        if (this.getBirthMonth()==month){
            this.monthlySalay+=bouns;
        }
        return this.monthlySalay;
    }
}
class HourlyEmployee extends Employee{//小时工类员工
    //工作时长和时薪和总薪
    private int hours;
    private double hourlySalary;
    private double allSalary;
    //构造方法
    public HourlyEmployee(String name,int birthMonth,int hours,double hourlySalary,double allSalary){
        super(name,birthMonth);
        this.hours=hours;
        this.hourlySalary=hourlySalary;
        this.allSalary=0;
    }
    //getter,setter方法
    public int getHours(){
        return this.hours;
    }
    public double getHourlySalary(){
        return this.hourlySalary;
    }
    public double getAllSalary(){
        return this.allSalary;
    }
    public void setHours(int hours){
        this.hours=hours;
    }
    public void setHourlySalary(double hourlySalary){
        this.hourlySalary=hourlySalary;
    }
    public void setAllSalary(double allSalary){
        this.allSalary=allSalary;
    }
    //重写抽象方法
    public double getSalary(int month,int bouns){
        final int workTime=160;
        final double more=hourlySalary*1.5;//超过160个小时部分的时薪
        if (this.getBirthMonth()==month){
            allSalary+=bouns;
        }
        if (this.hours>workTime){
            allSalary+=workTime*hourlySalary+(hours-workTime)*more;
        }
        else{
            allSalary+=hours*hourlySalary;
        }
        return this.allSalary;
    }
}
class SalesEmployee extends Employee{//销售类员工
    //销售额和提成比例和总薪
    private double sales;
    private double comm;
    private double allSalary;
    //构造方法
    public SalesEmployee(String name,int birthMonth,double sales,double comm,double allSalary){
        super(name,birthMonth);
        this.sales=sales;
        this.comm=comm;
        this.allSalary=0;
    }
    //getter,setter方法
    public double getSales(){
        return this.sales;
    }
    public double getComm(){
        return this.comm;
    }
    public double getAllSalary(){
        return this.allSalary;
    }
    public void setSales(double sales){
        this.sales=sales;
    }
    public void setComm(double comm){
        this.comm=comm;
    }
    public void setAllSalary(double allSalary){
        this.allSalary=allSalary;
    }
    //重写抽象方法
    public double getSalary(int month,int bons){
        if (this.getBirthMonth()==month){
            allSalary+=bons;
        }
        allSalary+=sales*comm;
        return this.allSalary;
    }
}
class PaySalary{//工资发放部门
    static double totalSalary;//静态工资总和
    public void calcEployeeSalary(int month,Employee...e){//可变参数一次性传入需要计算员工工资
       for(Employee person:e){
           double money=person.getSalary(month,person.bouns);
           totalSalary+=money;
           System.out.println(person.getName()+":"+money+"元");
       }
       System.out.println(month+"月份总计需发放工资:"+totalSalary+"元");
    }
    public static void main(String args[]){
        SalariedEmployee e1=new SalariedEmployee("张三",2,5000);
        HourlyEmployee e2=new HourlyEmployee("李四",2,170,50,0);
        SalesEmployee e3=new SalesEmployee("王五",2,10000,0.5,0);
        PaySalary paySalary=new PaySalary();
        paySalary.calcEployeeSalary(2,e1,e2,e3);
    }
}
