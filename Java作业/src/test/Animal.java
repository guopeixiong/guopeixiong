package test;

public abstract class Animal {
    protected String name;
    public abstract void cry();
    public abstract String getAnimalName();
}
class Dog extends Animal{
    protected String name="狗";
    public void cry(){
        System.out.println("汪汪汪");
    }
    public String getAnimalName(){
        return name;
    }
}
class Cat extends Animal{
    protected String name="猫";
    public void cry(){
        System.out.println("喵喵喵");
    }
    public String getAnimalName(){
        return name;
    }
}
class Simulator{
    public void playSound(Animal animal){
        System.out.println(animal.getAnimalName());
        animal.cry();
    }
    public static void main(String args[]){
        Simulator simulator=new Simulator();
        Dog dog=new Dog();
        Cat cat=new Cat();
        simulator.playSound(dog);
        simulator.playSound(cat);
    }
}
