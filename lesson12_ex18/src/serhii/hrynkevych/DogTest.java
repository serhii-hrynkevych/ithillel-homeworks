package serhii.hrynkevych;

// ****************************************************************
// DogTest.java
//
// A simple test class that creates a Dog and makes it speak.
//
// ****************************************************************
public class DogTest
{
    public static void main(String[] args) {
        Dog dog = new Dog("Spike");
        System.out.println(dog.getName() + " says " + dog.speak());

        Yorkshire yorkshire = new Yorkshire("Yorik");
        System.out.println(yorkshire.getName() + " says " + yorkshire.speak() + ", average breed weight "
                + yorkshire.avgBreedWeight());
        Labrador labrador = new Labrador("Labr", "black");
        System.out.println(labrador.getName() + " says " + labrador.speak() + ", color " + labrador.getColor()
                + ", average breed weight " + labrador.avgBreedWeight());


    }
}
