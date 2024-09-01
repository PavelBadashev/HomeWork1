package Animals;

public class Duck extends Animal implements Flying{

    public Duck(String name, Integer age, Integer weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say() {
        System.out.println("Кря!");
    }

    @Override
    public void go() {
        System.out.println("Утка идет!");
    }

    @Override
    public void eat() {
        System.out.println("Утка ест!");
    }

    @Override
    public void drink() {
        System.out.println("Утка пьет!");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу!");
    }
}
