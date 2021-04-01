package test3;

interface Comparable {
    public int compareTo(Object o);
}
abstract class Shape {
    public abstract void draw();
}
class Rectangle extends Shape implements Comparable {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void draw() {
    }

    public int getArea() {
        return length * width;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Rectangle)) {
            return -1;
        } else {
            Rectangle re = (Rectangle) o;
            int area1 = this.getArea();
            int area2 = re.getArea();
            if (area1 > area2) {
                return 1;
            } else if (area1 == area2) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
abstract class Fruit{
    public abstract void howToEat();
}
class Apple extends Fruit implements Comparable{
    private int weigth;
    public Apple(int weigth){
        this.weigth=weigth;
    }
    public int getWeigth(){
        return this.weigth;
    }
    public void setWeigth(int weigth){
        this.weigth=weigth;
    }
    public void howToEat(){}

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Apple)) {
            return -1;
        } else {
            Apple apple = (Apple) o;
            int weigth = apple.getWeigth();
            if (this.getWeigth() > weigth) {
                return 1;
            } else if (this.getWeigth() == weigth) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}

public class Test {
    public static void showComparable(Comparable com1,Comparable com2){
        if (com1 instanceof Rectangle&&com2 instanceof Rectangle){
            int result=com1.compareTo(com2);
            if (result==1){
                System.out.println("长方形1比长方形2大");
            }
            else if (result==0){
                System.out.println("两个长方形大小相同");
            }
            else {
                System.out.println("长方形1比长方形2小");
            }
        }

        else if (com1 instanceof Apple&&com2 instanceof Apple){
            int result=com1.compareTo(com2);
            if (result==1){
                System.out.println("苹果1比苹果2大");
            }
            else if (result==0){
                System.out.println("两个苹果重量相同");
            }
            else {
                System.out.println("苹果1比苹果2小");
            }
        }
        else {
            System.out.println("输入类型不同");
        }

    }
    public static void main(String[] args) {
            showComparable(new Rectangle(10,12),new Rectangle(5,12));
            showComparable(new Apple(13),new Apple(19));
    }
}
