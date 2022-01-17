package serhii.hrynkevych;

public class AnimalFactory {

    public static Animal getAnimalByKey(String key) {
        if (key.equals("da")) {
            return new Dog("Арамис");
        }
        if (key.equals("db")) {
            return new Dog("Блек");
        }
        if (key.equals("dc")) {
            return new Dog("Спайки");
        }
        if (key.equals("ca")) {
            return new Cat("Амадей");
        }
        if (key.equals("cb")) {
            return new Cat("Баксик");
        }
        if (key.equals("cc")) {
            return new Cat("Снежок");
        }
        return null;
    }
}
