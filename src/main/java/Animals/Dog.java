package Animals;

public class Dog extends Animal {
    public Dog(String name, Integer age, Integer weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say() {
        System.out.println("ГАВ!");
    }

    @Override
    public void go() {
        System.out.println("Идет!");
    }

    @Override
    public void eat() {
        System.out.println("Ест собачью еду!");
    }

    @Override
    public void drink() {
        System.out.println("Пьет!");
    }
}
